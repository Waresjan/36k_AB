package lanou.a36k_ab.FlowLayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/15.
 */
public class FlowLayoutAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<ImageView> imageViews;

    public FlowLayoutAdapter(Context context, ArrayList<ImageView> imageViews) {
        this.context = context;
        this.imageViews = imageViews;
    }

    public FlowLayoutAdapter(){

    }

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(imageViews.get(position));
        // container.removeViewAt(position);

    }

    //
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

}
