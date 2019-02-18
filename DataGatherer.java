import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class DataGatherer {
  public static void pen() {
    int i=0;
    int last_id=0;
    int next_id=0;
    String line="";

    String filename=MountBox.type.getText()+"-maxid.txt";
    BufferedReader reader;

    //GO TO *-maxid.txt AND SEE LAST ID
    try {
      reader=new BufferedReader(new FileReader(filename));
    	line=reader.readLine();
    	while (line != null) {
    		System.out.println(line);
        last_id=Integer.parseInt(line);
        line = reader.readLine();
      }
      next_id=++last_id;
    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    //GO TO *-maxid.txt AGAIN AND RESET LAST ID
    try {
  		File file = new File(filename);
  		if(!file.exists()) {
  			System.out.println("File not found");;
  		}
  		PrintWriter pw = new PrintWriter(file);
      String content=""+next_id;
  		pw.println(content);
  		pw.close();
    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    //CREATING *-bulk.json
    String indexname=MountBox.index.getText();
    String typename=MountBox.type.getText();
    String head="POST /"+indexname+"/"+typename+"/_bulk\r\n";
    filename=typename+"-bulk.json";

    try {
      //CHECK IF BULK FILE ALREADY EXISTS OTHERWISE CREATE IT
      File check=new File(filename);
      if(!check.exists()) {
        check.createNewFile();
        FileWriter file = new FileWriter(filename);
    		PrintWriter pw = new PrintWriter(file);
        String content=head;
        pw.println(content);
    		pw.close();
      }

      FileWriter file = new FileWriter(filename, true);
  		PrintWriter pw = new PrintWriter(file);
      String content="";
      int nof=BulkLoader.count;
      content+="{ \"index\" : { \"_index\" : " +"\""+indexname +"\", \"_type\" :"+"\""+typename+"\", \"_id\" : \""+next_id+"\" } }\r\n{";
      String filename1=MountBox.type.getText();
      filename1+="-properties.txt";
      reader = new BufferedReader(new FileReader(filename1));
      line = reader.readLine();
      i=0;
      while (line != null) {
        if(isItNum(BulkLoader.tf_value[i].getText())) {
          content+="\""+line+"\" :"+BulkLoader.tf_value[i].getText()+",";
        }
        else {
          content+="\""+line+"\" : \""+BulkLoader.tf_value[i].getText()+"\",";
        }
        line=reader.readLine();
        if((++i)==(nof-1)) {
          break;
        }
      }
      if(isItNum(BulkLoader.tf_value[i].getText())) {
        content+="\""+line+"\" :"+BulkLoader.tf_value[i].getText()+"}";
      }
      else {
        content+="\""+line+"\" : \""+BulkLoader.tf_value[i].getText()+"\"}";
      }
  		pw.println(content);
  		pw.close();
  		System.out.println("DataGatherer: Test case passed");
      Runtime rs = Runtime.getRuntime();
      rs.exec("notepad "+filename);
		}
    catch (IOException e) {
			System.out.println("DataGatherer: Exception occured while writing to a file");
		}
	}

  private static boolean isItNum(String value) {
    try {
      int temp=Integer.parseInt(value);
      return true;
    }
    catch(NumberFormatException nfe) {
      System.out.println("String - found and ignored");
      return false;
    }
  }
}
