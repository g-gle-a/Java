import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class


public class MatrixMult {
	public static void main(String[] args) {
		
	    try {
	      System.out.println("Input file name 1");
	      Scanner filename = new Scanner(System.in);
	      File myObj = new File(filename.nextLine ()); // or var filename
	      System.out.println("Input file 1 succesfully open \n ---- \n");
	      
	      //Start reading into memory
	      Scanner myReader = new Scanner(myObj);
	      myReader.useDelimiter(",");
	      ArrayList<String> list = new ArrayList<String>();
	      while (myReader.hasNextLine()) {
	    	  list.add(myReader.nextLine());
	      }  
	      
  	      // Knowing  the dimensions of the matrix
	      int nRows = list.size();
          String firstline = list.get(0); 	
	      String[] cols= firstline.split(",");
	      int nCols = cols.length;
	      float[][] myMatrix1 = new float[nRows][nCols];
	      int i=0;
	      for (String csvLine : list) {
	    	  String[] csvRead = csvLine.split(",");
	    	  for (int j=0; j<nCols; j++) {
	    		 myMatrix1[i][j] = Float.parseFloat(csvRead[j]);  
	    	  }
	    	  i++;
	      }
	      
	      System.out.println("Input file name 2");
	      Scanner filename2 = new Scanner(System.in);
	      File myObj2 = new File(filename2.nextLine ()); // or var filename
	      System.out.println("Input file 2 succesfully open \n ---- \n");
	      Scanner myReader2 = new Scanner(myObj2);
	      myReader2.useDelimiter(",");
	      
	      //Start reading into memory
	      ArrayList<String> list2 = new ArrayList<String>();
	      while (myReader2.hasNextLine()) {
	    	  list2.add(myReader2.nextLine());
	      }  
	      
	      int nRows2 = list2.size();
          firstline = list2.get(0); 	
	      String[] cols2= firstline.split(",");
	      int nCols2 = cols2.length;
      
	      float[][] myMatrix2 = new float[nRows2][nCols2];
	      i=0;
	      for (String csvLine : list2) {
	    	  String[] csvRead = csvLine.split(",");
	    	  for (int j=0; j<nCols; j++) {
	    		 myMatrix2[i][j] = Float.parseFloat(csvRead[j]);  
	    	  }
	    	  i++;
	      }
	      
	      System.out.println("Output file name");
	      Scanner fileOut = new Scanner(System.in);
	      FileWriter myWriter = new FileWriter(fileOut.nextLine()); 
	      System.out.println("Output file  succesfully open \n ---- \n");

	      // Warning I don't know the correct order of these two sentences :) 
	      myReader.close();
	      myReader2.close();
	      filename.close();
	      filename2.close();
	      // Matrix Multiplication here!!!
	      if (nCols != nRows2) {
	    	  System.out.println("Can't multiply these matrices, incompatible rows and cols sizes:" + nCols + "--" + nRows2);
	      }
	      float[][] myNumbers = new float[nRows][nCols2];	      
	      for (i=0; i < nRows; i++) {
	    	  for (int j=0; j < nCols2; j++) {
	    		  float data=0;
	    		  for (int k=0; k < nRows2; k++) {
	    			  data += myMatrix1[i][k] * myMatrix2[k][j];
	    		  }
	    		  myNumbers[i][j] = data;
	    	  }
	      }
	      System.out.println("Matrices Multiplied \n ---- \n");
	      // Final Matrix output
	   for (i=0; i < nRows ; i++) {
	    	  for ( int j=0; j<nCols2; j++) {
	    		 String data = Float.toString (myNumbers[i][j]) + ',';
	    		 myWriter.write(data);
	    	  }
	    	  myWriter.write('\n');
	     }
	      System.out.println("Output succesfull \n ---- \n.... All Done ......\n ---- \n");
	      myWriter.close();
	      fileOut.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
		
	
