package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    Text output;
    private boolean operatorPressed=false;
    private boolean lastPressedOperator=false;
    private double number1=0d;
    private boolean number1Flag = false;
    private String operator;
    @FXML
    public void numButton(ActionEvent actionEvent) {

        String s = output.getText();
        lastPressedOperator=false;

        if(operatorPressed){
            output.setText(((Button)actionEvent.getSource()).getText());
            operatorPressed=false;

        }else{
            s+=((Button)actionEvent.getSource()).getText();
            output.setText(s);
        }
    }
    @FXML
    public void operatorButton(ActionEvent actionEvent) {
        if (lastPressedOperator){
            operator= ((Button)actionEvent.getSource()).getText();
            return;
        }

        operatorPressed= true;
        String op = ((Button)actionEvent.getSource()).getText();
        if(number1Flag){
            double number2 = Double.parseDouble(output.getText());
            Double x = Model.calculate(number1, number2, operator );
            if(Math.floor(x)== Math.ceil(x)){
                output.setText(String.valueOf( (((int)Math.floor(x)))));
            }else
                output.setText(String.valueOf(x));

            number1=Double.parseDouble( output.getText());

            operator=op;

        }else{
            number1 =Double.parseDouble( output.getText());
            number1Flag=true;
            operator= op;

        }
        lastPressedOperator=true;
       // number1 =Long.parseLong( output.getText());
    }

    public void acHandler(ActionEvent actionEvent) {
        operator="";
        operatorPressed=false;
        number1=0;
        number1Flag=false;
        output.setText("");

    }

    public void negativeHandler(ActionEvent actionEvent) {
        String s = output.getText();
        if (s.charAt(0)=='-'){
            s= s.substring(1);
            output.setText(s);
        }else {
            output.setText("-"+s);
        }
    }

    public void percentHandler(ActionEvent actionEvent) {

    }
}
