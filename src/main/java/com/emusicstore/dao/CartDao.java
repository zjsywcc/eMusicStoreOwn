package com.emusicstore.dao;

import com.emusicstore.model.Cart;

/**
 * Created by wcc on 2016/8/3.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
