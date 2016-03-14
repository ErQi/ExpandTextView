package com.erqi.le;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * 功    能：对TextView进行装饰,用指定文字在指定行尾替换,然后调用方法展开相信信息等 <br>
 * 作　　者：ErQi  <br>
 * 创建日期：2016/3/11  11:07 <br>
 * 注    意：TextView的宽度需要为match_parent,高度需要为wrap_content便于自动扩张<br>
 */
public class ExpandTextView {
    private TextView mTextView;
    private String mContent;

    public ExpandTextView(TextView textView) {
        mTextView = textView;
    }

    /**
     * 功 能：设置TextViews省略的内容 <br>
     * 作 者：ErQi <br>
     * 时 间：2016/3/11 10:46 <br>
     * 注 意：暂  无 <br>
     *
     * @param content 要显示的全部内容
     * @param hint    末尾省略的提示语
     * @param line    未暂开情况下显示几行
     */
    public void setTextContent(String content, String hint, int line) {
        if (mTextView == null || mTextView.getLayout() == null) {
            throw new IllegalArgumentException("TextView不能为空,切宽度必须为match_parent");
        }
        mTextView.setText(content);
        mTextView.setMaxLines(line);
        mContent = content;
        if (mTextView.getLayout().getLineCount() <= line) return;
        int lineEnd = mTextView.getLayout().getLineEnd(line == 0 ? 0 : line - 1);
        content = content.substring(0, lineEnd);
        Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        float hintWidth = mTextPaint.measureText(hint);
        float subWidth = 0;
        int i = 0;
        while (hintWidth > subWidth) {
            i++;
            String substring = content.substring(lineEnd - i, lineEnd);
            subWidth = mTextPaint.measureText(substring);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(content);
        StringBuilder replace = builder.replace(lineEnd - i, lineEnd, hint);
        mTextView.setText(replace);
    }

    /**
     * 功 能：显示TextView的详细信息 <br>
     * 作 者：ErQi <br>
     * 时 间：2016/3/11 11:12 <br>
     * 注 意：暂  无 <br>
     */
    public void showDetails() {
        if (mTextView != null) {
            mTextView.setMaxLines(Integer.MAX_VALUE);
            mTextView.setText(mContent);
        }
    }
}
