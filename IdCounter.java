// CREATING MAXID COUNTER FILE FOR THE TYPE

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class IdCounter {
  public static void pen() {
    String filename=CreatorClass.tf2.getText()+"-maxid.txt";
		try {
  		File file = new File(filename);
  		if(!file.exists()) {
  			file.createNewFile();
  		}
  		PrintWriter pw = new PrintWriter(file);
      String content="0";
      pw.println(content);
  		pw.close();
      Runtime rs = Runtime.getRuntime();
      rs.exec("notepad "+filename);
		}
    catch (IOException e) {
			e.printStackTrace();
		}
	}
}
