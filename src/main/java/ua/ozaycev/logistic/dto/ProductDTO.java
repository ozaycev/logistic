package ua.ozaycev.logistic.dto;

/**
 * Created by Ozaycev on 20.06.2016.
 */
public class ProductDTO {

    private String name;

    public ProductDTO() {
    }

    public ProductDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
