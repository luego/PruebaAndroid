package com.topicos.pruebaandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.location.*;

public class MainActivity extends Activity {
	
	//GUI
	Button bt;
	TextView tv;
	TextView alertaTxt;
	
	//Locations
	LocationManager lm;
	LocationListener ll;
	Location locDestBloqueG;
	Location locRoble;
	Location locIglesiaSanJuanBautista;
	Location locClinicaAsuncion;
	Location locPortalPrado;
	Location locColegioHebreo;
	
	//varriables estaticas
	final float CINCUENTA_MT = 50;
	final float CIEN_MT = 100;
	final float QUINIENTOS_MT = 500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Lugares
		this.locDestBloqueG = this.localizacionBuilder(11.01963352438345,
				-74.84984238588302);
		this.locRoble = this.localizacionBuilder(11.01963352438345,
				-74.84984238588302);
		this.locIglesiaSanJuanBautista = this.localizacionBuilder(
				10.978537736773477, -74.8162250282669);
		this.locClinicaAsuncion = this.localizacionBuilder(10.987964158787392,
				-74.80886504673003);
		this.locPortalPrado = this.localizacionBuilder(10.98894364682612,
				-74.78921518348693);
		this.locColegioHebreo = this.localizacionBuilder(10.998927919995998,
				-74.82311830543517);

		lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		ll = new LocationListener() {

			@Override
			public void onLocationChanged(Location loc) {
				//Si no lo redondeo pueda que los decimales no hagan que concuerden con exactitud
				
				float result = Math.round(loc.distanceTo(locDestBloqueG));
				String alertaTemp = "Ningún lugar cerca";
				tv.setText("Lat:" + loc.getLatitude() + " ,Log: "
						+ loc.getLongitude());
				// BLoque G

				if (result == CINCUENTA_MT) {
					alertaTemp = "Usted esta a 50 mts del bloque G de Posgrados";
				} else if (result == CIEN_MT) {
					alertaTemp = "Usted esta a 100 mts del bloque G de Posgrados";
				} else if (result == QUINIENTOS_MT) {
					alertaTemp = "Usted esta a 500 mts del bloque G de Posgrados";
				}

				result = Math.round(loc.distanceTo(locRoble));
				if (result == CINCUENTA_MT) {
					alertaTemp = "Usted esta a 50 mts del Roble Amarillo";
				} else if (result == CIEN_MT) {
					alertaTemp = "Usted esta a 100 mts del Roble Amarillo";
				} else if (result == QUINIENTOS_MT) {
					alertaTemp = "Usted esta a 500 mts del Roble Amarillo";
				}

				result = Math.round(loc.distanceTo(locIglesiaSanJuanBautista));
				if (result == CINCUENTA_MT) {
					alertaTemp = "Usted esta a 50 mts de la Iglesia SanJuan Bautista";
				} else if (result == CIEN_MT) {
					alertaTemp = "Usted esta a 100 mts de la Iglesia SanJuan Bautista";
				} else if (result == QUINIENTOS_MT) {
					alertaTemp = "Usted esta a 500 mts de la Iglesia SanJuan Bautista";
				}

				result = Math.round(loc.distanceTo(locClinicaAsuncion));
				if (result == CINCUENTA_MT) {
					alertaTemp = "Usted esta a 50 mts de la Clinica Asuncion";
				} else if (result == CIEN_MT) {
					alertaTemp = "Usted esta a 100 mts de la Clinica Asuncion";
				} else if (result == QUINIENTOS_MT) {
					alertaTemp = "Usted esta a 500 mts de la Clinica Asuncion";
				}

				result = Math.round(loc.distanceTo(locPortalPrado));
				if (result == CINCUENTA_MT) {
					alertaTemp = "Usted esta a 50 mts del Portal del Prado";
				} else if (result == CIEN_MT) {
					alertaTemp = "Usted esta a 100 mts del Portal del Prado";
				} else if (result == QUINIENTOS_MT) {
					alertaTemp = "Usted esta a 500 mts del Portal del Prado";
				}

				result = Math.round(loc.distanceTo(locColegioHebreo));
				if (result == CINCUENTA_MT) {
					alertaTemp = "Usted esta a 50 mts del ColegioHebreo";
				} else if (result == CIEN_MT) {
					alertaTemp = "Usted esta a 100 mts del ColegioHebreo";
				} else if (result == QUINIENTOS_MT) {
					alertaTemp = "Usted esta a 500 mts del ColegioHebreo";
				}
				alertaTxt.setText(alertaTemp);
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub

			}

		};

		bt = (Button) findViewById(R.id.btnHola);
		tv = (TextView) findViewById(R.id.textView1);
		alertaTxt = (TextView) findViewById(R.id.alertaTxt);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
		bt.setOnClickListener(buttonListener);

	}

	public Location localizacionBuilder(double lat, double log) {
		Location loc = new Location(LocationManager.GPS_PROVIDER);
		loc.setLatitude(lat);
		loc.setLongitude(log);
		return loc;
	}

	public OnClickListener buttonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			changeText();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void changeText() {
		// TODO Auto-generated method stub
		// tv.setText("Hola Uninorte!!");

		// lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
		Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if (loc != null)
			tv.setText("Lat:" + loc.getLatitude() + " ,Log:"
					+ loc.getLongitude());
		else
			tv.setText("Location : UnKnown");
	}
}
