import java.util.ArrayList;
import java.util.Scanner;

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

        Customer newCustomer = new Customer(customerId, customerName, customerAddress, customerPhoneNumber, customerEmail);
        Database.customerRecords.add(newCustomer);

        }



    public static void updateCustomerViaPhoneNumber(int phoneNumber){

        int customerToUpdateViaPhoneNumber = 0;
        for (int i = 0; i < Database.customerRecords.size(); i++) {
            Customer updateCustomer = Database.customerRecords.get(i);
            int findCustomersPhoneNumber = updateCustomer.getPhoneNumber();
            if (findCustomersPhoneNumber == phoneNumber){
                customerToUpdateViaPhoneNumber = updateCustomer.getId();
                System.out.println("Under construction");

            }
        }
    }

    public static void deleteCustomer(){

        System.out.println("Would you like to delete a customers infomation?");
        String deleteCustomerOrNot = scanner.nextLine();
        if(deleteCustomerOrNot.equals("yes")){
            System.out.println("Which customer would you like to delete, find the customer phone number");
            int customerPhoneNumber = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < Database.customerRecords.size(); i++) {
                Customer newCustomer = Database.customerRecords.get(i);
                int customerId = newCustomer.getPhoneNumber()+1;

                if (customerId == customerPhoneNumber){

                    Database.customerRecords.remove(customerPhoneNumber);
                }
                System.out.println(customerPhoneNumber + " has now been delete from your database");
            }

        }
    }
}
////Test Customer Class//
//        Customer søs = new Customer(1,"Søs Kjergaard","Sportsvej 60, Lejl. 233, Glostrup", 22443380,"slys87@gmail.com");
//        Customer kevin = new Customer(2,"Kevin Johansen","Guldbergsgade 23, København N", 23874590,"kevin.j@gmail.com");
//        Customer henrietta = new Customer(3,"Henrietta Olsen","Sølvergade 65, Valby", 80443322,"henriettaIsNice@gmail.com");
//        Customer mohammed = new Customer(4,"Mohammed Said","Jacobsvej 8, København S", 75449259,"Mo.verdensmester@gmail.com");
