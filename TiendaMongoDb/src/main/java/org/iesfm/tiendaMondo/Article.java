package org.iesfm.tiendaMondo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "articles")
public class Article {
    @Id
    private int id;
    private String nombre;
    private double price;
    private List<String> tags;

    @JsonCreator
    public Article(@JsonProperty() int id,
                   @JsonProperty()String nombre,
                   @JsonProperty()double price,
                   @JsonProperty()List<String> tags) {
        this.id = id;
        this.nombre = nombre;
        this.price = price;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && Double.compare(article.price, price) == 0 && Objects.equals(nombre, article.nombre) && Objects.equals(tags, article.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, price, tags);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", price=" + price +
                ", tags=" + tags +
                '}';
    }
}
