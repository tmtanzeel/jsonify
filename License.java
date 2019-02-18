import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class License {
  Image image = new Image(getClass().getResourceAsStream("assets/images/open-source-logo.png"));
  public void display() {
    Scene scene;
    Stage stage=new Stage();
    BorderPane layout=new BorderPane();
    VBox vbox1=new VBox(10);
    vbox1.setPadding(new Insets(30, 10, 10, 10));
    VBox vbox2=new VBox(5);
    vbox2.setPadding(new Insets(30, 10, 10, 10));

    Label imagelabel = new Label();
    imagelabel.setGraphic(new ImageView(image));
    Label label1=new Label("Hola!");
    label1.getStyleClass().add("hola-text");
    Label label2=new Label("It's Open Source");
    label2.getStyleClass().add("open-source-text");
    File imageFile = new File("assets/images/github-logo-1.png");
    Image imageDecline = new Image(imageFile.toURI().toString());
    Button github=new Button("github", new ImageView(imageDecline));
    github.getStyleClass().add("github-button");
    github.setOnAction(e -> {
      try {
        // create a URI
        URI u=new URI("https://www.github.com/tmtanzeel");
        Desktop d=Desktop.getDesktop();
        d.browse(u);
      }
      catch (Exception evt) {
      }
    });
    vbox1.getChildren().add(imagelabel);
    vbox2.getChildren().addAll(label1, label2, github);
    layout.setLeft(vbox1);
    layout.setCenter(vbox2);

    scene=new Scene(layout, 440, 240);
    scene.getStylesheets().add("assets/css/License.css");
    stage.setTitle("LICENSE");
    stage.setScene(scene);
    stage.resizableProperty().setValue(Boolean.FALSE);
    stage.show();
  }
}
