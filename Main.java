//Vavatsioulas Dimitrios dai18008
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		TicTacToe game=new TicTacToe();
		Scanner scan=new Scanner(System.in);
		Random random=new Random();
	
		System.out.println("Welcome to this simple Tic Tac Toe game.");
		
		game.initBoard();
		char winner=0;
		do {
			game.printBoard();
			int x,y;
			//SEIRA TOU XRISTI
				do {
					
					System.out.println("It's players turn. Enter the row and then the column of your move (example: 1 and then 2 means first row and second column)");
					x=scan.nextInt()-1;
					y=scan.nextInt()-1; //giati otan o xristis dosei 3 kai 3, theloume na perasoume ston kodika 2 kai 2
					if(!game.isMoveValid(x, y)) System.out.println("Cell is already taken or you entered coordinates which are out of bounds . Try entering another cell."); //i kinisi ekteleitai mono an einai epitrepti, simfona me tin isMoveValid
					else {
						game.makeMove(x, y);
						break; //an i kinisi einai epitrepti, tote pame ston epomeno paikti, opote break apto loop tou xristi
					}
				}while(!game.isMoveValid(x, y))	;	
				
				if(game.winOrNot()) winner='x'; //an iparxei niki se auto to stadio, tote sigoura exei kerdisei o xristis. i metavliti winner xrisimopoieitai sto teliko stadio tou apotelesmatos
				
				game.changePlayer();
				
			//SEIRA TOU COMPUTER
				do {
					if(!game.winOrNot() && !game.isBoardFull()){ //protou kanei tin kinisi o ipologistis, prepei na elegksoume an exei kerdisei idi o xristis
						x=random.nextInt(3); 
						y=random.nextInt(3);
						System.out.println("Computer's move: "+(x+1)+(y+1));
						if(!game.isMoveValid(x, y)) System.out.println("Cell is already taken. Computer will try again another cell.");
						else{
							game.makeMove(x, y);
							break;
						}
					}
					else break;
				}while(!game.isMoveValid(x, y))	;
				
				game.changePlayer();
				
			}while(!game.winOrNot() && !game.isBoardFull());
		
		//TELIKO STADIO EMFANISIS APOTELESMATOS
		if (game.isBoardFull() && (!game.winOrNot()))
        {
			game.printBoard();
            System.out.println("The game is a tie. Noone wins.");
        }
        else
        {
            game.printBoard();
            if (winner=='x')  System.out.println("User wins!"); //i timi tis metavlitis winner elegxetai apo tin grammi 32.
            else System.out.println("Computer wins!");
        }
		
	}
}
