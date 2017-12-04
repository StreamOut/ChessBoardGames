package game;

public class Vector {
	private int axeX;
	private int axeY;
	
	public Vector (String vector) {
		int i = 1;
		if(vector.charAt(0) == '-')
			i++;
		this.axeX = Integer.valueOf(vector.substring(0, i));
		this.axeY = Integer.valueOf(vector.substring(i, vector.length()));
		System.out.println("X "+axeX+" Y "+axeY);
	}

	public int getAxeX() {
		return axeX;
	}

	public int getAxeY() {
		return axeY;
	}

	@Override
	public String toString() {
		return "Vector [axeX=" + axeX + ", axeY=" + axeY + "]";
	}
	

}
