/* 1. Soal Praktikum Java: Simple Café Ordering System
Latihan praktikum mandiri pemrograman Java berorientasi objek (OOP dasar) yang berfokus pada implementasi Class, Attribute, Method, Constructor, dan Static Keyword tanpa melibatkan konsep lanjutan seperti Inheritance, Encapsulation, maupun ArrayList.
1. Ketentuan Class Menu
Buat sebuah class bernama Menu dengan spesifikasi komponen sebagai berikut:
A. Attributes
Nama Attribute
Tipe Data
Deskripsi
 
name
String
Menyimpan nama item menu.
price
double / int
Menyimpan harga per porsi menu.
category
String
Kategori menu (contoh: Food, Beverage).
totalMenu
static int
Menghitung jumlah seluruh objek menu yang telah di-instansiasi.

B. Constructor
Menerima parameter: nama menu, harga, dan kategori.
Menginisialisasi attribute instan dengan nilai parameter terkait.
Setiap kali sebuah objek Menu baru dibuat, nilai variabel static totalMenu bertambah 1.
C. Methods
showMenu(): Menampilkan detail menu (Nama, Harga, dan Kategori).
discount(double percentage): Menghitung dan mengembalikan nilai harga setelah dipotong diskon sesuai persentase yang diberikan.
changePrice(double newPrice): Mengubah nilai harga menu (price) menjadi harga yang baru.
2. Program Utama (Main Class)
Di dalam method main, lakukan inisialisasi minimal 4 objek menu berikut:
Nama Menu
Harga Awal
Kategori
 
Espresso
Rp 20.000
Beverage
Croissant
Rp 25.000
Food
Matcha
Rp 22.000
Beverage
Sandwich
Rp 30.000
Food

Alur instruksi eksekusi yang wajib diimplementasikan:
Menampilkan seluruh daftar menu yang telah dibuat menggunakan method showMenu().
Menerapkan dan menampilkan perhitungan diskon 10% pada item Espresso.
Mengubah harga item Croissant menjadi Rp 28.000 menggunakan method changePrice().
Menampilkan kembali informasi terkini untuk Espresso dan Croissant.
Menampilkan jumlah total menu yang terdaftar dengan mengakses atribut static Menu.totalMenu.
3. Contoh Output yang Diharapkan
=== CAFE MENU ===

Name     : Espresso
Price    : Rp20000
Category : Beverage

Name     : Croissant
Price    : Rp25000
Category : Food

Name     : Matcha
Price    : Rp22000
Category : Beverage

Name     : Sandwich
Price    : Rp30000
Category : Food

=== AFTER UPDATE ===

Espresso
Original Price : Rp20000
Discount 10%   : Rp18000

Croissant
New Price : Rp28000

Total Menu : 4


4. Tantangan Bonus: Class Order
Bagi yang telah menyelesaikan tugas utama dengan cepat, tambahkan class kedua bernama Order:
Attributes: orderId (String/int), customerName (String), menu (objek Menu), quantity (int).
Constructor: Order(orderId, customerName, menu, quantity).
Methods:
calculateTotal(): Menghitung total biaya berdasarkan menu.price * quantity.
showOrder(): Menampilkan rincian pesanan (Nama Pelanggan, Menu yang dipesan, Jumlah, dan Total Bayar).
Skenario Pengujian: Buat pesanan dengan nama pelanggan Key, memesan menu Espresso sebanyak 2 porsi, lalu tampilkan total pembayarannya.

 */


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
        order1.showOrder();

    }
}


