package ch1.repository;

import ch1.model.PizzaOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<PizzaOrder,Long> {
}
