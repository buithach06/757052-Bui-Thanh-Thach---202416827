package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
// import các lớp dữ liệu: CompactDisc, Store, vv.

public class AddCDToStoreScreenController {
    
    // Khai báo fx:id cho các TextField
    @FXML private TextField txtTitle;
    @FXML private TextField txtCategory;
    @FXML private TextField txtCost;
    @FXML private TextField txtArtist; // Thuộc tính đặc thù của CD

    // ... (Thêm trường Store nếu cần) ...

    @FXML
    private void addCDButtonPressed(ActionEvent event) {
        String title = txtTitle.getText();
        String artist = txtArtist.getText();
        
        try {
            float cost = Float.parseFloat(txtCost.getText());

            // 1. Tạo đối tượng CD mới
            // CompactDisc newCD = new CompactDisc(title, category, cost, artist); 

            // 2. Thêm vào Store
            // store.addMedia(newCD); 
            
            // 3. Hiển thị thông báo và dọn dẹp form
            // showAlert("Success", "CD '" + title + "' added.");
            
        } catch (NumberFormatException e) {
            // showAlert("Input Error", "Cost must be a valid number.");
        }
    }
}
