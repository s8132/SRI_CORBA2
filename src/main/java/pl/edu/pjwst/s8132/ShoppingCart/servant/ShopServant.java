package pl.edu.pjwst.s8132.ShoppingCart.servant;

import pl.edu.pjwst.s8132.ShoppingCart.Product;
import pl.edu.pjwst.s8132.ShoppingCart._ShopImplBase;

import java.util.ArrayList;
import java.util.List;

public class ShopServant extends _ShopImplBase {

    List<Product> productList = new ArrayList<>();
    
    @Override
    public Product[] products() {
        fillProduct();
        Product[] products = new Product[this.productList.size()];
        return productList.toArray(products);
    }

    private void fillProduct(){
        this.productList.add(new Product(1, "Dell xps 13"));
        this.productList.add(new Product(2, "Dell xps 15"));
        this.productList.add(new Product(3, "Apple MacBook Pro 15 Retina"));
        this.productList.add(new Product(4, "Apple MacBook Air"));
        this.productList.add(new Product(5, "Dell Vostro 3500"));
        this.productList.add(new Product(6, "Lenovo"));
        this.productList.add(new Product(7, "Samsung"));
        this.productList.add(new Product(8, "Sony Vaio"));
        this.productList.add(new Product(9, "Asus"));
        this.productList.add(new Product(10, "MSI"));
    }
}
