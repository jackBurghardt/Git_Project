
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class GitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//create file
		File test = new File("testerFile.txt"); 
		FileWriter fw = new FileWriter("testerFile.txt");
		fw.write("some content");
		fw.close();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	   File test = new File ("./objects/testerFile.txt"); 
	   test.delete(); 
	
	}

	@Test
	void testBlob() throws IOException {
		//fail("Not yet implemented");
		Blob b = new Blob("testerFile.txt");	
		File f = new File("./objects/94e66df8cd09d410c62d9e0dc59d3a884e458e05"); 
		assertTrue(f.exists()); 		
	}
	
	@Test
	void testInit() throws IOException {
		File f = new File ("index");
		f.delete(); 
		File ob = new File("./objects/");
		ob.delete();
		
		File testOne = new File("testOne");
		File testTwo = new File("testTwo");
		
		FileWriter f1 = new FileWriter("testOne");
		f1.write("slunch");
		f1.close();
		
		FileWriter f2 = new FileWriter("testTwo");
		f2.write("snorgle");
		f2.close();
		
		Index i = new Index();
		i.initialize(); 
		 
		File in = new File("index"); 
//		assertTrue(in.exists()); 
//		File direct = new File("./objects/");
//		direct.mkdir();
//		assertTrue(direct.exists()); 	
		
		i.add("testOne"); 
		i.add("testTwo"); 
				 
		 
		//test index updated and objects are created
		File one = new File ("./objects/e5ef1ad3c916742189cce8e01ef60ca0a7b59d30");
		assertTrue(one.exists());
		File two = new File ("./objects/76bc269b136c9a12b8bd28a89cf987491f85001e");
		assertTrue(two.exists());
			
		
		i.remove("testOne");
		i.remove("testTwo");
		
		//test index updated and objects are removed 
		assertFalse(one.exists());
		assertFalse(two.exists());

	}
	

}
