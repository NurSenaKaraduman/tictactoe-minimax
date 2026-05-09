import java.util.*;

public class TicTacToeAI {

    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    // Tahtayı yazdır
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i*3] + " | " + board[i*3+1] + " | " + board[i*3+2]);
        }
        System.out.println();
    }

    // Kazanan kontrolü
    static boolean checkWinner(char player) {
        int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == player &&
                board[pos[1]] == player &&
                board[pos[2]] == player) {
                return true;
            }
        }
        return false;
    }

    // Tahta dolu mu?
    static boolean isFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }

    // Minimax
    static int minimax(boolean isMaximizing) {

        if (checkWinner('O')) return 1;
        if (checkWinner('X')) return -1;
        if (isFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = 'O';
                    int score = minimax(false);
                    board[i] = ' ';
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;

        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = 'X';
                    int score = minimax(true);
                    board[i] = ' ';
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    // En iyi hamle
    static int bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int move = 0;

        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = 'O';
                int score = minimax(false);
                board[i] = ' ';

                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }
        return move;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();

            System.out.print("0-8 arası hamle gir (X): ");
            int userMove = sc.nextInt();

            if (board[userMove] != ' ') {
                System.out.println("Orası dolu!");
                continue;
            }

            board[userMove] = 'X';

            if (checkWinner('X')) {
                printBoard();
                System.out.println("Kazandın!");
                break;
            }

            if (isFull()) {
                System.out.println("Berabere!");
                break;
            }

            int aiMove = bestMove();
            board[aiMove] = 'O';

            if (checkWinner('O')) {
                printBoard();
                System.out.println("AI kazandı!");
                break;
            }

            if (isFull()) {
                System.out.println("Berabere!");
                break;
            }
        }

        sc.close();
    }
}