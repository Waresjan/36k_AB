package lanou.a36k_ab.homepage.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;

import lanou.a36k_ab.R;
import lanou.a36k_ab.homepage.recommend.GlideImageLoader;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends android.support.v4.app.Fragment {

   private ArrayList<String>pics = new ArrayList<>();
    String url1 = "http://img.boqiicdn.com/Data/BK/A/1411/26/img77931416972193.jpg";
    String url2 = "http://pic29.nipic.com/20130506/3822951_102005116000_2.jpg";
    String url3 = "http://pic36.nipic.com/20131125/8821914_090743677000_2.jpg";
    String url4 = "http://pic36.nipic.com/20131125/8821914_090743677000_2.jpg";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage_recommend,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pics.add(url1);
        pics.add(url2);
        pics.add(url3);
        pics.add(url4);
        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
       //设置图片加载
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(pics);
        //设置banner的动画效果
        banner.setBannerTitles(Arrays.asList("Title1", "title2", "title3","title4"));
        //设置自动轮播  默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //设置指示器(banner模式中自带指示器)
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕后最后调用
        banner.start();
    }
}
