package hust.soict.dsai.javafx;

// Import các lớp cần thiết (chỉnh sửa theo package thực tế của bạn)
// Giả định các lớp này nằm trong các package khác
import hust.soict.dsai.aims.cart.Cart; 
import hust.soict.dsai.aims.media.Media; 
import hust.soict.dsai.aims.media.Playable; 

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue; 
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

// Giữ lại implements Initializable để sử dụng initialize(URL, ResourceBundle) chuẩn
public class CartScreenController implements Initializable {
    
    // Khai báo GUI components (fx:id)
    @FXML
    private TableView<Media> tblMedia; 
    @FXML
    private TableColumn<Media, String> colMediaTitle; 
    @FXML
    private TableColumn<Media, String> colMediaCategory; 
    @FXML
    private TableColumn<Media, Float> colMediaCost; 

    // Các thành phần cho Lọc (Bước 10)
    @FXML
    private TextField filterTextField; 
    @FXML
    private RadioButton radioById; 
    @FXML
    private RadioButton radioByTitle; 
    
    // Các nút và Label (Bước 8 & 5.4)
    @FXML
    private Button btnRemove; 
    @FXML
    private Button btnPlay; 
    @FXML
    private Label totalCostLabel;

    private Cart cart;
    private FilteredList<Media> filteredList; // Danh sách có thể lọc được
    
    // Constructor (Cần được gọi trong CartScreen.java khi tải FXML)
    public CartScreenController(Cart cart) {
    	this.cart = cart;
    }
 
    // Constructor mặc định (cần thiết nếu sử dụng FXMLLoader mặc định)
    public CartScreenController() {}
    
    
    // Phương thức Initialize (Bước 7, 8, 10)
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (cart != null) {
            setupTableView();
            setupFiltering();
            setupButtonStateListener(); 
            updateTotalCost(); // Cập nhật tổng tiền ban đầu
        }
    }

    private void setupTableView() {
        // Thiết lập Cell Value Factory
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        
        // Sửa lỗi: Sử dụng ReadOnlyFloatWrapper cho cột Cost
        colMediaCost.setCellValueFactory(cellData -> 
            new ReadOnlyFloatWrapper(cellData.getValue().getCost()).asObject());

        // Thiết lập Filtering List (Bước 10)
        ObservableList<Media> itemsOrdered = this.cart.getItemsOrdered();
        filteredList = new FilteredList<>(itemsOrdered, p -> true); // Hiển thị tất cả ban đầu

        // Gắn danh sách đã lọc vào TableView
        SortedList<Media> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tblMedia.comparatorProperty());
        tblMedia.setItems(sortedList);
    }
    
    // Thiết lập Logic Lọc (Bước 10)
    private void setupFiltering() {
        // 1. Lắng nghe thay đổi của TextField (Từ khóa)
        filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
        
        // 2. Lắng nghe thay đổi của RadioButton (Chế độ lọc)
        ChangeListener<Boolean> radioChangeListener = (observable, oldValue, newValue) -> {
            // Khi chế độ lọc thay đổi, buộc TextField phải được đánh giá lại
            filterTextField.setText(filterTextField.getText()); 
        };
        // Kiểm tra null để tránh lỗi nếu chưa thiết lập FXML hoàn chỉnh
        if (radioByTitle != null) radioByTitle.selectedProperty().addListener(radioChangeListener);
        if (radioById != null) radioById.selectedProperty().addListener(radioChangeListener);
    }

    // Phương thức áp dụng bộ lọc (Bước 10)
    private void showFilteredMedia(String filter) {
        filteredList.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filter.toLowerCase();

            // Lọc theo Tiêu đề hoặc ID
            if (radioByTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            } 
            // Giả định nếu radioByTitle không được chọn, mặc định là ID
            else if (radioById.isSelected()) {
                // Cần có phương thức getId() trong class Media để lọc theo ID.
                // Tạm thời dùng Title nếu ID không khả dụng.
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }

    // Thiết lập Lắng nghe Trạng thái Nút (Bước 8)
    private void setupButtonStateListener() {
        // Ẩn các nút khi khởi tạo
        btnRemove.setVisible(false);
        btnPlay.setVisible(false);

        // Thêm ChangeListener vào thuộc tính mục được chọn
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                } else {
                    btnRemove.setVisible(false);
                    btnPlay.setVisible(false);
                }
            }
        });
    }
    
    // Cập nhật trạng thái hiển thị của các nút (Bước 8)
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true); // Remove luôn hiện khi có mục được chọn
        
        // Nút Play chỉ hiện nếu mục có thể phát (implement Playable)
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // Cập nhật tổng chi phí (Chưa triển khai chi tiết vì thiếu class Cart)
    private void updateTotalCost() {
        // float total = cart.getTotalCost(); 
        // totalCostLabel.setText(String.format("%.2f $", total));
    }

    
    // Phương thức Xóa mục (Bước 9)
    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem(); // Lấy mục đã chọn
        if (selectedMedia != null) {
             // Xóa mục khỏi đối tượng Cart
            cart.removeMedia(selectedMedia); 
            
            // Không cần gọi refresh vì ObservableList sẽ tự cập nhật hiển thị
            updateTotalCost();
        }
    }

    // Xử lý sự kiện khi nhấn nút "Place order"
    @FXML
    private void placeOrderButtonPressed(ActionEvent event) {
        // Logic đặt hàng sẽ ở đây
    }

    // Xử lý sự kiện khi nhấn nút "Play"
    @FXML
    private void playButtonPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null && selectedMedia instanceof Playable) {
            // ((Playable) selectedMedia).play(); // Gọi phương thức play()
            
            // Hiển thị thông báo đang phát...
        }
    }
}