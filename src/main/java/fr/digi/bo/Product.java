package fr.digi.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Column(name="CODE")
    private String code;
    @Column(name="LABEL")
    private String label;
    @Column(name="TYPE")
    @Enumerated(EnumType.STRING)
    private ProdType type;
    @Column(name="PRICE")
    private double price;
    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Set<PetStore> petStores;

    {
        petStores=new HashSet<PetStore>();
    }

    public Product() {
    }

    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Product(String code, String label, ProdType type, double price, Set<PetStore> petStores) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }

    /**
     * Getter for code
     * return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for code
     *
     * @param code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for label
     * return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter for label
     *
     * @param label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter for type
     * return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter for type
     *
     * @param type to set
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter for price
     * return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     *
     * @param price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for petStores
     * return petStores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Setter for petStores
     *
     * @param petStores to set
     */
    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", petStores=").append(petStores);
        sb.append('}');
        return sb.toString();
    }
}
