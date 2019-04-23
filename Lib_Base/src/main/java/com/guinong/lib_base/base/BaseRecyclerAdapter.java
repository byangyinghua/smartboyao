package com.guinong.lib_base.base;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangyu
 * @time 2017/4/19 0019 on 下午 14:15
 * @desc
 */
public abstract class BaseRecyclerAdapter <T> extends RecyclerView.Adapter<BaseRecyclerHolder>{

    protected List<T> mItems;
    protected Activity mContext;
    protected LayoutInflater mInflater;
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;
    protected DecimalFormat mFormat;

    public BaseRecyclerAdapter(Activity ctx, List<T> list) {
        mItems = (list != null) ? list : new ArrayList<T>();
        mContext = ctx;
        mInflater = LayoutInflater.from(ctx);
        mFormat = new DecimalFormat("0.00");
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final BaseRecyclerHolder holder = new BaseRecyclerHolder(mInflater.inflate(getItemLayoutId(viewType), parent, false));
        if (mClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
        if(null != mItems.get(position)){
            bindData(holder, position, mItems.get(position));
        }
    }

    public List<T> getmItems(){
        if(mItems != null){
            return mItems;
        }
        return null;
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void add(int pos, T item) {
        mItems.add(pos, item);
        notifyItemInserted(pos);
    }

    public void setData(List<T> list){
        mItems = (list != null) ? list : new ArrayList<T>();
        notifyDataSetChanged();
    }

    public void delete(int pos) {
        mItems.remove(pos);
        notifyItemRemoved(pos);
    }

    public void swap(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    final public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    final public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    /**
     * 重写该方法，根据viewType设置item的layout
     *
     * @param viewType 通过重写getItemViewType（）设置，默认item是0
     * @return
     */
    abstract protected int getItemLayoutId(int viewType);

    /**
     * 重写该方法进行item数据项视图的数据绑定
     *
     * @param holder   通过holder获得item中的子View，进行数据绑定
     * @param position 该item的position
     * @param item     映射到该item的数据
     */
    abstract protected void bindData(BaseRecyclerHolder holder, int position, T item);

    public interface OnItemClickListener {
        void onItemClick(View itemView, int pos);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View itemView, int pos);
    }

    @Override
    public void onViewAttachedToWindow(BaseRecyclerHolder holder) {
        super.onViewAttachedToWindow(holder);
    }


    /**
     * 判断view不为空并显示
     * @param view
     */
    public void emptyVisibity(View view){
        if(view != null){
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 判断view不为空并隐藏
     * @param view
     */
    public void emptyGone(View view){
        if(view != null){
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 判断view不为空且是否获取控件
     * @param view
     * @param isEnabled
     */
    public void emptyEnabled(View view,boolean isEnabled){
        if(null != view){
            view.setEnabled(isEnabled);
        }
    }

    /**
     * 设置TextView值
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv, String str){
        if(null != tv && null != str){
            tv.setText(str);
        }
    }

    /**
     * 设置TextView值
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv,int str){
        if(null != tv){
            tv.setText(str);
        }
    }

    /**
     * 设置View背景颜色
     * @param view
     * @param color
     */
    public void emptyViewBackColor(View view ,int color){
        if(null != view){
            view.setBackgroundColor(color);
        }
    }
}
