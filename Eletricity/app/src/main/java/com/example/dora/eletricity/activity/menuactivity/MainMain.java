package com.example.dora.eletricity.activity.menuactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dora.eletricity.Adapter.FragmentAdapter;
import com.example.dora.eletricity.R;
import com.example.dora.eletricity.activity.ActivityTest;
import com.example.dora.eletricity.framgment.Fragment_First;
import com.example.dora.eletricity.framgment.Fragment_alwals;
import com.example.dora.eletricity.framgment.Fragment_setting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2021/4/20.
 */

public class MainMain extends AppCompatActivity  {


    private BottomNavigationView bnView;
    private ViewPager viewPager;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView,favorView,balanceView,contractView,messageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        // 设置阴影部分颜色为透明
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        bnView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        viewPager = (ViewPager) findViewById(R.id.view_pager);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment_First());
        fragments.add(new Fragment_alwals());
        fragments.add(new Fragment_setting());

        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //BottomNavigationView 点击事件监听
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuId = menuItem.getItemId();
                Intent intent = new Intent();
                // 跳转指定页面：Fragment
                switch (menuId) {
                    case R.id.tab_one:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.tab_two:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.tab_three:
                        viewPager.setCurrentItem(3);
                        break;
                }
                //startActivity(intent);
                return false;
            }
        });

        // ViewPager 滑动事件监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //将滑动到的页面对应的 menu 设置为选中状态
                bnView.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        NavigationView navigationView= (NavigationView)findViewById(R.id.navigation_view);
        navigationView(navigationView);

    }

    private void navigationView(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent=new Intent();
                switch (item.getItemId()) {
                    case R.id.nav_favor:
                        Toast.makeText(MainMain.this, "gotyougotyougotyou!!!", Toast.LENGTH_SHORT).show();

                        intent.setClass(getApplicationContext(), ActivityTest.class);

                        break;
                    case R.id.nav_balance:
                        intent.setClass(getApplicationContext(), ActivityTest.class);
                        break;
                    case R.id.nav_contract:
                        intent.setClass(getApplicationContext(), ActivityTest.class);
                        break;
                    case R.id.nav_message:
                        intent.setClass(getApplicationContext(), ActivityTest.class);
                        break;
                }

                startActivity(intent);

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


}



