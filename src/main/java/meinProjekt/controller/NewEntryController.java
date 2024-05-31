package meinProjekt.controller;

import meinProjekt.model.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class NewEntryController {

    private TagebuchManager manager;

    @FXML
    private TextField dateField;

    @FXML
    private TextArea personenField;

    @FXML
    private TextArea orteField;

    @FXML
    private TextArea erlebnisseField;

    @FXML
    private TextArea gefuehleField;

    public NewEntryController() {
        manager = new TagebuchManager();
    }

    @FXML
    public void onSave(ActionEvent event) {
        try {
            String date = dateField.getText();
            String personen = personenField.getText();
            String orte = orteField.getText();
            String erlebnisse = erlebnisseField.getText();
            String gefuehle = gefuehleField.getText();

            TagebuchEntry newEntry = new TagebuchEntry(date, personen, orte, erlebnisse, gefuehle);
            manager.saveEntry(newEntry);

            // Eintrag gespeichert, Felder zurücksetzen
            dateField.setText("");
            personenField.setText("");
            orteField.setText("");
            erlebnisseField.setText("");
            gefuehleField.setText("");

        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error
        }
    }
}

