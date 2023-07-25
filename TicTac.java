import java.util.Scanner;

public class TicTac{
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }


        boolean GameOver = false;
        char player = 'X';
        Scanner sc = new Scanner(System.in);
        
        while(!GameOver){

            PrintBoard(board);
            System.out.println("player " +player +" enter:");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if(board[row][col] == ' '){
                board[row][col] = player;
                GameOver = haveWon(board, player);
                if(!GameOver){
                    player = (player == 'X') ? 'O' : 'X';
                }else{
                    System.out.println("player " +player +" as won");
                    sc.close();
                }
            }else{
                System.out.println("Invalid move choose again");
            }



            if(draw(board)){
                System.out.println("Match Draw");
                sc.close();
                break;
            }
        
    }

    
}


    static boolean draw(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if(board[row][col] == ' '){
                    return false;
                }
            }
        }

        return true;

    }



    static boolean haveWon(char[][] board,char player) {

        // check for row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check for column
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
        return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
        return true;
        }
        return false;

        
    }


    static void PrintBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }

            System.out.println();
            if(row < 2)
                System.out.println("-------------");
        
            
        }

    }

}