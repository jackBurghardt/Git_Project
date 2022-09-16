import java.io.IOException;
import java.util.ArrayList;

public class TreeTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	 	ArrayList <String> treeList = new ArrayList <String> (); 
	 	String o = "blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f";
	 	String t = "blob : 01d82591292494afd1602d175e165f94992f6f5f";
	 	String th = "blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83";
	 	String f = "tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b";
	 	String fr = "tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976"; 
	 	treeList.add(o);
	 	treeList.add(t);
	 	treeList.add(th);
	 	treeList.add(f);
	 	treeList.add(fr);
	 	Tree arbol = new Tree(treeList);
	}

}
