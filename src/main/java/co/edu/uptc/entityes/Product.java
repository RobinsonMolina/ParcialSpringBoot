package co.edu.uptc.entityes;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private short stock;
    @Column(nullable = false)
    private LocalDate dueDate;
    @Column(nullable = false)
    private float price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Sale> sale;



    public Product (){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
