import java.util.ArrayList;

/**
 * Test Main for Parsing the TSV File
 */

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Car> dino = new ArrayList<>();
		Parser p = new Parser();

		dino = p.parseTSV();

		System.out.println("Debug: Size of car list: " + dino.size());

		if (dino.isEmpty()) {
			System.out.println("Debug: No cars were parsed!");
			return;
		}

		for (Car car: dino) {
			System.out.println("Debug: " + car.getCarName());
		}
	}
}
