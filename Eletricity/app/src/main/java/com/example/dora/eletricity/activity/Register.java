package com.example.dora.eletricity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dora.eletricity.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.attr.inputType;

/**
 * Created by Dora on 2021/4/18.
 */

public class Register extends AppCompatActivity  {

    private Button btn_reg;
    private EditText phone,passW,repassW,etname,editText;
    private final String TAG = "RegisterActivity";
    private RadioButton managerbtn1,userbtn1;
    private RadioGroup permission;
//
//    String account = "";
//
//    private SharedPreferences sp;
//    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
//
//        Intent intent=getIntent();
//        account=intent.getStringExtra("account");

        phone=(EditText)findViewById(R.id.et_phone);
        passW=(EditText)findViewById(R.id.et_password);
        repassW=(EditText)findViewById(R.id.et_repassword);
        etname=(EditText)findViewById(R.id.et_name);
        btn_reg=(Button)findViewById(R.id.btn_register);
        managerbtn1=(RadioButton)findViewById(R.id.master1_btn);
        userbtn1=(RadioButton)findViewById(R.id.user1_btn);

        permission=(RadioGroup)findViewById(R.id.radiogruop1);




        btn_reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String tel = phone.getText().toString();
                String password1 = passW.getText().toString();
                String passowrd2 = repassW.getText().toString();
                String name=etname.getText().toString();
                String pattern = "^[1]([3-9])[0-9]{9}$";


                if (tel.length()==0){
                    Toast.makeText(Register.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if (tel.length()<11){
                    Toast.makeText(Register.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                }else if (!(managerbtn1.isChecked()||userbtn1.isChecked())){
                    Toast.makeText(Register.this, "请选择权限", Toast.LENGTH_SHORT).show();

                }else if(password1.length()<1||passowrd2.length()<1){
                    Toast.makeText(Register.this, "请输入密码", Toast.LENGTH_SHORT).show();

                } else if (password1.trim().equals(passowrd2.trim())){

                    Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.setClass(getApplicationContext(), Login.class);
                    startActivity(intent);
                    Register.this.finish();
                }else{
                    Toast.makeText(Register.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }

            }
        });
//
//        EditText edt_phone=(EditText)findViewById(R.id.et_phone);
//
//        edt_phone.setOnFocusChangeListener(this);

    }




//
//    private boolean isTelRig(String account){
//        if (account==null){
//            return false;
//        }
//
//        String pattern = "^[1]([3-9])[0-9]{9}$";
//        Pattern r = Pattern.compile(pattern);
//        Matcher m =r.matcher(account);
//        return m.matches();
//    }
//
//    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//        String inputStr = editText.getText().toString();
//        if (!hasFocus) {
//            if (inputType == R.id.et_phone) {
//                if (isTelRig((inputStr))) {
//
//                    editText.setError(null);
//                } else {
//                    editText.setError("请输入正确的电话号码！");
//                }
//            }
//        }
//    }
}
