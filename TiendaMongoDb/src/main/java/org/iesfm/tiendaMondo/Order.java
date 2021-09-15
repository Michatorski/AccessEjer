package org.iesfm.tiendaMondo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection =  "orders")
public class Order {
    @Id
    private int orderId;
    private String clientNif;
    private double price;
    private Date date;
    private List<Item> items;

    @JsonCreator
    public Order(@JsonProperty("order_id") int orderId,
                 @JsonProperty("client_nif") String clientNif,
                 @JsonProperty("price") double price,
                 @JsonProperty("date") Date date,
                 @JsonProperty("items") List<Item> items) {
        this.orderId = orderId;
        this.clientNif = clientNif;
        this.price = price;
        this.date = date;
        this.items = items;
    }

//    public Item getItem(){
//        for ( Item item:
//              items) {
//            return item;
//        }
//    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientNif() {
        return clientNif;
    }

    public void setClientNif(String clientNif) {
        this.clientNif = clientNif;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Double.compare(order.price, price) == 0 && Objects.equals(clientNif, order.clientNif) && Objects.equals(date, order.date) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, clientNif, price, date, items);
    }
}
