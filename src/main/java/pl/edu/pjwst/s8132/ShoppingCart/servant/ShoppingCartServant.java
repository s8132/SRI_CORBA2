package pl.edu.pjwst.s8132.ShoppingCart.servant;

import pl.edu.pjwst.s8132.ShoppingCart.CartItem;
import pl.edu.pjwst.s8132.ShoppingCart._ShoppingCartImplBase;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServant extends _ShoppingCartImplBase {

    List<CartItem> cartItemList = new ArrayList<>();

    @Override
    public CartItem[] cartItems() {
        CartItem[] cartItems = new CartItem[this.cartItemList.size()];
        return this.cartItemList.toArray(cartItems);
    }

    @Override
    public void addProduct(CartItem cartItem) {
        this.cartItemList.add(cartItem);
    }

    @Override
    public void checkOut() {
        this.cartItemList.clear();
    }

}
