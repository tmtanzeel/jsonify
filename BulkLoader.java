import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BulkLoader {
  //static TextField[] tf_prop=new TextField[50];
  static TextField[] tf_value=new TextField[50];
  static String filename="";
  static int count=0;
  public static void display() {
    Button push=new Button("Push");
    push.setOnAction(e -> {
      DataGatherer.pen();
    });
    HBox hbox=new HBox(10);
    hbox.setPadding(new Insets(10, 0, 50, 0));
    hbox.setAlignment(Pos.CENTER);
    hbox.getChildren().add(push);
    BorderPane layout=new BorderPane();
    GridPane grid=new GridPane();
    grid.setPadding(new Insets(40, 10, 10, 10));
    grid.setVgap(8);
    grid.setHgap(10);
    grid.setAlignment(Pos.CENTER);
    int i=0;
    Label[] label=new Label[50];
    BufferedReader reader;
    filename=MountBox.type.getText();
    filename+="-properties.txt";
    try {
      reader = new BufferedReader(new FileReader(filename));
      String line = reader.readLine();
      while (line != null) {
        line = reader.readLine();
        count++;
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    try {
      reader = new BufferedReader(new FileReader(filename));
    	String line = reader.readLine();
    	while (line != null) {
    		//System.out.println(line);
    		// read next line
        //TextField tfp=new TextField();
        TextField tfv=new TextField();
        Label lb=new Label();

        //tf_prop[i]=tfp;
        tf_value[i]=tfv;
        tf_value[i].setPromptText("value");
        label[i]=lb;
        label[i].setText(""+line+": ");

        line = reader.readLine();

        try {
          grid.getChildren().add(label[i]);
          //grid.getChildren().add(tf_prop[i]);
          grid.getChildren().add(tf_value[i]);
        }
        catch(Exception e) {
          System.out.println("failed to execute");
        }
        i++;
    	}
      for(i=0; i<count; i++) {
        try {
          GridPane.setConstraints(label[i], 0, i);
          //GridPane.setConstraints(tf_prop[i], 1, i);
          GridPane.setConstraints(tf_value[i], 2, i);
        }
        catch(Exception e) {
          e.printStackTrace();
        }
      }
    	reader.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    layout.setTop(grid);
    layout.setBottom(hbox);
    Scene scene=new Scene(layout, 450, 300);
    Stage stage=new Stage();
    stage.setScene(scene);
    stage.setTitle("BULK LOAD BOX");
    stage.setResizable(false);
    stage.show();
  }
}
