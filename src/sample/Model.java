package sample;

public class Model {
    public static double calculate(double value1, double value2, String operator){
        double result = 0;
        switch (operator){
            case "+":
                return   value1+value2;

            case "-":
                return  value1-value2;

            case "x":
                return  value1*value2;

            case "/":
                if(value2==0){
                    return  0;
                }else   return value1/value2;


        }
        return 0;
    }


}
