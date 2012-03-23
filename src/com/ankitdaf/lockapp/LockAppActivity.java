/* 
 * 
 * Copyright 2012 Ankit Daftery
 * All Rights Reserved
 * 
 */

package com.ankitdaf.lockapp;

import android.app.Activity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LockAppActivity extends Activity {

    /** Called when the activity is first created. */
    EditText password;	
    Button submit;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        password = (EditText) findViewById(R.id.pass);
        submit = (Button) findViewById(R.id.submit);
        submitaction(submit);
    }
	
	/*
	 *  Disables keypress, home and back keys
	 */
	
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }
    
    /*
     * Locks the screen,sets it as a keyguard
     */
    @Override
    public void onAttachedToWindow() {
        // TODO Auto-generated method stub
        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
        super.onAttachedToWindow();
    }
    
    /*
     * Method to implement action to be carried out when Submit is clicked
     * Checks password and unlocks if password is correct
     */

    private void submitaction(Button submit)
    {
    	submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {			
				if (password.getText().toString().equals("unlock"))
		        {
				LockAppActivity.this.finish();
		        }
				else
				{
				Toast.makeText(getApplicationContext(), "Incorrect password : " + password.getText().toString(), Toast.LENGTH_SHORT).show();	
				}
				}
				}
        );
    }

}