package lanou.a36k_ab.video;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class VideoAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments2;

    public void setFragments2(ArrayList<Fragment> fragments2) {
        this.fragments2 = fragments2;
    }

    ArrayList<Fragment>fragments1;
    String[] strings = {"最新","频道"};

    public VideoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments2.get(position);
    }

    @Override
    public int getCount() {
        return fragments2 == null ? 0 :fragments2.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}

