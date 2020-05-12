package maidez.practices.refreshShops;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class RefreshShops {
    private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

    private static HttpClient client;

    static {
        cm.setMaxTotal(10);
        cm.setDefaultMaxPerRoute(10);
        client = HttpClients.custom().setConnectionManager(cm).build();
    }

    private static final String ACCESS_TOKEN = "";
    private static final String COOKIE = "";
    private static final String SHOP_IDS = "";

    private static final String METHOD = "";

    public static void main(String[] args) throws IOException {
        List<Integer> integers = readFromFile();
        List<List<Integer>> partitions = Lists.partition(integers, 100);
        System.out.println("共" + partitions.size() + "组");
        for (int i = 0; i < partitions.size(); i++) {
            System.out.println("当前第" + (i + 1) + "组");
            call(partitions.get(i));
        }
    }

    private static List<Integer> readFromFile() throws IOException {
        List<Integer> shopIds = Lists.newArrayList();
        File file = new File("/Users/luwenyi/Desktop/TPRotateShop (1).txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String strLine = null;
        int lineCount = 1;
        while (null != (strLine = bufferedReader.readLine())) {
            System.out.println("第[" + lineCount + "]行数据:[" + strLine + "]");
            shopIds.add(Integer.valueOf(strLine));
            lineCount++;
        }
        return shopIds;
    }

    private static void call(List<Integer> shopIds) {
        HttpPost httpPost = new HttpPost("");
        httpPost.setConfig(RequestConfig.custom().setSocketTimeout(10000).build());

        httpPost.setHeader("Cookie", COOKIE);
        httpPost.setHeader("access-token", ACCESS_TOKEN);
        httpPost.setHeader("Content-Type", "application/json");

        String shopIdsStr = JSON.toJSONString(shopIds);
        String requestBody = METHOD.replace(SHOP_IDS, shopIdsStr);
        StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);

        httpPost.setEntity(stringEntity);
        try {
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.println("FAILED:" + shopIdsStr);
            } else {
                InputStream content = response.getEntity().getContent();
                String result = new BufferedReader(new InputStreamReader(content)).lines().collect(Collectors.joining("\n"));
                Resp parse = JSON.parseObject(result, Resp.class);
                System.out.println(parse.getData().getCode() + ":" + shopIdsStr);
            }
        } catch (Exception ex) {
            System.out.println("FAILED_EX:" + shopIdsStr);
        } finally {
            httpPost.releaseConnection();
        }
    }

    @Data
    private static class Resp {
        private RespMeta meta;
        private RespData data;
    }

    @Data
    private static class RespMeta {
        private boolean success;
        private String message;
    }

    @Data
    private static class RespData {
        private int code;
        private String response;
    }
}
