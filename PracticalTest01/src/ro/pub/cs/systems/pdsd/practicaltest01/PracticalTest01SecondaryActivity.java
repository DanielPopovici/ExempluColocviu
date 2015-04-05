package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity{

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);
        
        final Context context = this;
          
        
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        Integer total = data.getInt("total");
        
        
        EditText text = (EditText)findViewById(R.id.textTotal);
        text.setText(total + "");
        
        
        
        
        Button buttonOK = (Button)findViewById(R.id.buttonOK);
        
        buttonOK.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(context, PracticalTest01MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
        Button buttonCancel = (Button)findViewById(R.id.buttonCancel);
        
        buttonCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				setResult(RESULT_OK);
				finish();
			}
		});
    }
}
