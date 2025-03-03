public class SumMatrix {
    int[][] _matrix;
    int rows, cols;

    public SumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        _matrix = new int[rows][cols];

        // Compute row-wise prefix sums
        for (int i = 0; i < rows; i++) {
            _matrix[i][0] = matrix[i][0];
            for (int j = 1; j < cols; j++) {
                _matrix[i][j] = _matrix[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        // Compute sum for each row in the range
        for (int r = row1; r <= row2; r++) {
            sum += _matrix[r][col2] - (col1 > 0 ? _matrix[r][col1 - 1] : 0);
        }

        return sum;
    }
}
