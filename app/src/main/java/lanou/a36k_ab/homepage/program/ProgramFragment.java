package lanou.a36k_ab.homepage.program;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

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

import lanou.a36k_ab.FlowLayout.FlowLayoutAdapter;
import lanou.a36k_ab.FlowLayout.FlowLayoutBean;
import lanou.a36k_ab.FlowLayout.ways;
import lanou.a36k_ab.R;
import lanou.a36k_ab.SQLlite.DBtools;
import lanou.a36k_ab.homepage.program.ProgramAdapter;
import lanou.a36k_ab.homepage.program.ProgramBean;

/**
 * Created by dllo on 16/10/24.
 */
public class ProgramFragment extends android.support.v4.app.Fragment {
    private ProgramAdapter headAdapter;
    private ArrayList<ProgramBean> mArrayList;
    private PullToRefreshListView lv_head;
    private DBtools tools;
    private ArrayList<FlowLayoutBean> lunbotubeenbo;
    private ViewPager Viewpagerlunbo;
    private TextView lun_tv;
    private int currItem;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage_program,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        View lunbo_view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_flowlayout, null);



        lun_tv = (TextView) lunbo_view.findViewById(R.id.lun_tit);
        Viewpagerlunbo = (ViewPager) lunbo_view.findViewById(R.id.vp_lunbo);


        lv_head = (PullToRefreshListView) view.findViewById(R.id.lv_head);
        lunbotubeenbo  = new ArrayList<>();
        mArrayList = new ArrayList();
        headAdapter = new ProgramAdapter(getActivity());
        headAdapter.setmBeanArrayList(mArrayList);
        lv_head.setAdapter(headAdapter);
        final String str = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=all&pagingAction=up";


        HeadAsyncTask headAsyncTask = new HeadAsyncTask();
        headAsyncTask.execute(str);
        //罗博图请求
        lunBoTu lunboqq = new lunBoTu();
        lunboqq.execute(str);

        tools = new DBtools(getContext());
        mArrayList=  tools.QueryTableheadbean();
//把pull listview 转换成listview 然后add HeadTiao
        ListView listView1 = lv_head.getRefreshableView();
        listView1.addHeaderView(lunbo_view);

        //刷新和加载

        lv_head.setMode(PullToRefreshBase.Mode.BOTH);

        lv_head.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                mArrayList.clear();
                HeadAsyncTask headAsyncTask1 = new HeadAsyncTask();
                headAsyncTask1.execute(str);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                HeadAsyncTask headAsyncTask1 = new HeadAsyncTask();
                headAsyncTask1.execute("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=all&pagingAction=up");
            }
        });

    }
//解析首页的文字图片

    class HeadAsyncTask extends AsyncTask<String ,Integer, ArrayList<ProgramBean>> {

        @Override
        protected ArrayList<ProgramBean> doInBackground(String... params) {


            try {
                URL url  = new URL(params[0]);

                HttpURLConnection connection = (HttpURLConnection)url.openConnection();

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    InputStream is = connection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(is);
                    BufferedReader bufferdreader = new BufferedReader(reader);
                    String line = "";
                    String result = new String();

                    while((line = bufferdreader.readLine()) != null ){
                        result += line;
                    }

                    bufferdreader.close();
                    reader.close();
                    is.close();
                    connection.disconnect();



                    JSONObject object = new JSONObject(result);

                    if(object.has("T1348647909107")){
                        JSONArray array = object.getJSONArray("T1348647909107");
                        for (int i = 0; i <array.length() ; i++) {
                            JSONObject object1 = (JSONObject)array.get(i);

                            ProgramBean bean = new ProgramBean();

                            if(object1.has("title")){
                                bean.setTitle(object1.getString("title"));
                            }
                            if (object1.has("imgsrc")){
                                bean.setImgUrl(object1.getString("imgsrc"));
                            }
                            mArrayList.add(bean);
                            tools.insertProgramFragment(bean);
                        }
                    }
                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return mArrayList;



        }

        @Override
        protected void onPostExecute(ArrayList<ProgramBean> headBeen) {

            headAdapter.setmBeanArrayList(headBeen);
            headAdapter.notifyDataSetChanged();
            lv_head.onRefreshComplete();
        }



    }
    //轮播图的解析
    class  lunBoTu extends AsyncTask<String ,Void ,ArrayList<Bitmap>>{


        @Override
        protected ArrayList<Bitmap> doInBackground(String ... params) {
            ArrayList<Bitmap> arrayList = new ArrayList<>();
            lunbotubeenbo = new ArrayList<>();
            lunbotubeenbo = ways.JSONlun(ways.readUrl(params[0]), "T1348647909107");

            for (int i = 0; i < lunbotubeenbo.size(); i++) {


                Bitmap bitmap = ways.imageParse(lunbotubeenbo.get(i).getImagelin());
                arrayList.add(bitmap);
            }
            return arrayList;


        }

        @Override
        protected void onPostExecute(ArrayList<Bitmap> bitmaps) {
            super.onPostExecute(bitmaps);

            ImageView iv;
            ArrayList<ImageView> imageViews = new ArrayList<>();
            for (int i = 0; i < bitmaps.size(); i++) {
                iv = new ImageView(getContext());
                iv.setImageBitmap(bitmaps.get(i));
                imageViews.add(iv);
            }

            lun_tv.setText(lunbotubeenbo.get(1).getTitlelun());
            Viewpagerlunbo.setAdapter(new FlowLayoutAdapter(getContext(), imageViews));


            Viewpagerlunbo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                }

                @Override
                public void onPageSelected(int position) {
                    lun_tv.setText(lunbotubeenbo.get(position % lunbotubeenbo.size()).getTitlelun());
                    currItem = position;
                    Log.d("lunBoTu+", "position:" + position);
                    Log.d("lunBoTu+", "来打我啊");
                }

                @Override
                public void onPageScrollStateChanged(int state) {


                }

            });





        }
    }
    }



