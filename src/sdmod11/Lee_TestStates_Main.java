package sdmod11;

import java.util.ArrayList;


/**
 * This application will spellcheck a user document against the words in a MySQL "dictionary" database. 
 * Misspelled words are printed to the console.
 * 
 * @author James Lee
 *
 */
public class Lee_TestStates_Main {

	/**
	 * main() creates dictionary and user doc objects and then loops on each word in user doc array
	 * and checks for correct spelling. Misspelled words are printed to the console.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		// Name and location of user document
		String testFileName = "C:\\JavaProjects\\SD-Mod11-MySQL\\testStates.txt";

		// Instantiate dictionary and user document objects
		Dictionary dictionary = new Dictionary();
		User_Document userDocument = new User_Document(testFileName);
		
		// Get user document. Constructor for user document loads the doc into an array.
		ArrayList<String> docArr = userDocument.getUserDocArr();

		System.out.println("Running spellchecker...\n");

		docArr.forEach((word) -> {
			if (!dictionary.spellCheck(word)) {
				System.out.println('"' + word + '"' + " not found!");
			}
		});

		System.out.println("\nDone.");

	}

}
