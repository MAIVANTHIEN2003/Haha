package Session11.Asissgnment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HomeController {


    public void studentModule(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void bookModule(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("book.fxml"));
        Main.rootStage.setScene(new Scene(root, 1095, 758));
    }

    public void rentModule(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("rent.fxml"));
        Main.rootStage.setScene(new Scene(root, 952, 694));
    }
}