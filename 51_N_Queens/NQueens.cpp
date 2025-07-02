#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
  void func(int col, int n, vector<string> &board, vector<int> &leftRow, vector<int> &upperDiag, vector<int> &lowerDiag, vector<vector<string>> &res)
  {
    if (col == n)
    {
      res.push_back(board);
      return;
    }

    for (int row = 0; row < n; row++)
    {
      if (leftRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n + col - row - 1] == 0)
      {
        board[row][col] = 'Q';
        leftRow[row] = 1;
        lowerDiag[row + col] = 1;
        upperDiag[n + col - row - 1] = 1;

        func(col + 1, n, board, leftRow, upperDiag, lowerDiag, res);

        board[row][col] = '.';
        leftRow[row] = 0;
        lowerDiag[row + col] = 0;
        upperDiag[n + col - row - 1] = 0;
      }
    }
  }

public:
  vector<vector<string>> solveNQueens(int n)
  {
    vector<vector<string>> res;
    vector<string> board(n, string(n, '.'));
    vector<int> leftRow(n, 0), upperDiag(2 * n - 1, 0), lowerDiag(2 * n - 1, 0);
    func(0, n, board, leftRow, upperDiag, lowerDiag, res);
    return res;
  }
};

int main()
{
  Solution solver;

  cout << "Example 1: n = 4\n";
  vector<vector<string>> result4 = solver.solveNQueens(4);
  for (auto &board : result4)
  {
    for (auto &row : board)
      cout << row << "\n";
    cout << "\n";
  }

  cout << "Example 2: n = 5\n";
  vector<vector<string>> result5 = solver.solveNQueens(5);
  for (auto &board : result5)
  {
    for (auto &row : board)
      cout << row << "\n";
    cout << "\n";
  }

  return 0;
}
