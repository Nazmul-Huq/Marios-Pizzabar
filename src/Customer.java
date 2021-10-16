import java.util.ArrayList;
import java.util.Scanner;

//Class written by Søs
public class Customer {
    static Scanner scanner = new Scanner(System.in);

    private int id;
    private String name;
    private String address;
    private int phoneNumber;
    private String email;

    public Customer(int id, String name, String address, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {

        return this.id;
    }

    public String getName(){

        return this.name;
    }

    public String getAddress(){

        return this.address;
    }

    public int getPhoneNumber(){

        return this.phoneNumber;
    }

    public String getEmail(){

        return this.email;
    }

    int customerIds = 0;
    String customerNames = "";
    String customerAddresses = "";
    int customerPhoneNumbers = 0;
    String customerEmails = "";

    //Method to add a new customer via a scanner
    public static void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input a customer ID ");
        int customerId = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter your name ");
        String customerName = scanner.nextLine();

        System.out.println("now please enter your address, phone number and email-address ");
        String customerAddress = scanner.nextLine();
        int customerPhoneNumber = Integer.parseInt(scanner.nextLine());
        String customerEmail = scanner.nextLine();


        System.out.println("Is you details correct?");
        System.out.println("Name: " + customerName);
        System.out.println("Address: " + customerAddress);
        System.out.println("Phone number: " + customerPhoneNumber);
        System.out.println("Email: " + customerEmail);
        System.out.println("Please write 'yes' if your details i correct, or 'no' if your details is incorrect");
        String correctOrNot = scanner.nextLine();
        if (correctOrNot.equals("yes")){
            System.out.println("Your details have been saved!");
        } else {

        }

        //Storing a new customer in the Database class
        Customer newCustomer = new Customer(customerId, customerName, customerAddress, customerPhoneNumber, customerEmail);
        Database.customerRecords.add(newCustomer);

    }


    //Method to update a customer information (name, address, phone number, email)
    public static void updateCustomer(){

        System.out.println("Would you like to update a customer information? Please write 'yes'");
        String updateCustomerOrNot = scanner.nextLine();
        if (updateCustomerOrNot.equals("yes")){
            System.out.println("Which customer would you like to update information from?");
            int customerIds = Integer.parseInt(scanner.nextLine());

            //Finds the index number of the customer ID through a for loop
            for (int i = 0; i < Database.customerRecords.size(); i++) {
                Customer customerToUpdate = Database.customerRecords.get(i);
                int findCustomerId = customerToUpdate.getId();

                //Comparing the found customer ID with the requested customer ID
                if (findCustomerId == customerIds){

                    //Through the customer ID we can edit name, address, phone number or/and email
                    int findCustomerIndex = i;
                    String findCustomerName = customerToUpdate.getName();
                    String findCustomerAddress = customerToUpdate.getAddress();
                    int findCustomerPhoneNumber = customerToUpdate.getPhoneNumber();
                    String findCustomerEmail = customerToUpdate.getEmail();

                    System.out.println(customerToUpdate.getId());
                    System.out.println(customerToUpdate.getName());
                    System.out.println(customerToUpdate.getAddress());
                    System.out.println(customerToUpdate.getPhoneNumber());
                    System.out.println(customerToUpdate.getEmail());

                    System.out.println("What information would you like to change?");
                    System.out.println(" 1. Name \n 2. Address \n 3. Phone number \n 4. Email");
                    int thingsToChange = Integer.parseInt(scanner.nextLine());
                    if(thingsToChange == 1){
                        System.out.println("What would you like to change the name to?");
                        findCustomerName = scanner.nextLine();
                    } else if(thingsToChange == 2){
                        System.out.println("What would you like to change the address to?");
                        findCustomerAddress = scanner.nextLine();
                    } else if(thingsToChange == 3){
                        System.out.println("What would you like to change the phone number to?");
                        findCustomerPhoneNumber = Integer.parseInt(scanner.nextLine());
                    } else if(thingsToChange == 4){
                        System.out.println("What would you like to change the email to?");
                        findCustomerEmail = scanner.nextLine();
                    }

                    Customer updatedCustomer = new Customer(findCustomerId, findCustomerName,findCustomerAddress,findCustomerPhoneNumber,findCustomerEmail);

                    //Storing updated information about the customer
                    Database.customerRecords.set(i, updatedCustomer);
                    System.out.println("The " + updatedCustomer + " has now been changed");
                }
            }
        }
    }

    //Method to delete a customer from the database through the phone number (GDPR)
    public static void deleteCustomer(){

        System.out.println("Would you like to delete a customers information? If yes, please write 'yes'");
        String deleteCustomerOrNot = scanner.nextLine();
        if(deleteCustomerOrNot.equals("yes")){
            System.out.println("Which customer would you like to delete, find the customer phone number");
            int customerPhoneNumber = Integer.parseInt(scanner.nextLine());

            //Finding phone number through for loop
            for (int i = 0; i < Database.customerRecords.size(); i++) {
                Customer newCustomer = Database.customerRecords.get(i);
                int customerId = newCustomer.getPhoneNumber()+1;

                //Comparing phone number found through for loop to the requested phone number
                if (customerId == customerPhoneNumber){

                    //Storing in the database
                    Database.customerRecords.remove(customerPhoneNumber);
                }

            }
            System.out.println(customerPhoneNumber + " has now been delete from your database");
        }
    }
}
