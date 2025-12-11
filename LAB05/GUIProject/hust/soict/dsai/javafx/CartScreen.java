package hust.soict.dsai.javafx;

//Mã nguồn CartScreen theo Figure 38:
public class CartScreen extends JFrame {
 private Cart cart;

 public CartScreen(Cart cart) {
     super();
     this.cart = cart;

     JFXPanel jfxPanel = new JFXPanel();
     this.add(jfxPanel);

     this.setTitle("Cart");
     this.setVisible(true);

     Platform.runLater(new Runnable() {
         @Override
         public void run() {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart.fxml"));
                 // fxmlLoader.setController(new CartScreenController(cart)); 
                 Parent root = fxmlLoader.load();
                 
                 Scene scene = new Scene(root);
                 jfxPanel.setScene(scene);

             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     });
 }
 // ...
}