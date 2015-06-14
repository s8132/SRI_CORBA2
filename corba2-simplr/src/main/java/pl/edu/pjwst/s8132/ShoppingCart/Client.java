package pl.edu.pjwst.s8132.ShoppingCart;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Client {

    public static void main(String[] args) {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);


        try {
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Arytmetyka", "");
            NameComponent path[] = {nc};
            ShoppingCart proxy = ShoppingCartHelper.narrow(ncRef.resolve(path));

            System.out.println("Dodaj id: 1");
            proxy.addProduct(1);
            System.out.println("Products:");
            for(Integer integer: proxy.p()){
                System.out.println("\t" + integer);
            }

            System.out.println("Dodaj [2,3,4,5,6,7]");
            proxy.addProduct(2);
            proxy.addProduct(3);
            proxy.addProduct(4);
            proxy.addProduct(5);
            proxy.addProduct(6);
            proxy.addProduct(7);
            System.out.println("Products:");
            for(Integer integer: proxy.p()){
                System.out.println("\t" + integer);
            }

            System.out.println("Remove product [2,3,4]");
            proxy.removeProduct(2);
            proxy.removeProduct(3);
            proxy.removeProduct(4);
            System.out.println("Products:");
            for(Integer integer: proxy.p()){
                System.out.println("\t" + integer);
            }


        } catch (InvalidName | NotFound | org.omg.CosNaming.NamingContextPackage.InvalidName | CannotProceed invalidName) {
            invalidName.printStackTrace();
        }
    }
}
