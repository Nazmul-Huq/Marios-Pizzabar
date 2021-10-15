import java.util.ArrayList;

// This class is written by Victor
public class Statistics
{
    public static void mostSellingPizza()
    {
        int[] mostPizzaSales = new int[5];

        // Looping through the array list in the database to get the different orders
        for (int i = 0; i < Database.permanentOrderRecord.size(); i++)
        {
            // Making new order for every order from database
            Order mostSoldOrder = Database.permanentOrderRecord.get(i);

            // Making an array list for pizzaIDs and getting the values from each individual order
            ArrayList<Integer> pizzaIDs = mostSoldOrder.getPizzaId();

            // Looping through the pizzaID array list in the database
            for (int j = 0; j < pizzaIDs.size(); j++)
            {
                // Getting each individual pizzaIDs and update it in the pizzaSales int array
                int pizzaNumber = pizzaIDs.get(i);


                // Checking the amount of pizzas and update that element in the integer array
                switch (pizzaNumber)
                {
                    case 1:
                        mostPizzaSales[0]++;
                        break;

                    case 2:
                        mostPizzaSales[1]++;
                        break;

                    case 3:
                        mostPizzaSales[2]++;
                        break;

                    case 4:
                        mostPizzaSales[3]++;
                        break;

                    case 5:
                        mostPizzaSales[4]++;
                        break;
                }
            }

            // Looping through the pizzas and find the least selling pizza's number
            int mostSellingPizza = 0;
            for (int k = 0; k < mostPizzaSales.length; k++)
            {
                if (mostPizzaSales[i] > mostSellingPizza)
                {
                    mostSellingPizza = mostPizzaSales[i];
                }
            }

            // Looping through the pizzas and find least selling pizza's index
            for (int l = 0; l < mostPizzaSales.length; l++)
            {
                int pizzaSellingValueIndex = mostPizzaSales[i];

                if (pizzaSellingValueIndex == mostSellingPizza)
                {
                    pizzaSellingValueIndex = l;
                }

                switch (pizzaSellingValueIndex)
                {
                    case 1:
                        System.out.println("Least selling pizza is Margarita" + mostSellingPizza);
                        break;

                    case 2:
                        System.out.println("Least selling pizza is Hawaii" + mostSellingPizza);
                        break;

                    case 3:
                        System.out.println("Least selling pizza is Pepperoni" + mostSellingPizza);
                        break;

                    case 4:
                        System.out.println("Least selling pizza is Spicy Pizza" + mostSellingPizza);
                        break;

                    case 5:
                        System.out.println("Least selling pizza is Tuna Pizza" + mostSellingPizza);
                        break;
                }
            }
        }
    }


    public static void leastSellingPizza()
    {


        int[] leastPizzaSales = new int[5];

        // Looping through the array list in the database to get the different orders
        for (int p = 0; p < Database.permanentOrderRecord.size(); p++)
        {
            // Making new order for every order from database
            Order leastSoldOrder = Database.permanentOrderRecord.get(p);

            // Making an array list for pizzaIDs and getting the values from each individual order
            ArrayList<Integer> pizzaIDs = leastSoldOrder.getPizzaId();

            // Looping through the pizzaID array list in the database
            for (int j = 0; j < pizzaIDs.size(); j++)
            {
                // Getting each individual pizzaIDs and update it in the pizzaSales int array
                int pizzaNumber = pizzaIDs.get(j);


                // Checking the amount of pizzas and update that element in the integer array
                switch (pizzaNumber)
                {
                    case 1:
                        leastPizzaSales[0]++;
                        break;

                    case 2:
                        leastPizzaSales[1]++;
                        break;

                    case 3:
                        leastPizzaSales[2]++;
                        break;

                    case 4:
                        leastPizzaSales[3]++;
                        break;

                    case 5:
                        leastPizzaSales[4]++;
                        break;
                }
            }

            // Looping through the pizzas and find the least selling pizza's number
            int leastSellingPizza = 0;
            for (int k = 0; k < leastPizzaSales.length; k++)
            {
                if (leastPizzaSales[k] < leastSellingPizza)
                {
                    leastSellingPizza = leastPizzaSales[k];
                }
            }

            // Looping through the pizzas and find least selling pizza's index
            for (int l = 0; l < leastPizzaSales.length; l++)
            {
                int pizzaSellingValueIndex = leastPizzaSales[l];

                if (pizzaSellingValueIndex == leastSellingPizza)
                {
                    pizzaSellingValueIndex = l;
                }

                switch (pizzaSellingValueIndex)
                {
                    case 1:
                        System.out.println("Least selling pizza is Chicken Pizza" + leastSellingPizza);
                        break;

                    case 2:
                        System.out.println("Least selling pizza is Egg Pizza" + leastSellingPizza);
                        break;

                    case 3:
                        System.out.println("Least selling pizza is Ham Pizza" + leastSellingPizza);
                        break;

                    case 4:
                        System.out.println("Least selling pizza is Bacon Pizza" + leastSellingPizza);
                        break;

                    case 5:
                        System.out.println("Least selling pizza is Beef Pizza " + leastSellingPizza);
                        break;
                }
            }


            // Remember to make it break automatically, if 5 pizzas are selected
        }
    }
}