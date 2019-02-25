package gui;

import domein.AdminController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HoofdMenu extends VBox {

    @FXML
    private Button btnOverzicht;
    @FXML
    private Button btnBeheerLeden;
    @FXML
    private Button btnBeheerActiviteiten;
    @FXML
    private Button btnInschrijvenActiviteit;
    @FXML
    private Button btnBeheerLesmateriaal;

    private BeginScherm parent;
    private OverzichtMenu overzichtMenu;
    private AdminController adminController;

    public HoofdMenu(BeginScherm parent, AdminController adminController) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HoofdMenu.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.parent = parent;
        this.adminController = adminController;
    }

    @FXML
    private void toonOverzichtMenu(ActionEvent event) {
        parent.getChildren().remove(this);
        overzichtMenu = new OverzichtMenu(this, adminController);
        parent.getChildren().add(overzichtMenu);
    }

    public BeginScherm getParentClass() {
        return parent;
    }

}