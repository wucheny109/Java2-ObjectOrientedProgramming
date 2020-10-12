/**
 * CHENYU WU
 * 991566725
 * Final Project
 * April 5 2020
 */
package content;

/**
 *
 * @author j.kw
 */
public class Order {

    private String orderID;
    private String customerID;
    private String product;
    private String shippingMethod;

    public Order(String orderID) {
        this.orderID = orderID;
    }
    
    public String getOrderID() {
        return this.orderID;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public String getProduct() {
        return this.product;
    }

    public String getShippingMethod() {
        return this.shippingMethod;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Override
    public String toString() {
        return this.orderID + "," + this.customerID + "," + this.product + ","
                + this.shippingMethod;
    }

}
