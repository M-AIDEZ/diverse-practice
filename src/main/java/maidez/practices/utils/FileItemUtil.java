package maidez.practices.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by fang on 2017/9/4.
 */
public class FileItemUtil {

    public static List<Row> getXlsx(String filePath) {
        return getXlsx(filePath, 0);
    }

    public static List<Row> getXlsx(String filePath, int startRowIndex) {
        List<Row> ret = Lists.newArrayList();
        try {
            Workbook wb = new XSSFWorkbook(new FileInputStream(filePath));
            Sheet sheet = wb.getSheetAt(0);
            for (int rowIndex = startRowIndex; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    ret.add(row);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("文件读取失败:" + ex.getMessage(), ex);
        }
        return ret;
    }

    public static final class ExcelParseConfig<T> {
        private int startRowIndex;

        public int getStartRowIndex() {
            return startRowIndex;
        }

        private List<ColumnParser> columnParsers;

        private Supplier<T> initializer;

        private Consumer<T> consumer;


        public void addColumnParser(ColumnParser<?> columnParser) {
            this.columnParsers.add(columnParser);
        }

        public ExcelParseConfig(Supplier<T> initializer, int startRowIndex, Consumer<T> consumer) {
            this.initializer = initializer;
            this.startRowIndex = startRowIndex;
            this.columnParsers = Lists.newArrayList();
            this.consumer = consumer;
        }

        public class ColumnParser<R> {
            private BiConsumer<T, R> attributeSetter;
            private int columnIndex;
            private Function<Cell, R> attributeExtractor;
            private String hintMsg;

            public ColumnParser(BiConsumer<T, R> attributeSetter, int columnIndex, Function<Cell, R> attributeExtractor, String hintMsg) {
                this.attributeSetter = attributeSetter;
                this.columnIndex = columnIndex;
                this.attributeExtractor = attributeExtractor;
                this.hintMsg = hintMsg;
            }

            public ColumnParser(BiConsumer<T, R> attributeSetter, int columnIndex, Function<Cell, R> attributeExtractor) {
                this.attributeSetter = attributeSetter;
                this.columnIndex = columnIndex;
                this.attributeExtractor = attributeExtractor;
                this.hintMsg = "";
            }

            void parse(T t, Row row) {
                try {
                    R apply = attributeExtractor.apply(row.getCell(columnIndex));
                    attributeSetter.accept(t, apply);
                } catch (Exception e) {
                    //no need to log
                    String errorMsg = "第" + (row.getRowNum() + 1) + "行第" + (columnIndex + 1) + "列格式错误" + (StringUtils.isBlank(hintMsg) ? "" : ("，" + hintMsg));
                    throw new RuntimeException(errorMsg);
                }
            }
        }

        public T parse(Row row) {
            T t = initializer.get();
            for (ColumnParser<?> columnParser : this.columnParsers) {
                columnParser.parse(t, row);
            }
            return t;
        }

        public void parseThenCommit(Row row) {
            try {
                consumer.accept(parse(row));
            } catch (Exception e) {
                System.out.println("第" + (row.getRowNum() + 1) + "行执行失败，" + e.getMessage());
            }
        }


    }

    public static <T> List<T> parse(String filePath, ExcelParseConfig<T> excelParseConfig) {
        if (!filePath.endsWith(".xlsx")) {
            throw new IllegalArgumentException("文件格式错误，请上传 .xlsx格式的文件！");
        }
        List<Row> rows = FileItemUtil.getXlsx(filePath, excelParseConfig.getStartRowIndex());
        if (rows.size() < 1) {
            throw new IllegalArgumentException("文件内容不能为空");
        }
        return rows.stream().map(excelParseConfig::parse).collect(Collectors.toList());
    }

}
