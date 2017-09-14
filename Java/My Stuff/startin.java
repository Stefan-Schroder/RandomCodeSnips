import java.nio.file.Files;
import java.nio.file.Paths;

class startin{
	public static void main(String [] args){
		URL main = startin.class.getResource("startin.class");
		if (!"file".equalsIgnoreCase(main.getProtocol()))
		  throw new IllegalStateException("Main class is not stored in a file.");
		File path = new File(main.getPath());
		System.out.println(path.toString());
	}
}