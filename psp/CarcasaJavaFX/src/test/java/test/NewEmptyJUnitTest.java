/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import fx.controllers.FXMLBorderPaneController;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author oscar
 */
@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    private static FXMLBorderPaneController rootController;
    private static BorderPane root;

    @Start
    private void start(Stage primaryStage) throws IOException {
        try {
            if (root == null) {
                FXMLLoader loaderMenu = new FXMLLoader(NewEmptyJUnitTest.class.getResource("/fxml/FXMLBorderPane.fxml"));
                root = loaderMenu.load();
                rootController = loaderMenu.getController();
                Scene scene = new Scene(root);

                primaryStage.setTitle("Carcasa FX");
                primaryStage.setScene(scene);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        primaryStage.show();
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    @Tag("prueba")
    @Order(1)
    public void jj(FxRobot robot) {
        robot.clickOn("#fxMenuP");
        robot.sleep(1000);
//        robot.clickOn("#fxMenu");
//        robot.sleep(1000);
//        assertEquals("test", rootController.probando);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Order(0)
    public void hello(FxRobot robot) {
        robot.clickOn("#fxMenuP");
        robot.clickOn("#fxMenu");

        ((TextField) robot.lookup("#fxTxtNombre").query()).setText("PROBNADO");

        robot.sleep(500);
        robot.clickOn("#fxBoton");
        robot.clickOn("#fxBoton");
        robot.sleep(500);
        //robot.closeCurrentWindow();
        robot.listTargetWindows().stream().forEach((arg0) -> {

        });
//		Button b = (Button)robot.lookup(".button").queryAll().stream().filter((t) -> {
//                    return ((Button)t).getText().equals("OK") 
//			    && ((Button)t).getId() == null ;
//                }).findFirst().get();
//                    
//                robot.clickOn(b);
        robot.clickOn("#hola");
        //System.out.println(((Label) robot.lookup("texto").query()).getText());
        rootController.setNombre("test");

    }

}
