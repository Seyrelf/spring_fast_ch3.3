package ch1.model;

import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private String name;
    private  Type type;

    public enum Type{
        DOUGH,PROTEIN,VEGGIES,CHEESE,SAUCE
    }

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public  Ingredient(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
