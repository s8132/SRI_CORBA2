package pl.edu.pjwstk.s8132.sri.corba;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import pl.edu.pjwstk.s8132.sri.corba.arytmetyka.DzieleniePrzezZero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Client {

    public static void main(String[] args) {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);


        try {
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Arytmetyka", "");
            NameComponent path[] = {nc};
            Arytmetyka proxy = ArytmetykaHelper.narrow(ncRef.resolve(path));

            System.out.println("Suma");
            proxy.s1(1);
            proxy.s2(2);
            proxy.Suma();
            System.out.println(proxy.wynik());

            System.out.println("Ro¿nica");
            proxy.s1(10);
            proxy.s2(25);
            proxy.Roznica();
            System.out.println(proxy.wynik());


            System.out.println("Iloczyn");
            proxy.s1(5);
            proxy.s2(5);
            proxy.Iloczyn();
            System.out.println(proxy.wynik());

            System.out.println("Iloraz");
            proxy.s1(25);
            proxy.s2(5);
            try {
                proxy.Iloraz();
            } catch (DzieleniePrzezZero dzieleniePrzezZero) {
                dzieleniePrzezZero.printStackTrace();
            }
            System.out.println(proxy.wynik());


            System.out.println("Iloraz - ex");
            proxy.s1(0);
            proxy.s2(5);
            try {
                proxy.Iloraz();
            } catch (DzieleniePrzezZero dzieleniePrzezZero) {
                dzieleniePrzezZero.printStackTrace();
            }
            System.out.println(proxy.wynik());

        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }


        /*FileReader fr = null;
        try {
            fr = new FileReader("ref.ior");
            BufferedReader br = new BufferedReader(fr);
            String ior = br.readLine();

            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            Arytmetyka proxy = ArytmetykaHelper.narrow(obj);


            System.out.println("Suma");
            proxy.s1(1);
            proxy.s2(2);
            proxy.Suma();
            System.out.println(proxy.wynik());

            System.out.println("Ro¿nica");
            proxy.s1(10);
            proxy.s2(25);
            proxy.Roznica();
            System.out.println(proxy.wynik());


            System.out.println("Iloczyn");
            proxy.s1(5);
            proxy.s2(5);
            proxy.Iloczyn();
            System.out.println(proxy.wynik());

            System.out.println("Iloraz");
            proxy.s1(25);
            proxy.s2(5);
            try {
                proxy.Iloraz();
            } catch (DzieleniePrzezZero dzieleniePrzezZero) {
                dzieleniePrzezZero.printStackTrace();
            }
            System.out.println(proxy.wynik());


            System.out.println("Iloraz - ex");
            proxy.s1(0);
            proxy.s2(5);
            try {
                proxy.Iloraz();
            } catch (DzieleniePrzezZero dzieleniePrzezZero) {
                dzieleniePrzezZero.printStackTrace();
            }
            System.out.println(proxy.wynik());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }
}
