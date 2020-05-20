package com.spryl.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ceviriler {
	 public static String characterKontrol(String data)
		{
			if (data == null)
				return null;
			if (data.trim().length() > 0) 
			{
				data = data.trim().replaceAll("[^a-zA-Z0-9\\._:,;-ÇçŞşĞğÜüİıÖö ]", "");
			}

			return data;
		} 
	 
	 public static int mailAdresSayi(String[] mailadresler)	 
	 {
		 int i = 0;
		 String toadreslerString = "";
		 for (String mail : mailadresler) 
		 {
			 if (!mail.equals("") && !mail.equals("null")) 
			 {	 
				 if (toadreslerString.indexOf(mail) == -1) i++;
				 toadreslerString = toadreslerString + mail + ";";
			 }
		}
		 return i;
		 
	 }
	 
	 public static String getCurrent_Date() {			
			return new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
		}
}
