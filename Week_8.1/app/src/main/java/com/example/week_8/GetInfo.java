package com.example.week_8;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetInfo extends Thread {

    public String info;

    public void run(){
        try {
            info="";

            // the Google Drive URL needs to be reformatted as per the earlier discussion
            URL url = new URL("https://drive.google.com/uc?id=1T1MkZZoN0kt3iHk18cGV1hrgA5S1dMOq");
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(2000);

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);

            String str;

            while ((str = br.readLine()) != null) {
                info=info.concat(str);
            }

            in.close();

        } catch (Exception e) {
            Log.d("MyTag",e.toString());
        }
    }

}