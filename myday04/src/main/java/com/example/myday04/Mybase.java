package com.example.myday04;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

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
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){

            convertView = View.inflate(context,R.layout.mybase,null);
            holder = new ViewHolder();
            holder.item_Error_code = convertView.findViewById(R.id.item_Error_code);
            holder.item_Reason = convertView.findViewById(R.id.item_Reason);
            convertView.setTag(holder);
        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        holder.item_Error_code.setText(list.get(position).getContent());


        return convertView;
    }

    class ViewHolder{

        TextView item_Error_code,item_Reason;

    }
}
