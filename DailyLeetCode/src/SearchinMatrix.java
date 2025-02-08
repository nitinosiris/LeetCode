public class SearchinMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Binary search on first col to find correct row
        int start = 0, end = rows - 1;
        int mid = 0;
        while(start <= end)
        {
            mid = start + (end - start) / 2;
            if(matrix[mid][0] > target)
                end = mid - 1;
            else if(matrix[mid][cols - 1] < target)
                start = mid + 1;
            else
                break;
        }

        if(start > end)
            return false;

        int row = mid;
        int l = 0, r = cols - 1;
        while(l <= r)
        {
            int newMid = l + (r - l) / 2;
            if(matrix[row][newMid] == target)
                return true;
            else if(matrix[row][newMid] > target)
                r = newMid - 1;
            else
                l = newMid + 1;
        }
        return false;
    }
}
