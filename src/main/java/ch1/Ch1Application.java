package ch1;

import ch1.model.Ingredient;
import ch1.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Ch1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch1Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo){
		return  args -> {
			repo.save(new Ingredient("TDH","THIN DOUGH", Ingredient.Type.DOUGH));
			repo.save(new Ingredient("TCDH","THICK DOUGH", Ingredient.Type.DOUGH));
			repo.save(new Ingredient("CHN","CHICKEN", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("BF","BEAF", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("PPN","PEPPERONI", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("TM","TOMATE", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("PK","PICKLE", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("GD","GOUDA", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("CHR","CHEDER", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("MZ","MOZZARELLA", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("MO","MAYO", Ingredient.Type.SAUCE));
			repo.save(new Ingredient("KTH","KETCHUP", Ingredient.Type.SAUCE));

		};
	}

}




