import java.util.*;

public class TicTacToe_terminal {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    // Save the board as a list of strings. Each element respresentig one space on a board.
    static String[] board = new String[9];
    // static int[] ints = IntStream.range(1, 10).toArray(); // Array of nulls, od length 9
    // static String[] board = Arrays.toString(ints).split("[\\[\\]]")[1].split(", ");

    // Scanner object for user inputs
    static Scanner inputs = new Scanner(System.in);

    // Initial board
    static String[] initializeBoard(String[] board) {
        for (int i = 1; i < 10; i++) {
            board[i-1] = ANSI_BLACK + Integer.toString(i) + ANSI_RESET;
        }
        return board;
    }

    static void printBoard(String[] board) {
        String horizontalLine = "-------------";
        System.out.println(horizontalLine);
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println(horizontalLine);
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println(horizontalLine);
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println(horizontalLine);
    }

    static boolean chooseSlot(String player) {
        System.out.print("Input a slot number: ");
        Integer slotNum = Integer.valueOf(inputs.nextLine());

        if (slotNum < 1 || slotNum > 9) {
            System.out.println(ANSI_RED + "Invalid input! Input a slot number again!" + ANSI_RESET);
            return false;

        } else if (board[slotNum - 1] == "X" || board[slotNum - 1] == "O") {
            System.out.println(ANSI_RED + "Slot is already taken! Input a slot number again!" + ANSI_RESET);
            return false;

        } else {
            board[slotNum - 1] = player;
            return true;
        }
    }

    static boolean checkWinner(String[] board) {
        String[] winOptions = {board[0] + board[1] + board[2],
                               board[3] + board[4] + board[5],
                               board[6] + board[7] + board[8],
                               board[0] + board[3] + board[6],
                               board[1] + board[4] + board[7],
                               board[2] + board[5] + board[8],
                               board[0] + board[4] + board[8],
                               board[2] + board[4] + board[6]};
        boolean XWon = Arrays.stream(winOptions).anyMatch("XXX"::equals);
        boolean OWon = Arrays.stream(winOptions).anyMatch("OOO"::equals);

        if (XWon) {
            printBoard(board);
            System.out.println("X IS THE WINNER!!!");
            return XWon;
        } else if (OWon) {
            printBoard(board);
            System.out.println("O IS THE WINNER!!!");
            return OWon;
        } else {
            return false;
        }
    } 
                        
    public static void main(String[] args) {
        String[] players = {"X", "O"};
        Integer i = 0;
        board = initializeBoard(board);

        while (!checkWinner(board)) {
            printBoard(board);
            boolean B = chooseSlot(players[i]);

            if (B) {
                i = (i + 1) % 2;
            }
        }
    }
}