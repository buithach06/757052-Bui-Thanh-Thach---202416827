package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
// import các lớp dữ liệu: DigitalVideoDisc, Store, vv.

public class AddDVDToStoreScreenController {
    
    // Khai báo fx:id cho các TextField
    @FXML private TextField txtTitle;
    @FXML private TextField txtCategory;
    @FXML private TextField txtCost;
    @FXML private TextField txtDirector;
    @FXML private TextField txtLength;

    // ... (Thêm trường Store nếu cần) ...

    @FXML
    private void addDVDButtonPressed(ActionEvent event) {
        String title = txtTitle.getText();
        String director = txtDirector.getText();
        
        try {
            float cost = Float.parseFloat(txtCost.getText());
            int length = Integer.parseInt(txtLength.getText()); // Chuyển đổi length sang int

            // 1. Tạo đối tượng DVD mới
            // DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, cost, director, length); 

            // 2. Thêm vào Store
            // store.addMedia(newDVD); 
            
            // 3. Hiển thị thông báo và dọn dẹp form
            // showAlert("Success", "DVD '" + title + "' added.");
            // clearFields();
            
        } catch (NumberFormatException e) {
            // showAlert("Input Error", "Cost and Length must be valid numbers.");
        }
    }
}
