public class MegaTicTacToe extends TicTacToe{

    public static void main(String[] args){
        MegaTicTacToe game = new MegaTicTacToe();
        game.playGame();
    }

    public MegaTicTacToe(){
        super(8);
    }

    @Override
    public boolean hasConnection() {
        return hasTTBConnection() || hasLTRConnection();
    }

}
