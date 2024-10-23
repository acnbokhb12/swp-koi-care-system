/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;
import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Product;
import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

/**
 *
 * @author DELL
 */
public class CartService {
    private Jedis jedis;
    
     public CartService() {
        this.jedis = new Jedis(IConstant.URI_JEDIS);
    }
    public void saveCart(int userId, int quantityToBuyProduct, String productID) {
    Map<String, String> cartData = jedis.hgetAll("cart:" + userId);
    
    // Kiểm tra cartData là null hoặc không thay đổi, khởi tạo một HashMap mới
    if (cartData == null || cartData.isEmpty()) {
        cartData = new HashMap<>();
    } else {
        // Chuyển đổi cartData thành HashMap có thể thay đổi
        cartData = new HashMap<>(cartData);
    }

    if (cartData.containsKey(productID)) {
        int existingQuantity = Integer.parseInt(cartData.get(productID));
        quantityToBuyProduct += existingQuantity;
    }
    cartData.put(productID, String.valueOf(quantityToBuyProduct));
    
    // Lưu vào giỏ hàng jedis
    jedis.hmset("cart:" + userId, cartData);
    //jedis.expire("cart:" + userId, 604800); // Đặt thời gian hết hạn là 1 tuần (604800 giây)
    jedis.expire("cart:" + userId, 1 * 60 * 60);
}
    public HashMap<Product,Integer> getCart(int userId){
        Map<String,String> cartData =   jedis.hgetAll("cart:" + userId);
        if(cartData==null && cartData.isEmpty()){
            return null;
        }
        // convert to cart real
        ProductService pds = new ProductService();
        HashMap<Product, Integer> cartUser = new HashMap<>();
        for(String productId : cartData.keySet()){
            Product p = pds.getProductById(Integer.parseInt(productId));
            cartUser.put(p, Integer.parseInt(cartData.get(productId)));
        }
        return cartUser;
    }  
}
 
 