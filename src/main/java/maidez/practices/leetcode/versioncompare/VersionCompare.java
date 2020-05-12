package maidez.practices.leetcode.versioncompare;

public class VersionCompare {
    public static int compareVersion(String version1, String version2) {
        String[] version1arr = version1.split("\\.");
        String[] version2arr = version2.split("\\.");
        int length = Math.max(version1arr.length, version2arr.length);
        for (int i = 0; i < length; i++) {
            int a = i > version1arr.length - 1 ? 0 : Integer.parseInt(version1arr[i]);
            int b = i > version2arr.length - 1 ? 0 : Integer.parseInt(version2arr[i]);
            int compareResult = Integer.compare(a, b);
            if (compareResult != 0) {
                return compareResult;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }
}
