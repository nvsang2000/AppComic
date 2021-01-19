package com.sict.mobile.appcomic.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sict.mobile.appcomic.Model.SignIn;
import com.sict.mobile.appcomic.Model.TokenUser;
import com.sict.mobile.appcomic.Model.User;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Remote.ApiClient;
import com.sict.mobile.appcomic.ServeComic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends Activity implements View.OnClickListener{
    public static final  String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText txtemail, txtpassword;
    private static final String TAG = "LoginActtivity";
    ServeComic serveComic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtemail = (EditText)findViewById(R.id.txtEmail_account);
        txtpassword = (EditText)findViewById(R.id.txtPass);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                SignIn();
                break;
            case R.id.btnRegister:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }


    private void SignIn() {
        serveComic = ApiClient.getRetrofitInstance().create(ServeComic.class);
        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();
        SignIn loginModel = new SignIn(email,password);
        Call<TokenUser> tokenCall = serveComic.login(loginModel);
        tokenCall.enqueue(new Callback<TokenUser>(){
            @Override
            public void onResponse(Call<TokenUser> call, Response<TokenUser> response) {
                if(response.isSuccessful()){
                    String token = response.body().getToken();
//                    Toast.makeText(LoginActivity.this, token, Toast.LENGTH_LONG).show();
                    getUserInfo(token);
                }else{
                    Toast.makeText(LoginActivity.this, "Thông tin dăng nhập sai", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<TokenUser> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void getUserInfo(String token) {
        serveComic = ApiClient.getRetrofitInstance().create(ServeComic.class);
        Call<User> userAuth = serveComic.getUserAuth("Bearer "+token);
        userAuth.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
//                    Toast.makeText(LoginActivity.this, response.body().getName(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG,"name : "+response.body());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    String nameAcount = response.body().getName();
                    int idAccount = response.body().getId();
                    String emailAccount = response.body().getEmail();
                    int gioiTinhAccount = response.body().getGioitinh();

                    intent.putExtra("Name_Account", nameAcount);
                    intent.putExtra("email_account", emailAccount);
                    intent.putExtra("gioitinh_account",gioiTinhAccount);
                    startActivity(intent);

                }else {
                    Toast.makeText(LoginActivity.this,
                            "token is not correct",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this,
                        "Failed",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
