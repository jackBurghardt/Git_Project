import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Date;

public class CommitTester {
	
	public static void main(String[] args)
	{
		Commit c = new Commit("a","a","a", null);
		System.out.println(c.commitSHA1());
	}

}
