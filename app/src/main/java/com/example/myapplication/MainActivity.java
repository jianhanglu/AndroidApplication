package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private Button buttonOk;
    private Button buttonCancel;
    private EditText editTextUserName;
    private EditText editTextPassword;
    private String userName;
    private Integer password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollect.addActivity(this);//将活动加入活动管理器中
        buttonOk = (Button)findViewById(R.id.buttonOK);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name=(EditText)findViewById(R.id.editTextUserName);
                name.setText("");
                EditText paw = findViewById(R.id.editTextPassword);
                paw.setText("");
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextUserName= findViewById(R.id.editTextUserName);
                userName= editTextUserName.getText().toString();
                Log.d("hkhaf",userName);
                editTextPassword = findViewById(R.id.editTextPassword);
                password=Integer.parseInt(editTextPassword.getText().toString().trim());
                if ("卢建航".equals(userName.trim()) && password==123456) {
                    Toast.makeText(MainActivity.this, "登录成功！！！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.myapplication.ACTION_START");
                    intent.putExtra("userName",userName);
                    intent.putExtra("password",password);
//                    intent.addCategory("com.example.myapplication.MY_CATE");
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "登录失败！！！", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
