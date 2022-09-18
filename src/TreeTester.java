import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TreeTester {
	
	static ArrayList<String> blackpink = new ArrayList<String>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackpink.add("blob : a43bef2021db1fc79daba6d150a92102b31a6a2e");
		blackpink.add("blob : 08d8e010ae385fa05e1328c68da7c9c4ef2cf290");
		blackpink.add("tree : 2486c6120aa2aac7dccc2670eae07f7a3601e2ab");
		blackpink.add("tree : 51ad0eae3f66ecd3c72bfac9373650513d6f6603");
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
		// The combined SHA1 should be 2415aecbf1da8ddd09447ccd88ea0e6fdbeb32d7
		String SHA1 = "2415aecbf1da8ddd09447ccd88ea0e6fdbeb32d7";
		File file = new File("./objects/" + SHA1);
		// Checks if the file with the right SHA1 name exists
		assertTrue(file.exists());
	}

}
