import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreatorClass {
  static String n;
  static TextField tf1, tf2, tf3;
  public static void askdialogue() {
    Scene scene;
    Stage stage=new Stage();
    Button create=new Button("Create");
    Label indexname=new Label("Index: ");
    Label typename=new Label("Type: ");
    Label nofields=new Label("No of fields: ");
    AtomicBoolean first = new AtomicBoolean(false);
    AtomicBoolean sec = new AtomicBoolean(false);
    AtomicBoolean third = new AtomicBoolean(false);

    tf1=new TextField("");
    tf1.setPromptText("health");
    tf2=new TextField("");
    tf2.setPromptText("patient");
    tf3=new TextField("");
    tf3.setPromptText("[1, 10]");

    create.setOnAction(e -> {
      //CHECK INDEXNAME TEXTFIELD FOR STRING
      if(isstring(tf1, tf1.getText())) {
        first.set(true);
      }
      else {
        tf1.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
      }

      //CHECK TYPENAME TEXTFIELD FOR STRING
      if(isstring(tf2, tf2.getText())) {
        sec.set(true);
      }
      else {
        tf2.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
      }

      //CHECK INTEGER VALIDITY FOR NO OF FIELDS
      if(isint(tf3, tf3.getText())) {
        //System.out.println("Passed");
        third.set(true);
      }
      else {
        //System.out.println("Failed");
        tf3.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
      }

      //OPEN NEW DIALOGUE WITH ALL TextFields
      if(first.get()==true && sec.get()==true && third.get()==true) {
        n=tf3.getText();
        MapCreator.display();
        stage.close();
      }
    });

    GridPane layout=new GridPane();
    layout.setPadding(new Insets(10, 10, 10, 10));
    layout.setVgap(8);
    layout.setHgap(10);
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().addAll(indexname, typename, nofields, tf1, tf2, tf3, create);

    GridPane.setConstraints(indexname, 0, 0);
    GridPane.setConstraints(tf1, 1, 0);
    GridPane.setConstraints(typename, 0, 1);
    GridPane.setConstraints(tf2, 1, 1);
    GridPane.setConstraints(nofields, 0, 2);
    GridPane.setConstraints(tf3, 1, 2);
    GridPane.setConstraints(create, 1, 3);

    scene=new Scene(layout, 350, 200);

    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("DIALOGUE");
    stage.setScene(scene);
    stage.showAndWait();
  }

  private static boolean isint(TextField tf, String value) {
    try {
      int x=Integer.parseInt(value);
      if(x<1 || x>10) {
        return false;
      }
      return true;
    }
    catch(NumberFormatException nfe) {
      System.out.println("Exception-Not a number: "+nfe);
      return false;
    }
  }

  private static boolean isstring(TextField tf, String value) {
    try {
      value=value.trim();
      if(value==null || value.equals(""))
        return false;

      if(!value.matches("[a-zA-Z]*"))
        return false;

      return true;
    }
    catch(Exception e) {
      System.out.println("Exception caught: "+e);
      return false;
    }
  }
}
