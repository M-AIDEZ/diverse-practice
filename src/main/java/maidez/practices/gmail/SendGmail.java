package maidez.practices.gmail;

import com.google.common.collect.Lists;
import maidez.practices.utils.FileItemUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class SendGmail {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");

    private static FileItemUtil.ExcelParseConfig<List<String>> excelParseConfig;

    static {
        excelParseConfig = new FileItemUtil.ExcelParseConfig<>(Lists::newArrayList, 1, strList -> strList.forEach(System.out::println));
        excelParseConfig.addColumnParser(excelParseConfig.new ColumnParser<List<String>>(
                (strings, s) -> {
                    if (!CollectionUtils.isEmpty(s)) strings.addAll(s);
                },
                6,
                cell -> {
                    List<String> emails = Lists.newArrayList();
                    String email = cell.getStringCellValue().trim().replaceAll("\\s|\\n|；|/", ",");
                    for (String s : email.split(",")) {
                        if (EMAIL_PATTERN.matcher(s).matches()) {
                            emails.add(s);
                        }
                    }
                    return emails;
                }));
        excelParseConfig.addColumnParser(excelParseConfig.new ColumnParser<List<String>>(
                (strings, s) -> {
                    if (!CollectionUtils.isEmpty(s)) strings.addAll(s);
                },
                7,
                cell -> {
                    List<String> emails = Lists.newArrayList();
                    String email = cell.getStringCellValue().trim().replaceAll("\\s|\\n|；|/", ",");
                    for (String s : email.split(",")) {
                        if (EMAIL_PATTERN.matcher(s).matches()) {
                            emails.add(s);
                        }
                    }
                    return emails;
                }));
    }

    public static void main(String[] args) {
        List<String> emails = Lists.newArrayList();
        FileItemUtil.parse("/Users/luwenyi/Desktop/国内部.xlsx", excelParseConfig).forEach(emails::addAll);
        FileItemUtil.parse("/Users/luwenyi/Desktop/中国.xlsx", excelParseConfig).forEach(emails::addAll);
        FileItemUtil.parse("/Users/luwenyi/Desktop/广州.xlsx", excelParseConfig).forEach(emails::addAll);
        int finish = 0;
        List<List<String>> partition = Lists.partition(emails, 50);
        for (List<String> strings : partition) {
            try {
                send(StringUtils.join(strings, ","));
            } catch (UnsupportedEncodingException | MessagingException e) {
                e.printStackTrace();
            }
            System.out.println("TOTAL : " + partition.size() + ", FINISHED : " + ++finish);
        }
    }

    /*
     * gmail邮箱SSL方式
     */
    private static Properties ssl() {
        Properties props = new Properties();
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        return props;
    }

    /*
     * 通过gmail邮箱发送邮件
     */
    public static void send(String receivers) throws UnsupportedEncodingException, MessagingException {
        //选择ssl方式
        Properties props = ssl();

        final String username = "xzngzd@gmail.com";
        final String password = "LUWENYI666";
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        // -- Create a new message --
        Message msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username));
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receivers));
        msg.setSubject("【不容错过】澳洲精品五星酒庄迪金森庄园的来信");
        msg.setText("您好，亲爱的酒商朋友，\n" +
                "\n" +
                "我是来自澳洲精品五星酒庄迪金森酒庄的中国区代表Shaun，本酒庄葡萄酒系列获得詹姆斯·韩礼德96分评分，附件为我们的简介。希望可以与您展开业务上的合作，如果您有兴趣做进一步的业务探讨，请联系电话 15019250820（微信即电话）或者邮箱 xzngzd@gmail.com。期待您的回复。\n" +
                "\n" +
                "Shaun XU 肖恩·徐\n" +
                "Winery Representative 酒庄代表\n" +
                "Dickinson Estate 迪金森酒庄\n"
        );

        MimeMultipart multipart = new MimeMultipart();
        //创建文本节点
        MimeBodyPart text = new MimeBodyPart();
        String textContext = "您好，亲爱的酒商朋友，<br/>" +
                "<br/>" +
                "我是来自澳洲精品五星酒庄迪金森酒庄的中国区代表Shaun，本酒庄葡萄酒系列获得詹姆斯·韩礼德96分评分，附件为我们的简介。希望可以与您展开业务上的合作，如果您有兴趣做进一步的业务探讨，请联系电话 15019250820（微信即电话）或者邮箱 xzngzd@gmail.com。期待您的回复。<br/>" +
                "<br/>" +
                "<br/>" +
                "Shaun XU 肖恩·徐<br/>" +
                "Winery Representative 酒庄代表<br/>" +
                "Dickinson Estate 迪金森酒庄<br/>";
        text.setContent(textContext, "text/html;charset=UTF-8");

        //创建附件节点  读取本地文件,并读取附件名称
        MimeBodyPart pdf = new MimeBodyPart();
        DataHandler dataHandler = new DataHandler(new FileDataSource("/Users/luwenyi/Desktop/迪金森招商手册.pdf"));
        pdf.setDataHandler(dataHandler);
        pdf.setFileName(MimeUtility.encodeText(dataHandler.getName()));

        //将文本和图片添加到multipart
        multipart.addBodyPart(text);
        multipart.addBodyPart(pdf);
        multipart.setSubType("mixed");//混合关系

        msg.setContent(multipart);
        msg.setSentDate(new Date());
        msg.saveChanges();

        Transport.send(msg, InternetAddress.parse(receivers));
        System.out.println("Message sent.");
    }
}
