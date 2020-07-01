package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonChangeImage,buttonBar;
    private ImageButton imageButton;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        int password = intent.getIntExtra("password",0);
        Log.d("用户名",userName);
        Log.d("密码", String.valueOf(password));
        ActivityCollect.addActivity(this);//将活动加入活动管理器中
        imageView=findViewById(R.id.imageView);
        progressBar= findViewById(R.id.progressBar);
        buttonChangeImage = findViewById(R.id.buttonChangeImage);
        imageButton = findViewById(R.id.imageButton);
        buttonBar=findViewById(R.id.buttonBar);
        buttonBar.setOnClickListener(this);
        buttonChangeImage.setOnClickListener(this);
        imageButton.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_item:
//                Toast.makeText(FirstActivity.this, "新增选项被触发！！！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);

                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "移除选项被触发！！！", Toast.LENGTH_SHORT).show();
                finish();//销毁当前活动
                break;
            case R.id.net_item:
//                Toast.makeText(FirstActivity.this, "新增选项被触发！！！", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent1);
                startActivityForResult(intent1,1);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_back");
                    Log.d("FirstActivity", returnData);
                }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonChangeImage:
                imageView.setImageResource(R.drawable.image1);
                break;
            case R.id.buttonBar:
                int progress = progressBar.getProgress();
                progress += 10;
                progressBar.setProgress(progress);
//                if (progressBar.getVisibility()==View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }
                break;
            case R.id.imageButton:
                AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
                dialog.setTitle("帅锅点一点");
                dialog.setMessage("你的衰气无人能敌");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确实", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("不是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }
}
