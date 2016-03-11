package com.erqi.le;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mView;
    private String mString;
    private ExpandTextView mExpandTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (TextView) findViewById(R.id.view);
        mString = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十";
        mExpandTextView = new ExpandTextView(mView);
    }

    public void setContent(View view) {
        mExpandTextView.setTextContent(mString, ".....点击展开", 3);
    }

    public void showDetails(View view) {
        mExpandTextView.showDetails();
    }
}
