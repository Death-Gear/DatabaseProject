package com.example.shakkhor.database;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    MakeDatabase helper = new MakeDatabase(this);
    private static EditText name;
    private static EditText password;
    private static Button signIn;
    private static Button signUp;
    private static String str;
    private static SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        LoginButton();
        SignupButton();
        if(getUserLogin()){
            Intent intent = new Intent(LoginActivity.this, UserActivity.class);
            startActivity(intent);
        }
    }

    public void LoginButton(){
        name = (EditText)findViewById(R.id.editText_Username);
        password = (EditText)findViewById(R.id.editText_Pass);
        signIn = (Button)findViewById(R.id.button_Sign_In);

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                str = name.getText().toString();
                String pass = password.getText().toString();

                String Password = helper.searchPass(str);
                if(pass.equals(Password)){
                    storeUserDetails(true);
                    Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                    startActivity(intent);
                }else{
                    Toast msg = Toast.makeText(LoginActivity.this, "Username and Password don't match!", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
    }

    public void SignupButton(){
        signUp = (Button)findViewById(R.id.button_Sign_Up);

        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    public static String getUname(){
        String uname = getUserName();
        return uname;
    }


    public static void storeUserDetails(boolean loggedIn){
        SharedPreferences.Editor myEditor = sharedPreferences.edit();

        myEditor.putBoolean("LoggedIn", loggedIn);
        myEditor.putString("Username", str);
        myEditor.apply();
    }

    private boolean getUserLogin(){
        boolean login = sharedPreferences.getBoolean("LoggedIn", false);
        return login;
    }
    private static String getUserName(){
        String uname = sharedPreferences.getString("Username","");
        return uname;
    }
}
