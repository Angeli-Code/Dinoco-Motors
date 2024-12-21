import java.util.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Parser Object used by Database Class to Parse the data in a TSV File
 *
 * @author Angelo Laberinto
 * @version 1.0
 * @since 12/20/2024
 */
public class CSVParser
{
	private static final String dataFileName; /* TODO: Secure Removed Path */
	private Logger logger = Logger.getLogger(CSVParser.class.getName());
	private boolean debugMode = false;

	/**
	 * Constructor that defines whether or not debugging information gets
	 * logged to the console or note
	 * @param debugMode	True or False
	 */
	public CSVParser(boolean debugMode)
	{
		this.debugMode = debugMode;
	}

	/**
	 * Parses TSV File into an ArrayList of Cars
	 *
	 * @return ArrayList with Parsed Data
	 */
	public ArrayList<Car> parseTSV()
	{
		ArrayList<Car> carList = new ArrayList<>();

		try {
			File file = new File(dataFileName);
			Scanner inReader = new Scanner(file);

			while (inReader.hasNextLine()) {
				String line = inReader.nextLine();
				String[] fields = line.split("\t");

				String[] values = fields[0].trim().split("\\s+");
				String carName = fields[1].replaceAll("\"", "").trim();

				Car car = new Car(
						values[0],
						values[1],
						values[2],
						values[3],
						values[4],
						values[5],
						values[6],
						values[7],
						carName);

				carList.add(car);
			}

			inReader.close();
			if (debugMode) {
				logger.log(Level.INFO, "File Parsing Complete");
			}
} catch (IOException e) {
			logger.log(Level.SEVERE, "Error parsing TSV file", e);
		}
		return carList;
	}
}
