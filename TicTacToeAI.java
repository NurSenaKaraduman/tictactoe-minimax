import java.util.*; 
/**
 * Tic Tac Toe AI - Minimax algoritmasıyla yenilmez XOX.
 *
 * Bilgisayar (O) her hamlede tüm olası oyun ağacını dolaşır
 * ve en iyi sonucu veren hamleyi seçer. Bu yüzden kazanmak
 * imkansızdır; en iyi ihtimalle berabere kalınır.
 *
 * Tahta tek boyutlu bir dizidir, indeksler şöyle dağılır:
 *
 *      0 | 1 | 2
 *      ---------
 *      3 | 4 | 5
 *      ---------
 *      6 | 7 | 8
 *
 * Algoritmanın kavramsal anlatımı için README.md dosyasına bak.
 */

public class TicTacToeAI {
 
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
 
 
    /** Tahtayı 3x3 düzeninde konsola yazdırır. */
    static void printBoard() {
        // i*3 püf noktası: tek boyutlu diziyi 3'lü gruplara böler.
        // i=0 -> 0,1,2  |  i=1 -> 3,4,5  |  i=2 -> 6,7,8
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i*3] + " | " + board[i*3+1] + " | " + board[i*3+2]);
        }
        System.out.println();
    }
 
 
    /** Verilen oyuncu kazandı mı kontrol eder (8 olası kombinasyon). */
    static boolean checkWinner(char player) {
        // Kazanma kombinasyonları: 3 satır, 3 sütun, 2 çapraz.
        // İç içe if'ler yerine veriyle yönlendirilen yaklaşım — daha temiz.
        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8},   // satırlar
            {0,3,6}, {1,4,7}, {2,5,8},   // sütunlar
            {0,4,8}, {2,4,6}             // çaprazlar
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
 
 
    /** Tahtada hiç boşluk kalmadıysa true (berabere durumu için). */
    static boolean isFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }
 
 
    /**
     * Minimax: oyun ağacını rekürsif olarak dolaşıp en iyi skoru bulur.
     *
     * Skorlama:  +1 = O kazandı, 0 = berabere, -1 = X kazandı.
     * (Simetrik olduğu için Math.max/min doğal çalışır.)
     *
     * Maximizing oyuncu (O) skoru büyütmeye, minimizing oyuncu (X)
     * küçültmeye çalışır. Bilgisayar, rakibin her zaman en kötüyü
     * yapacağını varsayar.
     */
    static int minimax(boolean isMaximizing) {
 
        // Taban durumlar — oyun bittiyse rekürsiyon durur.
        if (checkWinner('O')) return 1;
        if (checkWinner('X')) return -1;
        if (isFull())         return 0;
 
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
 
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    // Backtracking deseni: dene -> hesapla -> GERİ AL.
                    // Geri alma adımını unutursan zihinde denenen hamleler
                    // tahtada kalır ve oyun bozulur.
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
 
 
    /**
     * Bilgisayarın oynayacağı en iyi hücreyi belirler.
     * Minimax'in en dış katmanı gibi düşünülebilir — burada
     * sadece skoru değil, hangi index'in seçildiğini de tutarız.
     */
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
 
            // Kullanıcının sırası
            System.out.print("0-8 arası hamle gir (X): ");
            int userMove = sc.nextInt();
 
            if (board[userMove] != ' ') {
                System.out.println("Orası dolu!");
                continue;
            }
            board[userMove] = 'X';
 
            if (checkWinner('X')) { printBoard(); System.out.println("Kazandın!"); break; }
            if (isFull())         { System.out.println("Berabere!"); break; }
 
            // Bilgisayarın sırası — Minimax devreye giriyor
            int aiMove = bestMove();
            board[aiMove] = 'O';
 
            if (checkWinner('O')) { printBoard(); System.out.println("AI kazandı!"); break; }
            if (isFull())         { System.out.println("Berabere!"); break; }
        }
 
        sc.close();
    }
}
