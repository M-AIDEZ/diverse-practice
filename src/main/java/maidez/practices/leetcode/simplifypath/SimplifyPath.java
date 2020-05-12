package maidez.practices.leetcode.simplifypath;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        int i = 0;
        String[] paths = new String[split.length];
        for (String s : split) {
            if ("".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                if (i != 0) {
                    i--;
                }
            } else if (!".".equals(s)) {
                paths[i++] = s;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i1 = 0; i1 < i; i1++) {
            sb.append("/").append(paths[i1]);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        simplifyPath.simplifyPath("/a//b////c/d//././/..");
    }
}
