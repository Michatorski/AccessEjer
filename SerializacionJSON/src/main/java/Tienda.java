import java.util.List;
import java.util.Objects;

public class Tienda {
    private String name;
    private List<Product> catalog;
    private List<Order> orders;


    public Tienda(){

    }

    public Tienda(String name, List<Product> catalog, List<Order> orders) {
        this.name = name;
        this.catalog = catalog;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Product> catalog) {
        this.catalog = catalog;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return Objects.equals(name, tienda.name) &&
                Objects.equals(catalog, tienda.catalog) &&
                Objects.equals(orders, tienda.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catalog, orders);
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "name='" + name + '\'' +
                ", catalog=" + catalog +
                ", orders=" + orders +
                '}';
    }
}
