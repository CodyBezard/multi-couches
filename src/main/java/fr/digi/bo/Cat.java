package fr.digi.bo;

import java.util.Date;

public class Cat extends Animal{
    private String chipid;

    public Cat(Date birth, String couleur, String chipid) {
        super(birth, couleur);
        this.chipid = chipid;
    }

    public Cat(Date birth, String couleur, PetStore petStore, String chipid) {
        super(birth, couleur, petStore);
        this.chipid = chipid;
    }

    /**
     * Getter for chipid
     * return chipid
     */
    public String getChipid() {
        return chipid;
    }

    /**
     * Setter for chipid
     *
     * @param chipid to set
     */
    public void setChipid(String chipid) {
        this.chipid = chipid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cat{");
        sb.append("chipid='").append(chipid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
