package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button buttonSec = (Button)findViewById(R.id.buttonSecActivity);
        
        
        button1.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText text1 = (EditText)findViewById(R.id.text1);
				
				Integer clickCount = Integer.parseInt(text1.getText().toString());
				
				text1.setText("" + (++clickCount));
			}
		});
        
        button2.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText text2 = (EditText)findViewById(R.id.text2);
				
				Integer clickCount = Integer.parseInt(text2.getText().toString());
				
				text2.setText("" + (++clickCount));
			}
		});
        
        buttonSec.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				EditText text1 = (EditText)findViewById(R.id.text1);
				EditText text2 = (EditText)findViewById(R.id.text2);
				
				Integer clickCount = Integer.parseInt(text1.getText().toString());
				clickCount += Integer.parseInt(text2.getText().toString());
				
				Intent intent = new Intent("practical.test.secondary.activity");
				intent.putExtra("total", clickCount);
				startActivityForResult(intent, 80085);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	
    	EditText text1 = (EditText)findViewById(R.id.text1);
    	EditText text2 = (EditText)findViewById(R.id.text2);
    	
    	outState.putCharSequence("edittext1value", text1.getText().toString());
    	outState.putCharSequence("edittext2value", text2.getText().toString());
    	
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onRestoreInstanceState(savedInstanceState);
    	
    	EditText text1 = (EditText)findViewById(R.id.text1);
    	EditText text2 = (EditText)findViewById(R.id.text2);
    	
    	text1.setText(savedInstanceState.getCharSequence("edittext1value"));
    	text2.setText(savedInstanceState.getCharSequence("edittext2value"));
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	Toast.makeText(this, "Result code: " + resultCode, Toast.LENGTH_LONG).show();
    
    	Log.d("onActivityResult", resultCode + "");
    }
    
}
