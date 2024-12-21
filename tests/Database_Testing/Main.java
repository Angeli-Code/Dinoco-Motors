import java.util.ArrayList;

/**
 * Test that tests the connection and correct flow of data from a
 * a SQL Database back to the main after being parsed
 */

public class Main
{
	public static void main(String[] args)
	{
		Database db = new Database();
		db.updateDatabase();

		ArrayList<Car> dataList = new ArrayList<>();

		dataList = db.downloadDatabase();

		for(int i = 0; i < dataList.size();i++) {
			System.out.println("Main Method Data: "
					+ dataList.get(i).getCarName());
		}
	}
}
