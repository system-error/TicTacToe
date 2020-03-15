public class Board {

    private Player[][] board;

    public Board(){
        board = new Player[3][3];
        initialTheBoard();
    }

    public void initialTheBoard(){
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                board[row][col] = null;
            }
        }
    }
    public void displayTheBoard(){
        for (int i = 1; i < 4; i++){
            System.out.print("   " +i);
        }
        System.out.println();
        for (int row = 0; row < 3; row++){
            System.out.println(" -------------");
            System.out.print(row +1 + "| ");
                for (int col = 0; col < 3; col++){
                    System.out.print(board[row][col] == null ? "# | " : board[row][col].getSymbol() + " | " );
                }
            System.out.println();
        }
        System.out.println(" -------------");
    }

    public boolean play(int row, int col, Player p) {
        if ((row > 1 || row <= 3 || col > 1 || col <= 3)) {
            if(board[row - 1][col - 1] == null){
                board[row - 1][col - 1] = p;
                return true;
            }else  {
                System.out.println("Please try another coordinate!!");
                return false;
            }
        }else{
            return false;
        }
    }

    public Player checkForWinner(){
        for(int i = 0; i<3; i++){
            //check in rows for winner
            if((board[i][0] == board[i][1]) && (board[i][0] == board[i][2] )){
                return board[i][0];
            }
            //check in columns for winner
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] ){
                return board[0][i];
            }
        }
        //check in left diagonal for winner
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2] ){
            return board[0][0];
        }
        //check in right diagonal for winner
        if(board[0][2] == board[1][1] && board[0][2] == board[2][0] ){
            return board[0][2];
        }
        return null;
    }

    public boolean checkForTie(){
        int counter =0;
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                counter++;
                if(board[row][col] != null && counter==9){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.displayTheBoard();
        Player p1 = new Player("Chris",'X');
        Player p2 = new Player("Takis",'O');
        b.play(1,1,p1);
        b.play(1,2,p1);
        b.play(1,3,p2);
        b.play(2,1,p2);
        b.play(2,2,p1);
        b.play(2,3,p1);
        b.play(3,1,p1);
        b.play(3,2,p1);
        b.play(3,3,p2);
        b.displayTheBoard();
        b.checkForTie();
        b.checkForWinner();
    }

}
