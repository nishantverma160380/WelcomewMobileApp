package com.mastek.anew.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity implements View.OnClickListener {

    Button bLogin;
    EditText eUsername, ePassword;
    TextView eRegisterLink;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsername = (EditText) findViewById(R.id.eUsername);
        ePassword = (EditText) findViewById(R.id.ePassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        eRegisterLink = (TextView) findViewById(R.id.eRegisterLink);

        bLogin.setOnClickListener(this);
        eRegisterLink.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin: {
                String username = eUsername.getText().toString();
                String password = ePassword.getText().toString();
                User user = new User(username,password);
                userLocalStore.setUserLoggedIN(true);
                startActivity(new Intent(this, MainActivity.class));
                break;
            }
            case R.id.eRegisterLink: {
                startActivity(new Intent(this, Register.class));
                break;
            }
        }

    }

}
