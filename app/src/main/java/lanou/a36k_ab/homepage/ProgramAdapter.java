package lanou.a36k_ab.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lanou.a36k_ab.R;

/**
 * Created by dllo on 16/9/29.
 */
public class ProgramAdapter extends BaseAdapter {

    Context mContext;

    public ProgramAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<ProgramBean> mBeanArrayList;

    public void setmBeanArrayList(ArrayList<ProgramBean> mBeanArrayList) {
        this.mBeanArrayList = mBeanArrayList;
    }

    @Override
    public int getCount() {
        return mBeanArrayList == null ? 0 : mBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_homepage_program_item,null);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        viewHolder.tv.setText(mBeanArrayList.get(position).getTitle());

        Picasso.with(mContext).load(mBeanArrayList.get(position).getImgUrl()).into(viewHolder.iv);


        return convertView;
    }

    private class MyViewHolder {

        private final TextView tv;
        private final ImageView iv;

        public MyViewHolder(View convertView) {

            iv = (ImageView) convertView.findViewById(R.id.item_iv);
            tv = (TextView) convertView.findViewById(R.id.item_tv);

        }

    }
}
