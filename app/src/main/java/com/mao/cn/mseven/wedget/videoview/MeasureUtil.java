package com.mao.cn.mseven.wedget.videoview;

/**
 * author:  zhangkun .
 * date:    on 2017/9/5.
 */

import android.view.View;

import com.mao.cn.mseven.utils.tools.LogU;

public class MeasureUtil {
    /**
     * 原始尺寸
     */
    public static final int ASPECT_RATIO_ORIGIN = 0;
    /**
     * 保持宽高比让短边铺满屏幕
     */
    public static final int ASPECT_RATIO_FIT_PARENT = 1;
    /**
     * 保持宽高比让高宽都match_parent不留空隙
     */
    public static final int ASPECT_RATIO_PAVED_PARENT = 2;
    /**
     * 按照指定比例 16:9
     */
    public static final int ASPECT_RATIO_16_9 = 3;
    public static final int ASPECT_RATIO_4_3 = 4;
    private static final String TAG = "MeasureUtil";

    //int widthMeasureSpec, int heightMeasureSpec
    public static MeasureUtil.Size measure(int displayAspectRatio, int widthMeasureSpec, int heightMeasureSpec, int videoWidth, int videoHeight) {
        int width = View.getDefaultSize(videoWidth, widthMeasureSpec);
        int height = View.getDefaultSize(videoHeight, heightMeasureSpec);
        if (displayAspectRatio == ASPECT_RATIO_ORIGIN) {
            return new MeasureUtil.Size(videoWidth, videoHeight);//P
        } else if (videoWidth > 0 && videoHeight > 0) {
            int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
            int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
            int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
            int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);

            LogU.w("EXACTLY:" + View.MeasureSpec.EXACTLY + ",至多:" + View.MeasureSpec.AT_MOST + ",未指定:" + View.MeasureSpec.UNSPECIFIED);//W/MeasureUtil: EXACTLY:View.MeasureSpec.EXACTLY,至多: View.MeasureSpec.AT_MOST ,未指定:0
            if (widthMode == View.MeasureSpec.EXACTLY && heightMode == View.MeasureSpec.EXACTLY) {  //
                float percentView = (float) widthSize / (float) heightSize;
                float percentVideo;
                switch (displayAspectRatio) {
                    case ASPECT_RATIO_FIT_PARENT:
                    case ASPECT_RATIO_PAVED_PARENT:
                    default:
                        percentVideo = (float) videoWidth / (float) videoHeight;
                        break;
                    case ASPECT_RATIO_16_9:
                        percentVideo = 1.7777778F;
                        break;
                    case ASPECT_RATIO_4_3:
                        percentVideo = 1.3333334F;
                }

                switch (displayAspectRatio) {
                    case ASPECT_RATIO_FIT_PARENT:
                    case ASPECT_RATIO_16_9:
                    case ASPECT_RATIO_4_3:
                        if (percentVideo > percentView) {
                            width = widthSize;
                            height = (int) ((float) widthSize / percentVideo);
                        } else {
                            height = heightSize;
                            width = (int) ((float) heightSize * percentVideo);
                        }
                        break;
                    case ASPECT_RATIO_PAVED_PARENT:
                        if (percentVideo > percentView) {
                            height = heightSize;
                            width = (int) ((float) heightSize * percentVideo);
                        } else {
                            width = widthSize;
                            height = (int) ((float) widthSize / percentVideo);
                        }
                }
            } else if (widthMode == View.MeasureSpec.EXACTLY) {
                width = widthSize;
                height = widthSize * videoHeight / videoWidth;
                if (heightMode == View.MeasureSpec.AT_MOST && height > heightSize) {
                    height = heightSize;
                }
            } else if (heightMode == View.MeasureSpec.EXACTLY) {
                height = heightSize;
                width = heightSize * videoWidth / videoHeight;
                if (widthMode == View.MeasureSpec.AT_MOST && width > widthSize) {
                    width = widthSize;
                }
            } else {
                width = videoWidth;
                height = videoHeight;
                if (heightMode == View.MeasureSpec.AT_MOST && videoHeight > heightSize) {
                    height = heightSize;
                    width = heightSize * videoWidth / videoHeight;
                }

                if (widthMode == View.MeasureSpec.AT_MOST && width > widthSize) {
                    width = widthSize;
                    height = widthSize * videoHeight / videoWidth;
                }
            }

            return new MeasureUtil.Size(width, height);
        } else {
            return new MeasureUtil.Size(width, height);
        }
    }

    public static class Size {
        public final int width;
        public final int height;

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

}