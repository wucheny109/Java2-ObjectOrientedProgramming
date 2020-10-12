/**
 * CHENYU WU
 * 991566725
 * Assignment 2
 * Feb 25 2020
 */
package content;

public class Order {

    private String orderID = new String();
    private String firstName = new String();
    private String lastName = new String();
    private String city = new String();

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    private int orderA;
    private int orderB;
    private int orderC;
    private int orderD;

    public void setOrderA(int orderA) {
        this.orderA = orderA;
    }

    public int getOrderA() {
        return orderA;
    }

    public void setOrderB(int orderB) {
        this.orderB = orderB;
    }

    public int getOrderB() {
        return orderB;
    }

    public void setOrderC(int orderC) {
        this.orderC = orderC;
    }

    public int getOrderC() {
        return orderC;
    }

    public void setOrderD(int orderD) {
        this.orderD = orderD;
    }

    public int getOrderD() {
        return orderD;
    }
}
