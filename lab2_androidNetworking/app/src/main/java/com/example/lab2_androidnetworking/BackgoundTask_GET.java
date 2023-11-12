package com.example.lab2_androidnetworking;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgoundTask_GET extends AsyncTask<Void, Void ,Void> {


String duongdan = MainActivity.NameServer;
Context context;
TextView tv_result;
String name,score;
String str;

    public BackgoundTask_GET(Context context, TextView tv_result, String name, String score) {
        this.context = context;
        this.tv_result = tv_result;
        this.name = name;
        this.score = score;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        duongdan += "?name=" +this.name + "&score=" + this.score;

        try {
            URL url = new URL(duongdan);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line = "";
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            str = stringBuffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        tv_result.setText(str);
    }
}
