/**
 * CHENYU WU
 * 991566725
 * Final Project
 * April 5 2020
 */
package content;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author j.kw
 */
public class OrderFile {

    public static ArrayList<Order> getData() throws IOException {
        ArrayList<Order> orderList = new ArrayList<>();

        FileReader fr = new FileReader("./src/content/Order.dat");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            Order one = new Order(st.nextToken());
            one.setCustomerID(st.nextToken());
            one.setProduct(st.nextToken());
            one.setShippingMethod(st.nextToken());
            orderList.add(one);
            line = br.readLine();
        }
        br.close();
        fr.close();
        return orderList;
    }

    public static void setData(ArrayList<Order> orderList) throws IOException {

        FileWriter fw = new FileWriter("./src/content/Order.dat");
        BufferedWriter bw = new BufferedWriter(fw);

        String sData = new String();
        for (Order sub : orderList) {
            sData = sub.getOrderID() + "," + sub.getCustomerID() + ","
                    + sub.getProduct() + "," + sub.getShippingMethod();
            bw.write(sData);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
