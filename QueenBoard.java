import java.util.Arrays;
public class QueenBoard {
  private int[][]board;



  public QueenBoard(int size) {
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int i = 0; i < board.length; i++) {
        for (int y = 0; y < board[r].length; y++) {
          if ((i == r || (i - r == y - c)) && (y > c || i > r))  {
            board[i][y] += 1;
          }
        }
      }
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for (int i = 0; i < board.length; i++) {
        for (int y = 0; y < board[r].length; y++) {
          if ((i == r || (i - r == y - c)) && (y >= c || i > r) && board[i][y] != 0) {
            board[i][y] -= 1;
          }
        }
      }
      return true;
    }
    else {
      return false;
    }
  }

  public int[][] getBoard() {
    return board;
  }
  public String toString() {
    return "";
  }

  public boolean solve() {
    return true;
  }

  public int countSolutions() {
    return 0;
  }

}
