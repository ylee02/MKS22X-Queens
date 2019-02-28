import java.util.Arrays;
public class QueenBoard {
  private int[][]board;



  public QueenBoard(int size) {
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c) {
    if (c >= board.length || r >= board.length) {
      return false;
    }
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int i = 0; i < board.length; i++) {
        for (int y = 0; y < board[r].length; y++) {
          if ((i == r || (i - r == y - c) || ((-1 * (i-r) == y-c) && y > c)) && (y > c ) )  {
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
    if (c >= board.length || r >= board.length) {
      return false;
    }
   if (board[r][c] == -1) {
      board[r][c] = 0;
      for (int i = 0; i < board.length; i++) {
        for (int y = 0; y < board[r].length; y++) {
          if ((i == r || (i - r == y - c) || (-1 * (i-r) == y-c)) && (y > c ) && board[i][y] != 0)  {
            if (board[i][y] > 0) {
				board[i][y] -= 1;
			}
          }
        }
      }
      return true;
    }
    else {
      return false;
    }
  }
  
  public void clear() {
    int[][] temp = new int[board.length][board.length];
    board = temp;
  }
  
  public void isCleared() {
    for (int i = 0; i < board.length; i++) {
      for (int y = 0; y < board.length; y++) {
        if (board[i][y] != 0) {
          throw new IllegalStateException(); 
        } 
      }
    }
  }


  public int[][] getBoard() {
    return board;
  }
  public String toString() {
    String ans = "[";
    for (int i = 0; i < board.length; i++) {
      ans += "[" + board[i][0];
      for (int y = 1; y < board.length; y++) {
        ans += ", " + board[i][y];
      }
      ans += "]\n";
    }
    ans += "]";
    return ans;
  }

  public boolean solve() {
    return helper(0);
  }

  public boolean helper(int c) {
    if (c >= board.length) {
      return true;
    }
    for (int i = 0; i < board.length; i++) {
      if (addQueen(i, c)) {
        if (helper(c + 1)) {
          return true;
        }
        removeQueen(i, c);
      }
    }
    return false;
    
  }

  public int countSolutions() {
    return helper2(0);
  }
  
  public int helper2(int c) {
    if (c == board.length) {
		
		return 1;
	}
    else{
      int ans = 0;
      for (int i = 0; i < board.length; i++){
        if (addQueen(i, c)){
          ans+= helper2(c + 1);
		  
        }
		removeQueen(i,c);
      }
      return ans;
    }
  }
    
	
	


}
