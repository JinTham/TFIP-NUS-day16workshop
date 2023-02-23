package tfip.ssf.day16workshop.Controllers;

import java.io.Reader;
import java.io.StringReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import tfip.ssf.day16workshop.Model.Order;
import tfip.ssf.day16workshop.Model.OrderResponse;
import tfip.ssf.day16workshop.Service.OrderService;

@RestController
@RequestMapping(path="/api/order", produces=MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrderService orderSvc;

    // application/x-www-form-urlencoded
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postOrder(@RequestBody String payload){
        
        // Json is the wire format
		// Convert from String to JsonObject
		Reader reader = new StringReader(payload);

		JsonReader jsonReader = Json.createReader(reader);
		JsonObject json = jsonReader.readObject();

        // Convert Json to entity model
		Order order = Order.create(json);
        
        //Generate orderID in order entity
        String orderId = orderSvc.createNewOrder(order);

        // Construct response
		OrderResponse resp = new OrderResponse();
		resp.setOrderId(orderId);
		resp.setMessage("Order created");
        //Convert response to Json Object
		json = resp.toJson();

		// Send response back to client
		return ResponseEntity.status(201).body(json.toString());

    }
}
