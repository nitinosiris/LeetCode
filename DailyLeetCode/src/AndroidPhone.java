public class AndroidPhone {
    int[][] directions = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    // skip[i][j] = k means from i to j need to pass through k
    int[][] skip = new int[10][10];
    int ans;
    int min, max;

    public int uniquePatterns(int n, int m) {
        ans = 0;
        min = n;
        max = m;

        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        skip[4][6] = skip[6][4] = 5;
        skip[2][8] = skip[8][2] = 5;
        skip[7][3] = skip[3][7] = 5;
        skip[9][1] = skip[1][9] = 5;

        boolean[] visited = new boolean[10];

        // 1, 3, 7, 9 are symmetric (corner points)
        ans += 4 * dfs(1, 1, visited);
        // 2, 4, 6, 8 are symmetric (edge centers)
        ans += 4 * dfs(2, 1, visited);
        // 5 is center
        ans += dfs(5, 1, visited);

        return ans;
    }

    private int dfs(int current, int len, boolean[] visited) {
        if (len > max) return 0;
        int res = 0;
        if (len >= min) res++;

        visited[current] = true;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[current][i] == 0 || visited[skip[current][i]])) {
                res += dfs(i, len + 1, visited);
            }
        }
        visited[current] = false;
        return res;
    }
}
