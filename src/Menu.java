import java.util.Arrays;

public class Menu {

    private int id;
    private String name;
    private double price;
    private String[] ingredients;

    public Menu(int id, String name, double price, String[] ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }

    public void addMenu(){

    }

    public void updateMenu(){

    }

    public void deleteMenu(){


    }
}
