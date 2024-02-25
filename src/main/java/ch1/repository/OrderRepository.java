package ch1.repository;

import ch1.model.PizzaOrder;

public interface OrderRepository {
    PizzaOrder save(PizzaOrder order);
}
