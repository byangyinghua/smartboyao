package com.guinong.lib_base.adapter;

import android.app.Activity;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.guinong.lib_base.R;
import com.guinong.lib_base.base.BaseDelegateAdapter;
import com.guinong.lib_base.base.BaseRecyclerHolder;

import java.util.List;

/**
 * Created by wangyu on 2018/8/16 0016.
 */

public class FeatureRightNoDataAdapter extends BaseDelegateAdapter<String> {


    public FeatureRightNoDataAdapter(Activity ctx, List<String> list, LayoutHelper mLayoutHelper, int mCount) {
        super(ctx, list, mLayoutHelper, mCount);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_no_data;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, String item) {
        TextView tv_nodata = holder.getTextView(R.id.tv_nodata);
        tv_nodata.setText(item);
    }
}
