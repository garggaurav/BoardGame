/**
 * A general class to implement two player board games where players take turns
 * to fill the board.
 */
public abstract class Board{

	private int size; //Dimensions of the board size x size
	private char playerTurn='A'; //Alternates between A and B as players take turns
    private int connectionLength;
    private char[][] board;


    public abstract boolean hasConnection();
    /*
        Makes and returns empty board of specified size and connection length.
        @param1 (int): Size of the board
        @param2 (int): Connection Length
     */
    public char[][] makeBoard(int size, int length){
        this.size = size;
        this.connectionLength = length;
        board = new char[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                board[i][j] = '-';
            }
        }
        return board;
    }

    public int getSize(){
        return size;
    }

    public int getConnectionLength() {
        return connectionLength;
    }

    public char[][] getBoard(){
        return board;
    }

	public char getCurrentPlayer(){
		return playerTurn;
	}

    public char getOtherPlayer(){
        if(playerTurn == 'A') return 'B';
        else return 'A';
    }

    /*
        Returns true of board is full, false otherwise.
     */
    public boolean boardFull(){
        int size = getSize();
        char[][] board = getBoard();

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    /*
        Returns true if Board has a connection of length
        connectionLength from left to right
     */
	public boolean hasLTRConnection() {
        int size = getSize();
        char[][] board = getBoard();

        for(int i=0; i<size; i++){
            char check = board[i][0];
            int count = 0;

            for(int j=0; j<size;j++){
                if(check == '-' || check != board[i][j]) {
                    count = 0;
                    check = board[i][j];
                }
                count++;

                if(count == getConnectionLength()){
                    return true;
                }
            }
        }
        return false;
    }

    /*
       Returns true if Board has a connection of length
       connectionLength from top to bottom
    */
    public boolean hasTTBConnection(){
        int size = getSize();
        char[][] board = getBoard();

        for(int i=0; i<size; i++){
            char check = board[0][i];
            int count = 0;

            for(int j=0; j<size;j++) {
                if (check == '-' || check != board[j][i]) {
                    count = 0;
                    check = board[j][i];
                }
                count++;

                if(count == getConnectionLength()){
                    return true;
                }
            }
        }
        return false;

    }
    /*
        Returns true if Board has connection of length
        connectionLength along diagonal from top left to bottom right
     */
    public boolean hasDTRConnection() {
        int size = getSize();
        char[][] board = getBoard();

        for(int i=0; i<size;){
            char check = board[i][0];
            int count = 0;

            for(int j=0; j<size;){
                if(check == '-' || check != board[i][j]) {
                    count = 0;
                    check = board[i][j];
                }
                count++;

                if(count == getConnectionLength()){
                    return true;
                }

                i++; j++;
            }
        }
        return false;
    }
    /*
        Returns true if Board has connection of length
        connectionLength along diagonal from top right to bottom left
     */
    public boolean hasDTLConnection() {
        int size = getSize();
        char[][] board = getBoard();

        for(int i=0; i<size;){
            char check = board[i][size-1];
            int count = 0;

            for(int j=size-1; j>=0;){
                if(check == '-' || check != board[i][j]) {
                    count = 0;
                    check = board[i][j];
                }
                count++;

                if(count == getConnectionLength()){
                    return true;
                }

                i++; j--;
            }
        }
        return false;
    }

    /*
        Switches player between A and B
     */
	public void switchPlayer(){
		if(playerTurn == 'A') playerTurn = 'B';
		else playerTurn = 'A';
	}

    /*
        Prints the board
     */
    public void printBoard(){
        char[][] board = getBoard();
        int size = getSize();

        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
    /*
        Plays a random move and switches player
     */
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
        }while(board[i][j]!='-');

        board[i][j] = getCurrentPlayer();
        switchPlayer();
        return true;
    }

	
}