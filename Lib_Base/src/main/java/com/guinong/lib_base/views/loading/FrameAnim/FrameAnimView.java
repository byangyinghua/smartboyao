package com.guinong.lib_base.views.loading.FrameAnim;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 帧动画view
 *
 * @author haohao on 2017/6/27 13:43
 * @version v1.0
 */
public class FrameAnimView extends RecyclingImageView {

    protected FrameAnimation mAnimation;
    private List<Integer> mRes = new ArrayList<>();
    private int duration = (int) FrameAnimation.DEFAULT_DURATION;
    private boolean mLoop = true;

    public FrameAnimView(Context context) {
        super(context);
        init(null);
    }

    public FrameAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FrameAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
     /*   if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FrameAnimView);
            int resId = typedArray.getResourceId(R.styleable.FrameAnimView_animSrc, 0);
            if (resId != 0) {
                loadFromXml(resId);
            }
            typedArray.recycle();
        }*/

        /*mRes.add(R.mipmap.loading_5_00000);
        mRes.add(R.mipmap.loading_5_00001);
        mRes.add(R.mipmap.loading_5_00002);
        mRes.add(R.mipmap.loading_5_00003);
        mRes.add(R.mipmap.loading_5_00004);
        mRes.add(R.mipmap.loading_5_00005);
        mRes.add(R.mipmap.loading_5_00006);
        mRes.add(R.mipmap.loading_5_00007);
        mRes.add(R.mipmap.loading_5_00008);
        mRes.add(R.mipmap.loading_5_00009);
        mRes.add(R.mipmap.loading_5_00010);
        mRes.add(R.mipmap.loading_5_00012);
        mRes.add(R.mipmap.loading_5_00013);
        mRes.add(R.mipmap.loading_5_00014);
        mRes.add(R.mipmap.loading_5_00015);
        mRes.add(R.mipmap.loading_5_00016);
        mRes.add(R.mipmap.loading_5_00017);
        mRes.add(R.mipmap.loading_5_00018);
        mRes.add(R.mipmap.loading_5_00019);
        mRes.add(R.mipmap.loading_5_00020);
        mRes.add(R.mipmap.loading_5_00021);
        mRes.add(R.mipmap.loading_5_00022);
        mRes.add(R.mipmap.loading_5_00023);
        mRes.add(R.mipmap.loading_5_00024);
        mRes.add(R.mipmap.loading_5_00025);
        mRes.add(R.mipmap.loading_5_00026);
        mRes.add(R.mipmap.loading_5_00027);
        mRes.add(R.mipmap.loading_5_00028);
        mRes.add(R.mipmap.loading_5_00029);
        mRes.add(R.mipmap.loading_5_00030);
        mRes.add(R.mipmap.loading_5_00031);
        mRes.add(R.mipmap.loading_5_00032);
        mRes.add(R.mipmap.loading_5_00033);
        mRes.add(R.mipmap.loading_5_00034);
        mRes.add(R.mipmap.loading_5_00035);
        mRes.add(R.mipmap.loading_5_00036);
        mRes.add(R.mipmap.loading_5_00037);
        mRes.add(R.mipmap.loading_5_00038);
        mRes.add(R.mipmap.loading_5_00039);
        mRes.add(R.mipmap.loading_5_00040);
        mRes.add(R.mipmap.loading_5_00041);
        mRes.add(R.mipmap.loading_5_00042);
        mRes.add(R.mipmap.loading_5_00043);
        mRes.add(R.mipmap.loading_5_00044);
        mRes.add(R.mipmap.loading_5_00045);
        mRes.add(R.mipmap.loading_5_00046);
        mRes.add(R.mipmap.loading_5_00047);
        mRes.add(R.mipmap.loading_5_00048);
        mRes.add(R.mipmap.loading_5_00049);
        mRes.add(R.mipmap.loading_5_00050);*/

        if (mRes == null || mRes.size() == 0) {
            return;
        }
        int[] data = new int[mRes.size()];
        for (int i = 0; i < mRes.size(); i++) {
            data[i] = mRes.get(i);
        }
        mAnimation = new FrameAnimation.FrameAnimationBuilder(getResources())
                .setLoop(mLoop)
                .setResIds(data)
                .setDuration(duration)
                .build();
        mAnimation.setOnImageLoadListener(new OnImageLoadListener() {
            @Override
            public void onImageLoad(BitmapDrawable drawable) {
                FrameAnimView.this.setImageDrawable(drawable);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    public void setImageSrcs(int[] res) {
        mAnimation.setResIds(res);
    }

    public void start() {
        if (mAnimation != null) {
            mAnimation.start();
        }
    }

    public void stop() {
        if (mAnimation != null) {
            mAnimation.stop();
        }
    }

    private void loadFromXml(int resourceId) {
        XmlResourceParser parser = getContext().getResources().getXml(
                resourceId);
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {

                } else if (eventType == XmlPullParser.START_TAG) {
                    String name = parser.getName();
                    if (!TextUtils.isEmpty(name) && name.equals("animation-list")) {
                        int size = parser.getAttributeCount();
                        for (int i = 0; i < size; i++) {
                            if (parser.getAttributeName(i).equals(
                                    "oneshot")) {
                                mLoop = !parser.getAttributeBooleanValue(
                                        i, true);
                            }
                        }
                    }
                    if (parser.getName().equals("item")) {
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            if (parser.getAttributeName(i).equals(
                                    "drawable")) {
                                int resId = Integer.parseInt(parser
                                        .getAttributeValue(i)
                                        .substring(1));
                                if (resId != 0)
                                    mRes.add(resId);
                            } else if (parser.getAttributeName(i)
                                    .equals("duration")) {
                                duration = parser.getAttributeIntValue(
                                        i, 1000);
                            }
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                } else if (eventType == XmlPullParser.TEXT) {
                }
                eventType = parser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }
}
