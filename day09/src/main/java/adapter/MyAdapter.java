package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day09.MyAppilaction;
import com.example.day09.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import Bean.CocietyBean;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<CocietyBean.ResultBean.DataBean> list;
    private  final  int ONE_ITEM = 0;
    private  final  int TWO_ITEM = 1;
    private  final  int THREE_ITEM = 2;

    public MyAdapter(Context context, List<CocietyBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getViewTypeCount() {

        return 3;
    }


    @Override
    public int getItemViewType(int position) {
        String thumbnail_pic_s = list.get(position).getThumbnail_pic_s();
        String thumbnail_pic_s02 = list.get(position).getThumbnail_pic_s02();
        String thumbnail_pic_s03 = list.get(position).getThumbnail_pic_s03();

        if (thumbnail_pic_s!=null&&thumbnail_pic_s02==null&&thumbnail_pic_s03==null){
            return ONE_ITEM;
        }else if (thumbnail_pic_s != null && thumbnail_pic_s02 != null && thumbnail_pic_s03 ==null){
            return TWO_ITEM;
        }else if (thumbnail_pic_s != null && thumbnail_pic_s02 != null && thumbnail_pic_s03 !=null){
            return THREE_ITEM;
        }else {
            return ONE_ITEM;
        }
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
        int type = getItemViewType(i);
        if (type == ONE_ITEM){
            OneViewHplder oneViewHplder;
            if (view == null) {
                view = View.inflate(context,R.layout.item_one,null);

                oneViewHplder = new OneViewHplder();
                oneViewHplder.imageView = view.findViewById(R.id.img);

                oneViewHplder.textView = view.findViewById(R.id.tv1);

                view.setTag(oneViewHplder);

            }else {
                oneViewHplder = (OneViewHplder) view.getTag();
            }
            oneViewHplder.textView.setText(list.get(i).getTitle());

            ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),oneViewHplder.imageView, MyAppilaction.getOption());

            return view;
            }else if (type ==TWO_ITEM){
            TwoViewHplder twoViewHplder;
            if (view == null){
                view = View.inflate(context,R.layout.item_two,null);
                 twoViewHplder = new TwoViewHplder();

                 twoViewHplder.textView = view.findViewById(R.id.tv2);
                 twoViewHplder.imageView1 = view.findViewById(R.id.img);
                 twoViewHplder.imageView1 = view.findViewById(R.id.img1);
                 view.setTag(twoViewHplder);
            }else {
                twoViewHplder = (TwoViewHplder) view.getTag();
            }
            twoViewHplder.textView.setText(list.get(i).getTitle());
            ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),twoViewHplder.imageView1,MyAppilaction.getOption());
            ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s02(),twoViewHplder.imageView1,MyAppilaction.getOption());

            return view;
        }else if (type == THREE_ITEM){
                ThreeViewHplder threeViewHplder;
                if (view==null){
                    view = View.inflate(context,R.layout.item_three,null);
                    threeViewHplder = new ThreeViewHplder();
                    threeViewHplder.textView = view.findViewById(R.id.tv3);
                    threeViewHplder.imageView = view.findViewById(R.id.img);
                    threeViewHplder.imageView2 = view.findViewById(R.id.img1);
                    threeViewHplder.imageView3 = view.findViewById(R.id.img2);
                    view.setTag(threeViewHplder);
                }else {
                    threeViewHplder = (ThreeViewHplder) view.getTag();
                }
                threeViewHplder.textView.setText(list.get(i).getTitle());

                ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),threeViewHplder.imageView,MyAppilaction.getOption());
                ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s02(),threeViewHplder.imageView2,MyAppilaction.getOption());
                ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s03(),threeViewHplder.imageView3,MyAppilaction.getOption());
                return view;
        }else {

        }

        return null;
    }

    class OneViewHplder{

        TextView textView;
        ImageView imageView;

    }
    class TwoViewHplder{

        TextView textView;
        ImageView imageView1,imageView2;

    }
    class ThreeViewHplder{

        TextView textView;
        ImageView imageView,imageView2,imageView3;

    }
}
