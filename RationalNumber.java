
public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
  super(0.0);
    if (nume > 0 && deno < 0){
      nume = nume * -1;
      deno = deno * -1;
      int g = gcd(nume, deno);
      int newnum = nume / g;
      int newden = deno / g;
      numerator = newnum;
      denominator = newden;
    }
    if (deno < 0 && nume < 0){
      nume = nume * -1;
      deno = deno * -1;
      int g = gcd(nume, deno);
      int newnum = nume / g * -1;
      int newden = deno / g * -1;
      numerator = newnum;
      denominator = newden;
    }
    if (nume == 0.0 || deno == 0){
      numerator = 0;
      denominator = 1;
    }
    else{
    int g = gcd(nume, deno);
    int newnum = nume / g;
    int newden = deno / g;
    numerator = newnum;
    denominator = newden;
    }
  }

  public double getValue(){
    return (double)getNumerator() / getDenominator();
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber newratio = new RationalNumber(getDenominator(), getNumerator());
    return newratio;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if(this.getNumerator() == other.getNumerator() &&
    this.getDenominator() == other.getDenominator()){
      return true;
    }
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (getNumerator() == 0 ){
      return "0";
    }
    if (getDenominator() == 1){
      return "" + getNumerator();
    }
    else{
      return "" + getNumerator() + "/" + getDenominator();
    }
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    while (b != 0) {
         int temp = b;
         b = a % b;
         a = temp;
     }
     return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int a = gcd(getNumerator(), getDenominator());
    numerator = numerator / a;
    denominator = denominator / a;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber mult;
    mult = new RationalNumber(this.getNumerator() * other.getNumerator(),
    this.getDenominator() * other.getDenominator());
    return mult;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    other = other.reciprocal();
    return this.multiply(other);
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int firstnum = this.getNumerator() * other.getDenominator();
    int secondnum = other.getNumerator() * this.getDenominator();
    int newden = this.getDenominator() * other.getDenominator();
    int anc = firstnum + secondnum;
    RationalNumber added = new RationalNumber(anc, newden);
    return added;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int firstnum = this.getNumerator() * other.getDenominator();
    int secondnum = other.getNumerator() * this.getDenominator();
    int newden = this.getDenominator() * other.getDenominator();
    int xyz = firstnum - secondnum;
    RationalNumber subtracted = new RationalNumber(xyz, newden);
    return subtracted;
  }
}
