package lanou.a36k_ab.FlowLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by dllo on 16/10/15.
 */
public class ways {
    public static String readUrl(String pathStr) {
        String result = new String();
        try {
            URL url = new URL(pathStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int code = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == code) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                connection.disconnect();

            }
        } catch (MalformedURLException e) {
            // TODO: handle exception
        } catch (IOException e) {
            // TODO: handle exception
        }
        return result;
    }
    public static ArrayList<FlowLayoutBean> JSONlun(String data, String code) {
        ArrayList<FlowLayoutBean> lunbos = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray(code);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (i == 0) {
                    FlowLayoutBean lunboBean = new FlowLayoutBean();
                    if (obj.has("imgsrc")) {
                        lunboBean.setImagelin(obj.getString("imgsrc"));
                    }
                    if (obj.has("title")) {
                        lunboBean.setTitlelun(obj.getString("title"));
                    }
                    lunbos.add(lunboBean);
                    if (obj.has("ads")) {
                        JSONArray objImgs = obj.getJSONArray("ads");
                        for (int j = 0; j < objImgs.length(); j++) {
                            JSONObject object = objImgs.getJSONObject(j);
                            FlowLayoutBean lunboBean1 = new FlowLayoutBean();
                            if (object.has("title")) {
                                lunboBean1.setTitlelun(object.getString("title"));
                            }
                            if (object.has("imgsrc")) {
                                lunboBean1.setImagelin(object.getString("imgsrc"));
                            }
                            lunbos.add(lunboBean1);
                        }
                        continue;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lunbos;
    }
    public static Bitmap imageParse(String ima) {
        Bitmap bit = null;
        try {
            URL url = new URL(ima);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                InputStream inputStream = connection.getInputStream();
                bit = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                connection.disconnect();
            }
        } catch (MalformedURLException e) {
            // TODO: handle exception
        } catch (IOException e) {
            // TODO: handle exception
        }
        return bit;
    }

}
