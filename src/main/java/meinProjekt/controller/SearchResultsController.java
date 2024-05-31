package meinProjekt.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import meinProjekt.model.*;

import java.util.List;
public class SearchResultsController {

    @FXML
    private TableView<TagebuchEntry> searchResultsTable;

    @FXML
    private TableColumn<TagebuchEntry, String> dateColumn;
    @FXML
    private TableColumn<TagebuchEntry, String> personenColumn;
    @FXML
    private TableColumn<TagebuchEntry, String> orteColumn;
    @FXML
    private TableColumn<TagebuchEntry, String> erlebnisseColumn;
    @FXML
    private TableColumn<TagebuchEntry, String> gefuehleColumn;

    @FXML
    private void initialize() {
        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));
        personenColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPersonen()));
        orteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOrte()));
        erlebnisseColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getErlebnisse()));
        gefuehleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGefuehle()));

        searchResultsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void setEntries(List<TagebuchEntry> entries) {
        searchResultsTable.getItems().setAll(entries);
    }
}
