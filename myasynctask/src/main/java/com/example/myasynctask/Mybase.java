package com.example.myasynctask;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class Mybase extends BaseAdapter {
    private Context context;
    private List<ConstellationBean.ResultBean.DataBean> list;

    public Mybase(Context context, List<ConstellationBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = View.inflate(context, R.layout.mybase, null);
            holder = new ViewHolder();
            holder.error_code = view.findViewById(R.id.error_code);
            holder.reason = view.findViewById(R.id.reason);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.error_code.setText(list.get(i).getContent());

        return view;
    }
    class ViewHolder{
        TextView error_code,reason;
    }
}
