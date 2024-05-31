package meinProjekt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import meinProjekt.model.TagebuchEntry;

public class DatabaseHandler {
    private Connection connection;
    private static final String DB_URL ="jdbc:sqlite:src/main/resources/database-file.db";



    // Erstelle die Tabelle, wenn sie nicht existiert
    public void createTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS tagebuch ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "date TEXT,"
            + "personen TEXT,"
            + "orte TEXT,"
            + "erlebnisse TEXT,"
            + "gefuehle TEXT"
            + ")";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DatabaseHandler() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(TagebuchEntry entry) {
        String insertQuery = "INSERT INTO tagebuch (date, personen, orte, erlebnisse, gefuehle) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, entry.getDate());
            preparedStatement.setString(2, entry.getPersonen());
            preparedStatement.setString(3, entry.getOrte());
            preparedStatement.setString(4, entry.getErlebnisse());
            preparedStatement.setString(5, entry.getGefuehle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getEntriesByDate(String date) {
        String selectQuery = "SELECT * FROM tagebuch WHERE date = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, date);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

