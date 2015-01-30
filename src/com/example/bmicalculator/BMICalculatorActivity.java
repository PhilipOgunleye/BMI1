package com.example.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

public class BMICalculatorActivity extends Activity {
	
	private EditText txtheight;
	private EditText txtweight;
	private TextView txtresult;
	private Button btncalculate;
	private Button btnreset;
	private double bmi = 0;
	private double valueheight = 0;
	private double valueweight = 0;
	private String resulttext;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initControls();
        /*TextView tv = new TextView(this);
        tv.setText("BMI Calculator");
        setContentView(tv);*/
        
   }
    
    public static double round2(double num) {
    	double result = num * 100;
    	result = Math.round(result);
    	result = result / 100;
    	return result;
    	}
    
    
    private void initControls() {
    	txtheight = (EditText)findViewById(R.id.txtheight);
    	txtweight = (EditText)findViewById(R.id.txtweight);
    	txtresult = (TextView)findViewById(R.id.txtresult);
    	btncalculate = (Button)findViewById(R.id.btncalculate);
    	//btnreset = (Button)findViewById(R.id.btnreset);
    	btncalculate.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){ calculate(); }});
    	//btnreset.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){ reset(); }});
    }
    
    private void calculate()    {
    	valueheight =Double.parseDouble(txtheight.getText().toString());
    	valueweight	=Double.parseDouble(txtweight.getText().toString());
    	bmi = (valueweight / (valueheight * valueheight))*703;
    	bmi = round2(bmi);
    	//txttipamount.setText(Double.toString(bmi));
    	if (bmi >= 30) { /* obese */
    		resulttext = "Your BMI of " + Double.toString(bmi) + " is OBESE.";
    		txtresult.setText(resulttext);
    	} else if (bmi >= 25) {
    		resulttext = "Your BMI of " + Double.toString(bmi) + " is OVERWEIGHT.";
    		txtresult.setText(resulttext);
    	} else if (bmi >= 18.5) {
    		resulttext = "Your BMI of " + Double.toString(bmi) + " is IDEAL.";
    		txtresult.setText(resulttext);
    	} else {
    		resulttext = "Your BMI of " + Double.toString(bmi) + " is UNDERWEIGHT.";
    		txtresult.setText(resulttext);
    	}
    }
    private void reset()
    {
    	txtresult.setText("Your BMI is unknown.");
    	txtheight.setText("0");
    	txtweight.setText("0");
    }

    
    
}