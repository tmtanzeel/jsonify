//GRID ARRANGEMENT OF MULTIPLE TextFields and Labels AND A BUTTON FOR SUBMIT
//ASSUMING 10 COMPONENTS FOR EACH
//FOR EG. A FORM

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
//import java.io.File;

public class MapCreator {
  static TextField[] fieldname=new TextField[50];
  static TextField[] fieldtype=new TextField[50];
  public static void display() {
    Button save=new Button("Save");
    Button discard=new Button("Discard");
    Label[] labelname=new Label[50];
    Label[] labeltype=new Label[50];
    Label label;
    GridPane grid;
    BorderPane layout;
    HBox hbox1, hbox2;
    Scene scene;
    int i, j;

    Stage primarystage=new Stage();

    save.setOnAction(e -> {
      System.out.println("pressed");
/*
      File newFolder = new File("FOLDER");
      boolean created =  newFolder.mkdir();
      if(created)
        System.out.println("Folder was created !");
      else
        System.out.println("Unable to create folder");
*/
      Map.pen();
      Fields.pen();
      IdCounter.pen();
    });
    discard.setOnAction(e -> {
      primarystage.close();
    });

    label=new Label("All fields are mandatory");

    grid=new GridPane();
    grid.setPadding(new Insets(0, 10, 10, 10));
    grid.setAlignment(Pos.CENTER);
    grid.setVgap(15);
    grid.setHgap(15);

    hbox1=new HBox(10);
    hbox1.setPadding(new Insets(50, 0, 0, 0));
    hbox1.setAlignment(Pos.CENTER);
    hbox1.getChildren().add(label);

    hbox2=new HBox(10);
    hbox2.setPadding(new Insets(0, 0, 50, 0));
    hbox2.setAlignment(Pos.CENTER);
    hbox2.getChildren().addAll(save, discard);

    layout=new BorderPane();
    layout.setTop(hbox1);
    layout.setCenter(grid);
    layout.setBottom(hbox2);

    for(i=0; i<Integer.parseInt(CreatorClass.n); i++) {
      TextField textfield1=new TextField();
      TextField textfield2=new TextField();
      Label lbname=new Label("Field: ");
      Label lbtype=new Label("Type: ");
      fieldname[i]=textfield1;
      fieldtype[i]=textfield2;
      labelname[i]=lbname;
      labeltype[i]=lbtype;
      try {
        grid.getChildren().add(fieldname[i]);
        grid.getChildren().add(fieldtype[i]);
        grid.getChildren().add(labelname[i]);
        grid.getChildren().add(labeltype[i]);
      }
      catch(Exception e) {
        System.out.println("failed to execute");
      }
    }

    for(i=0; i<Integer.parseInt(CreatorClass.n); i++) {
      GridPane.setConstraints(labelname[i], 0, i);
      GridPane.setConstraints(fieldname[i], 1, i);
      GridPane.setConstraints(labeltype[i], 2, i);
      GridPane.setConstraints(fieldtype[i], 3, i);
    }

    scene=new Scene(layout, 100*5, 80*7);

    primarystage.setScene(scene);
    primarystage.setResizable(false);
    primarystage.setTitle("WINDOW");
    primarystage.show();
  }
}
