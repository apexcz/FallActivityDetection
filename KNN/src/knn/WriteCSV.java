package knn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This class encapsulate methods which related to CSV operation
public class WriteCSV {
	static PrintWriter pw;
	static int i = 0;

	// This method create a CSV file
	static public void initFile(String fileName) {
		try {
			pw = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// This method write a row of data to CSV file
	static public void writeRow(double[] result) {
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < result.length; i++) {
			sb.append(result[i]);
			sb.append(',');
		}
		sb.append('\n');
		pw.write(sb.toString());
	}

	// This method close the PrintWriter and close the file
	static public void closeFile() {
		pw.close();
	}
}
