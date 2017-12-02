package game;

import util.ConfigLoader;

public class ChessBoard {
	private Piece[][] pieces = new Piece[8][8];
	
	private void initChessBoard() {
		Piece piece = new Piece("1", "Cavalier", "Joueur 1", 'C');
		pieces[0][1] = piece;
	}
	
	public void addPiece(Piece piece, int i, int j) {
		pieces[i][j] = piece;
	}
	
	public void display (){
//		for(int i = 0; i < 8; i++)
//			System.out.print(" _");
		System.out.println();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(pieces[i][j] != null)
					System.out.print("|"+pieces[i][j].getDraw());
				else
					System.out.print("| ");
			}
			System.out.println("|");
		}
	}

	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		//chessBoard.initChessBoard();
		chessBoard.display();
		ConfigLoader.loadConfigFile("res/rules/chess.cfg", chessBoard);
		chessBoard.display();
	}
}
