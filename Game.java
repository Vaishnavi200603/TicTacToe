import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        while(!gameOver){
            printBoard(board);
            System.out.print("Player " + player + " enter row : ");
            int row = sc.nextInt();
            System.out.print("Player " + player + " enter col: ");
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                count++;
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("*************************************");
                    System.out.println("PLAYER " + player + " WON!!!");
                    System.out.println("*************************************");
                    gameOver = true;
                }
                else{
                    if(player == 'X'){
                        player = 'O';
                    }
                    else{
                        player = 'X';
                    }
                }
            }
            else{
                System.out.println("invalid move, TRY AGAIN");
                System.out.println("-----------------------------------------------------------------");
            }

            if(count == 9){
                System.out.println("*************************************");
                System.out.println("IT'S A TIE");
                System.out.println("*************************************");
                gameOver = true;
            }
        }
        printBoard(board);
    }

    public static void printBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board, char player){
        //check the rows
        for(int i=0; i<board.length; i++){
            if(board[i][0] == player && board[i][1] == player
                    && board[i][2] == player){
                return true;
            }
        }

        //check for columns
        for(int j=0; j<board[0].length; j++){
            if(board[0][j] == player && board[1][j] == player
                    && board[2][j] == player){
                return true;
            }
        }

        //for diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
}
