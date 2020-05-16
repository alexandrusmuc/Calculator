package sample;

public class Model {
    public static long calculate(long value1, long value2, String operator){
        long result = 0;
        switch (operator){
            case "+":
                return   value1+value2;

            case "-":
                return  value1-value2;

            case "*":
                return  value1*value2;

            case "/":
                if(value2==0){
                    return  0;
                }else   return value1/value2;


        }
        return 0;
    }


}
