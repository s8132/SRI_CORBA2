package pl.edu.pjwst.s8132.ShoppingCart;

/**
* pl/edu/pjwst/s8132/ShoppingCart/ShoppingCartHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./ShoppingCart.idl
* niedziela, 14 czerwca 2015 04:27:31 CEST
*/

public final class ShoppingCartHolder implements org.omg.CORBA.portable.Streamable
{
  public pl.edu.pjwst.s8132.ShoppingCart.ShoppingCart value = null;

  public ShoppingCartHolder ()
  {
  }

  public ShoppingCartHolder (pl.edu.pjwst.s8132.ShoppingCart.ShoppingCart initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = pl.edu.pjwst.s8132.ShoppingCart.ShoppingCartHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    pl.edu.pjwst.s8132.ShoppingCart.ShoppingCartHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return pl.edu.pjwst.s8132.ShoppingCart.ShoppingCartHelper.type ();
  }

}
