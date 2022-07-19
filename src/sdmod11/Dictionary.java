package sdmod11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Class Dictionary opens a connection to a MySQL database and loads a table called "words" into an arraylist.
 * @author James Lee
 *
 */
public class Dictionary {
	
	private ArrayList<String> dictionary;
	
	
	public Boolean spellCheck(String word) {
    	if (this.dictionary.contains(word)) {
    		return true;
    	}
    	return false;
	}
	
	
	public int getSize() {
		return(this.dictionary.size());
	}
	
	
	Dictionary() {
		try {
			this.dictionary = loadMySqlDictionary();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	ArrayList<String> loadMySqlDictionary() throws Exception {
		try {
			Connection conn = getConnection();
			
			// Prep SQL command. MySQL table is words. MySQL field is word.
			PreparedStatement statement = conn.prepareStatement("Select word from words");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> dictArr = new ArrayList<String>();
			while (result.next()) {
				dictArr.add(result.getString("word"));
			}
			System.out.println("Dictionary loaded into array...");
			return dictArr;
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/dictionary";  // Name of MySQL database is dictionary
			String username = "jim";
			String password = "password";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to MySQL database...");
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

}
