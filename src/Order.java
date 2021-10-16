import java.util.ArrayList;
import java.util.Date;

/*
 *this class written by Nazmul
 */
public class Order {

    private int id;
    private int customerId;
    private ArrayList<Integer> pizzaId = new ArrayList<>();
    private ArrayList<String> pizzaName= new ArrayList<>();
    private ArrayList<Double> pizzaPrice = new ArrayList<>();
    private Date deliveryTime;
    private double finalPrice;

    public Order(int id, int customerId, ArrayList<Integer> pizzaId, ArrayList<String> pizzaName, ArrayList<Double> pizzaPrice, Date deliveryTime, double finalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.deliveryTime = deliveryTime;
        this.finalPrice = finalPrice;
    }

    public int getId(){ return this.id; }
    public ArrayList<Integer> getPizzaId(){ return this.pizzaId; }
    public ArrayList<String > getPizzaName(){ return this.pizzaName; }
    public Date getDeliveryTime(){
        return this.deliveryTime;
    }

    // add a newly created order to both order record and permanent order record
    public void addOrder(Order newOrder){
        Database.orderRecord.add(newOrder);
        Database.permanentOrderRecord.add(newOrder);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", pizzaId=" + pizzaId +
                ", pizzaName=" + pizzaName +
                ", pizzaPrice=" + pizzaPrice +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
