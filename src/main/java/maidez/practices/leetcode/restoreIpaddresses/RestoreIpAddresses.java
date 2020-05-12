package maidez.practices.leetcode.restoreIpaddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            String ip1 = s.substring(0, i + 1);
            if (!isNumberLegal(ip1)) {
                break;
            }
            for (int j = i + 1; j < s.length(); j++) {
                String ip2 = s.substring(i + 1, j + 1);
                if (!isNumberLegal(ip2)) {
                    break;
                }
                for (int k = j + 1; k < s.length(); k++) {
                    String ip3 = s.substring(j + 1, k + 1);
                    if (!isNumberLegal(ip3)) {
                        break;
                    }
                    String ip4 = s.substring(k + 1);
                    if (!isNumberLegal(ip4)) {
                        continue;
                    }
                    result.add(String.join(".", ip1, ip2, ip3, ip4));
                }
            }
        }
        return result;
    }

    private boolean isNumberLegal(String s) {
        if (s.length() > 3 || s.length() < 1) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }


    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses("010010");
        restoreIpAddresses.restoreIpAddresses("0000");
        restoreIpAddresses.restoreIpAddresses("25525511135");
    }
}
