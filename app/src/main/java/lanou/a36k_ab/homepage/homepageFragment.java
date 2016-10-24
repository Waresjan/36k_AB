package lanou.a36k_ab.homepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.a36k_ab.R;

/**
 * Created by dllo on 16/10/21.
 */
public class HomepageFragment extends Fragment {
    private ViewPager homepage_vp;
    private TabLayout homepage_tl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage,null);
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_homepage);
//
//        homepage_vp = (ViewPager) findViewById(R.id.homepage_vp);
//        homepage_tl = (TabLayout) findViewById(R.id.Main_tl);
//
//        ArrayList<Fragment> fragments1 = new ArrayList<>();
//        fragments1.add(new FlashFragment());
//        fragments1.add(new RecommendFragment());
//        fragments1.add(new ProgramFragment());
//
//        HomepageAdapter adapter =
//                new HomepageAdapter(getSupportFragmentManager());
//        adapter.setFragments1(fragments1);
//        homepage_vp.setAdapter(adapter);
//        homepage_tl.setupWithViewPager(homepage_vp);
//
//
//    }
}
