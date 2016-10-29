package lanou.a36k_ab.video;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.a36k_ab.R;
import lanou.a36k_ab.homepage.HomepageAdapter;

/**
 * Created by dllo on 16/10/21.
 */
public class VideoFragment extends Fragment {
    private ViewPager video_vp;
    private TabLayout video_tl;
    private FragmentManager supportFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       video_vp = (ViewPager) view.findViewById(R.id.video_vp);
        video_tl = (TabLayout) view.findViewById(R.id.video_tl);

        ArrayList<Fragment> fragments2 = new ArrayList<>();
        fragments2.add(new ChannelFragment());
        fragments2.add(new NewFragment());


        HomepageAdapter adapter =
                new HomepageAdapter(getActivity().getSupportFragmentManager());
        adapter.setFragments1(fragments2);
        video_vp.setAdapter(adapter);
        video_tl.setupWithViewPager(video_vp);


    }


}


