
package org.example.printfour;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.printfour.entities.User;
import org.example.printfour.service.UserService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class HelloController {
    private UserService userService;

    public HelloController() {
    }

    private double x = 0;
    private double y = 0;


    @FXML
    private Button closeBtn;

    @FXML
    private TextField emailFld;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private PasswordField passwordFld;

    @FXML
    void close() {
        System.exit(0);
    }

    @FXML
    public void signIn() throws IOException {
        String email = emailFld.getText();
        String password = passwordFld.getText();
        User user = userService.signIn(email, password);
        if (user != null) {
            loginBtn.getScene().getWindow().hide();
            //LINK YOUR DASHBOARD
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminPage.fxml")));

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Email or password invalid!");
        alert.showAndWait();
    }


}
