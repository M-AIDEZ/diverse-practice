package maidez.practices.leetcode.shoppingoffers;

import java.util.*;
import java.util.stream.Stream;

//https://leetcode-cn.com/problems/shopping-offers/
public class ShoppingOffers {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String mostWord = "";
        int most = -1;
        Map<String, Integer> word2count = new HashMap<>();
        paragraph = paragraph
                .toLowerCase()
                .replaceAll("[!?',;.]", " ")
                .replaceAll("\\s\\s+", " ")
                .trim();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        for (String s : paragraph.split(" ")) {
            if (bannedSet.contains(s)) {
                continue;
            }
            if (word2count.containsKey(s)) {
                word2count.put(s, word2count.get(s) + 1);
            } else {
                word2count.put(s, 1);
            }
            if (word2count.get(s) > most) {
                mostWord = s;
                most = word2count.get(s);
            }
        }
        return mostWord;
    }

    public static void main(String[] args) {
        mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
    }
}