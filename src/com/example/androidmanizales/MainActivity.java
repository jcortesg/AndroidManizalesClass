package com.example.androidmanizales;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	
	public final static String Extra_mj= "com.example.androidmanizales.Hola";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Resources res = this.getResources();
        String[] lista= res.getStringArray(R.array.lista);
        
        TextView linea = (TextView)findViewById(R.id.lista1);
        linea.setText(lista[1]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void login (View view){
    	
    	String Hola[]= new String[2];
    	EditText nombre  = (EditText)findViewById(R.id.Hola1);
    	EditText pass = (EditText)findViewById(R.id.pass);
    	Hola[0] = nombre.getText().toString();
    	Hola[1] = pass.getText().toString();
 
    	
    if(checkpresent( Hola[1], Hola[0]) == true){
    		
    		Intent conector = new Intent(this, Activity2Activity.class);
    		conector.putExtra(Extra_mj, Hola);
        	startActivity(conector);
    	}
    	else{
    		Error();
    	}
    }
    
    
     //hacemos vibrar el telefono
    
    public void Error(){
    	Vibrator vibrar =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	vibrar.vibrate(800);
    	
    	Toast notif = Toast.makeText(this,"Pon algo en los campos", Toast.LENGTH_LONG);
    	notif.show();
	
    }
    
    //validamos presencia
    
    public boolean checkpresent (String pass , String user){
    	if(user.equals("") || pass.equals("") ) {
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    } 
