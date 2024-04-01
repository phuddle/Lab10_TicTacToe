import java.util.Scanner;
public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain;

        do { // prompt players to play again
            playGame(in);
            playAgain = SafeInput.getYNConfirm(in, "Do you want to play again?");
            clearBoard();
        } while (playAgain);

        System.out.println("Thanks for playing Tic Tac Toe!");
    }
        //clear the board and set the player to x (since x moves first)
    private static void playGame(Scanner in)
    {
        clearBoard();
        display();

        //get coords for the moves which should be 1 - 3 for row and col
        //prompt user X to enter a coordinate
        //getRangedInt(scanner, "Choose your X coordinate [0-2]", 0, 2)
        //getRangedInt(scanner, "Choose your Y coordinate [0-2]", 0, 2)
        while (true)
        {
            int row = SafeInput.getRangedInt(in, "Enter row ", 1, 3);
            int col = SafeInput.getRangedInt(in,"Enter column ", 1, 3);

            row--; //converts to an array index
            col--; //converts to an array index

            if (isValidMove(row, col))
            { board[row][col] = currentPlayer;
                display();
                if (isWin(currentPlayer)) //if there is a win or a tie announce it
                {
                    System.out.println(currentPlayer + " wins!");
                    break;
                } else if (isTie()) {
                    System.out.println("It's a tie!");
                    break;
                }
                    togglePlayer();
                }
            else {
                System.out.println("Invalid move. Try again.");
            }

            }
    }
    private static void clearBoard() //sets all the board elements to space " "
    {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " "; //make this cell a space
            }
        }
    }

    private static void display() //displays the tictactoe grid
    {
        System.out.println(" 1 2 3");
        for (int row = 0; row < ROW; row++) {
            System.out.println((row + 1) + " ");
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col]);
                if (col < COL - 1)  //convert player move coordinates to array indices which are 0 - 2 by subtracting 1
                {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < ROW - 1)  //convert player move coordinates to array indices which are 0 - 2 by subtracting 1
            {
                System.out.println("-----");
            }
        }
        System.out.println();
    }







        //loop until converted player coords are a valid move
        private static boolean isValidMove(int row, int col)
        {
            //is it equal to space?
            return board[row][col].equals(" ");
        }



        //if approps check for a win or a tie (if it's possible for a win or a tie at this point in the game, check for it)
        private static boolean isWin(String player)
        {
            return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
        }

        private static boolean isRowWin(String player)
        {
            for(int row = 0; row < ROW; row++)
            {
                if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
                {
                    return true;
                }
            }
            return false; //no row win
        }

    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; //no column win
    }
     private static boolean isDiagonalWin(String player)
     {
         return board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) ||
                 board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player);//no diagonal win
     }


         private static boolean isTie()
         {
             for (int row = 0; row < ROW; row++)
             {
                 for (int col = 0; col < COL; col++)
                 {
                     if (board[row][col].equals(" "))
                     {
                         return false;
                     }
                 }
             }
             return true;
         }

        //toggle player (i.e. x --> o, o --> x)
    private static void togglePlayer()
    {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }
    }


