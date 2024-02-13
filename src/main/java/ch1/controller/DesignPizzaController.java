package ch1.controller;


import ch1.model.Ingredient;
import ch1.model.Ingredient.Type;
import ch1.model.Pizza;
import ch1.model.PizzaOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("TDH","THIN DOUGH",Type.DOUGH),
                new Ingredient("TCDH","THICK DOUGH",Type.DOUGH),
                new Ingredient("CHN","CHICKEN",Type.PROTEIN),
                new Ingredient("BF","BEAF",Type.PROTEIN),
                new Ingredient("PPN","PEPPERONI",Type.PROTEIN),
                new Ingredient("TM","TOMATE",Type.VEGGIES),
                new Ingredient("PK","PICKLE",Type.VEGGIES),
                new Ingredient("CHR","CHEDER",Type.CHEESE),
                new Ingredient("GD","GOUDA",Type.CHEESE),
                new Ingredient("MZ","MOZZARELLA",Type.CHEESE),
                new Ingredient("MO","MAYO",Type.SAUCE),
                new Ingredient("KTH","KETCHUP",Type.SAUCE));

        Type[] types = Ingredient.Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }
    }

    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder order(){
        return  new PizzaOrder();
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza(){
        return  new Pizza();
    }

    @GetMapping
    public  String  showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid Pizza pizza, Errors errors, @ModelAttribute PizzaOrder pizzaOrder){
        if(errors.hasErrors()){
            return "design";
        }
        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);
        return "redirect:/orders/current";
    }
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients,Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
