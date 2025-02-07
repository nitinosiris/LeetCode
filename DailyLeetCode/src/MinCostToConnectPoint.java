import java.util.*;

public class MinCostToConnectPoint {
    class Point{
        int x, y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y; // Simple hash function
        }
    }
    class Triple implements Comparable<Triple> {
        int first;
        Point p1, p2;

        // Constructor
        public Triple(int first, int xi, int yi, int xj, int yj) {
            this.first = first;
            this.p1 = new Point(xi, yi);
            this.p2 = new Point(xj, yj);
        }

        // Compare by the first integer
        @Override
        public int compareTo(Triple other) {
            return Integer.compare(this.first, other.first);
        }
    }

    class DisjointSetUnion {
        private final Map<Point, Point> parent = new HashMap<>();
        private final Map<Point, Integer> rank = new HashMap<>();

        public void makeSet(Point p) {
            if (!parent.containsKey(p)) {  // Ensure each point is initialized
                parent.put(p, p);
                rank.put(p, 0);
            }
        }

        public Point find(Point p) {
            makeSet(p);
            if (!parent.get(p).equals(p)) {
                parent.put(p, find(parent.get(p))); // Path compression
            }
            return parent.get(p);
        }

        public void union(Point p1, Point p2) {
            Point root1 = find(p1);
            Point root2 = find(p2);

            if (root1.equals(root2)) return; // Already in same set

            int rank1 = rank.get(root1);
            int rank2 = rank.get(root2);

            if (rank1 < rank2) {
                parent.put(root1, root2);
            } else if (rank2 < rank1) {
                parent.put(root2, root1);
            } else {
                parent.put(root2, root1);
                rank.put(root1, rank1 + 1);
            }
        }
    }


    class Solution {
        public int minCostConnectPoints(int[][] points) {
            List<Triple> edges = new ArrayList<>();
            int n = points.length;

            // Create all possible edges
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(new Triple(dis, points[i][0], points[i][1], points[j][0], points[j][1]));
                }
            }

            // Sort edges by weight (distance)
            Collections.sort(edges);

            // Initialize DSU and make sets for all unique points
            DisjointSetUnion dsu = new DisjointSetUnion();
            for (int[] point : points) {
                dsu.makeSet(new Point(point[0], point[1]));
            }

            int cost = 0, count = 0;
            for (Triple edge : edges) {
                if (dsu.find(edge.p1).equals(dsu.find(edge.p2))) continue;

                // Add edge to MST
                cost += edge.first;
                dsu.union(edge.p1, edge.p2);
                count++;

                // Stop early if we have n-1 edges
                if (count == n - 1) break;
            }

            return cost;
        }
    }

}
