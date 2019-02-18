import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Fields {
  public static void pen() {
    int i;
    String filename=CreatorClass.tf2.getText()+"-properties.txt";
    //System.out.println(filename);
		try {
  		File file = new File(filename);
  		if(!file.exists()) {
  			file.createNewFile();
		   }
  		PrintWriter pw = new PrintWriter(file);
      String content="";
      int nof=Integer.parseInt(CreatorClass.tf3.getText());
      for(i=0; i<nof-1; i++) {
        String prop_name=MapCreator.fieldname[i].getText();
        content+=prop_name+"\r\n";
      }
      String prop_name=MapCreator.fieldname[i].getText();
      content+=prop_name;
  		pw.println(content);
  		pw.close();
  		System.out.println("Done");
      Runtime rs = Runtime.getRuntime();
      rs.exec("notepad "+filename);
		}
    catch (IOException e) {
			e.printStackTrace();
		}
	}
}
