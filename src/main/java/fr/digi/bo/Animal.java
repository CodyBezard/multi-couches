package fr.digi.bo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Column(name="BIRTH")
    private Date birth;
    @Column(name="COULEUR")
    private String couleur;
    @ManyToOne
    @JoinColumn(name="ID_PETSTORE")
    private PetStore petStore;

    /** Constructeur vide POJO */
    public Animal() {
    }


    public Animal(Date birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public Animal(Date birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    /**
     * Getter for birth
     * return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Setter for birth
     *
     * @param birth to set
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Getter for couleur
     * return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Setter for couleur
     *
     * @param couleur to set
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Getter for petStore
     * return petStore
     */
    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * Setter for petStore
     *
     * @param petStore to set
     */
    public void setPetStore(PetStore petStore) {
        if(this.petStore!= null){ //Est-ce que j'avais un petStore
            this.petStore.getAnimaux().remove(this); //Je demande à mon ancien petStore de me retirer de la liste des animaux
        }
        this.petStore = petStore; //Je change le petStore
        if(this.petStore !=null){ //Est-ce que mon petStore existe
            this.petStore.getAnimaux().add(this); // Je demande au petStore d'ajouter l'animal
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
