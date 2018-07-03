package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller {

    // Checkbox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckbox;
    @FXML private CheckBox baconCheckbox;
    @FXML private CheckBox ananasCheckbox;

    // ChoiceBox example
    @FXML private ChoiceBox presidentChoiceBox;
    @FXML private Label choiceBoxLabel;

    @FXML
    public void initialize() {
        pizzaOrderLabel.setText("");
        choiceBoxLabel.setText("");

        presidentChoiceBox.getItems().add("Donald Trump");
        presidentChoiceBox.getItems().add("Obama");
        presidentChoiceBox.getItems().add("Clinton");
        presidentChoiceBox.setValue("Donald Trump");
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


}
