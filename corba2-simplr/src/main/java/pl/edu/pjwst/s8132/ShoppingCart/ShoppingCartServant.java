package pl.edu.pjwst.s8132.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServant extends _ShoppingCartImplBase{

    List<Integer> products = new ArrayList<Integer>();

    @Override
    public int[] p() {
        return getProducts();
    }

    @Override
    public void addProduct(int productId) {
        this.products.add(productId);
    }

    @Override
    public void removeProduct(int productId) {
        for(int i=0; i<this.products.size(); i++){
            if(this.products.get(i)==productId){
                this.products.remove(i);
            }
        }
    }

    private int[] getProducts(){
        int[] ints = new int[this.products.size()];
        for(int i=0; i<this.products.size(); i++){
            ints[i] = this.products.get(i);
        }
        return ints;
    }
}
