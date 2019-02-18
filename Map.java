import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Map {
  public static void pen() {
    int i;
    String indexname=CreatorClass.tf1.getText();
    String typename=CreatorClass.tf2.getText();
    String filename=CreatorClass.tf2.getText()+"-mapping.json";
    System.out.println(filename);
		try {
  		File file = new File(filename);
  		if(!file.exists()) {
  			file.createNewFile();
  		}
  		PrintWriter pw = new PrintWriter(file);
      String content="PUT /"+indexname+"\r\n{"+"\r\t\"mappings\": {\r\n"+"\r\t\t"+"\""+typename+"\": {\r\n\t\t\t\"properties\": {";
      String more="";
      int nof=Integer.parseInt(CreatorClass.tf3.getText());
      for(i=0; i<nof-1; i++) {
        String prop_name=MapCreator.fieldname[i].getText();
        String prop_type=MapCreator.fieldtype[i].getText();;
        more+="\r\n"+"\r\t\t\t\t"+"\""+prop_name+"\": {"+"\r\n"+"\r\t\t\t\t"+"\"type\": "+"\""+prop_type+"\""+"\r\n\t\t\t"+"},";
      }
      content+=more;
      String prop_name=MapCreator.fieldname[i].getText();
      String prop_type=MapCreator.fieldtype[i].getText();;
      content+="\r\n"+"\r\t\t\t\t"+"\""+prop_name+"\": {"+"\r\n"+"\r\t\t\t\t"+"\"type\": "+"\""+prop_type+"\""+"\r\n\t\t\t"+"}";
      content+="\r\n\t\t}\r\n\t}\r\n}}";
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
