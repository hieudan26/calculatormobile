package hcmute.edu.vn.caculator_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String texViewvalue="";
    private static String previous="";
    private static int cal =-1;
    private static boolean clear =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Button> listBtn = addBtn();
        for (Button btn:listBtn
             ) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addText((String) btn.getText());
                }
            });
        }

        Button btnClear = (Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearText();
            }
        });

        Button btnSum = (Button) findViewById(R.id.btn_plus);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calbtn(0);
            }
        });

        Button btnSub = (Button) findViewById(R.id.btn_minus);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calbtn(1);
            }
        });

        Button btnMul = (Button) findViewById(R.id.btn_multiply);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calbtn(2);
            }
        });

        Button btnDivide = (Button) findViewById(R.id.btn_divide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calbtn(3);
            }
        });

        Button btnEqual = (Button) findViewById(R.id.btn_equal);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calbtn(-1);
                texViewvalue = "";
                previous = "";
                clear = true;
            }
        });

    }
    private List<Button> addBtn(){
        List<Button> listBtn = new ArrayList<>();
        Button btn0 = (Button) findViewById(R.id.btn_number_zero);
        Button btn1 = (Button) findViewById(R.id.btn_number_one);
        Button btn2 = (Button) findViewById(R.id.btn_number_two);
        Button btn3 = (Button) findViewById(R.id.btn_number_three);
        Button btn4 = (Button) findViewById(R.id.btn_number_four);
        Button btn5 = (Button) findViewById(R.id.btn_number_five);
        Button btn6 = (Button) findViewById(R.id.btn_number_six);
        Button btn7 = (Button) findViewById(R.id.btn_number_seven);
        Button btn8 = (Button) findViewById(R.id.btn_number_eight);
        Button btn9 = (Button) findViewById(R.id.btn_number_nine);
        Button btn10 = (Button) findViewById(R.id.btn_dot);

        listBtn.add(btn0);
        listBtn.add(btn1);
        listBtn.add(btn2);
        listBtn.add(btn3);
        listBtn.add(btn4);
        listBtn.add(btn5);
        listBtn.add(btn6);
        listBtn.add(btn7);
        listBtn.add(btn8);
        listBtn.add(btn9);
        listBtn.add(btn10);
        return listBtn;
    }

    private void addText(String value){
        if(texViewvalue.lastIndexOf(".")!= -1 && value.equals(".")){
            return;
        }
        if(clear == true){
            previous = texViewvalue;
            texViewvalue = "";
            clear = false;
        }
        texViewvalue += value;
        updateText();

    }

    private void clearText(){
        texViewvalue = "";
        previous = "";
        cal= -1;
        updateText();
    }

    private void updateText(){
        TextView textView = (TextView) findViewById(R.id.txt_result);
        textView.setText(texViewvalue);
    }

    private void calbtn(int mode){
        if(texViewvalue.equals("")){
            updateText();
            return;
        }
        if(cal == -1){
            clear = true;
            updateText();
        }
        else{
            printResult();
            updateText();
            clear = true;
        }
        cal= mode;
    }



    private void printResult(){
        double num1 = Double.parseDouble(previous);
        double num2 = Double.parseDouble(texViewvalue);
        double result=0;
        switch (cal){
            case 0:{
                result = num1 + num2;
                break;
            }
            case 1:{
                result = num1 - num2;
                break;
            }
            case 2:{
                result = num1 * num2;

                break;
            }
            case 3:{
                result = num1 / num2;
                break;
            }
            default:
                break;
        }
        texViewvalue = String.valueOf(result);

    }
}