package com.example.ux32vd.absensimobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.ux32vd.absensimobile.api.APIService;
import com.example.ux32vd.absensimobile.api.RetrofitClient;
import com.example.ux32vd.absensimobile.helper.Config;
import com.example.ux32vd.absensimobile.helper.Controller;
import com.example.ux32vd.absensimobile.helper.SQLiteHandler;
import com.example.ux32vd.absensimobile.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MenuLogin extends AppCompatActivity {

    //API Service
    APIService service;

    ProgressDialog pDialog;
    protected Button btn_register, btn_login;
    protected EditText txt_username, txt_password;
    //Intent intent;

    //int success;
    //ConnectivityManager conMgr;

    //private String url = Config.URL + "login.php";

    //private static final String TAG = MenuLogin.class.getSimpleName();

//    private static final String TAG_SUCCESS = "success";
//    private static final String TAG_MESSAGE = "message";
//
//    public final static String TAG_USERNAME = "username";
//    public final static String TAG_ID = "id";
//
//    String tag_json_obj = "json_obj_req";
//
//    SharedPreferences sharedpreferences;
//    Boolean session = false;
//    String id, username;
//    public static final String my_shared_preferences = "my_shared_preferences";
//    public static final String session_status = "session_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_login);

        service = RetrofitClient.getService();

//        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        {
//            if (conMgr.getActiveNetworkInfo() != null
//                    && conMgr.getActiveNetworkInfo().isAvailable()
//                    && conMgr.getActiveNetworkInfo().isConnected()) {
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet Connection",
//                        Toast.LENGTH_LONG).show();
//            }
//        }

        btn_login = (Button) findViewById(R.id.btn_login);
        txt_username = (EditText) findViewById(R.id.txt_username);
        txt_password = (EditText) findViewById(R.id.txt_password);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Cek session login jika TRUE maka langsung buka MainActivity
//        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
//        session = sharedpreferences.getBoolean(session_status, false);
//        id = sharedpreferences.getString(TAG_ID, null);
//        username = sharedpreferences.getString(TAG_USERNAME, null);

//        if (session) {
//            Intent intent = new Intent(MenuLogin.this, MenuUtama.class);
//            intent.putExtra(TAG_ID, id);
//            intent.putExtra(TAG_USERNAME, username);
//            finish();
//            startActivity(intent);
//        }


        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String username = txt_username.getText().toString();
                String password = txt_password.getText().toString();
                pDialog.setMessage("Logging in ...");
                showDialog();

                service.saveLogin(username, password)
                        .enqueue(new Callback<com.example.ux32vd.absensimobile.model.Response>() {
                            @Override
                            public void onResponse(Call<com.example.ux32vd.absensimobile.model.Response> call, retrofit2.Response<com.example.ux32vd.absensimobile.model.Response> response) {

                                if (response.isSuccessful()) {
                                    Toast.makeText(MenuLogin.this, "Sukses", Toast.LENGTH_LONG).show();
                                    hideDialog();

                                    SharedPreferences sharedPreferences = getSharedPreferences("dataOrtu", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("token", String.valueOf(response.body().getOrtu().getToken()));
                                    //editor.putInt("id_ortu", Integer.valueOf(response.body().getOrtu().getIdOrtu()));
                                    editor.putString("nama", String.valueOf(response.body().getOrtu().getNama()));
                                    editor.putString("username", String.valueOf(response.body().getOrtu().getUsername()));
                                    editor.apply();

                                    Intent intent = new Intent(getApplicationContext(), MenuUtama.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(MenuLogin.this, "Gagal ada masalah pengisian", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<com.example.ux32vd.absensimobile.model.Response> call, Throwable t) {
                                Toast.makeText(MenuLogin.this, "Gagal" + t, Toast.LENGTH_LONG).show();
                            }
                        });


                // mengecek kolom yang kosong
//                if (username.trim().length() > 0 && password.trim().length() > 0) {
//                    if (conMgr.getActiveNetworkInfo() != null
//                            && conMgr.getActiveNetworkInfo().isAvailable()
//                            && conMgr.getActiveNetworkInfo().isConnected()) {
//                        checkLogin(username, password);
//                    } else {
//                        Toast.makeText(getApplicationContext() ,"No Internet Connection", Toast.LENGTH_LONG).show();
//                    }
//                } else {
//                    // Prompt user to enter credentials
//                    Toast.makeText(getApplicationContext() ,"Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
//                }
            }
        });

//        btn_register.setOnClickListener(new View.OnClickListener() {
//
//
//    }
//
//    private void checkLogin(final String username, final String password) {
//        pDialog = new ProgressDialog(this);
//        pDialog.setCancelable(false);
//        pDialog.setMessage("Logging in ...");
//        showDialog();
//
//        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Log.e(TAG, "Login Response: " + response.toString());
//                hideDialog();
//
//                try {
//                    JSONObject jObj = new JSONObject(response);
//                    success = jObj.getInt(TAG_SUCCESS);
//
//                    // Check for error node in json
//                    if (success == 1) {
//                        String username = jObj.getString(TAG_USERNAME);
//                        String id = jObj.getString(TAG_ID);
//
//                        Log.e("Successfully Login!", jObj.toString());
//
//                        Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
//
//                        // menyimpan login ke session
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//                        editor.putBoolean(session_status, true);
//                        editor.putString(TAG_ID, id);
//                        editor.putString(TAG_USERNAME, username);
//                        editor.commit();
//
//                        // Memanggil main activity
//                        Intent intent = new Intent(MenuLogin.this, MenuUtama.class);
//                        intent.putExtra(TAG_ID, id);
//                        intent.putExtra(TAG_USERNAME, username);
//                        finish();
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(getApplicationContext(),
//                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
//
//                    }
//                } catch (JSONException e) {
//                    // JSON error
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "Login Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(),
//                        error.getMessage(), Toast.LENGTH_LONG).show();
//
//                hideDialog();
//
//            }
//        }) {
//
//            @Override
//            protected Map<String, String> getParams() {
//                // Posting parameters to login url
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("username", username);
//                params.put("password", password);
//
//                return params;
//            }
//
//        };
//
//        // Adding request to request queue
//        Controller.getInstance().addToRequestQueue(strReq, tag_json_obj);
//    }
//
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}