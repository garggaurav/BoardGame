public class TicTacToe extends Board{

    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        game.playGame();
    }

    public TicTacToe(){
        makeBoard(3, 3);
    }

    public TicTacToe(int size){
        makeBoard(size, 3);
    }

    public TicTacToe(int size, int length){
        makeBoard(size, length);
    }

    /*
        Plays a simulation of the game using Board.randomMove
     */
    public void playGame() {
        boolean gameover = hasConnection();
        while (!gameover) {
            randomMove();
            printBoard();
            gameover = hasConnection() || boardFull();
            System.out.println("GAMEOVER? " + gameover );
        }
    }

    @Override
    public boolean hasConnection() {
        return hasDTLConnection() || hasDTRConnection() || hasLTRConnection() || hasTTBConnection();
    }
}