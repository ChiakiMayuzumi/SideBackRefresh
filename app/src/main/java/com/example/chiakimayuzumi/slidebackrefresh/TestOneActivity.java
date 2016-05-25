package com.example.chiakimayuzumi.slidebackrefresh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by chiakimayuzumi on 16/5/25.
 */
public class TestOneActivity extends SideBackRefreshActivity {

  private TextView mTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTextView = (TextView) findViewById(R.id.text);
    mTextView.setText("This is TestActivity");

  }

}
