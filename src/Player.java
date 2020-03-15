public class Player {
    private String name;
    private int wins;
    private char symbol;

    public Player(String name, char symbol){
        this.symbol = symbol;
        this.name = name;
        wins = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public char getSymbol() {
        return symbol;
    }

    public void addWin(){
        wins++;
    }
}
