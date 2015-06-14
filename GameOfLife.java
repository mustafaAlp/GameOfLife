package GameOfLife;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 
 * @author Mustafa ALP
 * @studentid 091044059
 *
 */
public class GameOfLife {
	private int width;
	private int height;
	private static int alive = 0;


	private Cell[] livingCells;
	private int size;
	
	
	/**
	 * changes value of the private data field width
	 * 
	 */
	private void setWidth(int input){
		width = input;
	}

	/**
	 * changes value of the private data field height
	 * 
	 */
	private void setHeight(int input){
		height = input;
	}

	
	
	
	/**
	 * Adds a new cell to Cell[] field livingCells
	 * increases  int field size 
	 * increases static int field alive
	 *  
	 * @param input
	 * 
	 */
	private void push_back(Cell input){

		
	 	if (size + 1  == livingCells.length) {//reallocation
			livingCells = Arrays.copyOf(livingCells, size * 2);
		}

		livingCells[size] = input;
		++size;
		++alive;
	}


	/**
	 * 
	 * @param y coordinate of a cell
	 * @param x coordinate of a cell
	 * 
	 * @return true if there is an alive Cell in this coordinates
	 * @return false otherwise
	 */
	private boolean isCellAlive(int y, int x){
		return isCellAlive(new Cell(x, y));
	}
	
	/**
	 * 
	 * @param input an Cell ofject
	 *
	 * @return true if there is an alive Cell equal to input
	 * @return false otherwise
	 */
	private boolean isCellAlive(Cell input){
		for (int i = 0; i < size ; ++i) {
			if(		livingCells[i].getX() == input.getX()
				&&	livingCells[i].getY() == input.getY() ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param y coordinate of a cell
	 * @param x coordinate of a cell
	 * 
	 * @return true if the Cell will be alive in the next generation
	 * @return false
	 * 
	 */
	private boolean survive(int y, int x){

		int neighbor ;

		neighbor = countNeighbors(y, x);

		if(neighbor == 3 || (isCellAlive(y,x) && neighbor ==2)){
			return true;
		}

		return false;
	}
	
	
	/**
	 *	changes borders of the board when needed
	 *	
	 * 
	 */
	private void enlarge(){
		enlargeToLeft();
		enlargeToRigth();
		enlargeToDown();
		enlargeToUp();
	}
	
	
	
	/**
	 *	changes left border of the board when needed
	 * 
	 */
	private void enlargeToLeft(){
		boolean temp = false;

		for (int i = 0; i < height; ++i) {
			if (survive(i, -1)) {
				temp = true;
				break;
			}
		}
		
		if (temp == true) {
			setWidth(width + 1);
			for (int i = 0; i < size; ++i) {
				livingCells[i].setX(livingCells[i].getX() + 1);
			}
		}
}

	
	/**
	 *	changes right border of the board when needed
	 * 
	 */
	private void enlargeToRigth(){
		boolean temp = false;

		for (int i = 0; i < height; ++i) {
			if (survive(i, width )) {
				temp = true;
				break;
			}
		}
		if (temp == true) {
			setWidth(width + 1);
		}
	}
	
	/**
	 *	changes up border of the board when needed
	 * 
	 */
	private void enlargeToUp(){
		boolean temp = false;

		for (int i = 0; i < width; ++i) {
			if (survive(-1, i)) {
				temp = true;
				break;
			}
		}

		if (temp == true) {
			setHeight(getHeight() + 1);
			for (int i = 0; i < size; ++i) {
				livingCells[i].setY(livingCells[i].getY() + 1);
			}
		}
	}

	
	/**
	 *	changes down border of the board when needed
	 *	
	 *
	 */
	private void enlargeToDown(){
		boolean temp = false;

		for (int i = 0; i < getWidth(); ++i) {
			if (survive(height, i)) {
				temp = true;
				break;
			}
		}

		if (temp == true) {
			setHeight(getHeight() + 1);
		}
	}
	
	/**
	 * miniaturizes borders of the board when needed
	 * 
	 * 
	 */
	private void miniaturize(){
		miniaturizeLeft();
		miniaturizeRigth();
		miniaturizeUp();
		miniaturizeDown();
	}
	
	
	/**
	 * miniaturizes left border of the board when needed
	 * 
	 * 
	 */
	private void miniaturizeLeft(){
		boolean temp = true;
		
		for (int i = 0; i < height; i++) {
			if (isCellAlive(i, 0)) {
				temp = false;
				break;
			}
		}
		
		if (temp) {
			for (int i = 0; i < size; i++) {
				livingCells[i].setX(livingCells[i].getX() - 1);
			}
			--width;
			
			miniaturizeLeft();
		}
	}

	/**
	 * miniaturizes right border of the board when needed
	 * 
	 * 
	 * 
	 */
	private void miniaturizeRigth(){
		boolean temp = true;
		
		for (int i = 0; i < height; i++) {
			if (isCellAlive(i, width -1 )) {
				temp = false;
				break;
			}
		}
		
		if (temp) {
			--width;
			miniaturizeRigth();
		}
	}
	
	/**
	 * miniaturizes up border of the board when needed
	 * 
	 * 
	 */
	private void miniaturizeUp(){		
		boolean temp = true;
		
		for (int i = 0; i < width; i++) {
			if (isCellAlive(0, i)) {
				temp = false;
				break;
			}
		}
		
		if (temp) {
			for (int i = 0; i < size; i++) {
				livingCells[i].setY(livingCells[i].getY() - 1);
			}
			--height;
			miniaturizeUp();
		}
	}
	
	/**
	 * miniaturizes down border of the board when needed
	 * 
	 * 
	 */
	private void miniaturizeDown(){
		boolean temp = true;
		
		for (int i = 0; i < width; i++) {
			if (isCellAlive(height - 1, i)) {
				temp = false;
				break;
			}
		}
		
		if (temp) {
			--height;
			miniaturizeDown();
		}
	}

	/**
	 * 
	 * @param line
	 * @param lineNumber
	 */
	private void evaluate(String line, int lineNumber){
		width  = line.length();
		height = lineNumber + 1;
		
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != ' ') {
				push_back(new Cell(i, lineNumber));
			}
		}
	}
	
	/**
	 * 
	 * @param y
	 * @param x
	 * @return
	 */
	private int countNeighbors(int y, int x){

		int neighbor=0;

		for (int i = y-1; i <= y+1; ++i) {
			for (int j = x-1; j <= x+1; ++j) {
				if (isCellAlive(i,j) && !( y==i && x ==j)) {
					++neighbor;
				}
			}
		}

		return neighbor;
	}
	
	
	/**
	 * no parameter constructor
	 * 
	 */
	public GameOfLife(){
		size = 0;
		
		livingCells = new Cell[5];
	}

	
	/**
	 * getter for field width
	 * 
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * getter for field length
	 * 
	 */
	public int getHeight(){
		return height;
	}
	
	/**
	 * getter for static field alive
	 */
	public static int getAlive(){
		return alive;
	}
	
	/**
	 * gets board input from a text file
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void read(String fileName) throws FileNotFoundException{
		Scanner inputStream = null;
		
		try{
			inputStream = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		String line = null;
		
		for (int i = 0; inputStream.hasNextLine(); i++) {
			line = inputStream.nextLine();
			evaluate(line, i);
		}
		
	}
	
	/**
	 *  plays the game for a single time step
	 *
	 */
	public void play(){
		GameOfLife newGenerations = new GameOfLife();

		enlarge();

		alive -= size;
		
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if (survive(i, j)) {
					newGenerations.push_back(new Cell(j,i));
				}
			}
		}
		
		livingCells = newGenerations.livingCells;		
		size = newGenerations.size;
		
		miniaturize();
	}
	
	
	/**
	 * takes another GameOfLife object
	 * adds second object's Cells to first object
	 * 
	 * @param second
	 * 
	 */
	public void join(GameOfLife second){
		for (int i = 0; i < second.size; i++) {
			if (!isCellAlive(second.livingCells[i])) {
				push_back(second.livingCells[i]);
			}
		}
	}

	/**
	 * print object to standard output
	 * 
	 */
	public void print(){
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (isCellAlive(i, j)) {
					System.out.print("x ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.printf("\n");
		}
	}

}
