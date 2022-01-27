package org.iesfm.tiendamongo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Item {
    private int idArticle;
    private String nameArticle;
    private int amount;

    @JsonCreator
    public Item(@JsonProperty("id_article") int idArticle,
                @JsonProperty("name_article")String nameArticle,
                @JsonProperty("amount")int amount) {
        this.idArticle = idArticle;
        this.nameArticle = nameArticle;
        this.amount = amount;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idArticle == item.idArticle && amount == item.amount && Objects.equals(nameArticle, item.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle, nameArticle, amount);
    }
}
