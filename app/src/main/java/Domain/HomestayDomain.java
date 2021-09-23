package Domain;

import java.io.Serializable;

public class HomestayDomain implements Serializable {
    private String name;
    private String img;
    private String description;
    private Double price;
    private int NumberInSlide;

    public  HomestayDomain(){

    }

    public HomestayDomain(String name, String img, String description, Double price, int numberInSlide) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        NumberInSlide = numberInSlide;
    }

    public HomestayDomain(String name, String img, String description, Double price) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumberInSlide() {
        return NumberInSlide;
    }

    public void setNumberInSlide(int numberInSlide) {
        NumberInSlide = numberInSlide;
    }
}
