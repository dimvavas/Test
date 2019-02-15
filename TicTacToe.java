//Vavatsioulas Dimitrios dai18008

public class TicTacToe {
	private char[][] board;
	private char currentPlayer;
	
	//constructor
	public TicTacToe(){
		board=new char[3][3];
		initBoard();
		currentPlayer='x';
	}
	
	//getter gia to currentPlayer
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	//arxikopoiisi pinaka
	public void initBoard() {
		for(int i=0;i<3;i++) 
			for(int j=0;j<3;j++) 
				board[i][j]='-';
	}
	
	//ektiposi pinaka
	public void printBoard() {
		System.out.println("==============");
        for (int i=0;i<3;i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
                System.out.print(board[i][j] + " | ");
            System.out.println();
            System.out.println("==============");
        }
	}
	
	//elegxos an iparxei niki diagonia
	public boolean diagonalWin() {
		return (  ( (board[0][0]==board[1][1]) && (board[0][0]==board[2][2]) && (board[0][0]!='-') ) || ( (board[0][2]==board[1][1]) && (board[0][2]==board[2][0]) &&  (board[0][2]!='-') )  );
	}
	
	//elegxos an iparxei niki orizontia
	public boolean horizontalWin() {
		for(int i=0;i<3;i++) {
			if((board[i][0]==board[i][1]) && (board[i][0]==board[i][2]) && (board[i][0]!='-')) return true;
			
		}
		return false;
	}
	
	//elegxos an iparxei niki katheta
	public boolean verticalWin() {
		for(int y=0;y<3;y++) {
			if((board[0][y]==board[1][y]) && (board[0][y]==board[2][y]) && (board[0][y]!='-')) return true;
			
		}
		return false;
	}
	
	//sindiasmos twn 3 elegxwn oste na doume an iparxei niki
	public boolean winOrNot() {
		return (horizontalWin() || verticalWin() || diagonalWin());
	}
	
	//elegxei an o pinakas einai gematos
	public boolean isBoardFull() {
		boolean isFull=true;
			for(int i=0;i<3;i++) {
				for(int j=0; j<3;j++) {
					if (board[i][j]=='-'){
							isFull=false;
					}
				}
			}
		return isFull;
	}
	
	//allagi paikti pou exei seira na paiksei
	public void changePlayer() {
		if (currentPlayer=='x') currentPlayer='o';
		else currentPlayer='x';
	}
	
	//ektelei ston pinaka tin kinisi pou dinei input o xristis.
    public void makeMove(int x, int y) {
    	board[x][y] = currentPlayer;
    }
    
    //elegxei an i dosmeni kinisi epitrepetai
    public boolean isMoveValid(int x, int y) {
    		if((x>=0 && x<3) && (y>=0 && y<3)) {
    				if (board[x][y]=='-') {
    					return true; //diladi i kinisi mporei na paixtei. einai entos orion kai to keli eleuthero
    				}
    		}
    		return false;
    }
}