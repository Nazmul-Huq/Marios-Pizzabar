import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;



public class MariosPizzabar
{

    // Code written by Victor //
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to Mario's Pizzabar. To order, please press the number of the pizza you want (you can order a maximum of 5 pizzas).");


        while (true)
        {
            System.out.println("1. Press 1 to add an order" + '\n' + "2. Press 2 to delete an order" + '\n' + "3. Press 3 to update an order" + '\n' + "4. Press 4 to make a new list" +
                    '\n' + "5. Press 5 to add a customer" + '\n' + "6. Press 6 to update a customer" + '\n' + "7. Press 7 to to delete a customer" +
                    '\n' + "8. Press 8 to add a new menu" + '\n' + "9. Press 9 to update a menu" + '\n' + "10. Press 10 to delete a menu" + '\n' + "11. Press 11 to show statistics");

            int chooseBehaviour = Integer.parseInt(scanner.nextLine());

            switch (chooseBehaviour)
            {
                case 1:
                    // Create new order and add order to database
                    createAndAddNewOrder();
                    break;

                case 2:
                    // deleteOrder()
                    System.out.println("2");
                    break;

                case 3:
                    // updateOrder()
                    System.out.println("3");
                    break;

                case 4:
                    // Print the order list for Mario shorted by delivery date
                    printOrderListForMario();
                    break;

                case 5:
                    // addCustomer()
                    System.out.println("5");
                    break;

                case 6:
                    // updateCustomer()
                    System.out.println("6");
                    break;

                case 7:
                    // deleteCustomer()
                    System.out.println("7");
                    break;

                case 8:
                    // addNewMenu()
                    System.out.println("8");
                    break;

                case 9:
                    // updateMenu()
                    System.out.println("9");
                    break;

                case 10:
                    // deleteMenu()
                    System.out.println("10");
                    break;

                case 11:
                    Statistics.leastSellingPizza();

                    break;
            }

            System.out.println("Would like to continue or quit? Press 'C' to continue, or 'Q' to quit.");

            String continueOrQuit = scanner.nextLine();

            if(continueOrQuit == "Q")
                break;

            else if(continueOrQuit == "C")
                continue;
        }








    }
  // Victor's code ends here ^ //

        /*
     * written by Nazmul
     * get the delivery time, if user like to pick now then set the current date and time as delivery time
     * may be this can be done in an easy way but i can't find it
     */
    public static Date getDeliveryTime()
    {
        LocalDateTime now = LocalDateTime.now(); // get the current local date and time

        int deliveryYear = now.getYear(); // get year from current date and time
        int deliveryMonth = now.getMonthValue(); // get month from current date and time
        int deliveryDay = now.getDayOfMonth(); // get day from current date and time
        int deliveryTimeHour = now.getHour();// get hour from current date and time
        int deliveryTimeMinute = now.getMinute(); // get minute from current date and time

        System.out.println("Do you like to pick now or later. Enter 'n' for now, 'l' for later");

        String deliveryNowOrLater = scanner.nextLine().toLowerCase();

        // if 'n' is entered then we do not change deliveryTimeHour and deliveryTimeMinute
        // if 'l' is entered then ask for time and set deliveryTimeHour and deliveryTimeMinute to that time
        if (deliveryNowOrLater.equals("l"))
        {
            // means delivery not now
            System.out.println("when do you like to pick? Enter hour ");
            System.out.println("Please Enter hour ");
            deliveryTimeHour = Integer.parseInt(scanner.nextLine());
            System.out.println("Please Enter minute");
            deliveryTimeMinute = Integer.parseInt(scanner.nextLine());
        }

        // make delivery time and return it
        Date deliveryTime = new Date(deliveryYear, deliveryMonth, deliveryDay, deliveryTimeHour, deliveryTimeMinute);
        return deliveryTime;
    }

    /*
     * written by Nazmul
     * method will get a pizza id, will find that id record in database, get pizza price for that id, finally return it
     * for a detail explanation of how this method work see method "getCustomerIdFromDatabase"
     */
    public static double getPizzaPrice(int pizzaId){
        double pizzaPrice = 0.0;
        for (int i = 0; i < Database.pizzaDetail.size(); i++) {
            Pizza individualPizza = Database.pizzaDetail.get(i);
            int pizzaIdFromDatabase = individualPizza.getId();
            if (pizzaIdFromDatabase == pizzaId) {
                pizzaPrice = individualPizza.getPrice();
            }
        }
        return pizzaPrice;
    }

    /*
     * written by Nazmul
     * method will get a pizza id, will find that id record in database, get pizza name for that id, finally return it
     * for a detail explanation of how this method work see method "getCustomerIdFromDatabase"
     */
    public static String getPizzaName(int pizzaId){
        String pizzaName = "";
        for (int i = 0; i < Database.pizzaDetail.size(); i++) {
            Pizza individualPizza = Database.pizzaDetail.get(i);
            int pizzaIdFromDatabase = individualPizza.getId();
            if (pizzaIdFromDatabase == pizzaId) {
                pizzaName = individualPizza.getName();
            }
        }
        return pizzaName;
    }

    /*
     * written by Nazmul
     * method will ask to provide customer id or phone number
     * if customer id provided  it will check if customer id exist or not in "customerRecords. If not will return 0
     * if phone number is provided then will check and get the id number from "customerRecords". If can not found then will return 0
     */
    public static int getCustomerId(){
        int customerId = 0; // first set customer id to 0
        System.out.println("What is customer id? type exit if you do not know");
        String customerIdOrExit = scanner.nextLine(); // get the input from user
        if (customerIdOrExit.equals("exit")) { // if exit is typed then ask for phone number
            System.out.println("Enter phone number to find the customer id");
            int customersPhone = Integer.parseInt(scanner.nextLine()); // get the phone number
            customerId = getCustomerIdFromDatabase(customersPhone); // check and get customer id using phone number
        } else { // if customer id is given
            customerId = Integer.parseInt(customerIdOrExit); // we set given customer id to our "customerId" variable
        }
        return customerId;
    }

    /*
     * written by Nazmul
     * method to create a new order and add it to both permanentOrderRecord and orderRecord
     */
    public static void createAndAddNewOrder()
    {
        int id = getNewOrderId(); // generate an order id automatically

        ArrayList<Integer> pizzaIds = new ArrayList<>(); // start array list for pizza ids
        ArrayList<String> pizzaNames = new ArrayList<>(); // start array list for pizza names
        ArrayList<Double> pizzaPrices = new ArrayList<>(); // start array list for pizza prices
        double finalPrice = 0; // sum of all pizza price
        // start while loop to get input during order of 1 or 2 or 3 or more pizza
        while (true){
            System.out.println("Please enter Pizza id");
            int pizzaId = Integer.parseInt(scanner.nextLine());
            pizzaIds.add(pizzaId); // add given id to the pizzaIds array list
            String pizzaName = getPizzaName(pizzaId); // check and get pizza name from "pizzaDetail"
            pizzaNames.add(pizzaName); // add pizza name to pizzaNames array list
            double pizzaPrice = getPizzaPrice(pizzaId); // check and get pizza price from "pizzaDetail"
            pizzaPrices.add(pizzaPrice); // add pizza price to pizzaPrice array list
            finalPrice += pizzaPrice; // add pizza price to final price
            System.out.println("Enter 'c' to add more pizza, or 'q' to finish adding pizza");
            String continueOrQuit = scanner.nextLine();
            if (continueOrQuit.equals("q")) {
                break;
            }
        }

        Date deliveryTime = getDeliveryTime(); // get the delivery time
        int customerId = getCustomerId(); // get customer id
        if (customerId == 0) { // customer could not be found in the database
            System.out.println("Customer do not exist. Please create a new customer");
            // ask to make new customer
            // ************* call the method given by Søs to create a new customer
        }

        // finally make the new order and add to the database
        Order newOrder = new Order(id, customerId, pizzaIds,   pizzaNames, pizzaPrices, deliveryTime, finalPrice);
        newOrder.addOrder(newOrder);
    }

    /*
     * written by Nazmul
     * method will get customers phone number as parameter and check in database if phone no exist or not
     * if found will return the customer's id number, if not will return 0
     */
    public static int getCustomerIdFromDatabase(int customersPhone){
        int customerId = 0; // first set customer id to 0
        for (int i = 0; i < Database.customerRecords.size(); i++) {
            Customer individualCustomer = Database.customerRecords.get(i); // make a Customer for each record
            int customerPhoneInCustomerRecord = individualCustomer.getPhoneNumber(); // get the phone number from individual record
            if (customerPhoneInCustomerRecord == customersPhone) { // compare with given number and if true set get customer's id and set it, break the loop
                customerId = individualCustomer.getId();
                break;
            }
        }
        return customerId;
    }



    /*
     * written by Nazmul
     * method will check and get total number of records currently exists at "permanentOrderRecord"
     * then add 1 with total number of records to make a unique order id, and is Incrementing all time (1, 2, 3.....)
     */
    public static int getNewOrderId(){
        int newOrderId=1;
        int numberOfOrderRecordsInDatabase = Database.permanentOrderRecord.size();
        newOrderId = numberOfOrderRecordsInDatabase + 1;
        return newOrderId;
    }


    /*
     * written by Nazmul
     */
    public static void printOrderListForMario(){
        SimpleDateFormat dateFormatForMario = new SimpleDateFormat("HH:mm"); // define time format for Mario
        ArrayList<Order> sortedOrderListForMario = getSortedOrderListForMario(); // get the sorted order list for Mario based on delivery time
        System.out.println("Order no \t Delivery Time \t Pizza no and Name");
        for (int i = 0; i < sortedOrderListForMario.size(); i++) {
            Order individualOrder = sortedOrderListForMario.get(i);
            System.out.print(individualOrder.getId()+ "\t\t\t\t");
            Date deliveryTime = individualOrder.getDeliveryTime();
            String deliveryTimeAfterFormat = dateFormatForMario.format(deliveryTime); // format the delivery time to only hour and minute
            System.out.print(deliveryTimeAfterFormat + "\t\t");
            ArrayList<Integer> pizzaNumber = individualOrder.getPizzaId();
            ArrayList<String> pizzaName = individualOrder.getPizzaName();
            for (int j = 0; j < pizzaNumber.size(); j++) {
                System.out.print(pizzaNumber.get(j) + " - ");
                System.out.print(pizzaName.get(j) + ", ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /*
     * written by Nazmul
     * bubble sort is used to sort order list based on delivery time, which Mario (the owner) will use during pizza making
     */
    public static ArrayList<Order> getSortedOrderListForMario(){
        ArrayList<Order> orderToSort = Database.orderRecord;

        int i, j, k;
        Order tempOrder;
        boolean swapped;
        int arraySize = orderToSort.size();

        for (i = 0; i < arraySize - 1; i++) {
            swapped = false;
            for (j = 0; j < arraySize - i - 1; j++) {
                k = j + 1;
                Date deliveryTimeAtIndexJ = orderToSort.get(j).getDeliveryTime();
                Date deliveryTimeAtIndexK = orderToSort.get(k).getDeliveryTime();
                if ( deliveryTimeAtIndexJ.after(deliveryTimeAtIndexK) ){
                    tempOrder = orderToSort.get(j);
                    orderToSort.set(j, orderToSort.get(k));
                    orderToSort.set(k, tempOrder);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        return orderToSort;
    }

}

