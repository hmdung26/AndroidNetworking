package com.example.lab2_androidnetworking;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class backgroundTask_POSTPT2 extends AsyncTask<String , Void , Void> {
    Context context;
    TextView tv_resultPT2;
    String strResultPT2;
    String duongdan = exercise4.NameServer;

    public backgroundTask_POSTPT2(Context context, TextView tv_resultPT2) {
        this.context = context;
        this.tv_resultPT2 = tv_resultPT2;
    }

    @Override
    protected Void doInBackground(String... strings) {

        try {
            URL url = new URL(duongdan);
            String link = "a=" + URLEncoder.encode(strings[0].toString(),"utf-8") +  "&b=" +
                    URLEncoder.encode(strings[1].toString(),"utf-8")  +  "&c=" +
                    URLEncoder.encode(strings[2].toString(),"utf-8");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setFixedLengthStreamingMode(link.getBytes().length);
            httpURLConnection.setRequestProperty("context-Type", "application/x-www-form-urlencoded");
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.print(link);
            printWriter.close();
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            strResultPT2 = stringBuffer.toString();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        tv_resultPT2.setText(strResultPT2);
    }
}
