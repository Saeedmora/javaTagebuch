package meinProjekt.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import meinProjekt.model.TagebuchEntry;
import meinProjekt.model.TagebuchManager;

public class SearchController {

    private TagebuchManager manager;

    @FXML
    private TextField searchField;

    @FXML
    private TextArea resultsArea;

    public SearchController() {
        manager = new TagebuchManager();
    }

    @FXML
    public void onSearch() {
        try {
            String date = searchField.getText();
            if (manager == null) {
                System.out.println("Manager ist null");
                return;
            }

            if (date == null) {
                System.out.println("Date ist null");
                return;
            }
            List<TagebuchEntry> entries = manager.getEntriesByDate(date);

            if (entries == null) {
                System.out.println("Entries ist null");
                resultsArea.setText("Keine Einträge für dieses Datum gefunden.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (TagebuchEntry entry : entries) {
                sb.append(entry.toString());
                sb.append("\n\n");
            }

            

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/meinProjekt/view/SearchResultsView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            SearchResultsController resultsController = fxmlLoader.getController();
            resultsController.setEntries(entries);

        } catch (IOException e) {
            e.printStackTrace();
            resultsArea.setText("Ein Fehler ist aufgetreten.");
        }
    }
}
