public class StoreTest {

    public static void main(String[] args) {
        Store myStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);

        System.out.println("Sau khi them 3 DVD");
        myStore.printStore();

        System.out.println("Xoa 'Star Wars'");
        myStore.removeDVD(dvd2);
        myStore.printStore();

        System.out.println("Co gang xoa lai 'Star Wars'");
        myStore.removeDVD(dvd2);
        myStore.printStore();
    }
}