package ch1.converter;

import ch1.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String,Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(){
        ingredientMap.put("TDH",new Ingredient("TDH","THIN DOUGH", Ingredient.Type.DOUGH));
        ingredientMap.put("TCDH",new Ingredient("TCDH","THICK DOUGH", Ingredient.Type.DOUGH));
        ingredientMap.put("CHN",new Ingredient("CHN","CHICKEN", Ingredient.Type.PROTEIN));
        ingredientMap.put("BF",new Ingredient("BF","BEAF", Ingredient.Type.PROTEIN));
        ingredientMap.put("PPN",new Ingredient("PPN","PEPPERONI", Ingredient.Type.PROTEIN));
        ingredientMap.put("TM",new Ingredient("TM","TOMATE", Ingredient.Type.VEGGIES));
        ingredientMap.put("PK",new Ingredient("PK","PICKLE", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHR",new Ingredient("CHR","CHEDER", Ingredient.Type.CHEESE));
        ingredientMap.put("GD",new Ingredient("GD","GOUDA", Ingredient.Type.CHEESE));
        ingredientMap.put("MZ",new Ingredient("MZ","MOZZARELLA", Ingredient.Type.CHEESE));
        ingredientMap.put("MO",new Ingredient("MO","MAYO", Ingredient.Type.SAUCE));
        ingredientMap.put("KTH",new Ingredient("KTH","KETCHUP", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id){
        return  ingredientMap.get(id);
    }

}
