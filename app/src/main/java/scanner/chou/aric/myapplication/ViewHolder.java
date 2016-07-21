package scanner.chou.aric.myapplication;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aric on 16/7/20.
 * ViewHolder 用来存储各种view的应用用以避免findviewbyid
 * 在本例中通过viewHolder的getViewHolder 方法去获取一个viewHolder.
 * 1.如果是第一次那么肯定是没有convertView 自然也就没有viewHolder,所以去创建一个convertView 并且将viewHolder settag进去
 * 2.如果不是第一次并且已经有缓存的convertview 了,那么这个convertview中一定是有viewHolder的直接取出来就可以了.
 */
public class ViewHolder {
    private SparseArray<View> mItemViews;//本质是map 只是它的key是 integer 它的value是view
    private int mPostion;
    private View mConvertView;

    public ViewHolder(Context mContext, ViewGroup mViewParent, int mLayoutId, int mPostion) {
        mConvertView= LayoutInflater.from(mContext).inflate(mLayoutId,mViewParent,false);
        mConvertView.setTag(this);
        mItemViews=new SparseArray<>();
    }

    public static ViewHolder getViewHolder(Context mContext, View convertView,ViewGroup mViewParent, int mLayoutId, int mPostion){

        if(convertView==null){
            return new ViewHolder(mContext,mViewParent,mLayoutId,mPostion);
        }else{
            ViewHolder holder = ((ViewHolder) convertView.getTag());
            holder.mPostion=mPostion;
            return holder;
        }
    }

    public <T extends View> T getItemView(int viewId){
        View view = mItemViews.get(viewId);
        if(view==null){
            view=mConvertView.findViewById(viewId);
            mItemViews.put(viewId,view);
        }

        return (T)view;
    }


    public View getConvertView(){
        return mConvertView;
    }

    public ViewHolder setText(int textViewId,String text){
        TextView textView = getItemView(textViewId);
        textView.setText(text);

        return this;
    }
}
