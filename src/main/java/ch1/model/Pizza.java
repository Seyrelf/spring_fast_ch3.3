package ch1.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
public class Pizza {
    @Id
    private long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min=5,message = "Name must be at least 5 char long")
    private String name;

    @NotNull
    @Size(min=5,message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredients = new ArrayList<>();
}
