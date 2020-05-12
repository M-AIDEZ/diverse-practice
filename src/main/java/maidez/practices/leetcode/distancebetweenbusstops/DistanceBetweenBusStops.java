package maidez.practices.leetcode.distancebetweenbusstops;

//https://leetcode-cn.com/problems/distance-between-bus-stops/
public class DistanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalDistance = 0;
        int clockDistance = 0;
        boolean arrived = false;
        for (int i = start; totalDistance == 0 || i != start; i = (i + 1) % distance.length) {
            totalDistance += distance[i];
            if (!arrived) {
                clockDistance += distance[i];
                if (destination == ((i + 1) % distance.length)) {
                    arrived = true;
                }
            }
        }
        return Math.min(clockDistance, totalDistance - clockDistance);
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13, 18, 1, 44, 41, 14, 5, 38, 25, 48}, 22, 0));
    }

}
