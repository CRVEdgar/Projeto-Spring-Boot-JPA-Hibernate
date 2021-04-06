package com.example.projetospringboot.entities;

import com.example.projetospringboot.entities.pk.OrdemItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_order_item")
public class OrdemItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId //usado no caso de id composto
    private OrdemItemPK id;

    private Integer quantity;
    private Double price;

    public OrdemItem() {
    }

    public OrdemItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return id.equals(ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
