package com.example.zhongyulong20182611;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/11.
 */

public class Mybaes extends BaseAdapter {
    private Context context;
    private List<UserBean.DataBean.DatasBean> list;

    public Mybaes(Context context, List<UserBean.DataBean.DatasBean> list) {
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
        if (view==null){
            holder = new ViewHolder();
            view = View.inflate(context,R.layout.mybase,null);

            holder.text1 = view.findViewById(R.id.text1);
            holder.text2 = view.findViewById(R.id.text2);
            holder.text3 = view.findViewById(R.id.text3);

            view.setTag(holder);
        }else{

            holder = (ViewHolder) view.getTag();
        }

        holder.text1.setText((CharSequence) list.get(i).getEnvelopePic());
        holder.text2.setText(list.get(i).getAuthor());
        holder.text3.setText(list.get(i).getChapterName());

        return  view;
        }

    }
    class ViewHolder{
        TextView text1,text2,text3;
    }


