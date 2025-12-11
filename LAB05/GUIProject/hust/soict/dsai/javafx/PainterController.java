package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;
    
    @FXML
    private RadioButton eraserRadioButton;

    private Color currentColor = Color.BLACK; 
    private final Color CANVAS_COLOR = Color.WHITE; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        penRadioButton.setSelected(true);
        currentColor = Color.BLACK;

        penRadioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                currentColor = Color.BLACK;
            }
        });

        eraserRadioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                currentColor = CANVAS_COLOR; 
            }
        });
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {

        double radius = (eraserRadioButton.isSelected()) ? 8 : 2;
        
        Circle newCircle = new Circle(
            event.getX(), 
            event.getY(), 
            radius,        
            currentColor 
        );
        drawingAreaPane.getChildren().add(newCircle);
    }

  
    @FXML
    void clearButtonPressed(ActionEvent event) {

        drawingAreaPane.getChildren().clear();
    }
}