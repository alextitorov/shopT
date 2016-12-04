package model;

import dto.ProductDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Discount> discounts = new HashSet<Discount>();

    public Product(){
    }

    /*public Product(int id){
        this.id = id;
    }

    public Product(ProductDTO productDTO){
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
    }*/

    public void addProductDiscont(Discount discount){
        discount.setProduct(this);
        getDiscounts().add(discount);
    }

}
