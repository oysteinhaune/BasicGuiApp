package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    // Checkbox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckbox;
    @FXML private CheckBox baconCheckbox;
    @FXML private CheckBox ananasCheckbox;

    // ChoiceBox example
    @FXML private ChoiceBox presidentChoiceBox;
    @FXML private Label choiceBoxLabel;

    // ChoiceBox example 2
    @FXML private ComboBox hobbyComboBox;
    @FXML private Label hobbyLabel;

    @FXML
    public void initialize() {
        pizzaOrderLabel.setText("");
        choiceBoxLabel.setText("");

        presidentChoiceBox.getItems().add("Donald Trump");
        presidentChoiceBox.getItems().add("Obama");
        presidentChoiceBox.getItems().add("Clinton");
        presidentChoiceBox.setValue("Donald Trump");

        hobbyComboBox.getItems().add("Fiske");
        hobbyComboBox.getItems().add("Ta bilder");
        hobbyComboBox.getItems().addAll("Reise", "Lage mat", "Drikke øl");
        hobbyLabel.setText("");
    }

    public void tabellButton(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("tabellen.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void pizzaOrderButton (ActionEvent event) {
        String order = "Pizzatopping valgt: \n";

        if (pepperoniCheckbox.isSelected()) {
            order += "Pepperoni \n";
        }
        if (baconCheckbox.isSelected()) {
            order += "Bacon \n";
        }
        if (ananasCheckbox.isSelected()) {
            order += "Ananas \n";
        }
        if (!pepperoniCheckbox.isSelected() && !baconCheckbox.isSelected() && !ananasCheckbox.isSelected()){
            order += "Ingen ekstra valgt\n";
        }

        pizzaOrderLabel.setText("Bestillingen er registrert\n\n" + order + "\nHåper det smaker!");
    }

    public void presidentButton (ActionEvent event) {
        choiceBoxLabel.setText("Din stemme er lagt inn:\n" + "Du stemmer på:\n" + presidentChoiceBox.getValue().toString());
    }

    public void updateComboBox (ActionEvent event) {
        hobbyLabel.setText("Hobby valgt:\n" + hobbyComboBox.getValue().toString());
    }
}
