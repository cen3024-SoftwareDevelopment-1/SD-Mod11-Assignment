package sdmod11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class User_Document reads a text file and loads each line into an arraylist.
 * @author James Lee
 *
 */
public class User_Document {
	
	private ArrayList<String> doc = new ArrayList<String>();
	
	
	User_Document(String filename) throws IOException {
	    /** File path is passed as parameter */
	    File file = new File(filename);

	    /** Creating an object of BufferedReader class */
	    BufferedReader br = null;
	    
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
        String newLine;
		// System.out.println("Reading user document...");

        while ((newLine = br.readLine()) != null) {
            if (!(newLine.isEmpty())) {
				this.doc.add(newLine);
            }
        }
        
        System.out.println("User Document loaded into array...");

	    br.close();
	}
	
	public ArrayList<String> getUserDocArr() {
		return this.doc;
	}
	
	public int getSize() {
		return(this.doc.size());
	}

}
