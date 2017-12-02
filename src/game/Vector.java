package game;

public class Vector {
	private int [] way = new int[2];
	
	public Vector (String vector) {
		int j = 0;
		for(int i = 0; i < vector.length(); i++) {
			if(vector.charAt(i) == '-') {
				i++;
				way[j] = Character.getNumericValue((vector.charAt(i))) - 2 * Character.getNumericValue((vector.charAt(i)));
			}
			else
				way[j] = Character.getNumericValue((vector.charAt(i)));
			j++;
			
		}
	}

	public int[] getWay() {
		return way;
	}

	public void setWay(int[] way) {
		this.way = way;
	}

}
