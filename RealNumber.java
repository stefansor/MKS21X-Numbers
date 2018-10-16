public class RealNumber{
  private double val = 42;
  public RealNumber(double x){
    val = x;
  }
  public double getVal(){
    return val;
  }
  public String toString(){
    return "" + this.getVal();
  }

}
