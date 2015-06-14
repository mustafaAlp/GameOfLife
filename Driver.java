package GameOfLife;

import java.io.FileNotFoundException;

/**
 * 
 * @author Mustafa ALP
 * @studentid 091044059
 *
 */
public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		GameOfLife habitat_1 = new GameOfLife();
		GameOfLife habitat_2 = new GameOfLife();
		GameOfLife habitat_3 = new GameOfLife();
		GameOfLife habitat_4 = new GameOfLife();
		GameOfLife habitat_5 = new GameOfLife();
		
		
		try {
			habitat_1.read("input/a.txt");
			habitat_2.read("input/b.txt");
			habitat_3.read("input/c.txt");
			habitat_4.read("input/d.txt");
			habitat_5.read("input/e.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("\nHabitat_1 :\n");
		habitat_1.print();

		System.out.printf("\n\n\nHabitat_1.play():\n");

		habitat_1.play();		
		habitat_1.print();
		
		
		System.out.printf("\n\n\nHabitat_2:\n");
		habitat_2.print();

		System.out.printf("\n\n\nHabitat_3:\n");
		habitat_3.print();

		System.out.printf("\n\n\nHabitat_4:\n");
		habitat_4.print();

		System.out.printf("\nalive Cells: %d", GameOfLife.getAlive());

		
		System.out.printf("\n\n\nHabitat_3.join(Habitat_4):\n");
		habitat_3.join(habitat_4);
		habitat_3.print();

		System.out.printf("\nalive Cells: %d", GameOfLife.getAlive());

		System.out.printf("\n\n\nHabitat_5:\n");
		habitat_5.print();
				
	}

}
