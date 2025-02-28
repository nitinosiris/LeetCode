import java.util.Stack;

public class SurroundedRegions {
    private int rows;
    private int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        // iterate on all edges
        // if found 'O'
        // replace it with 'T'
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                // on edges
                if(((i == 0 || i == rows - 1) || (j == 0 || j == cols - 1)) && board[i][j] == 'O')
                {
                    dfs(board, i, j);
                }
            }
        }


        // change all those O to X if they are not T
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                // on edges
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col)
    {
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {row, col});

        while(!stack.isEmpty())
        {
            var top = stack.pop();
            int i = top[0];
            int j = top[1];

            // change pos to T
            board[i][j] = 'T';

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] dir : directions)
            {
                int newRow = dir[0] + i;
                int newCol = dir[1] + j;

                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
                    continue;
                else
                {
                    if(board[newRow][newCol] == 'O')
                        stack.push(new int[] {newRow, newCol});
                }
            }
        }
    }
}
