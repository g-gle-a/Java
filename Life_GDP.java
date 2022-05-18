import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Life_GDP {
	public static void main(String[] args) {
		
	    try {
	      System.out.println("Input file name");
	      Scanner filename = new Scanner(System.in);
	      File myObj = new File(filename.nextLine ()); // or var filename
	      System.out.println("Input file succesfully open \n ---- \n");
	      System.out.println("Output file name");
	      Scanner fileOut = new Scanner(System.in);
	      FileWriter myWriter = new FileWriter(fileOut.nextLine()); 
	      Scanner myReader = new Scanner(myObj);
	      myReader.useDelimiter(",");
	      
	      while (myReader.hasNextLine()) {

	    	   String csvLine = myReader.nextLine();
	    	   String[] csvRead = csvLine.split(",");
	    	   //String theCountry = new String (csvRead[0] + ',' + csvRead[1] + ',' + csvRead[2]+ ',');
	    	   String theCountry = new String (csvRead[0] + ',' );
	    	   for ( int i = 1 ; i <= 61; i++) {
	    		 //  myWriter.write(Integer.toString(i));
	    		   String value =  csvRead[i];
	    		   String data = Integer.toString(1959 + i) + ',' + theCountry + value + '\n';
	    		   myWriter.write (data);
	    	   }
	      }	 
	      filename.close();
	      myReader.close();
	      fileOut.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
