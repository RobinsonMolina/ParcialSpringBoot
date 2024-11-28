package co.edu.uptc.entityes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    @JsonIgnore
    private Customer customer;

    public Sale() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

