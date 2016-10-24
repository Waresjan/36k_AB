package lanou.a36k_ab.homepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class HomepageAdapter extends FragmentPagerAdapter {

    public void setFragments1(ArrayList<Fragment> fragments1) {
        this.fragments1 = fragments1;
    }

    ArrayList<Fragment>fragments1;
        String[] strings = {"视讯","推荐","早起项目"};

    public HomepageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments1.get(position);
    }

    @Override
    public int getCount() {
        return fragments1 == null ? 0 :fragments1.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
