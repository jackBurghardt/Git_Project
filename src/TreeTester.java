
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TreeTester {
	
	static ArrayList<String> blackpink = new ArrayList<String>();
	static String contents = "";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackpink.add("blob : a43bef2021db1fc79daba6d150a92102b31a6a2e");
		contents += "blob : a43bef2021db1fc79daba6d150a92102b31a6a2e\n";
		blackpink.add("blob : 08d8e010ae385fa05e1328c68da7c9c4ef2cf290");
		contents += "blob : 08d8e010ae385fa05e1328c68da7c9c4ef2cf290\n";
		blackpink.add("tree : 2486c6120aa2aac7dccc2670eae07f7a3601e2ab");
		contents += "tree : 2486c6120aa2aac7dccc2670eae07f7a3601e2ab\n";
		blackpink.add("tree : 51ad0eae3f66ecd3c72bfac9373650513d6f6603");
		contents += "tree : 51ad0eae3f66ecd3c72bfac9373650513d6f6603\n";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// Deletes the files created earlier
		File toDelete = new File("2415aecbf1da8ddd09447ccd88ea0e6fdbeb32d7");
		toDelete.delete();
	}

	@Test
	void test() throws IOException {
		// Creates a tree which should write out the file
		Tree tree = new Tree(blackpink);
		// The combined SHA1 should be 8e58fff796894d9c44d7560ba76fec6d1207453f
		String SHA1 = "8e58fff796894d9c44d7560ba76fec6d1207453f";
		File file = new File("./objects/" + SHA1);
		String fileContents = "";
		// Checks if the file with the right SHA1 name exists
		assertTrue(file.exists());
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		char nextLetter;
		
		while(reader.ready())
		{
			nextLetter = (char)reader.read();
			fileContents += nextLetter;
		}
		reader.close();
		System.out.println(fileContents);
		System.out.println(contents);
		assertTrue(contents.equals(fileContents));
	}
}
