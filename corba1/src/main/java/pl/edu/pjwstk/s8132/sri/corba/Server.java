package pl.edu.pjwstk.s8132.sri.corba;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Server {

    public static void main(String[] args) {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
        ArytmetykaServant as = new ArytmetykaServant();
        /*orb.connect(as);

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("ref.ior")));
            out.println(
                    orb.object_to_string(as) );
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Arytmetyka", "");
            NameComponent path[] = {nc};
            ncRef.rebind(path, as);
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
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
