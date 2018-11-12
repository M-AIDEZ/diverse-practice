package maidez.practices.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * Created by luwenyi on 2018/9/6.
 */
public class ChocolateBuyList {

    //数量
    private static int[] prdCnt = {1152, 576, 384, 288, 192, 96, 60, 48, 27, 15};
    //价值
    private static int[] prdCost = {2865, 1598, 946, 766, 474, 269, 170, 139, 89, 65};

    private static int maxw = 3500;

    public static void main(String[] args) {

        for (int i = 0; i < prdCnt.length; i++) {
            System.out.println(String.format("[ %s 粒装, 价格：%s，单价：%s ]", prdCnt[i], prdCost[i], (double) prdCost[i] / prdCnt[i]));
        }

        int[] cost = new int[maxw + 1];
        int[] buyCnt = new int[maxw + 1];
        Map<Integer, Integer[]> buyMap = Maps.newHashMap();
        for (int i = 0; i < cost.length; i++) {
            cost[i] = i == 0 ? 0 : Integer.MAX_VALUE;
            buyCnt[i] = 0;
            buyMap.put(0, new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        }

        for (int needCnt = 1; needCnt <= maxw; needCnt++) {
            for (int prdIdx = 0; prdIdx < prdCnt.length; prdIdx++) {
                int reference = needCnt - prdCnt[prdIdx] < 0 ? 0 : needCnt - prdCnt[prdIdx];
                Integer[] referenceBuyMap = buyMap.get(reference);
                if (buyCnt[reference] + prdCnt[prdIdx] >= needCnt && cost[reference] + prdCost[prdIdx] < cost[needCnt]) {
                    cost[needCnt] = cost[reference] + prdCost[prdIdx];
                    buyCnt[needCnt] = buyCnt[reference] + prdCnt[prdIdx];
                    Integer[] thisBuyMap = referenceBuyMap.clone();
                    thisBuyMap[prdIdx]++;
                    buyMap.put(needCnt, thisBuyMap);
                }
            }
        }

        for (int i = 3200; i <= 3200; i++) {
            System.out.println(String.format("需求：%s, 实际购买：%s，花费：%s，购买组合：%s", i, buyCnt[i], cost[i], Optional.ofNullable(buyMap.get(i)).map(ChocolateBuyList::buyListStr).orElse("计算错误")));
        }
    }

    private static String buyListStr(Integer[] buyList) {
        StringBuilder strBuilder = new StringBuilder("");
        for (int i = 0; i < prdCnt.length; i++) {
            try {
                strBuilder.append(String.format("[ %s 粒装：%s份 ]，", prdCnt[i], buyList[i]));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(1);
            }
        }
        return strBuilder.toString().substring(0, strBuilder.length() - 1);
    }

}
