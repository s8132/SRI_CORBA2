package pl.edu.pjwstk.s8132.sri.corba;

public final class ArytmetykaHolder implements org.omg.CORBA.portable.Streamable
{
  public Arytmetyka value = null;

  public ArytmetykaHolder ()
  {
  }

  public ArytmetykaHolder (Arytmetyka initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ArytmetykaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ArytmetykaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ArytmetykaHelper.type ();
  }

}
