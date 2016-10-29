package lanou.a36k_ab.SQLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

import lanou.a36k_ab.homepage.program.ProgramBean;

/**
 * Created by dllo on 16/10/14.
 */
public class DBtools {
    private SQLiteDatabase database;
    public DBtools(Context context) {

        MySQLHelper helper = new MySQLHelper
                (context, "news.db" , null , 1);
        database = helper.getWritableDatabase();
    }


    public void insertHeadTiao(ProgramBean bean) {
   Cursor cursor= database.query("headtiao",null,"title = ?",new String[]{bean.getTitle()},null,null,null);
        if (cursor != null){
           int count = cursor.getCount();
            if (count > 0){
                return;
            }

             ContentValues values = new ContentValues();
             values.put("title",bean.getTitle());
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            bean.getImgUrl().compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//
//            byte[] iconResult = outputStream.toByteArray();
              values.put("imgUrl",bean.getImgUrl());



            database.insert("headtiao",null,values);
        }


    }

    public ArrayList<ProgramBean> QueryTableheadbean( ) {
        ArrayList<ProgramBean> bean = new ArrayList<>();
     Cursor cursor =   database.query("headtiao",null,null,null,null,null,null);
        if (cursor != null){
            while (cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String imgUrl = cursor.getString(cursor.getColumnIndex("imgUrl"));
                ProgramBean beenn = new ProgramBean();
                beenn.setImgUrl(imgUrl);
                beenn.setTitle(title);
                bean.add(beenn);

            }
        }

   return bean;

    }

    public void insertProgramFragment(ProgramBean bean) {

    }
}
