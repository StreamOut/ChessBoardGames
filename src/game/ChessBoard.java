package game;

import java.util.ArrayList;
import java.util.Scanner;

import util.ConfigLoader;

public class ChessBoard {
	private Piece[][] pieces = new Piece[8][8];
	private String joueur1;
	private String joueur2;
	
	private ArrayList<Vector> calulateMove (int i, int j) {
		ArrayList<Vector> moves = new ArrayList<>();
		boolean freeWay = true;
		if(pieces[i][j] != null) {
			ArrayList<Vector> pieceMove = pieces[i][j].getMovements();
			for(int z = 0; z < pieceMove.size(); z++) {
				Vector move = pieceMove.get(z);
				if(i + move.getAxeX() < 8 && i + move.getAxeX() >= 0 && j + move.getAxeY() < 8 && j + move.getAxeY() >= 0) {
					if(move.getAxeX() == 0) {
						for(int l = j + 1; l <= j + move.getAxeY(); l++)
							if(pieces[i][l] != null)
								freeWay = false;
					}
					else if(move.getAxeY() == 0) {
						for(int k = i + 1; k <= i + move.getAxeX(); k++)
							if(pieces[k][j] != null)
									freeWay = false;
					}
					else {
						for(int k = i + 1; k <= i + move.getAxeX(); k++)
							for(int l = j + 1; l <= j + move.getAxeY(); l++)
								if(pieces[k][l] != null)
									freeWay = false;
					}
					if(freeWay)
						moves.add(move);
				}
			}
		}
		return moves;
	}
	
	private void movePiece(int i, int j, Vector vector) {
		Piece piece = pieces[i][j];
		pieces[i][j] = null;
		pieces[i+vector.getAxeX()][j+vector.getAxeY()] = piece;
		
	}
	
	public void addPiece(Piece piece, int i, int j) {
		pieces[i][j] = piece;
	}
	
	private void display (){
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
	
	private void gameLoop() {
		String joueurId;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Position x de la piece :");
		    int x = sc.nextInt();
		    System.out.println("Position y de la piece :");
		    int y = sc.nextInt();
		    if(pieces[x][y] == null) {
		    	System.out.println("Il n'y a pas de pièce à cet endroit !");
		    	continue;
		    }
		    ArrayList<Vector> vector = calulateMove(x, y);
		    if(vector.isEmpty()) {
		    	System.out.println("La pièce ne peut pas bouger !");
		    	continue;
		    }
		    for(int i = 0; i < vector.size(); i++) {
		    	System.out.println(i+1 +": la piece peut etre deplacer en x : "+(x+vector.get(i).getAxeX()) + " et y : "+ (y + vector.get(i).getAxeY()));
		    }
		    System.out.println("Choisir un coup :");
		    int c = sc.nextInt();
		    movePiece(x, y, vector.get(c-1));
		    display();
		}
	}

	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		ConfigLoader.loadConfigFile("res/rules/chess.cfg", chessBoard);
		chessBoard.display();
		chessBoard.gameLoop();
	}
}
