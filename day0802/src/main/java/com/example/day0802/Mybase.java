package com.example.day0802;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class Mybase extends BaseAdapter {
    private List<String> list;
    private Context context;

    public Mybase(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holderl;
        if (view == null) {
            view = View.inflate(context, R.layout.mybase,null);
            holderl = new ViewHolder();
            holderl.imageView = view.findViewById(R.id.img);
            view.setTag(holderl);
        }else {
            holderl = (ViewHolder) view.getTag();
        }
        String s = list.get(i);
        ImageLoader.getInstance().displayImage(s,holderl.imageView,MyApplication.getOptions());

        return view;
    }
    class ViewHolder{
ImageView imageView;
    }
}
