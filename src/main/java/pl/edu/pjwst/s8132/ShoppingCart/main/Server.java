package pl.edu.pjwst.s8132.ShoppingCart.main;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import pl.edu.pjwst.s8132.ShoppingCart.servant.ShopServant;
import pl.edu.pjwst.s8132.ShoppingCart.servant.ShoppingCartServant;

public class Server {

    public static void main(String[] args) {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
        ShoppingCartServant as = new ShoppingCartServant();
        ShopServant shopServant = new ShopServant();

        try {
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("ShoppingCart", "");
            NameComponent path[] = {nc};
            ncRef.rebind(path, as);

            NameComponent nameComponent = new NameComponent("Shop", "");
            NameComponent paths[] = {nameComponent};
            ncRef.rebind(paths, shopServant);
        } catch (InvalidName | org.omg.CosNaming.NamingContextPackage.InvalidName | CannotProceed | NotFound invalidName) {
            invalidName.printStackTrace();
        }

        Object sync = new Object();
        synchronized (sync) {
            try {
                sync.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
