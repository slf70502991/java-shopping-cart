import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//This class includes the methods for reading and writing username and password to a text file.
public class AccessAccount{
	AccessAccount(){}
	String relativePath = ".\\file\\account.txt";
	
	//Check whether the file exists.
	private static boolean fileExists(String fileName) {
        try {
            new FileWriter(fileName, true).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
	
	//If a user want to sing up a new account, this method will write the username and password to a text file.
	public void writeAccount(String username, String password) throws IOException {
		FileWriter filewriter = new FileWriter(relativePath, true);
		if(fileExists(relativePath)) {
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			bufferedWriter.write(username +"," +password);
			bufferedWriter.newLine();
			System.out.println("User Registered Successfully!\n");
			if(bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}
	
	//When logging in, this method is used for checking whether the specific account exists.
	public boolean readAccount(String username, String password) {
		boolean status = false;
		try (BufferedReader reader = new BufferedReader(new FileReader(relativePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.contains(username)) {
                	String[]  account = line.split(",");
                    if(account[0].equals(username) && account[1].equals(password)){
                    	status = true;
                    }else {
                    	System.out.println("Username or Password id incorrect.");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Errors happen when accessign the data: " + e.getMessage());
        }
		return status;
	}
}