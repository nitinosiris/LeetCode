import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<String, Set<Character>> squares = new HashMap<>();

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                String sq = (i / 3) + "," + (j / 3);
                if(board[i][j] == '.')
                    continue;

                if(rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j])
                        || cols.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j])
                        || squares.computeIfAbsent(sq, k -> new HashSet<>()).contains(board[i][j]))
                    return false;

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(sq).add(board[i][j]);
            }
        }
        return true;
    }
}
