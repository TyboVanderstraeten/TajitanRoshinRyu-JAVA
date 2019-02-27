/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Tim
 */
public class Activiteit {

    private String naam;
    private Formule formule;
    private LocalDate datum;
    private String straat;
    private String stad;
    private String postcode;
    private String huisnummer;
    private String bus;
    private List<Lid> deelnemers;

    private final SimpleStringProperty sNaam = new SimpleStringProperty();
    private final SimpleStringProperty sFormule = new SimpleStringProperty();
    private final SimpleStringProperty sDatum = new SimpleStringProperty();
    private final SimpleStringProperty sStraat = new SimpleStringProperty();
    private final SimpleStringProperty sStad = new SimpleStringProperty();
    private final SimpleStringProperty sPostcode = new SimpleStringProperty();
    private final SimpleStringProperty sHuisnummer = new SimpleStringProperty();
    private final SimpleStringProperty sBus = new SimpleStringProperty();

    // enkel naam en datum zijn verplicht in de DB, 
    // vandaar krijgen deze private setters 
    // en worden deze altijd in de constructor geïnitialiseerd
    public Activiteit(String naam, Formule formule, LocalDate datum) {
        setNaam(naam);
        setFormule(formule);
        setDatum(datum);
        deelnemers=new ArrayList<>();
    }

    //Getters voor simplestringproperties
    public StringProperty naamProperty() {
        return sNaam;
    }

    public StringProperty formuleProperty() {
        return sFormule;
    }

    public StringProperty datumProperty() {
        return sDatum;
    }

    public StringProperty straatProperty() {
        return sStraat;
    }

    public StringProperty stadProperty() {
        return sStad;
    }

    public StringProperty postcodeProperty() {
        return sPostcode;
    }

    public StringProperty huisnummerProperty() {
        return sHuisnummer;
    }

    public StringProperty busProperty() {
        return sBus;
    }

    //Gewone getters en setters
    public String getNaam() {
        return sNaam.get();
    }

    private void setNaam(String naam) {
        sNaam.set(naam);
    }

    public Formule getFormule() {
        return Formule.valueOf(sFormule.get());
    }

    private void setFormule(Formule formule) {
        sFormule.set(formule.name());
    }

    public LocalDate getDatum() {
        return LocalDate.parse(sDatum.get());
    }

    private void setDatum(LocalDate datum) {
        sDatum.set(datum.toString());
    }

    private String getStraat() {
        return sStraat.get();
    }

    public void setStraat(String straat) {
        sStraat.set(straat);
    }

    public String getStad() {
        return sStad.get();
    }

    public void setStad(String stad) {
        sStad.set(stad);
    }

    public String getPostcode() {
        return sPostcode.get();
    }

    public void setPostcode(String postcode) {
        sPostcode.set(postcode);
    }

    public String getHuisnummer() {
        return sHuisnummer.get();
    }

    public void setHuisnummer(String huisnummer) {
        sHuisnummer.set(huisnummer);
    }

    public String getBus() {
        return sBus.get();
    }

    public void setBus(String bus) {
        sBus.set(bus);
    }

    public List<Lid> getDeelnemers() {
        return deelnemers;
    }

    public void setDeelnemers(List<Lid> deelnemers) {
        this.deelnemers = deelnemers;
    }

    public void voegDeelnemerToe(Lid lid) {
        this.deelnemers.add(lid);
    }

    public void verwijderDeelnemer(Lid lid) {
        this.deelnemers.remove(lid);
    }

}
