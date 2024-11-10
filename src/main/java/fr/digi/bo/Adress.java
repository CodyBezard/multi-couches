package fr.digi.bo;

import jakarta.persistence.*;

@Entity
@Table(name="adresse")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Column(name="NUMBER")
    private String number;
    @Column(name="STREET")
    private String street;
    @Column(name="ZIPCODE")
    private String zipCode;
    @Column(name="CITY")
    private String city;

    public Adress() {
    }

    public Adress(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * Getter for number
     * return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter for number
     *
     * @param number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter for street
     * return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for street
     *
     * @param street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for zipCode
     * return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter for zipCode
     *
     * @param zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter for city
     * return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city
     *
     * @param city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Adress{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
