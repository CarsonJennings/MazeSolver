import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter {
	FileWriter fw;
    String filename;
	
	public FilePrinter(String filename) {
		fw = null;
		try {
			fw = new FileWriter(filename);
		} catch (IOException e) {
			System.out.println("Error setting up " + filename);
			System.exit(-1);
		}
	}

	public void println(String toPrint) {
		try { 
			fw.write(toPrint + "\n");
		} catch (IOException e) {
			System.out.println("Could not write to " + filename);
		}
	}

	public void close() {
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("Error closing fileWriter.");
		}	
	}
}