import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Main extends Application {
  Button create, edit, append, drop, lisence, mount;
  HBox hb, hb1;
  BorderPane layout;
  Scene scene;

  @Override
  public void start(Stage primarystage) {

    //CREATE BUTTON
    create=new Button("Create");
    create.setOnAction(e -> {
      CreatorClass.askdialogue();
    });

    //MOUNT BUTTON
    mount=new Button("Mount");
    mount.setOnAction(e -> {
      MountBox.display();
    });

    //EDIT BUTTON
    edit=new Button("Edit");
    edit.setOnAction(e -> {

    });

    //APPEND BUTTON
    append=new Button("Append");
    append.setOnAction(e -> {

    });

    //DROP BUTTON
    drop=new Button("Drop");
    drop.setOnAction(e -> {

    });

    //LISENCE BUTTON
    lisence=new Button("License");
    lisence.setOnAction(e -> {
      new License().display();
    });

    Image image = new Image(getClass().getResourceAsStream("assets/images/wallpaper.png"));
    Label label1 = new Label();
    label1.setGraphic(new ImageView(image));

    hb1=new HBox(10);
    hb1.setAlignment(Pos.CENTER);
    hb1.getChildren().add(label1);


    hb=new HBox(50);
    hb.setAlignment(Pos.CENTER);
    hb.getChildren().addAll(create, mount, edit, append, drop, lisence);

    layout=new BorderPane();
    layout.setPadding(new Insets(10, 10, 10, 10));
    layout.setTop(hb1);
    layout.setBottom(hb);

    scene=new Scene(layout, 350, 200);
    scene.getStylesheets().add("assets/css/Main.css");

    create.getStyleClass().add("control-buttons");
    edit.getStyleClass().add("control-buttons");
    append.getStyleClass().add("control-buttons");
    drop.getStyleClass().add("control-buttons");
    lisence.getStyleClass().add("control-buttons");
    mount.getStyleClass().add("control-buttons");

    primarystage.setTitle("JSON MANAGER");
    primarystage.setMinWidth(1000);
    primarystage.setMinHeight(450);
    //primarystage.resizableProperty().setValue(Boolean.FALSE);
    primarystage.setScene(scene);
    primarystage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
