package com.example.ux32vd.absensimobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ux32vd.absensimobile.api.APIService;
import com.example.ux32vd.absensimobile.api.RetrofitClient;
import com.example.ux32vd.absensimobile.helper.SQLiteHandler;
import com.example.ux32vd.absensimobile.helper.SessionManager;

import java.util.HashMap;

public class MenuUtama extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //APIService
    APIService service;

    //NavDrawer
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    public Button btn_logout;
    public TextView txt_token, txt_username, txt_nama, txt_token_nav, txt_username_nav, txt_nama_nav;
    //String id, username, nama;
    NavigationView navigationView;


//    public static final String TAG_ID = "id";
//    public static final String TAG_USERNAME = "username";
//    public static final String TAG_NAMA = "nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);


        mDrawerLayout = findViewById(R.id.navigation_main);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        //onclick navbar
//        navigationView = (NavigationView) findViewById(R.id.navigation_main);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                switch (id) {
//                    case R.id.logout:
//                        break;
//                }
//                return false;
//            }
//        });


        service = RetrofitClient.getService();

        txt_token = mDrawerLayout.findViewById(R.id.txt_token);
        txt_nama = mDrawerLayout.findViewById(R.id.txt_nama);
        txt_username = mDrawerLayout.findViewById(R.id.txt_username);


        SharedPreferences sharedPreferences = getSharedPreferences("dataOrtu", MODE_PRIVATE);
        final String token = sharedPreferences.getString("token", "");
        //int id_ortu = sharedPreferences.getInt("id_ortu", 0);
        final String nama = sharedPreferences.getString("nama", "");
        final String username = sharedPreferences.getString("username", "");

        txt_token.setText(token);
        txt_nama.setText(nama);
        txt_username.setText(username);

        btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // mengosongkan nilai id dan username
                SharedPreferences sharedPreferences = getSharedPreferences("dataOrtu", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();

                Intent intent = new Intent(MenuUtama.this, MenuLogin.class);
                finish();
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
            return true;

        int id = item.getItemId();
        if (id == R.string.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout: {
                //dosomething
                break;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu, menu);
        return true;
    }

}
//        txt_id = (TextView) findViewById(R.id.txt_id);
//        txt_username = (TextView) findViewById(R.id.txt_username);
//        txt_nama = (TextView) findViewById(R.id.txt_nama);
//        btn_logout = (Button) findViewById(R.id.btn_logout);
//
//        sharedpreferences = getSharedPreferences(MenuLogin.my_shared_preferences, Context.MODE_PRIVATE);
//
//        id = getIntent().getStringExtra(TAG_ID);
//        username = getIntent().getStringExtra(TAG_USERNAME);
//        nama = getIntent().getStringExtra(TAG_NAMA);
//
//        txt_id.setText("ID : " + id);
//        txt_username.setText("USERNAME : " + username);
//        txt_nama.setText("NAMA : " + nama);
//
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                // update login session ke FALSE dan mengosongkan nilai id dan username
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putBoolean(MenuLogin.session_status, false);
//                editor.putString(TAG_ID, null);
//                editor.putString(TAG_USERNAME, null);
//                editor.putString(TAG_NAMA, null);
//                editor.commit();
//
//                Intent intent = new Intent(MenuUtama.this, MenuLogin.class);
//                finish();
//                startActivity(intent);
//            }
//        });
//
//    }


