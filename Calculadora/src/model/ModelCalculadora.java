package model;
public class ModelCalculadora 
{
    private float Num1;
    private float Num2;

    public float getNum1() {
        System.out.println("getNumero 1");
        return Num1;
    }

    public void setNum1(float Num1) {
        System.out.println("setNumero 1");
        this.Num1 = Num1;
    }

    public float getNum2() {
        System.out.println("getNumero 2");
        return Num2;
    }

    public void setNum2(float Num2) {
        System.out.println("setNumero 2");
        this.Num2 = Num2;
    }    
}
