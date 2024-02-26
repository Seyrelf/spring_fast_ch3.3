package ch1.repository;

import ch1.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface IngredientRepository extends CrudRepository<Ingredient,String > {
}
