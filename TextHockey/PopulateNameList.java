package TextHockey;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PopulateNameList {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		
		Scanner inFile = new Scanner(new File("/Users/benha/eclipse-workspace/TextHockey/first-names.txt")).useDelimiter(System.lineSeparator());
		ArrayList<String> list = new ArrayList<String>();
		
		while(inFile.hasNextLine()){
			list.add(inFile.nextLine());
		}
		
		inFile.close();

	}

}
