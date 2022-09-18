import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TreeTester {
	
	static ArrayList<String> robotics = new ArrayList<String>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		robotics.add("Anika : 01670a0aee5d4289cb1c8231ac7cd6db7b4e4be8");
		robotics.add("Audrey : 9f56d9b292b55162ca3999b56f054b407a2ae67e");
		robotics.add("Eric : 6d0e5951f2a9d928c1d17b25d57f0461296048e6");
		robotics.add("Karen : 961c4ce5692d8f0f612b4cd6d8665865aac3ace4");
		robotics.add("Kensuke : 2fa6905f03507615399918510f07657b129890fb");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException {
		// Creates a tree which should write out the file
		Tree tree = new Tree(robotics);
		// The combined SHA1 should be f692ce3bc466086b97b348d87bf39cbd0a59d06a
		String SHA1 = "f692ce3bc466086b97b348d87bf39cbd0a59d06a";
		File file = new File(SHA1);
		// Checks if the file with the right SHA1 name exists
		assertTrue(file.exists());
	}

}
