package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Get the bill input, convert to double
		        final EditText et = (EditText) findViewById(R.id.edtBillAmount);
		        String input=et.getText().toString();		    
		        double bill, tip;
		        if(input.equals("")) input = "0.0";  // Check for empty bill input
	        	bill = Double.parseDouble(input);
		        // Calculate tip
		        tip = bill * 0.12;
		        final CheckBox checkBox = (CheckBox) findViewById(R.id.chkRound);
		        String result = !checkBox.isChecked() ? String.format("%.2f", tip) : Integer.toString((int) Math.round(tip)); 
	            final TextView tv = (TextView) findViewById(R.id.txtTipResult);
                   tv.setText("Tip: $"+result);
			}
		});
    }
}