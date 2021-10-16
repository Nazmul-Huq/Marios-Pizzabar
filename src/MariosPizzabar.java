import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.Scanner;

public class MariosPizzabar {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //written by Nazmul: will add some order to start with, so that we can operate different functions
        // deletion of this bloc  and corresponding method's information will not affect the program
        addSomeOrder();

        //written by Søs: will add 4 pizza to start with, so that we can operate different functions
        // deletion of this bloc will not affect the program
        Pizza margherita = new Pizza(1, "Margherita", 72, "Tomato, Cheese");
        Database.pizzaDetail.add(margherita);
        Pizza hawaii = new Pizza(2,"Hawaii", 75, "Tomato, Cheese, Ham, Pineapple");
        Database.pizzaDetail.add(hawaii);
        Pizza pepperoni = new Pizza(3, "Pepperoni", 75, "Tomato, Cheese, Pepperoni");
        Database.pizzaDetail.add(pepperoni);
        Pizza spicy = new Pizza(4,"Spicy", 78,"Tomato, Cheese, Beef, Jalapeño, Crushed Chilli");
        Database.pizzaDetail.add(spicy);


        //written by Søs: will add 4 customer to start with, so that we can operate different functions
        // deletion of this bloc will not affect the program
        Customer søs = new Customer(1,"Søs Kjergaard","Sportsvej 60, Lejl. 233, Glostrup", 22443380,"slys87@gmail.com");
        Database.customerRecords.add(søs);
        Customer kevin = new Customer(2,"Kevin Johansen","Guldbergsgade 23, København N", 23874590,"kevin.j@gmail.com");
        Database.customerRecords.add(kevin);
        Customer henrietta = new Customer(3,"Henrietta Olsen","Sølvergade 65, Valby", 80443322,"henriettaIsNice@gmail.com");
        Database.customerRecords.add(henrietta);
        Customer mohammed = new Customer(4,"Mohammed Said","Jacobsvej 8, København S", 75449259,"Mo.verdensmester@gmail.com");
        Database.customerRecords.add(mohammed);


        // Code written by Victor starts here//
        System.out.println("Welcome to Mario's Pizzabar. To order, please press the number of the pizza you want (you can order a maximum of 5 pizzas).");


        while (true)
        {
            System.out.println("1. Press 1 to add an order" + '\n' + "2. Press 2 to delete an order" + '\n' + "3. Press 3 to update an order" + '\n' + "4. Press 4 to make a new list" +
                    '\n' + "5. Press 5 to add a customer" + '\n' + "6. Press 6 to update a customer" + '\n' + "7. Press 7 to to delete a customer" +
                    '\n' + "8. Press 8 to add a new pizza" + '\n' + "9. Press 9 to update a pizza" + '\n' + "10. Press 10 to delete a pizza" + '\n' + "11. Press 11 to show statistics");

            int chooseBehaviour = Integer.parseInt(scanner.nextLine());

            switch (chooseBehaviour)
            {
                case 1:
                    // Create new order and add order to database
                    createAndAddNewOrder();
                    break;

                case 2:
                    // find and delete the order from marios list. Print updated list for Mario
                    deleteOrder();
                    break;

                case 3:
                    // update an existing order. Note that this function is still under construction
                    System.out.println("Sorry! this function is under construction");
                    break;

                case 4:
                    // Print the order list for Mario shorted by delivery date
                    printOrderListForMario();
                    break;

                case 5:
                    // add a new customer
                    Customer.addNewCustomer();
                    break;

                case 6:
                    // update an existing Customer
                    Customer.updateCustomer();
                    break;

                case 7:
                    // delete and existing Customer
                    Customer.deleteCustomer();
                    break;

                case 8:
                    // add New pizza in the pizza database
                    Pizza.addNewPizza();
                    break;

                case 9:
                    // update an existing pizza
                    System.out.println("Sorry! this is under construciton");
                    break;

                case 10:
                    // delete an existing pizza from pizza database
                    Pizza.deletePizza();
                    break;

                case 11:
                    // show different statistics
                    Statistics.mostSellingPizza();
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

        // Victor's code ends here ^ //
    }


    /*
     * written by Nazmul
     * method to delete an order from marios order list
     */
    public static void deleteOrder(){
        System.out.println("Please enter order id to delete");
        int orderIdToDelete = Integer.parseInt(scanner.nextLine());
        int indexOfGivenOrderId = getIndexFromOrderId(orderIdToDelete); // fist get the index where given order id is located/stored in "orderRecord"
        Database.orderRecord.remove(indexOfGivenOrderId);
        printOrderListForMario(); // we print the updated list for mario after deletion

    }

    /*
     * written by Namul
     * get the index number of given order id
     */
    public static int getIndexFromOrderId(int orderId){
        int indexOfGivenOrderId = -1;
        for (int i = 0; i < Database.orderRecord.size() ; i++) {
            Order individualOrder = Database.orderRecord.get(i);
            int orderIdOfIndividualOrder = individualOrder.getId(); // get the id of individual order
            if (orderIdOfIndividualOrder == orderId) { // if match with given order, so we delete that order
                indexOfGivenOrderId = i;
                break;
            }

        }
        return indexOfGivenOrderId;
    }

    /*
     * written by Nazmul
     * method to create a new order and add it to both permanentOrderRecord and orderRecord
     */
    public static void createAndAddNewOrder(){
        int id = getNewOrderId(); // generate an order id automatically
        ArrayList<Integer> pizzaIds = new ArrayList<>(); // start array list for pizza ids
        ArrayList<String> pizzaNames = new ArrayList<>(); // start array list for pizza names
        ArrayList<Double> pizzaPrices = new ArrayList<>(); // start array list for pizza prices
        double finalPrice = 0; // sum of all pizza price
        // start while loop to get input during order of 1 or 2 or 3 or more pizzas
        while (true){
            System.out.println("Please enter Pizza id to add in the order");
            int pizzaId = Integer.parseInt(scanner.nextLine());
            pizzaIds.add(pizzaId); // add given id to the pizzaIds array list
            String pizzaName = getPizzaName(pizzaId); // check and get pizza name from "pizzaDetail"
            pizzaNames.add(pizzaName); // add pizza name to pizzaNames array list
            double pizzaPrice = getPizzaPrice(pizzaId); // check and get pizza price from "pizzaDetail"
            pizzaPrices.add(pizzaPrice); // add pizza price to pizzaPrice array list
            finalPrice = finalPrice + pizzaPrice; // add pizza price to final price
            System.out.println("Enter 'c' to add more pizza, or 'q' to finish adding pizza");
            String continueOrQuit = scanner.nextLine();
            if (continueOrQuit.equals("q")) {
                break;
            }
        }

        Date orderDate = new Date(); // order date is always todays date
        LocalTime deliveryTime = getDeliveryTime(); // ask and get the delivery time

        int customerId = getCustomerId(); // get customer id
        if (customerId == 0) { // customer could not be found in the database
            System.out.println("Customer do not exist. Please create a new customer");
            // ask to make new customer

            //Method called from the Customer class written by Søs
            Customer.addNewCustomer();
        }

        // Finally make the new order and add to the database
        Order newOrder = new Order(id, customerId, pizzaIds,   pizzaNames, pizzaPrices, orderDate, finalPrice, deliveryTime);
        newOrder.addOrder(newOrder);
        System.out.println("Following order has been added successfully");
        System.out.println(newOrder);
        System.out.println("Order list for mario is been updated as follows");
        printOrderListForMario();
    }


    /*
     * written by Nazmul
     * get the delivery time, if user like to pick now then set the current date and time as delivery time
     * may be this can be done in an easy way but i can't find it
     */
    public static LocalTime getDeliveryTime(){
        LocalTime deliveryTime = LocalTime.now(); // get the current local time
        System.out.println("Do you like to pick now or later. Enter 'n' for now, 'l' for later");
        String deliveryNowOrLater = (scanner.nextLine()).toLowerCase(Locale.ROOT);
        // if 'n' is entered then we do not change deliveryTime is same as current local time and we do nothing
        // if 'l' is entered then ask for time and set deliveryTime to given time
        if (deliveryNowOrLater.equals("l")) { // means delivery not now
            System.out.println("when do you like to pick?");
            System.out.println("Please Enter only hour fx, 13 or 20 ");
            int  deliveryTimeHour = Integer.parseInt(scanner.nextLine());
            System.out.println("Please Enter minute fx, 40 or 55");
            int deliveryTimeMinute = Integer.parseInt(scanner.nextLine());
            deliveryTime = LocalTime.of(deliveryTimeHour, deliveryTimeMinute);
        }
        // make delivery time and return it
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
            int pizzaIdFromDatabase = individualPizza.getPizzaId();
            if (pizzaIdFromDatabase == pizzaId) {
                pizzaPrice = individualPizza.getPizzaPrice();
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
            int pizzaIdFromDatabase = individualPizza.getPizzaId();
            if (pizzaIdFromDatabase == pizzaId) {
                pizzaName = individualPizza.getPizzaName();
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
        DateTimeFormatter dateFormatForMario = DateTimeFormatter.ofPattern( "HH:mm"); // define time format for Mario
        ArrayList<Order> sortedOrderListForMario = getSortedOrderListForMario(); // get the sorted order list for Mario based on delivery time
        System.out.println("Order no \t Delivery Time \t Pizza no and Name");
        for (int i = 0; i < sortedOrderListForMario.size(); i++) {
            Order individualOrder = sortedOrderListForMario.get(i);
            System.out.print(individualOrder.getId()+ "\t\t\t\t");
            LocalTime deliveryTime = individualOrder.getDeliveryTime();
            System.out.print(deliveryTime.format(dateFormatForMario)+ "\t\t");
            ArrayList<Integer> pizzaNumber = individualOrder.getPizzaId();
            ArrayList<String> pizzaName = individualOrder.getPizzaName();
            for (int j = 0; j < pizzaNumber.size(); j++) {
                System.out.print(pizzaNumber.get(j) + " - ");
                System.out.print(pizzaName.get(j) + ", ");
            }
            System.out.println();
        }
    }

    /*
     * written by Nazmul
     * bubble sort is used to sort order list based on delivery time, which Mario (the owner) will use during pizza making
     */
    public static ArrayList<Order> getSortedOrderListForMario(){
        //ArrayList<Order> orderToSort = Database.orderRecord; // first a
        int i, j, k;
        Order tempOrder;
        boolean swapped;
        //int arraySize = orderToSort.size();

        for (i = 0; i < Database.orderRecord.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < Database.orderRecord.size() - i - 1; j++) {
                k = j + 1;
                LocalTime deliveryTimeAtIndexJ = Database.orderRecord.get(j).getDeliveryTime();
                LocalTime deliveryTimeAtIndexK = Database.orderRecord.get(k).getDeliveryTime();
                if ( deliveryTimeAtIndexJ.compareTo(deliveryTimeAtIndexK) == 1 ){
                    tempOrder = Database.orderRecord.get(j);
                    Database.orderRecord.set(j, Database.orderRecord.get(k));
                    Database.orderRecord.set(k, tempOrder);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        return Database.orderRecord;
    }


    /*
     * written by Nazmul
     * add some orders to start with, so that different other functions can be checked easily
     * deleting this block of code will not affect the program
     */
    public static void addSomeOrder(){
        // create and add an order manually
        ArrayList<Integer> pizzaIds1 = new ArrayList<>();
        pizzaIds1.add(1);
        pizzaIds1.add(2);

        ArrayList<Double> pizzaPrices1 = new ArrayList<>();
        pizzaPrices1.add(10.0);
        pizzaPrices1.add(20.0);

        double finalPrice1 = 50.0;

        ArrayList<String> pizzaNames1 = new ArrayList<>();
        pizzaNames1.add("pizza 1");
        pizzaNames1.add("pizza 2");

        Date orderDate1 = new Date();
        LocalTime deliverTime1 = LocalTime.of(11, 50);

        Order newOrder = new Order(1, 1, pizzaIds1,   pizzaNames1, pizzaPrices1, orderDate1, finalPrice1, deliverTime1);
        newOrder.addOrder(newOrder);

        // create and add an order manually
        ArrayList<Integer> pizzaIds2 = new ArrayList<>();
        pizzaIds2.add(1);
        pizzaIds2.add(2);

        ArrayList<String > pizzaNames2 = new ArrayList<>();
        pizzaNames2.add("pizza 3");
        pizzaNames2.add("pizza 4");

        ArrayList<Double> pizzaPrices2 = new ArrayList<>();
        pizzaPrices2.add(1.0);
        pizzaPrices2.add(2.0);

        double finalPrice2 = 40.0;

        Date orderDate2 = new Date();
        LocalTime deliverTime2 = LocalTime.now();

        Order newOrder2 = new Order(2, 2, pizzaIds2,   pizzaNames2, pizzaPrices2, orderDate2, finalPrice2, deliverTime2);
        newOrder2.addOrder(newOrder2);


        // create and add an order manually
        ArrayList<Integer> pizzaIds3 = new ArrayList<>();
        pizzaIds3.add(1);
        pizzaIds3.add(3);

        ArrayList<String> pizzaNames3 = new ArrayList<>();
        pizzaNames3.add("pizza 3");
        pizzaNames3.add("pizza 4");

        ArrayList<Double> pizzaPrices3 = new ArrayList<>();
        pizzaPrices3.add(1.0);
        pizzaPrices3.add(2.0);

        double finalPrice3 = 60.00;


        Date orderDate3 = new Date();
        LocalTime deliverTime3 = LocalTime.now();

        Order newOrder3 = new Order(3, 3, pizzaIds3,   pizzaNames3, pizzaPrices3, orderDate3, finalPrice3, deliverTime3);
        newOrder3.addOrder(newOrder3);


    }

}