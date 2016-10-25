package lanou.a36k_ab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import lanou.a36k_ab.concern.ConcernFragment;
import lanou.a36k_ab.find.FindFragment;
import lanou.a36k_ab.homepage.HomepageFragment;
import lanou.a36k_ab.mine.MineFragment;
import lanou.a36k_ab.video.VideoFragment;


/**
 * Created by dllo on 16/10/24.
 */
public class Mainactivity extends FragmentActivity implements View.OnClickListener{

    //下方五个标题
    private RadioButton tabHomepage ,tabConcern , tabfind,tabmine,tabvideo;
    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        tabHomepage = (RadioButton) findViewById(R.id.homepage);
        tabConcern = (RadioButton) findViewById(R.id.concern);
        tabfind = (RadioButton) findViewById(R.id.find);
        tabmine = (RadioButton) findViewById(R.id.mine);
        tabvideo = (RadioButton) findViewById(R.id.video);

        tabHomepage.setChecked(true);
        // 第一次打开界面，首页需要显示内容，因此在onCreate中替换一次

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_view, new HomepageFragment());
        transaction.commit();

        tabHomepage.setOnClickListener(this);
        tabfind.setOnClickListener(this);
        tabConcern.setOnClickListener(this);
        tabvideo.setOnClickListener(this);
        tabmine.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.homepage:
                transaction.replace(R.id.main_view, new HomepageFragment());
                break;
            case R.id.concern:
                transaction.replace(R.id.main_view, new ConcernFragment());
                break;
            case R.id.find:
                transaction.replace(R.id.main_view, new FindFragment());
                break;

            case R.id.video:
                transaction.replace(R.id.main_view, new VideoFragment());
                break;

            case R.id.mine:
                transaction.replace(R.id.main_view, new MineFragment());
                break;
        }
        transaction.commit();
    }

}
