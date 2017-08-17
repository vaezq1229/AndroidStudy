package com.lwh.mystudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn1)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn1://自定义view
                Intent intent = new Intent(this,ListViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
