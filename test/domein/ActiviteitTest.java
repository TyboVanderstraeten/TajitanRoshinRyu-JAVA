package domein;

import domein.enums.Formule;
import domein.enums.Functie;
import domein.enums.Graad;
import exceptions.DatumIntervalException;
import exceptions.VolzetException;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActiviteitTest {

    Lid lid;
    Lid lid2;
    Activiteit activiteit;

    @Before
    public void setUp() {
        lid = new Lid("Tim", "Geldof", LocalDate.of(1997, Month.JULY, 17),
                "97.07.17-357.55",
                "0479330959", "051303050", "Izegem", "Winkelhoekstraat",
                "52", "8870", "tim.geldof@outlook.com",
                "Wachtwoord", "Izegem", "Man",
                "Belg", Graad.DAN5, Functie.LID);

        lid2 = new Lid("Tybo", "Vanderstraeten", LocalDate.of(1999, Month.DECEMBER, 8),
                "99.12.08.173.04",
                "0479365887", "098556880", "Kortrijk", "Prinses Clementinalaan",
                "11", "9980", "tybo.vanderstraeten@outlook.com",
                "TomatoSoup", "Gent", "Man",
                "Belg", Graad.KYU3, Functie.LID);

        activiteit = new Activiteit("Testactiviteit", Formule.ACTIVITEIT,
                1, LocalDate.of(2020, Month.DECEMBER, 20), LocalDate.of(2020, Month.MARCH, 10));

    }

    @After
    public void reset() {
        lid = new Lid("Tim", "Geldof", LocalDate.of(1997, Month.JULY, 17),
                "97.07.17-357.55",
                "0479330959", "051303050", "Izegem", "Winkelhoekstraat",
                "52", "8870", "tim.geldof@outlook.com",
                "Wachtwoord", "Izegem", "Man",
                "Belg", Graad.DAN5, Functie.LID);

        lid2 = new Lid("Tybo", "Vanderstraeten", LocalDate.of(1999, Month.DECEMBER, 8),
                "99.12.08.173.04",
                "0479365887", "098556880", "Kortrijk", "Prinses Clementinalaan",
                "11", "9980", "tybo.vanderstraeten@outlook.com",
                "TomatoSoup", "Gent", "Man",
                "Belg", Graad.KYU3, Functie.LID);

        activiteit = new Activiteit("Testactiviteit", Formule.ACTIVITEIT,
                1, LocalDate.of(2020, Month.DECEMBER, 20), LocalDate.of(2020, Month.MARCH, 10));
    }

    //Setter tests
    //Naam
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetNaam_Null_ThrowsIllegalArgumentException() {
        activiteit.setNaam(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetNaam_Empty_ThrowsIllegalArgumentException() {
        activiteit.setNaam("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetNaam_TeLang_ThrowsIllegalArgumentException() {
        String output = "";
        for (int i = 0; i < 36; i++) {
            output.concat("a");
        }
        activiteit.setNaam(output);
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaam_MetNummers_ThrowsInputMismatchException() {
        activiteit.setNaam("azezae12345");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaam_EnkelNummers_ThrowsInputMismmatchException() {
        activiteit.setNaam("15515");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaam_MetSymbolen_ThrowsInputMismatchException() {
        activiteit.setNaam("aze@ze-*/151");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaam_EnkelSymbolen_ThrowsInputMismatchException() {
        activiteit.setNaam("@@/*-+$^");
    }

    @Test
    public void activiteit_SetNaam_MetSpaties_Correct() {
        activiteit.setNaam("De Stage");
        Assert.assertEquals("De Stage", activiteit.getNaam());
    }

    @Test
    public void activiteit_SetNaam_Correct() {
        activiteit.setNaam("Hoogtestage");
        Assert.assertEquals("Hoogtestage", activiteit.getNaam());
    }

    //Straat
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetStraat_Null_ThrowsIllegalArgumentException() {
        activiteit.setStraat(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetStraat_Empty_ThrowsIllegalArgumentException() {
        activiteit.setStraat("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetStraat_TeLang_ThrowsIllegalArgumentException() {
        String output = "";
        for (int i = 0; i < 51; i++) {
            output.concat("a");
        }
        activiteit.setStraat(output);
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStraat_MetNummers_ThrowsInputMismatchException() {
        activiteit.setStraat("azezae12345");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStraat_EnkelNummers_ThrowsInputMismmatchException() {
        activiteit.setStraat("15515");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStraat_MetSymbolen_ThrowsInputMismatchException() {
        activiteit.setStraat("aze@ze-*/151");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStraat_EnkelSymbolen_ThrowsInputMismatchException() {
        activiteit.setStraat("@@/*-+$^");
    }

    @Test
    public void activiteit_SetStraat_MetSpaties_Correct() {
        activiteit.setStraat("De Van Eeckhoutstraat");
        Assert.assertEquals("De Van Eeckhoutstraat", activiteit.getStraat());
    }

    @Test
    public void activiteit_SetStraat_Correct() {
        activiteit.setStraat("Voskenslaan");
        Assert.assertEquals("Voskenslaan", activiteit.getStraat());
    }

    //Stad
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetStad_Null_ThrowsIllegalArgumentException() {
        activiteit.setStad(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetStad_Empty_ThrowsIllegalArgumentException() {
        activiteit.setStad("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetStad_TeLang_ThrowsIllegalArgumentException() {
        String output = "";
        for (int i = 0; i < 51; i++) {
            output.concat("a");
        }
        activiteit.setStad(output);
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStad_MetNummers_ThrowsInputMismatchException() {
        activiteit.setStad("azezae12345");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStad_EnkelNummers_ThrowsInputMismmatchException() {
        activiteit.setStad("15515");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStad_MetSymbolen_ThrowsInputMismatchException() {
        activiteit.setStad("aze@ze-*/151");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetStad_EnkelSymbolen_ThrowsInputMismatchException() {
        activiteit.setStad("@@/*-+$^");
    }

    @Test
    public void activiteit_SetStad_MetSpaties_Correct() {
        activiteit.setStad("Nieuw Gent");
        Assert.assertEquals("Nieuw Gent", activiteit.getStad());
    }

    @Test
    public void activiteit_SetStad_Correct() {
        activiteit.setStad("Gent");
        Assert.assertEquals("Gent", activiteit.getStad());
    }

    //PostCode
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_Null_ThrowsIllegalArgumentException() {
        activiteit.setPostcode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_Empty_ThrowsIllegalArgumentException() {
        activiteit.setPostcode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_TeLang_ThrowsIllegalArgumentException() {
        activiteit.setPostcode("55555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_MetLetters_ThrowsIllegalArgumentException() {
        activiteit.setPostcode("74aa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_EnkelLetters_ThrowsIllegalArgumentException() {
        activiteit.setPostcode("aaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_MetSymbolen_ThrowsIllegalArgumentException() {
        activiteit.setPostcode("74@-");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetPC_EnkelSymbolen_ThrowsIllegalArgumentException() {
        activiteit.setPostcode("/*@-");
    }

    @Test
    public void activiteit_SetPC_Correct() {
        activiteit.setPostcode("9000");
        Assert.assertEquals("9000", activiteit.getPostcode());
    }

    //HuisNummer
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetHNR_Null_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetHNR_Empty_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetHNR_TeLang_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer("123456");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetHNR_MetLetters_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer("74aa");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetHNR_EnkelLetters_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer("aaaa");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetHNR_MetSymbolen_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer("74@-");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetHNR_EnkelSymbolen_ThrowsIllegalArgumentException() {
        activiteit.setHuisnummer("/*@-");
    }

    @Test
    public void activiteit_SetHNR_Correct() {
        activiteit.setHuisnummer("13");
        Assert.assertEquals("13", activiteit.getHuisnummer());
    }

    //Bus
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetBus_TeLang_ThrowsIllegalArgumentException() {
        activiteit.setBus("123456");
    }

    @Test
    public void activiteit_SetBus_Correct() {
        activiteit.setBus("81a");
        Assert.assertEquals("81a", activiteit.getBus());
    }

    //Formule
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetFormule_Null_ThrowsIllegalArgumentException() {
        activiteit.setFormule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetFormule_Empty_ThrowsIllegalArgumentException() {
        activiteit.setFormule(Formule.valueOf(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetFormule_NotExisting_ThrowsIllegalArgumentException() {
        activiteit.setFormule(Formule.valueOf("BESTAATNIET"));
    }

    @Test
    public void activiteit_SetFormule_Correct() {
        activiteit.setFormule(Formule.WO_ZA);
        Assert.assertEquals(Formule.WO_ZA, activiteit.getFormule());
    }

    //BeginDatum
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetBeginDatum_Null_ThrowsIllegalArgumentException() {
        activiteit.setBeginDatum(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetBeginDatum_Empty_ThrowsIllegalArgumentException() {
        activiteit.setBeginDatum(LocalDate.of(Integer.valueOf(""), Integer.valueOf(""), Integer.valueOf("")));
    }

    @Test
    public void activiteit_SetBeginDatum_Correct() {
        activiteit.setBeginDatum(LocalDate.now());
        Assert.assertEquals(LocalDate.now(), activiteit.getBeginDatum());
    }

    //EindDatum
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetEindDatum_Empty_ThrowsIllegalArgumentException() {
        activiteit.setEindDatum(LocalDate.of(Integer.valueOf(""), Integer.valueOf(""), Integer.valueOf("")));
    }

    @Test
    public void activiteit_SetEindDatum_Correct() {
        activiteit.setBeginDatum(LocalDate.now());
        activiteit.setEindDatum(LocalDate.now().plusDays(10));
        Assert.assertEquals(LocalDate.now().plusDays(10), activiteit.getEindDatum());
    }

    //Einddatum voor begindatum
    @Test(expected = DatumIntervalException.class)
    public void activiteit_SetBeginDatum_SetEindDatum_EindKomtVoorBegin_ThrowsDatumIntervalException() {
        activiteit.setBeginDatum(LocalDate.now());
        activiteit.setEindDatum(LocalDate.now().minusDays(1));
    }

    @Test(expected = DatumIntervalException.class)
    public void activiteit_SetBeginDatum_SetEindDatum_BeginKomtVoorEinde_ThrowsDatumIntervalException() {
        activiteit.setEindDatum(LocalDate.now().plusDays(10));
        activiteit.setBeginDatum(LocalDate.now().plusDays(15));
    }

    //UitersteInschrijvingsDatum
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetUitersteInschrijvingsDatum_Null_ThrowsIllegalArgumentException() {
        activiteit.setUitersteInschrijvingsDatum(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetUitersteInschrijvingsDatum_Empty_ThrowsIllegalArgumentException() {
        activiteit.setUitersteInschrijvingsDatum(LocalDate.of(Integer.valueOf(""), Integer.valueOf(""), Integer.valueOf("")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetUitersteInschrijvingsDatum_InVerleden_ThrowsIllegalArgumentException() {
        activiteit.setUitersteInschrijvingsDatum(LocalDate.now().minusDays(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetUitersteInschrijvingsDatum_NaBeginDatum_ThrowsIllegalArgumentException() {
        activiteit.setBeginDatum(LocalDate.now().plusDays(10));
        activiteit.setUitersteInschrijvingsDatum(LocalDate.now().plusDays(15));
    }

    @Test
    public void activiteit_SetUitersteInschrijvingsDatum_Correct() {
        activiteit.setBeginDatum(LocalDate.now().plusDays(5));
        activiteit.setUitersteInschrijvingsDatum(LocalDate.now());
        Assert.assertEquals(LocalDate.now(), activiteit.getUitersteInschrijvingsDatum());

    }

    //MaxDeelnemers
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetMaxDeelnemers_Null_ThrowsIllegalArgumentException() {
        activiteit.setMaxDeelnemers(Integer.valueOf(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetMaxDeelnemers_Empty_ThrowsIllegalArgumentException() {
        activiteit.setMaxDeelnemers(Integer.valueOf(""));
    }

    @Test(expected = NumberFormatException.class)
    public void activiteit_SetMaxDeelnemers_MetLetters_ThrowsInputMismatchException() {
        activiteit.setMaxDeelnemers(Integer.valueOf("50a"));
    }

    @Test(expected = NumberFormatException.class)
    public void activiteit_SetMaxDeelnemers_EnkelLetters_ThrowsInputMismmatchException() {
        activiteit.setMaxDeelnemers(Integer.valueOf("azeaze"));
    }

    @Test(expected = NumberFormatException.class)
    public void activiteit_SetMaxDeelnemers_MetSymbolen_ThrowsInputMismatchException() {
        activiteit.setMaxDeelnemers(Integer.valueOf("15@/"));
    }

    @Test(expected = NumberFormatException.class)
    public void activiteit_SetMaxDeelnemers_EnkelSymbolen_ThrowsInputMismatchException() {
        activiteit.setMaxDeelnemers(Integer.valueOf("@@/*-+$^"));
    }

    @Test(expected = NumberFormatException.class)
    public void activiteit_SetMaxDeelnemers_MetSpaties_ThrowsNumberFormatException() {
        activiteit.setMaxDeelnemers(Integer.valueOf("5 0"));
    }

    @Test
    public void activiteit_SetMaxDeelnemers_Correct() {
        activiteit.setMaxDeelnemers(25);
        Assert.assertEquals(25, activiteit.getMaxDeelnemers());
    }

    //NaamLocatie
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetNaamLocatie_Null_ThrowsIllegalArgumentException() {
        activiteit.setNaamLocatie(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetNaamLocatie_Empty_ThrowsIllegalArgumentException() {
        activiteit.setNaamLocatie("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetNaamLocatie_TeLang_ThrowsIllegalArgumentException() {
        String output = "";
        for (int i = 0; i < 36; i++) {
            output.concat("a");
        }
        activiteit.setNaamLocatie(output);
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaamLocatie_MetNummers_ThrowsInputMismatchException() {
        activiteit.setNaamLocatie("azezae12345");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaamLocatie_EnkelNummers_ThrowsInputMismmatchException() {
        activiteit.setNaamLocatie("15515");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaamLocatie_MetSymbolen_ThrowsInputMismatchException() {
        activiteit.setNaamLocatie("aze@ze-*/151");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetNaamLocatie_EnkelSymbolen_ThrowsInputMismatchException() {
        activiteit.setNaamLocatie("@@/*-+$^");
    }

    @Test
    public void activiteit_SetLocatie_MetSpaties_Correct() {
        activiteit.setNaamLocatie("De Stage");
        Assert.assertEquals("De Stage", activiteit.getNaamLocatie());
    }

    @Test
    public void activiteit_SetNaamLocatie_Correct() {
        activiteit.setNaamLocatie("ArdenseCabine");
        Assert.assertEquals("ArdenseCabine", activiteit.getNaamLocatie());
    }

    //GsmNummer locatie
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetGsmNummer_Null_ThrowsIllegalArgumentException() {
        activiteit.setGsmnummer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetGsmNummer_Empty_ThrowsIllegalArgumentException() {
        activiteit.setGsmnummer("");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetGsmNummer_MetLetters_ThrowsInputMismatchException() {
        activiteit.setGsmnummer("aaaaa12345");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetGsmNummer_EnkelLetters_ThrowsInputMismmatchException() {
        activiteit.setGsmnummer("aaaaaaaaaa");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetGsmNummer_MetSymbolen_ThrowsInputMismatchException() {
        activiteit.setGsmnummer("@@@@@12345");
    }

    @Test(expected = InputMismatchException.class)
    public void activiteit_SetGsmNummer_EnkelSymbolen_ThrowsInputMismatchException() {
        activiteit.setGsmnummer("@@@@@@@@@@");
    }

    @Test
    public void activiteit_SetGsmNummer_Correct() {
        activiteit.setGsmnummer("0477441462");
        Assert.assertEquals("0477441462", activiteit.getGsmnummer());
    }

    @Test
    public void activiteit_SetGsmNummer_32_Correct() {
        activiteit.setGsmnummer("+32477441462");
        Assert.assertEquals("+32477441462", activiteit.getGsmnummer());
    }

    //Email locatie
    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetEmail_Null_ThrowsIllegalArgumentException() {
        activiteit.setEmail(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetEmail_Empty_ThrowsIllegalArgumentException() {
        activiteit.setEmail("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void activiteit_SetEmail_MetSpaties_ThrowsIllegalArgumentException() {
        activiteit.setEmail("tybo. vanderstraeten@student.hogent.be");
    }

    @Test
    public void activiteit_SetEmail_Correct1() {
        String email = "tybo.vanderstraeten@student.hogent.be";
        activiteit.setEmail(email);
        Assert.assertEquals(email, activiteit.getEmail());
    }

    @Test
    public void activiteit_SetEmail_Correct2() {
        String email = "jan@skynet.com";
        activiteit.setEmail(email);
        Assert.assertEquals(email, activiteit.getEmail());
    }

    @Test
    public void activiteit_SetEmail_Correct3() {
        String email = "testacc@hotmail.com";
        activiteit.setEmail(email);
        Assert.assertEquals(email, activiteit.getEmail());
    }
}
