package pl.edu.pjwst.s8132.ShoppingCart.main;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import pl.edu.pjwst.s8132.ShoppingCart.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);


        try {
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("ShoppingCart", "");
            NameComponent path[] = {nc};
            ShoppingCart proxy = ShoppingCartHelper.narrow(ncRef.resolve(path));

            NameComponent nameComponent = new NameComponent("Shop", "");
            NameComponent paths[] = {nameComponent};
            Shop shopProxy = ShopHelper.narrow(ncRef.resolve(paths));


            System.out.println("Products from shop");
            Product[] products = shopProxy.products();
            Random random = new Random();
            for(int i=0; i<products.length; i++){
                System.out.println("\tProduct(id: " + products[i].id + ", name:" + products[i].name + ")");
                if(i%2==0){
                    proxy.addProduct(new CartItem(random.nextInt(10),products[i]));
                }
            }

            System.out.println("Cart:");
            List<CartItem> cartItems = new ArrayList<>();
            CartItem[] items = proxy.cartItems();
            for(int i=0; i<items.length; i++){
                System.out.println("\t CartItem(amount: " + items[i].amount + ", Product(id: " + items[i].product.id + ", name: " + items[i].product.name + "))");
                if(i%2==0){
                    cartItems.add(items[i]);
                }
            }

            System.out.println("\tCarItem size: " + proxy.cartItems().length);

            System.out.println("Realizuj");
            proxy.checkOut();

            items = proxy.cartItems();
            for(int i=0; i<items.length; i++){
                System.out.println("\t CartItem(amount: " + items[i].amount + ", Product(id: " + items[i].product.id + ", name: " + items[i].product.name + "))");
                if(i%2==0){
                    cartItems.add(items[i]);
                }
            }

            System.out.println("\tCarItem size: " + proxy.cartItems().length);

        } catch (InvalidName | NotFound | org.omg.CosNaming.NamingContextPackage.InvalidName | CannotProceed invalidName) {
            invalidName.printStackTrace();
        }
    }
}
