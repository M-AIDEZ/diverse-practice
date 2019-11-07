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

    private static final String ACCESS_TOKEN = "eAHjYBS4sr2BUWHT_O6tj3SNxAoy01Pz83TT88tSi_Lyi3SLU4uALCuFpGQjcxNLCxNzC1MjE8sUsySTRBMt4xSjJGPL5JQUEwsnS4VbHfe-PdXVYDQiqNgCZKUDk8eFHz-3PtSNUjA1M0kytzRLTDHTMjSxNEhKskw1NEpOSTY1tzRINkyxBAAPdTX0**eAEFwQcBwEAIBDBLzAJy_hj-JTSxj2z3siBP1W_GAz5rZB6Jauam0AVxKkroSV7XrOLYzH87EBGC";

    private static final String COOKIE = "_lxsdk_cuid=16b3f2467efc8-0da81e0d708eb7-37637e03-1fa400-16b3f2467efc8; _lxsdk=16b3f2467efc8-0da81e0d708eb7-37637e03-1fa400-16b3f2467efc8; _hc.v=dd20ec08-6b4e-0680-e70e-50544d777b62.1560247557; _ga=GA1.2.1985983270.1560398688; uu=87a1e0c0-a38d-11e9-90ba-99fe0b367d70; cid=1; ai=1; skmtutc=N2ZwRCIKYWZR7q7gGbaItLNk7jQZC3zCruYu6uo3oDfvaqCTX/iqBE9XBPi8qRex-QmYp8ysYwdbPNTAQe+YfBwMpljY=; u=1111938539; SSO_SID=eAHjYBS4sr2BUWHupJWdj3SNuCySTFJMLQ0TE02tFJKSjcxNLC1MzC1MjUwsU8ySTBJNtIxTjJKMLZNTUkwsnCwV9p_acO6prgajEUHFFiBrHJg8tu860_tQN0rBKCk1yTjROMk0UcvcJNHC0MLc1NzYxNIyKS3FzCjFxBQAIuAuvw**eAEFwQkBwDAIA0BLoeMpcggF_xJ212QvvQmFP0B3_G2FdAjFkuvGyYN75IwV1z4qpAJ7s-UHZgUSJw; access_token=eAHjYBS4sr2BUWHT_O6tj3SNxAoy01Pz83TT88tSi_Lyi3SLU4uALCuFpGQjcxNLCxNzC1MjE8sUsySTRBMt4xSjJGPL5JQUEwsnS4VbHfe-PdXVYDQiqNgCZKUDk8eFHz-3PtSNUjA1M0kytzRLTDHTMjSxNEhKskw1NEpOSTY1tzRINkyxBAAPdTX0**eAEFwQcBwEAIBDBLzAJy_hj-JTSxj2z3siBP1W_GAz5rZB6Jauam0AVxKkroSV7XrOLYzH87EBGC; _lxsdk_s=16e25a07d60-294-02-d91%7C%7C66; JSESSIONID=F49FF1B564CC97BBEB90BC13E3D86E64";

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
        File file = new File("/Users/luwenyi/Desktop/ShopsToFresh2.txt");
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
