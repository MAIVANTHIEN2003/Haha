package Session11.Asissgnment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    public TableColumn<Book, String> sbookName;
    public TableColumn<Book,String> spubliisherName;
    public TableColumn<Book, Date> spubliishYear;
    public TableColumn<Book,String> sAuthor;
    public TableColumn<Book, Double> sPrice;

    // tao cac string ket noi
    public final static String connectionString = "jdbc:mysql://localhost:3306/quanly";
    public final static String user = "root";
    public final static String password = "";
    public TableView tbBook;
    public TableColumn sId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sbookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        spubliisherName.setCellValueFactory(new PropertyValueFactory<>("publiisherName"));
        spubliishYear.setCellValueFactory(new PropertyValueFactory<>("publiishYear"));
        sAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        sPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        try {
            // goi driver
            Class.forName("com.mysql.jdbc.Driver");
            // tao connect
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            // khai bao Statement de truy van sql
            Statement stt = conn.createStatement();
            // truy van sql
            String txt_sql = "select * from books";
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Book> list = FXCollections.observableArrayList();
            while (rs.next()){
                Book s = new Book(
                        rs.getInt("Id"),
                        rs.getString("BookName"),
                        rs.getString("PubliisherName"),
                        rs.getDate("PubliishYear"),
                        rs.getString("Author"),
                        rs.getDouble("Price")
                );
                list.add(s);
            }
            tbBook.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void backHome(ActionEvent event)  throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void addBook(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("bookForm.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
}
