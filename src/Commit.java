import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Date;

public class Commit {
	
	public String pTree = null;
	public String summary;
	public String author;
	public String date;
	
	Commit previous;
	Commit next;
	
	public Commit(String pTreeValue, String summaryValue, String authorName, Commit parent)
	{
		pTree = pTreeValue;
		summary = summaryValue;
		author = authorName;
		date = getDate();
		previous = parent;
		next = null;
	}
	
	public String getDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	public void writeFile()
	{
		
	}
	
	public String commitSHA1()
	{
		String info = pTree + "\n";
		if(previous != null)
		{
			info += previous + "\n";
		}
		info += author + "\n";
		info += date + "\n";
		info += summary + "\n";
		System.out.println(info);
		return generateSHA1(info);
	}
	
	public String generateSHA1(String input)
	{
		String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(input.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}
	
	public static String byteToHex(final byte[] hash)
	{
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}

}
