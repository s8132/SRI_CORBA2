package pl.edu.pjwstk.s8132.sri.corba;

import pl.edu.pjwstk.s8132.sri.corba.arytmetyka.*;

public abstract class _ArytmetykaImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements Arytmetyka, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _ArytmetykaImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_s1", new Integer (0));
    _methods.put ("_set_s1", new Integer (1));
    _methods.put ("_get_s2", new Integer (2));
    _methods.put ("_set_s2", new Integer (3));
    _methods.put ("_get_wynik", new Integer (4));
    _methods.put ("_set_wynik", new Integer (5));
    _methods.put ("Suma", new Integer (6));
    _methods.put ("Roznica", new Integer (7));
    _methods.put ("Iloczyn", new Integer (8));
    _methods.put ("Iloraz", new Integer (9));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Arytmetyka/_get_s1
       {
         double $result = (double)0;
         $result = this.s1 ();
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 1:  // Arytmetyka/_set_s1
       {
         double newS1 = in.read_double ();
         this.s1 (newS1);
         out = $rh.createReply();
         break;
       }

       case 2:  // Arytmetyka/_get_s2
       {
         double $result = (double)0;
         $result = this.s2 ();
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // Arytmetyka/_set_s2
       {
         double newS2 = in.read_double ();
         this.s2 (newS2);
         out = $rh.createReply();
         break;
       }

       case 4:  // Arytmetyka/_get_wynik
       {
         double $result = (double)0;
         $result = this.wynik ();
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 5:  // Arytmetyka/_set_wynik
       {
         double newWynik = in.read_double ();
         this.wynik (newWynik);
         out = $rh.createReply();
         break;
       }

       case 6:  // Arytmetyka/Suma
       {
         this.Suma ();
         out = $rh.createReply();
         break;
       }

       case 7:  // Arytmetyka/Roznica
       {
         this.Roznica ();
         out = $rh.createReply();
         break;
       }

       case 8:  // Arytmetyka/Iloczyn
       {
         this.Iloczyn ();
         out = $rh.createReply();
         break;
       }

       case 9:  // Arytmetyka/Iloraz
       {
         try {
           this.Iloraz ();
           out = $rh.createReply();
         } catch (DzieleniePrzezZero $ex) {
           out = $rh.createExceptionReply ();
           DzieleniePrzezZeroHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Arytmetyka:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _ArytmetykaImplBase
