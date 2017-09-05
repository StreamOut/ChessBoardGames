package game;

public class ChessBoard {
	
	public void display (){
//		for(int i = 0; i < 8; i++)
//			System.out.print(" _");
		System.out.println();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print("| ");
			}
			System.out.println("|");
		}
	}

	public static void main(String[] args) {
		new ChessBoard().display();
	}
}
