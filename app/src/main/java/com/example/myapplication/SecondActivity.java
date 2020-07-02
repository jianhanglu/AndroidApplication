package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button buttonNet , buttonCal,buttonBackResult,buttonBackApp,buttonProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonNet=findViewById(R.id.buttonNet);
        buttonCal=findViewById(R.id.buttonCall);
        buttonBackResult = findViewById(R.id.buttonBackResult);
        buttonBackApp = findViewById(R.id.buttonBackApp);
        buttonProgressDialog = findViewById(R.id.buttonProgressDialog);
        ActivityCollect.addActivity(this);//将活动加入活动管理器中
        buttonNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.xapi.edu.cn"));
                startActivity(intent);

            }
        });
        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        buttonBackResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data_back="你好，世界！！!";
                Intent intent = new Intent();
                intent.putExtra("data_back",data_back);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        buttonBackApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollect.finishAll();//关闭所有Activity
                android.os.Process.killProcess(android.os.Process.myPid());//杀掉进程
            }
        });
        buttonProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(SecondActivity.this);
                progressDialog.setTitle("心动了");
                progressDialog.setMessage("美图正在加载中。。。。");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }


}
