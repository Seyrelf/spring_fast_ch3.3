package ch1.repository;

import ch1.model.PizzaOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends CrudRepository<PizzaOrder,Long> {

    List<PizzaOrder> findByDeliveryZip(String deliveryZip);
}
