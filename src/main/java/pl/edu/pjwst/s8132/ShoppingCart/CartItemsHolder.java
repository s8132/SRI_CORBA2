package pl.edu.pjwst.s8132.ShoppingCart;


/**
* pl/edu/pjwst/s8132/ShoppingCart/CartItemsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./ShoppingCart.idl
* niedziela, 14 czerwca 2015 12:13:08 CEST
*/

public final class CartItemsHolder implements org.omg.CORBA.portable.Streamable
{
  public pl.edu.pjwst.s8132.ShoppingCart.CartItem value[] = null;

  public CartItemsHolder ()
  {
  }

  public CartItemsHolder (pl.edu.pjwst.s8132.ShoppingCart.CartItem[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = pl.edu.pjwst.s8132.ShoppingCart.CartItemsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    pl.edu.pjwst.s8132.ShoppingCart.CartItemsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return pl.edu.pjwst.s8132.ShoppingCart.CartItemsHelper.type ();
  }

}
