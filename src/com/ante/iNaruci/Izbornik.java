package com.ante.iNaruci;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Izbornik extends Activity {

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni_izbornik);
        
        Bundle extras = getIntent().getExtras();
        String rezultat = null;
        if (extras != null) {
            rezultat = extras.getString("rezultat");
        }
        
        String[] polje = rezultat.split(",");
        
        int IDKafica = 0;
        int brojStola = 0;
        
        try
        {
        	IDKafica = Integer.parseInt(polje[0]);
        	brojStola = Integer.parseInt(polje[1]);
        }
        
        catch(Exception e)
        {        	
        }
        
        TextView tVkaficStol = (TextView)findViewById(R.id.tVkaficStol);
        
        
        switch (IDKafica) 
        {
			case 1:		
				StringBuilder sb1 = new StringBuilder();
				sb1.append("Kafic: Modena, Broj stola: " + brojStola);
				
				tVkaficStol.setText(sb1);
				break;
	
			case 2:		
				StringBuilder sb2 = new StringBuilder();
				sb2.append("Kafic: Mistral, Broj stola: " + brojStola);
				
				tVkaficStol.setText(sb2);
				break;
				
			case 3:		
				StringBuilder sb3 = new StringBuilder();
				sb3.append("Kafic: Kongo, Broj stola: " + brojStola);
				
				tVkaficStol.setText(sb3);
				break;
				
			default:
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Greška prilikom skeniranja koda!");
				alertDialog.setMessage("Pokušajte ponovno!");
				alertDialog.setButton("U redu", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int which) {
					   Intent intent = new Intent(Izbornik.this, MainActivity.class);
			        	startActivity(intent);
				   }
				});
				// Set the Icon for the Dialog
				alertDialog.show();
				break;
		}
        
        Button btnNaruci = (Button)findViewById(R.id.btnNaruci);
        Button btnPozoviOsoblje = (Button)findViewById(R.id.btnPozoviOsoblje);           
        
        btnNaruci.setOnClickListener
        (new Button.OnClickListener()
        {
	        public void onClick(View v)
	        {
	        	Intent intent = new Intent(Izbornik.this, Ponuda.class);
	        	startActivity(intent); 
	        }
        }
		);
        
        btnPozoviOsoblje.setOnClickListener
        (new Button.OnClickListener()
        {
	        public void onClick(View v)
            {
	        	Intent intent = new Intent(Izbornik.this, PozoviOsoblje.class);
	        	startActivity(intent); 
            }
        }
		);
    }
}
