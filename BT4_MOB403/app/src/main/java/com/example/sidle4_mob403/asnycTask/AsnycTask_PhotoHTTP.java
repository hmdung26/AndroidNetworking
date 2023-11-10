package com.example.sidle4_mob403.asnycTask;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sidle4_mob403.MainActivity;
import com.example.sidle4_mob403.adapter.adapterPhoto;
import com.example.sidle4_mob403.model.photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AsnycTask_PhotoHTTP extends AsyncTask<Void, Void ,Void> {
    String duongdan = MainActivity.NameServer;
    Context context;
    RecyclerView rcv_photo;
    adapterPhoto adapterPhoto;

    public AsnycTask_PhotoHTTP(Context context, RecyclerView rcv_photo) {
        this.context = context;
        this.rcv_photo = rcv_photo;
    }

    photo pt;
    String str;
    @Override
    protected Void doInBackground(Void... voids) {
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

        try {
            JSONArray jsonArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jsonArray.length(); i++) {
//                photo pt = (photo) jsonArray.get(i);
//                String title = pt.getTitle();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int albumId = jsonObject.getInt("albumId");
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                String url = jsonObject.getString("url");
                String thumbnailUrl = jsonObject.getString("thumbnailUrl");
                Log.d(TAG, "onPostExecute: " + thumbnailUrl);
                photo pt = new photo(id,albumId,title,url,thumbnailUrl);
                arrayList.add(pt);
            }
            Log.d(TAG, "onPostExecute: " + arrayList);
            adapterPhoto =  new adapterPhoto(context,arrayList);
            rcv_photo.setAdapter(adapterPhoto);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
