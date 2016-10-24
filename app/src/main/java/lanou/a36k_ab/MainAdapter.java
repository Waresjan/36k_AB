package lanou.a36k_ab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class MainAdapter extends FragmentPagerAdapter {
    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    ArrayList<Fragment>fragments;
    String [] strings = {"首页","关注","发现","视频","我的"};


    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 :fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
