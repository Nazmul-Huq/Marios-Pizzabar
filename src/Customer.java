import javax.swing.plaf.basic.BasicListUI;

public class Customer {

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

    public int getId() {

        for (int i = 0; i < Database.customerRecords.indexOf(i); i++) {



        }
        return id;

    }

    public void addNewCustomer(Customer newCustomer){

        Database.customerRecords.add(null);

    }

    public void updateCustomer(){

        for (int i = 0; i < Database.customerRecords.size(); i++) {
            System.out.println();
        }
    }

    public void deleteCustomer(Customer deleteCustomer){

        Database.customerRecords.remove(null);
    }


}
