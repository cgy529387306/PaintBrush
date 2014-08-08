package it.moondroid.paintbrush.drawing;

import android.content.Context;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.paintbrush.R;


public class Brushes {
    private static int[] BRUSH_STYLES;
    private static Brush[] mBrushList;
    private static List<Brush> mPhotoBrushList;
    private static List<Brush> mStylishBrushList;

    static {
        mStylishBrushList = new ArrayList();
        mPhotoBrushList = new ArrayList();
        BRUSH_STYLES = new int[]{R.style.Brush_AirBrush, R.style.Brush_Bamboo1};
    }

    public static List<Brush> get(Context context, int type) {
        if (mBrushList == null) {
            loadBrushList(context);
        }
        return type == 0 ? mStylishBrushList : mPhotoBrushList;
    }

    public static Brush[] get(Context context) {
        if (mBrushList == null) {
            loadBrushList(context);
        }
        return mBrushList;
    }

    public static final void loadBrushList(Context context) {
        if (mBrushList == null) {
            long t1 = SystemClock.elapsedRealtime();
            mBrushList = Brush.parseStyleData(context, BRUSH_STYLES);
            long t2 = SystemClock.elapsedRealtime();
            Brush[] arr$ = mBrushList;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                Brush brush = arr$[i$];
                if (brush.getBrushType() == 0) {
                    mStylishBrushList.add(brush);
                } else {
                    mPhotoBrushList.add(brush);
                }
                i$++;
            }
        }
    }
}