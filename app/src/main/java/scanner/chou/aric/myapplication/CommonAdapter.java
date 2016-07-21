package scanner.chou.aric.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by aric on 16/7/20.
 */
public abstract class CommonAdapter<T> extends BaseAdapter  {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mLayoutInflater;
    protected int layoutId;

    public CommonAdapter(List<T> mDatas, Context mContext,int layoutId) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.layoutId=layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public  View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext, convertView, parent,layoutId,position);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();

    }

    public abstract void convert(ViewHolder viewHolder,T t);
}
