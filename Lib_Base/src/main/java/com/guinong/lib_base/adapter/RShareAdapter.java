package com.guinong.lib_base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.guinong.lib_base.R;
import com.guinong.lib_base.base.BaseRecyclerHolder;
import com.guinong.lib_base.bean.ShareDataBean;

/**
 * @author wangyu
 * @time 2017/12/15 0015 on 上午 10:19
 * @desc
 */
public class RShareAdapter extends DelegateAdapter.Adapter<BaseRecyclerHolder>{

    private LayoutHelper mLayoutHelper;
    protected LayoutInflater mInflater;
    private Context mContext;
    private ShareDataBean mShareDataBean;
    private OnRecycleItemClickListener mListener = null;

    public RShareAdapter(Context mContext, GridLayoutHelper mLayoutHelper, ShareDataBean mShareDataBean){
        this.mContext = mContext;
        this.mLayoutHelper = mLayoutHelper;
        mInflater = LayoutInflater.from(mContext);
        this.mShareDataBean = mShareDataBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final BaseRecyclerHolder holder = new BaseRecyclerHolder(mInflater.inflate(R.layout.share_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, final int position) {
        ImageView shareIcon = (ImageView) holder.getImageView(R.id.share_icon);
        TextView shareTitle = (TextView) holder.getTextView(R.id.share_title);
        Glide.with(mContext).load(mShareDataBean.getShareIcons()[position]).into(shareIcon);
        shareTitle.setText(mShareDataBean.getShareNames()[position]);
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.OnRecycleItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShareDataBean.getShareIcons().length;
    }

    public void setOnRecycleItemClickListener(OnRecycleItemClickListener listener){
        this.mListener = listener;
    }

    public interface OnRecycleItemClickListener{
        void OnRecycleItemClick(int position);
    }
}
