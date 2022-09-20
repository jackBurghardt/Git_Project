import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Date;

public class CommitTester {
	
	public static void main(String[] args)
	{
		Commit c = new Commit("pTree","Testing Commit","Author", null);
		System.out.println(c.commitSHA1());
		c.writeFile();
	}

}
