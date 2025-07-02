import java.util.*;

public class NQueenJava {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        
        int[] leftRow = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];

        backtrack(0, board, res, leftRow, lowerDiag, upperDiag, n);
        return res;
    }

    private void backtrack(int col, char[][] board, List<List<String>> res,
                           int[] leftRow, int[] lowerDiag, int[] upperDiag, int n) {
        if (col == n) {
            List<String> solution = new ArrayList<>();
            for (char[] row : board)
                solution.add(new String(row));
            res.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[n - 1 + col - row] = 1;

                backtrack(col + 1, board, res, leftRow, lowerDiag, upperDiag, n);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[n - 1 + col - row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        NQueenJava solver = new NQueenJava();

        System.out.println("Example: n = 4");
        List<List<String>> result4 = solver.solveNQueens(4);
        for (List<String> board : result4) {
            for (String row : board)
                System.out.println(row);
            System.out.println();
        }

        System.out.println("Example: n = 5");
        List<List<String>> result5 = solver.solveNQueens(5);
        for (List<String> board : result5) {
            for (String row : board)
                System.out.println(row);
            System.out.println();
        }
    }
}
