package com.epam.framework;

/**
 * Created by Артур.
 */
public class CartState {
    private static CartState cartState;
    private static float cartTotalSum;

    private CartState() {
    }

    public static CartState getInstance() {
        if (cartState == null) {
            cartState = new CartState();
        }
        return cartState;
    }

    public void setTotalSum(float totalSum) {
        cartTotalSum = totalSum;
    }

    public float getTotalSum() {
        return cartTotalSum;
    }
}
