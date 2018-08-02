package com.example.day10.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.day10.Bean.XlistBean;
import com.example.day10.R;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class MyBase extends BaseAdapter {
    private Context context;
    private List<XlistBean.DataBean> data;

    public MyBase(Context context, List<XlistBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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

        ViewHolder holder = null;
        if (view == null){
            view = View.inflate(context, R.layout.mybase,null);
            holder = new ViewHolder();
            holder.textView = view.findViewById(R.id.textView);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.textView.setText(data.get(i).getTitle());


        return view;
    }
    class  ViewHolder{
        TextView textView;
    }
}
