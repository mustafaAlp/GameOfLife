package GameOfLife;

/**
 * 
 * @author Mustafa ALP
 * @studentid 091044059
 *
 */
public class Cell {

	/**
	 * private data fields
	 * 
	 */
	private int x;
	private int y;
	

	/**
	 * no parameter constructor
	 * 
	 */
	public Cell(){
		x = 0;
		y = 0;
	}
	
	
	/**
	 * one parameter constructor
	 * 
	 * @param xInput
	 */
	public Cell(int xInput){
		x = xInput;
		y = 0;
	}

	/**
	 * two parameter constructor
	 * 
	 * @param xInput
	 * @param yInput
	 */
	public Cell(int xInput, int yInput){
		x = xInput;
		y = yInput;
	}

	/**
	 * setter for field x 
	 * 
	 * @param xInput
	 */
	public void setX(int xInput){
		//if(xInput >= 0)
			x = xInput;
	}
	
	/**
	 * setter for field y 
	 * 
	 * @param yInput: input for data field y
	 */
	public void setY(int yInput){
		//if(yInput >= 0)
			y = yInput;
	}
	
	/**
	 * getter for field x
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * getter for field y
	 */
	public int getY(){
		return y;
	}
}
