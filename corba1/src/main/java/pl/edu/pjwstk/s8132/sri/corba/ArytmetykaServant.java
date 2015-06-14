package pl.edu.pjwstk.s8132.sri.corba;

import pl.edu.pjwstk.s8132.sri.corba.arytmetyka.DzieleniePrzezZero;

public class ArytmetykaServant extends _ArytmetykaImplBase {

    private double s1;
    private double s2;
    private double wynik;

    public double s1() {
        return s1;
    }

    public void s1(double newS1) {
        this.s1=newS1;
    }

    public double s2() {
        return s2;
    }

    public void s2(double newS2) {
        this.s2=newS2;
    }

    public double wynik() {
        return wynik;
    }

    public void wynik(double newWynik) {
        this.wynik=newWynik;
    }

    public void Suma() {
        this.wynik = s1 + s2;
    }

    public void Roznica() {
        this.wynik = s2-s1;
    }

    public void Iloczyn() {
        this.wynik = s1*s2;
    }

    public void Iloraz() throws DzieleniePrzezZero {
        if(s1==0){
            this.wynik = 0;
            throw new DzieleniePrzezZero();
        }else{
            this.wynik = s2/s1;
        }
    }
}
