package pl.edu.pjwstk.s8132.sri.corba;

abstract public class ArytmetykaHelper
{
  private static String  _id = "IDL:Arytmetyka:1.0";

  public static void insert (org.omg.CORBA.Any a, Arytmetyka that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Arytmetyka extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ArytmetykaHelper.id (), "Arytmetyka");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Arytmetyka read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ArytmetykaStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Arytmetyka value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Arytmetyka narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Arytmetyka)
      return (Arytmetyka)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _ArytmetykaStub stub = new _ArytmetykaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Arytmetyka unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Arytmetyka)
      return (Arytmetyka)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _ArytmetykaStub stub = new _ArytmetykaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
