package ch1.controller;


import ch1.model.Ingredient;
import ch1.model.Ingredient.Type;
import ch1.model.Pizza;
import ch1.model.PizzaOrder;
import ch1.repository.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    private  final IngredientRepository ingredientRepository;

    @Autowired
    public  DesignPizzaController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
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
        return "redirect:/orders/current";
    }
    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients,Type type){
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }
}
