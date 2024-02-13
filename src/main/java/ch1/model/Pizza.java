package ch1.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Pizza {


    @NotNull
    @Size(min=5,message = "Name must be at least 5 char long")
    private String name;

    @NotNull
    @Size(min=5,message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
