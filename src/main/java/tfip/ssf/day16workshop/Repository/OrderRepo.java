package tfip.ssf.day16workshop.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import tfip.ssf.day16workshop.Model.Order;

@Repository
public class OrderRepo {
    @Autowired @Qualifier("my-redis")
    private RedisTemplate<String,String> template;

    public void insertOrder(Order order){
    }
}
