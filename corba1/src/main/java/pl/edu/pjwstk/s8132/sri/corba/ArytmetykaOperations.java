package pl.edu.pjwstk.s8132.sri.corba;

import pl.edu.pjwstk.s8132.sri.corba.arytmetyka.DzieleniePrzezZero;

public interface ArytmetykaOperations
{
  double s1();
  void s1(double newS1);
  double s2();
  void s2(double newS2);
  double wynik();
  void wynik(double newWynik);
  void Suma();
  void Roznica();
  void Iloczyn();
  void Iloraz() throws DzieleniePrzezZero;
} // interface ArytmetykaOperations
