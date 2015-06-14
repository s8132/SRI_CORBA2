package pl.edu.pjwstk.s8132.sri.corba.arytmetyka;


public final class DzieleniePrzezZeroHolder implements org.omg.CORBA.portable.Streamable
{
  public DzieleniePrzezZero value = null;

  public DzieleniePrzezZeroHolder ()
  {
  }

  public DzieleniePrzezZeroHolder (DzieleniePrzezZero initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DzieleniePrzezZeroHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DzieleniePrzezZeroHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DzieleniePrzezZeroHelper.type ();
  }

}
