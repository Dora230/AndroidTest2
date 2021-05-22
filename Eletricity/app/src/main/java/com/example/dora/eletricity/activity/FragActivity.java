package com.example.dora.eletricity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dora.eletricity.R;

/**
 * Created by Dora on 2021/4/13.
 */

public class FragActivity extends Activity implements View.OnClickListener {

    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);

        intView();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    private void intView() {

        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent();

        switch (v.getId()){
            case R.id.button:
              intent.setClass(getApplicationContext(),FragActivity.class);
                break;
            case R.id.button2:
                intent.setClass(getApplicationContext(),FragActivity.class);
                break;
            case R.id.button3:
                intent.setClass(getApplicationContext(),FragActivity.class);
                break;
        }
        this.startActivity(intent);

    }
}



