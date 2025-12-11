package hust.soict.dsai.javafx;

public class AddBookToStoreScreenController {
    
    // Khai báo fx:id cho các TextField (Phải khớp với FXML)
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtCategory;
    @FXML
    private TextField txtCost;
    @FXML
    private void addBookButtonPressed(ActionEvent event) {
        // Lấy dữ liệu từ các TextField
        String title = txtBookTitle.getText();
        float cost = Float.parseFloat(txtBookCost.getText());
    }
}

