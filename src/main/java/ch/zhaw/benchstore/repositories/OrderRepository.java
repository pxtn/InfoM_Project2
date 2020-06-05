package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT cust, ord FROM Order ord JOIN ord.customer cust WHERE cust.id = ?1")
    public List<Order> getOrdersFromCustomerWithId(long id);

    @Query("SELECT ord, DATEDIFF(date_of_delivery, date_of_order) AS deliveryTime FROM Order ord WHERE DATEDIFF(date_of_delivery, date_of_order) > 14 ORDER BY deliveryTime DESC")
    public List<Order> getDelayedOrders();

}
