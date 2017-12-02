package game;

import java.util.ArrayList;

public class Piece {
	private String id;
	private String name;
	private String joueurId;
	private char draw;
	private ArrayList<Vector> mouvements = new ArrayList<>();
	
	public Piece (String id, String name, String joueurId, char draw) {
		this.id = id;
		this.name = name;
		this.joueurId = joueurId;
		this.draw = draw;
	}
	
	public char getDraw() {
		return draw;
	}
	
	public void addMovement(Vector movement) {
		mouvements.add(movement);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Vector> getMovements() {
		return mouvements;
	}
	public void setMovements(ArrayList<Vector> movements) {
		this.mouvements = movements;
	}
	public String getJoueurId() {
		return joueurId;
	}
	public void setJoueurId(String joueurId) {
		this.joueurId = joueurId;
	}
	
	
	
	
}
