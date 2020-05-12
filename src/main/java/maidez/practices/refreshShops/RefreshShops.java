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

    private static final String ACCESS_TOKEN = "eAHjYBS4sr2BUWH78z2LvukaiRVkpqfm5-mm55elFuXlF-kWpxYBWVYKSclG5iaWFibmFqZGJpYpZkkmiSZaxilGScaWySkpJhZONgo7v196_lNXg9GIoGILkJUOTB6rn79b9lW3iZEhSsHC2DQ51cjIzMxCy8jExBJoVVqSiWlyclqagXGSgbEZAAGENqg**eAEFwQkBwDAIA0BLfC2NnADDv4TdWXpm2upNPYXYh2lR2iR6MIEteeeSlG6w4vO57cbwNZkfKYARtg";

    private static final String COOKIE = "_lxsdk_cuid=16b3f2467efc8-0da81e0d708eb7-37637e03-1fa400-16b3f2467efc8; _lxsdk=16b3f2467efc8-0da81e0d708eb7-37637e03-1fa400-16b3f2467efc8; _hc.v=dd20ec08-6b4e-0680-e70e-50544d777b62.1560247557; _ga=GA1.2.1985983270.1560398688; uu=87a1e0c0-a38d-11e9-90ba-99fe0b367d70; cid=1; ai=1; skmtutc=N2ZwRCIKYWZR7q7gGbaItLNk7jQZC3zCruYu6uo3oDfvaqCTX/iqBE9XBPi8qRex-QmYp8ysYwdbPNTAQe+YfBwMpljY=; access_token=eAHjYBS4sr2BUWH78z2LvukaiRVkpqfm5-mm55elFuXlF-kWpxYBWVYKSclG5iaWFibmFqZGJpYpZkkmiSZaxilGScaWySkpJhZONgo7v196_lNXg9GIoGILkJUOTB6rn79b9lW3iZEhSsHC2DQ51cjIzMxCy8jExBJoVVqSiWlyclqagXGSgbEZAAGENqg**eAEFwQkBwDAIA0BLfC2NnADDv4TdWXpm2upNPYXYh2lR2iR6MIEteeeSlG6w4vO57cbwNZkfKYARtg; _gid=GA1.2.1420770563.1577790107; _lxsdk_s=16f607f0974-cbb-bb-40c%7C%7C3; JSESSIONID=537CE6FFDC265A7C99140652B5907B6D";

    private static final String SHOP_IDS = "{{shopIds}}";

    private static final String METHOD = "{\"url\":\"http://service.dianping.com/apollo/shop/apolloShopService\",\"method\":\"refreshShops\",\"ip\":\"10.76.165.15\",\"projectName\":\"com.sankuai.dzs.pre_sales.shopservice\",\"paramTypes\":[\"java.util.List\"],\"paramValues\":[\"" + SHOP_IDS + "\"],\"validate\":false,\"direct\":false,\"version\":1}";

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
        HttpPost httpPost = new HttpPost("https://pigeon.sankuai.com/ajax/set/call/invoke");
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
