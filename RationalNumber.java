public class RationalNumber extends RealNumber{
  private double num = 42.0;
  private int den = 1;
  public RationalNumber(double a, int b){
    super(a);
    den = b;
  }
  public double getNum(){
    return num;
  }
  public int getDen(){
    return den;
  }
  public String toString(){
    return "" + getVal();
  }
  public boolean compare(RationalNumber x, RealNumber y){
    return true;
  }
  public boolean compare(RealNumber x, RealNumber y){
    return true;
  }
  public boolean compare(RationalNumber x, RationalNumber y){
    return true;
  }
}
