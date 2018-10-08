package test.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import logic.StoreManagement;
import logic.Store;

class StoreTest {
	
	private Store store = StoreManagement.STORE;
	private File outputFile;
	private File expectedOutputFile;
	private PrintStream fileStream;
	
	@BeforeEach
	void setUp() throws Exception {
		StoreManagement.readInput();
		outputFile = new File("src/test/solution/output.txt");
		expectedOutputFile = new File("src/test/solution/expectedOutput.txt");
		fileStream = new PrintStream(new FileOutputStream(outputFile));
		System.setOut(fileStream);
	}

	@Test
	void testStore() throws FileNotFoundException {
		store.showAllEmployees();
		store.showSalary();
		
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		BufferedReader outputFileReader = null;
		BufferedReader expectedOutputFileReader = null;
		ArrayList<String> outputLine = new ArrayList<String>();
		ArrayList<String> expectedOutputLine = new ArrayList<String>();
		
		try {
			outputFileReader = new BufferedReader(new FileReader(outputFile));
			expectedOutputFileReader = new BufferedReader(new FileReader(expectedOutputFile));
			String currentLine = null;
			while((currentLine = outputFileReader.readLine()) != null) {
				currentLine = currentLine.replaceAll("\\s", "");
				System.out.println(currentLine);
				outputLine.add(currentLine);
			}
			System.out.println("---------------------------------");
			while((currentLine = expectedOutputFileReader.readLine()) != null) {
				currentLine = currentLine.replaceAll("\\s", "");
				System.out.println(currentLine);
				expectedOutputLine.add(currentLine);
			}
			System.out.println("---------------------------------");
			if (outputLine.size() != expectedOutputLine.size()) {
				fail("The number of lines in the output file is not the same as expected output file.");
			}
			for (int i = 0; i < outputLine.size(); i++) {
				if (!outputLine.get(i).equals(expectedOutputLine.get(i))) {
					fail("Wrong out put at line: " + (i + 1));
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		    try {
		    	outputFileReader.close();
		    	expectedOutputFileReader.close();
		    } 
		    catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}

}
