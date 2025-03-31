import java.io.*;

public class Main {
    private static final String INVALID = "invalid";
    private static final String VALID = "valid";

    private static void solve(String s) {
        char[][] board = new char[3][3];
        int xCount = 0, oCount = 0;

        for (int i = 0; i < 9; i++) {
            char c = s.charAt(i);
            board[i / 3][i % 3] = c;
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
        }

        if (oCount > xCount || xCount - oCount > 1) {
            System.out.println(INVALID);
            return;
        }

        boolean xWins = isWinner(board, 'X');
        boolean oWins = isWinner(board, 'O');

        if (xWins && oWins) {
            System.out.println(INVALID);
        } else if (xWins && xCount != oCount + 1) {
            System.out.println(INVALID);
        } else if (oWins && xCount != oCount) {
            System.out.println(INVALID);
        } else if (!xWins && !oWins && xCount + oCount != 9) {
            System.out.println(INVALID);
        } else {
            System.out.println(VALID);
        }
    }

    private static boolean isWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("end")) {
            solve(input);
        }
    }
}