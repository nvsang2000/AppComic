package com.sict.mobile.appcomic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sict.mobile.appcomic.Model.Mess;
import com.sict.mobile.appcomic.Model.SignUp;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Remote.ApiClient;
import com.sict.mobile.appcomic.ServeComic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends Activity implements View.OnClickListener{
    EditText txtname, txtEmail, txtPasword;
    ServeComic serveComic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtname = findViewById(R.id.txtName_Signup);
        txtEmail = findViewById(R.id.txtEmail_Signup);
        txtPasword = findViewById(R.id.txtPassword_Signup);

        findViewById(R.id.btnRegister_Signup).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
         SignUp();
    }
    public void SignUp(){
        serveComic = ApiClient.getRetrofitInstance().create(ServeComic.class);
        String name = txtname.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPasword.getText().toString();
        SignUp registerModel = new SignUp(name,email,password);
        Call<Mess> messCall = serveComic.register(registerModel);
        messCall.enqueue(new Callback<Mess>(){
            @Override
            public void onResponse(Call<Mess> call, Response<Mess> response) {
                if (response.isSuccessful()){
                    String mess = response.body().getMessage();
                    Toast.makeText(RegisterActivity.this, mess, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Lỗi Đăng Kí", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Mess> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_LONG).show();
            }
        });
    }

}