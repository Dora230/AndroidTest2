package com.example.dora.eletricity.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dora.eletricity.R;
import com.example.dora.eletricity.activity.menuactivity.Call_Activity;
import com.example.dora.eletricity.framgment.FxFragment;
import com.example.dora.eletricity.framgment.SzFragment;
import com.example.dora.eletricity.framgment.TxlFragment;
import com.example.dora.eletricity.framgment.WxFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_login);

        btn = (Button) findViewById(R.id.btn_firlogin);

        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_firlogin:
                intent.setClass(getApplicationContext(), Login.class);

                break;
            default:
                break;
        }
        this.startActivity(intent);
    }

}



