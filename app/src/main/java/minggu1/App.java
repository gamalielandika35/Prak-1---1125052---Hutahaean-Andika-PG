

package minggu1;

    class Menu {
    String name;
    double price;
    String category;
    static int totalMenu = 0;

    public Menu (String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
        totalMenu++;
    }

    void showMenu(){
        System.out.println("Name: " + name  + "\nPrice : Rp" + price + "\nCategory : " + category + "\n");
    }

    int discount(double percentages){
        double discountPrice = price * (percentages / 100);
        return (int)(price - discountPrice);
    }

    void changePrice(double newPrice){
        price = (int)newPrice;
    }

    class Order {
    String orderId;
    String customerName;
    Menu menu;
    int q;

    public Order( String orderId, String customerName, Menu menu, int q){
        this.orderId = orderId;
        this.customerName = customerName;
        this.menu = menu;
        this.q = q;
    }

    int calculatetotal(){
        return (int)(menu.price * q);
    }

    void showOrder (){
        System.out.println("Nama Pelanggan : " + customerName + "\nMenu yang dipesan : " + menu.name + "\nJumlah : " + q + "\nTotal Bayar : Rp " + calculatetotal());

    }
}
    public static void main(String[] args){
        Menu menu1 = new Menu("Espresso", 20000, "Beverage");
        Menu menu2 = new Menu("Croissant", 25000, "Food");
        Menu menu3 = new Menu("Matcha", 22000, "Beverage");
        Menu menu4 = new Menu("Sandwich", 30000, "Food");

        System.out.println("      Menu Cafe    \n");

        menu1.showMenu();
        menu2.showMenu();
        menu3.showMenu();
        menu4.showMenu();

        System.out.println("       Harga setelah udah update  \n");
        System.out.println("Nama : " + menu1.name + "\nharga awal  : Rp " + menu1.price + "\nharga setelah diskon : " + menu1.discount(10));
        System.out.println("\nNama : " + menu2.name  );
        menu2.changePrice(28000);
        System.out.println("Harga baru : " + menu2.price + "\n");

        System.out.println("Total Menu : " + Menu.totalMenu + "\n");

        Menu.Order order1 = menu1.new Order("001", "Key", menu1, 2);
        Menu.Order order2 = menu1.new Order("002", "Key", menu2, 1);
        order1.showOrder();
        System.out.println();
        order2.showOrder();
    }
}


