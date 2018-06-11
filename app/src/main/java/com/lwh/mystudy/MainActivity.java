package com.lwh.mystudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lwh.mystudy.model.BieModel;
import com.lwh.mystudy.viewpagers.ViewPagerActivity;
import com.lwh.mystudy.widget.WidgetActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {


    @BindView(R.id.btn1)
    Button btn1;

    private List<BieModel> data = new ArrayList<>();
    private List<BieModel> data_b = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BieModel a = new BieModel();
        BieModel b = new BieModel();
        BieModel c = new BieModel();

        data.add(a);
        data.add(b);
        data.add(c);

        data_b.add(a);
        data_b.add(b);
        data_b.add(c);

        data_b.remove(data.get(1));
        Log.e("=====data======",data.size()+"");
        Log.e("=====data_b======",data_b.size()+"");

    }


    @OnClick({R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent intent1 = new Intent(this, ListViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(this, NotificationActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                DownloadActivity.launch(this);
                break;
            case R.id.btn4:
                startActivity(new Intent(this,ConstraintLayoutActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this,SwipRecycleActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this,RxJavaActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this,WidgetActivity.class));
                break;
            case R.id.btn8:
                startActivity(new Intent(this,ViewPagerActivity.class));
                break;
            case R.id.btn9:
                startActivity(new Intent(this,MyProgressViewActivity.class));
                break;
            case R.id.btn10:
//                ComponentName componentName = new ComponentName("com.kongzhong.jr.financial", "com.kongzhong.jr.financial.app.main.MainActivity");
//                Intent intent = new Intent();
//                intent.setComponent(componentName);
//                intent.putExtra("EXTRA_URL", "https://www.kongzhongjr.com/wap/big/index.html");
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);

                Intent intent4 = getPackageManager().getLaunchIntentForPackage("com.kongzhong.jr.financial");
                if (intent4 != null) {
                    intent4.putExtra("EXTRA_URL", "https://www.kongzhongjr.com/wap/big/index.html");
                    intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent4);
                }
                break;
            case R.id.btn11:
                Intent intent5 = getPackageManager().getLaunchIntentForPackage("com.kongzhong.jr.financial");
                if (intent5 != null) {
                    intent5.putExtra("EXTRA_URL", "investList");
                    intent5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent5);
                }
                break;
            case R.id.btn12:
                startActivity(new Intent(this,CoordinatorLayoutActivity.class));
                break;
        }
    }




}

