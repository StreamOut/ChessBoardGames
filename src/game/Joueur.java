package game;

import java.util.ArrayList;

public class Joueur {
	String name;
	String id;
	ArrayList<Piece> pieces = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	

}
