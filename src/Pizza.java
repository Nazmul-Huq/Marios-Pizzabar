import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    //Class written by Søs

    static Scanner scanner = new Scanner(System.in);

    private int pizzaId;
    private String pizzaName;
    private int pizzaPrice;
    private String pizzaIngredient;

    public Pizza(int pizzaId, String pizzaName, int pizzaPrice, String pizzaIngredient) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaIngredient = pizzaIngredient;
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

    public int getPizzaId() {

        return this.pizzaId;
    }

    public String getPizzaName() {

        return this.pizzaName;
    }

    public double getPizzaPrice() {

        return this.pizzaPrice;
    }

    int pizzaIds = 0;
    String pizzaNames = "";
    String pizzaIngredients = "";
    int pizzaPrices = 0;


    public static void addNewPizza() {

        System.out.println("Please give your new pizza a number");
        int pizzaId = Integer.parseInt(scanner.nextLine());

        System.out.println("What's the name of the pizza?");
        String pizzaName = scanner.nextLine();

        System.out.println("What is the ingredients in " + pizzaName + " ?");
        String pizzaIngredient = scanner.nextLine();

        System.out.println("And what should the price be?");
        int pizzaPrice = Integer.parseInt(scanner.nextLine());

        System.out.println("Do you want to save " + pizzaName + " to the database of pizzas?");
        String savePizzaOrNot = scanner.nextLine();
        if (savePizzaOrNot.equals("yes")) {
            System.out.println("Your have now saved " + pizzaName + " to the database");
        } else {

        }

        Pizza newPizza = new Pizza(pizzaId, pizzaName, pizzaPrice, pizzaIngredient);
        Database.pizzaDetail.add(newPizza);

    }

    public static void deletePizza() {

        System.out.println("Which pizza would you like to delete from the menu cart?");
        int pizzaIdToDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Database.pizzaDetail.size(); i++) {
            Pizza newPizza = Database.pizzaDetail.get(i);
            int pizzaIds = newPizza.getPizzaId() + 1;
            if (pizzaIds == pizzaIdToDelete) {

                Database.pizzaDetail.remove(pizzaIdToDelete);

            }
            System.out.println("Pizza " + pizzaIdToDelete + " has now been delete from your database");
        }
    }
}

//Test pizza class
//Pizza margherita = new Pizza(1, "Margherita", 72, "Tomato, Cheese");
//Pizza hawaii = new Pizza(2,"Hawaii", 75, "Tomato, Cheese, Ham, Pineapple");
//Pizza pepperoni = new Pizza(3, "Pepperoni", 75, "Tomato, Cheese, Pepperoni");
//Pizza spicy = new Pizza(4,"Spicy", 78,"Tomato, Cheese, Beef, Jalapeño, Crushed Chilli");