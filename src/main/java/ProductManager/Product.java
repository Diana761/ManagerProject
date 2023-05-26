package ProductManager;

public class Product {
    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    protected int id;
    protected String name;
    protected int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}
