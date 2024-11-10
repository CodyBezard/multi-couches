package fr.digi.bo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;


    public Fish(Date birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    public Fish(Date birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    /**
     * Getter for livingEnv
     * return livingEnv
     */
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Setter for livingEnv
     *
     * @param livingEnv to set
     */
    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
