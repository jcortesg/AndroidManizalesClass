package com.example.androidmanizales;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class SubidaDatos {

	private final String Logs = "LOG";
	
	public String getClima (String ciudad, String pais){
		String Res = null;
		SoapObject rpc;
		rpc = new SoapObject("http://www.webserviceX.NET", "GetWeather");
		
		rpc.addProperty("CityName" , ciudad);
		rpc.addProperty("CountryName", pais);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope( SoapEnvelope.VER11);
		envelope.bodyOut = rpc;
		envelope.dotNet =true;
		envelope.encodingStyle = SoapSerializationEnvelope.XSD;
		HttpTransportSE Transporte = null;

		try{
			String conexion = "htttp://www.websevicex.net/globalweather.asmx";
			Transporte = new HttpTransportSE(conexion);
			Transporte.debug =true;
			Transporte.call("http://www.webserviceX.NET/GetWeather", envelope);
			Res =envelope.getResponse().toString();
			
		}catch(Exception e){
			Log.e("Logs", "Error al subir datos"+ e.toString());
			//System.out.print(e.getMessage());
			Res = e.getMessage();
		}
		return Res;
	}



}
