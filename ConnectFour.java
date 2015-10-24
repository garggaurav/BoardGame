public class ConnectFour extends Board{

    public static void main(String[] args){
        ConnectFour game = new ConnectFour();
        game.playGame();
    }

    public ConnectFour(){
        makeBoard(6, 4);
    }

    public ConnectFour(int size){
        makeBoard(size, 4);
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

    @Override
    public boolean randomMove(){

        if(boardFull())
            return false;

        char[][] board = getBoard();
        int size = getSize();
        int i;
        int j;
        do{
            i = (int)Math.floor(Math.random()*size); //random number from 0 to size
            j = (int)Math.floor(Math.random()*size); //random number from 0 to size
        }while(board[i][j]!='-' || (i!=(size-1) && board[i+1][j]=='-'));

        board[i][j] = getCurrentPlayer();
        switchPlayer();
        return true;
    }

}