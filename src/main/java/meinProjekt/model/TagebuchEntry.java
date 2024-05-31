package meinProjekt.model;

public class TagebuchEntry {

    private String date;
    private String personen;
    private String orte;
    private String erlebnisse;
    private String gefuehle;

    public TagebuchEntry(String date, String personen, String orte, String erlebnisse, String gefuehle) {
        this.date = date;
        this.personen = personen;
        this.orte = orte;
        this.erlebnisse = erlebnisse;
        this.gefuehle = gefuehle;
    }

  

	public String getDate() {
        return date;
    }

    public String getPersonen() {
        return personen;
    }

    public String getOrte() {
        return orte;
    }

    public String getErlebnisse() {
        return erlebnisse;
    }

    public String getGefuehle() {
        return gefuehle;
    }
}
