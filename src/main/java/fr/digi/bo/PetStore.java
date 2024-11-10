package fr.digi.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="petstore")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="MANAGER_NAME")
    private String managerName;
    @OneToMany (mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animaux;
    @OneToOne
    private Adress adress; //Reference vers une adresse
    @ManyToMany
    @JoinTable(name="PETSTORE_PRODUCT",
            joinColumns = @JoinColumn(name="ID_PETSTORE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ID_PRODUCT", referencedColumnName = "ID"))
    private Set<Product> products;


    {
        animaux=new HashSet<Animal>();
        products=new HashSet<Product>();
    }

    public PetStore() {
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public PetStore(String name, String managerName, Set<Animal> animaux) {
        this.name = name;
        this.managerName = managerName;
        this.animaux = animaux;
    }

    public void addAnimal (Animal animal){
        animal.setPetStore(this);
    }

    /**
     * Getter for name
     * return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for managerName
     * return managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter for managerName
     *
     * @param managerName to set
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter for animaux
     * return animaux
     */
    public Set<Animal> getAnimaux() {
        return animaux;
    }

    /**
     * Setter for animaux
     *
     * @param animaux to set
     */
    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }

    /**
     * Getter for adress
     * return adress
     */
    public Adress getAdress() {
        return adress;
    }

    /**
     * Setter for adress
     *
     * @param adress to set
     */
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", animaux=").append(animaux);
        sb.append('}');
        return sb.toString();
    }
}
