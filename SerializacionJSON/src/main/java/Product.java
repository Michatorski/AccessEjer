import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

public class Product {

    private int productId;
    private double price;
    private String name;
    @JsonProperty("class")
    private String [] gameGenre;

    public  Product(){

    }

    public Product(int productId, double price, String name, String[] gameGenre) {
        this.productId = productId;
        this.price = price;
        this.name = name;
        this.gameGenre = gameGenre;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String[] gameGenre) {
        this.gameGenre = gameGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Arrays.equals(gameGenre, product.gameGenre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productId, price, name);
        result = 31 * result + Arrays.hashCode(gameGenre);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", gameGenre=" + Arrays.toString(gameGenre) +
                '}';
    }
}
