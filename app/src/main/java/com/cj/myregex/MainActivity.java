package com.cj.myregex;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button button;
    private String regex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%*.])[A-Za-z0-9!@#$%*.]{8,20}$";
    //大写、小写、数字、特殊字符，至少包含三种，长度8-20位。
    private String regex2 = "(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)[\\da-zA-Z\\W]{8,20}$)|(^(?=.*\\d)(?=.*[A-Z])(?=.*\\W)[\\da-zA-Z\\W]{8,20}$)|(^(?=.*\\d)(?=.*[a-z])(?=.*\\W)[\\da-zA-Z\\W]{8,20}$)|(^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[\\da-zA-Z\\W]{8,20}$)";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                submit();

                break;
        }
    }

    private void submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "editTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


        boolean matches = Pattern.matches(regex2, editTextString);
        if(matches){
            Toast.makeText(this, "校验成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "校验失败", Toast.LENGTH_SHORT).show();
        }





    }
}
