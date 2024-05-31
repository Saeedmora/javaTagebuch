package meinProjekt.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import meinProjekt.db.*;

public class TagebuchManager {

    private final DatabaseHandler databaseHandler;

    public TagebuchManager() {
        databaseHandler = new DatabaseHandler();
    }

    public void saveEntry(TagebuchEntry entry) {
        databaseHandler.addEntry(entry);
    }

    public List<TagebuchEntry> getEntriesByDate(String date) {
        ResultSet resultSet = databaseHandler.getEntriesByDate(date);
        List<TagebuchEntry> entries = new ArrayList<>();

        try {
            while (resultSet.next()) {
                String personen = resultSet.getString("personen");
                String orte = resultSet.getString("orte");
                String erlebnisse = resultSet.getString("erlebnisse");
                String gefuehle = resultSet.getString("gefuehle");
                entries.add(new TagebuchEntry(date, personen, orte, erlebnisse, gefuehle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entries;
    }
}
