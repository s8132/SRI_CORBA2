package pl.edu.pjwst.s8132.ShoppingCart;


/**
* pl/edu/pjwst/s8132/ShoppingCart/_ShoppingCartStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./ShoppingCart.idl
* niedziela, 14 czerwca 2015 04:27:31 CEST
*/

public class _ShoppingCartStub extends org.omg.CORBA.portable.ObjectImpl implements pl.edu.pjwst.s8132.ShoppingCart.ShoppingCart
{

  public int[] p ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_p", true);
                $in = _invoke ($out);
                int $result[] = pl.edu.pjwst.s8132.ShoppingCart.ShoppingCartPackage.productsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return p (        );
            } finally {
                _releaseReply ($in);
            }
  } // p

  public void addProduct (int productId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addProduct", true);
                $out.write_long (productId);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                addProduct (productId        );
            } finally {
                _releaseReply ($in);
            }
  } // addProduct

  public void removeProduct (int productId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeProduct", true);
                $out.write_long (productId);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                removeProduct (productId        );
            } finally {
                _releaseReply ($in);
            }
  } // removeProduct

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:pl/edu/pjwst/s8132/ShoppingCart/ShoppingCart:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ShoppingCartStub
