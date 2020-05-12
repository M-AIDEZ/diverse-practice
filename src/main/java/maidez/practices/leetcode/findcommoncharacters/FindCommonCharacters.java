package maidez.practices.leetcode.findcommoncharacters;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
        给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
        例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

        你可以按任意顺序返回答案。
        示例 1：
        输入：["bella","label","roller"]
        输出：["e","l","l"]
        示例 2：
        输入：["cool","lock","cook"]
        输出：["c","o"]

        提示：
        1 <= A.length <= 100
        1 <= A[i].length <= 100
        A[i][j] 是小写字母

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/find-common-characters
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class FindCommonCharacters {
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        for (char targetChar : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            String targetCharStr = "" + targetChar;
            int commonAppealCount = Integer.MAX_VALUE;
            for (String s : A) {
                if (!s.contains(targetCharStr)) {
                    commonAppealCount = 0;
                    break;
                }
                int appealCount = 0;
                for (char c : s.toCharArray()) {
                    if (c == targetChar) {
                        appealCount++;
                    }
                }
                commonAppealCount = Math.min(commonAppealCount, appealCount);
                if (commonAppealCount == 0) {
                    break;
                }
            }
            if (commonAppealCount == 0) {
                continue;
            }

            for (int i = 0; i < commonAppealCount; i++) {
                result.add(targetCharStr);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(commonChars(new String[]{"bella", "label", "roller"})));
    }
}
