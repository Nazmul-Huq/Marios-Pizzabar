import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    Scanner scanner = new Scanner(System.in);

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

    public void addNewCustomer(Customer newCustomer) {

        ArrayList<Integer> customerIds = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<String> customerAddresses = new ArrayList<>();
        ArrayList<Integer> customerPhoneNumbers = new ArrayList<>();
        ArrayList<String> customerEmails = new ArrayList<>();

        while (true) {
            System.out.println("Please enter your name ");
            String customerName = scanner.nextLine();
            customerNames.add(customerName);

            System.out.println("now please enter your address, phone number and email-address ");
            String customerAddress = scanner.nextLine();
            customerAddresses.add(customerAddress);
            int customerPhoneNumber = scanner.nextInt();
            customerPhoneNumbers.add(customerPhoneNumber);
            String customerEmail = scanner.nextLine();
            customerEmails.add(customerEmail);

            System.out.println("Is you details correct?");
            System.out.println("Name: " + customerName);
            System.out.println("Address: " + customerAddress);
            System.out.println("Phone number: " + customerPhoneNumber);
            System.out.println("Email: " + customerEmail);
            System.out.println();
            break;
        }

    }

    public static void updateCustomerViaPhoneNumber(int phoneNumber){

        int customerToUpdateViaPhoneNumber = 0;
        for (int i = 0; i < Database.customerRecords.size(); i++) {
            Customer updateCustomer = Database.customerRecords.get(i);
            int findCustomersPhoneNumber = updateCustomer.getPhoneNumber();
            if (findCustomersPhoneNumber == phoneNumber){
                customerToUpdateViaPhoneNumber = updateCustomer.getId();

            }
        }
    }

    public void deleteCustomer(Customer deleteCustomer){

        int customerToDelete = 0;
        for (int i = 0; i < Database.customerRecords.size(); i++) {
            Customer findCustomerToRemove = Database.customerRecords.remove(i);

        }
    }
}
////Test Customer Class//
//        Customer peter = new Customer(1,"Peter","København", 22443380,"petermail");
//        Customer kevin = new Customer(2,"kevin","København", 22334480,"kevinmail");
//        Customer henrietta = new Customer(3,"Henrietta","København", 80443322,"henriettarmail");
//        Customer paula = new Customer(4,"Paula","København", 80334422,"paulamail");
//
//        //Test Pizza class//
//        Pizza pizza1 = new Pizza(1, "Hawaii",56, "cheese, tomatosause, ham, pineapple");
//        Pizza pizza2 = new Pizza(2, "Serano", 61,"chesse, tomatosauce, real ham");
//
//         pizza2.printPizzaDetails();
//         pizza1.printPizzaDetails();