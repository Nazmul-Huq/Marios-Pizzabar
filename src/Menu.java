import java.util.Arrays;

public class Menu {

    private int id;
    private String name;
    private double price;
    private String ingredients;

    public Menu(int id, String name, double price, String ingredients) {
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
                ", ingredients='" + ingredients + '\'' +
                '}';
    }

    public void addNewMenu(Menu newMenu){


        Database.menuDetail.add(newMenu);

    }

    public void updateMenu(){



    }

    public void deleteMenu(){

    }
}
//Menu menu = new Menu(1, "Hawaii",56.5, "cheese, tomatosause, ham, pineapple");
//         Menu menu1 = new Menu(2, "Serano", 61,"chesse, tomatosauce, real ham");
//
//         menu.addMenu(menu);
//         menu.addMenu(menu1);
//
//        System.out.println(Database.menuDetail);