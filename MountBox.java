import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MountBox {
  static TextField index=new TextField();
  static TextField type=new TextField();
  public static void display() {
    Stage stage=new Stage();
    Button mount=new Button("Mount");
    mount.setOnAction(e -> {
      BulkLoader.display();
      stage.close();
    });
    Label index_label=new Label("Index: ");
    Label type_label=new Label("Type:");
    GridPane grid=new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.setVgap(8);
    grid.setHgap(10);
    grid.setAlignment(Pos.CENTER);
    grid.getChildren().addAll(index, type, index_label, type_label, mount);

    GridPane.setConstraints(index_label, 0, 0);
    GridPane.setConstraints(index, 1, 0);
    GridPane.setConstraints(type_label, 0, 1);
    GridPane.setConstraints(type, 1, 1);
    GridPane.setConstraints(mount, 1, 2);

    Scene scene=new Scene(grid, 350, 200);
    stage.setScene(scene);
    stage.setTitle("MOUNT BOX");
    stage.show();
  }
}
