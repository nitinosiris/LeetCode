import java.util.HashSet;

public class NonParallelRec {
    public double minAreaFreeRect(int[][] points) {
        double minArea = Double.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int[] pt : points) {
            set.add(encode(pt));
        }
        for (int i=0; i<points.length; i++) {
            for (int j=i+1; j<points.length; j++) {
                for (int k=j+1; k<points.length; k++) {

                    if (dist(points[i], points[k]) + dist(points[k], points[j])
                            != dist(points[i], points[j]))
                        continue;

                    int x4 = points[i][0] + points[j][0] - points[k][0];
                    int y4 = points[i][1] + points[j][1] - points[k][1];
                    if (!set.contains(encode(new int[] {x4, y4})))
                        continue;

                    double area = Math.sqrt(dist(points[i], points[k])) * Math.sqrt(dist(points[k], points[j]));

                    if (area == 0)
                        continue;
                    minArea = Math.min(area, minArea);
                }
            }

        }
        if (minArea == Double.MAX_VALUE) // be careful about this
            minArea = 0;
        return minArea;
    }
    public double dist(int[] pt1, int[] pt2) {
        return Math.pow(pt1[0] - pt2[0], 2) + Math.pow(pt1[1] - pt2[1], 2);
    }
    public int encode(int[] pt) {
        return pt[0] * 40000 + pt[1];
    }
}
