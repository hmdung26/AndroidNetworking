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
import java.net.URL;
import java.net.URLEncoder;

public class backgoundTask_POSTC extends AsyncTask<Void , Void , Void> {
    String duongdan = exercise3.NameServer;
    Context context;
    String canh;
    TextView tv_resultTT;
    String resutl;

    public backgoundTask_POSTC(Context context, String canh, TextView tv_resultTT) {
        this.context = context;
        this.canh = canh;
        this.tv_resultTT = tv_resultTT;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(duongdan);
            String link = "canh=" + URLEncoder.encode(canh,"utf-8");
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
            resutl = stringBuffer.toString();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        tv_resultTT.setText(resutl);
    }
}
