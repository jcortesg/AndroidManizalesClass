package com.example.androidmanizales;

import com.example.androidmanizales.MainActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Activity2Activity extends Activity {
	private ProgressDialog pd;
	private TextView pais;
	private TextView ciudad;
	private Button Btnenvio;
	private String Res;
	private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        context = this;
        ciudad =(TextView)findViewById(R.id.Ciudad);
        pais = (TextView)findViewById(R.id.Pais);
     
        
        Intent conector = getIntent();
        String[] user1 = conector.getStringArrayExtra(MainActivity.Extra_mj);
        TextView text = (TextView) findViewById(R.id.User1); 
        text.setText(user1[0]);
      
      // Toast noti =Toast.makeText(this, "Usted se Logueo como "+ user1[0] , Toast.LENGTH_LONG);
      // noti.show();       
    }
   
    public void xx(View arg0){
		new Descarga().execute("");
		pd = ProgressDialog.show(context, "Un segundo","Consultando el clima",true, false);
	}
    ;
   
    private class Descarga extends AsyncTask <String, Void, Object>{
   @Override
    	protected Integer doInBackground(String... args){
			SubidaDatos ws=new SubidaDatos();
			Res = ws.getClima(ciudad.getText().toString(),pais.getText().toString());
			Log.Res(Res.toString());
			return 1;
   		}
   
   		protected void onPostExecute (Object result){
   				pd.dismiss();
   				Toast.makeText(context,"Clima"+ Res ,Toast.LENGTH_LONG).show();
   				super.onPostExecute(result);
  }
    
   }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity2, menu);
        return true;
    }
    
    public void Salir(View v){
    	finish();
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event){
    	if(keyCode != KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0);{
    		return true;
    	}
    }
}


















