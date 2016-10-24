package lanou.a36k_ab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import lanou.a36k_ab.concern.concernFragment;
import lanou.a36k_ab.find.findFragment;
import lanou.a36k_ab.homepage.homepageFragment;
import lanou.a36k_ab.mine.mineFragment;
import lanou.a36k_ab.video.videoFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//找到组件
        vp = (ViewPager) findViewById(R.id.Main_vp);
        tl = (TabLayout) findViewById(R.id.Main_tl);

//建立集合
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new homepageFragment());
        fragments.add(new concernFragment());
        fragments.add(new findFragment());
        fragments.add(new videoFragment());
        fragments.add(new mineFragment());

        //绑定适配器
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);


    }
}
