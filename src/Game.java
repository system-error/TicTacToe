import java.util.Scanner;

public class Game {
    private Board b;
    private Player p1;
    private Player p2;
    private Player current;
    private Player winner;


    public Game(){
        b =new Board();
        b.displayTheBoard();
    }

    public void play(){
        int row,col;
        String continuePlaying = "yes";
        Scanner in = new Scanner(System.in);
        do{
            System.out.print(current.getName() + " give me the row: ");
            row = in.nextInt();
            System.out.print(current.getName() + " give me the col: ");
            col = in.nextInt();
            if(b.play(row,col,current)){
                b.displayTheBoard();
                winner = b.checkForWinner();
                if(winner !=null){
                    System.out.println("Congratulations " + winner.getName() +"! You won!!");
                    System.out.print("Do you want to play again? Yes/No ");
                    continuePlaying = checkForWrongAnswer(in.next().toLowerCase());
                }else{
                    if(b.checkForTie()){
                        System.out.println("Tie!!");
                        System.out.print("Do you want to play again? Yes/No ");
                        continuePlaying = in.next().toLowerCase();
                    }
                }
                current = current == p1 ? p2 : p1;
            }
        }while(continuePlaying.equals("yes") || continuePlaying.equals("y"));

        if(continuePlaying.equals("no") || continuePlaying.equals("n")){
            if(winner.getWins() == 1){
                System.out.println("The winner is "+winner.getName()+ " with " + winner.getWins() +" win");
            }else{
                System.out.println("The winner is "+winner.getName()+ " with " + winner.getWins() +" wins");
            }
        }

    }

    public void getThePlayers(){
        Scanner in = new Scanner(System.in);
        System.out.print("Hello player 1, give me your name please: ");
        String name1 = in.next();
        p1 = new Player(name1,'X');
        System.out.print("Hello player 2, give me your name please: ");
        String name2 = in.next();
        p2 = new Player(name2,'O');
        current = p1;

    }

    private String checkForWrongAnswer(String continuePlaying){
        int counter=0;
        Scanner in = new Scanner(System.in);
        do{
            if (continuePlaying.equals("yes") || continuePlaying.equals("no") || continuePlaying.equals("y") || continuePlaying.equals("n")){

                winner.addWin();
                current = winner;
                b.initialTheBoard();
                break;
            }
            else {
                System.out.println("You gave me wrong answer. Please tell Yes or No or y or n");
                continuePlaying = in.next().toLowerCase();
                counter++;
            }
        }while(counter < 2);
        return continuePlaying;
    }



}
