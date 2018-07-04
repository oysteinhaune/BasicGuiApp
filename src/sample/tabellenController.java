package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class tabellenController {

    //configure the table
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;

    public void objectButton(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void initialize() {
        // set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        // load dummy date
        tableView.setItems(getPeople());
    }

    // Will return an ObservableList of People objects
    public ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Øystein", "Haugnes Aune", LocalDate.of(1988, Month.MAY, 13)));
        people.add(new Person("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER, 12)));
        people.add(new Person("Elvis", "Presley", LocalDate.of(1935, Month.JANUARY, 8)));
        people.add(new Person("Linus", "Torvalds", LocalDate.of(1969, Month.DECEMBER, 28)));
        people.add(new Person("Bill", "Gates", LocalDate.of(1955, Month.OCTOBER, 28)));
        people.add(new Person("Mark", "Zuckerberg", LocalDate.of(1984, Month.MAY, 14)));

        return people;
    }
}
