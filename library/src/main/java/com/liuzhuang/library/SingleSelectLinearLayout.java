package com.liuzhuang.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by liuzhuang on 15/4/30.
 */
public class SingleSelectLinearLayout extends LinearLayout {
    public SingleSelectLinearLayout(Context context) {
        super(context);
    }

    public SingleSelectLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private ISingleSelectCallback callback;

    private int defaultSelectedPosition = -1;

    /**
     * default position
     * @param defaultSelectedPosition child view index
     * @return 返回自身实现链式调用
     */
    public SingleSelectLinearLayout setDefaultSelectedPosition(int defaultSelectedPosition) {
        this.defaultSelectedPosition = defaultSelectedPosition;
        return this;
    }

    public void initChildClickListener(ISingleSelectCallback callback) {
        if (callback == null) {
            return;
        }
        this.callback = callback;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (SingleSelectLinearLayout.this.callback == null) {
                            return;
                        }
                        updateItemClickState(v);
                    }
                });
            }
        }
        if (defaultSelectedPosition != -1 && getChildAt(defaultSelectedPosition) != null) {
            updateItemClickState(getChildAt(defaultSelectedPosition));
        }
    }

    private void updateItemClickState(View view) {
        if (view != null) {
            callback.onItemSelected(view);
            if (getChildCount() > 0) {
                for (int i = 0; i < getChildCount(); i++) {
                    if (getChildAt(i) != null && getChildAt(i) != view) {
                        callback.onItemUnSelected(getChildAt(i));
                    }
                }
            }
        }
    }
}
