import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    Scanner scanner = new Scanner(System.in);

    private int pizzaId;
    private String pizzaName;
    private int pizzaPrice;
    private String pizzaIngredients;

    public Pizza(int pizzaId, String pizzaName, int pizzaPrice, String pizzaIngredients) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaIngredients = pizzaIngredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaId=" + pizzaId +
                ", pizzaName='" + pizzaName + '\'' +
                ", pizzaPrice=" + pizzaPrice +
                ", pizzaIngredients='" + pizzaIngredients + '\'' +
                '}';
    }

    public int getPizzaId(){

        return this.pizzaId;
    }

    public String getPizzaName(){

        return this.pizzaName;
    }

    public double getPizzaPrice(){

        return this.pizzaPrice;
    }


    public void addNewPizza(Pizza newPizza){

        ArrayList<Integer> pizzaIds = new ArrayList<>();
        ArrayList<String> pizzaNames = new ArrayList<>();
        ArrayList<String> pizzaIngredients = new ArrayList<>();
        ArrayList<Integer> pizzaPrices = new ArrayList<>();

        while (true){
            System.out.println("What's the name of the pizza?");
            String pizzaName = scanner.nextLine();
            pizzaNames.add(pizzaName);

            System.out.println("What is the ingredients in " + pizzaName + " ?");
            String pizzaIngredient = scanner.nextLine();
            pizzaIngredients.add(pizzaIngredient);

            System.out.println("And what should the price be?");
            int pizzaPrice = scanner.nextInt();
            pizzaPrices.add(pizzaPrice);


    }

    public void updatePizza(){

        int pizzaToUpdate = 0;
        for (int i = 0; i < Database.pizzaDetail.size(); i++) {

        }
    }

    public void deletePizza(){

    }

    public void printPizzaDetails(){

        System.out.println("Pizza id: " + this.pizzaId);
        System.out.println("Pizza name: " + this.pizzaName);
        System.out.println("Pizza price: " + this.pizzaPrice);
        System.out.println("Pizza ingredients: " + this.pizzaIngredients);
    }
}
//Menu menu = new Menu(1, "Hawaii",56.5, "cheese, tomatosause, ham, pineapple");
//         Menu menu1 = new Menu(2, "Serano", 61,"chesse, tomatosauce, real ham");
//
//         menu.addMenu(menu);
//         menu.addMenu(menu1);
//
//        System.out.println(Database.menuDetail);