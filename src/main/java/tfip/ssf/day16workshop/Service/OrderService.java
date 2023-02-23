package tfip.ssf.day16workshop.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.ssf.day16workshop.Model.Order;
import tfip.ssf.day16workshop.Repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
	private OrderRepo orderRepo;

	public String createNewOrder(Order order) {
		// Generating the orderId
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		order.setOrderId(orderId);

		// Save the order
		orderRepo.insertOrder(order);

		return orderId;
	}
}
