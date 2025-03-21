import java.util.HashSet;

public class MinRec {
    //    Given a set of points find 4 points which form a rectangle and has
//    largest area of any such rectangle.
//    consider axes of rectangle parallel to x and y axis

    public int minAreaRect(int[][] points) {
        HashSet<String> set = new HashSet<>();

        for(int[] pt : points)
        {
            String str = pt[0] + "," + pt[1];
            set.add(str);
        }
        int minArea = Integer.MAX_VALUE;
        int x1; int y1; int x2; int y2;
        for(int i = 0; i < points.length - 1; i++)
        {
            // bottom left
            x1 = points[i][0];
            y1 = points[i][1];

            for(int j = i + 1; j < points.length; j++)
            {
                // top right
                x2 = points[j][0];
                y2 = points[j][1];

                if (x1 == x2 || y1 == y2)
                    continue;
                // right bottom
                String rightBottom = x2 + "," + y1;

                // top left
                String topLeft = x1 + "," + y2;

                if(set.contains(rightBottom) && set.contains(topLeft))
                {
                    minArea = Math.min(minArea, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
