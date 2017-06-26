package com.mastek.anew.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity implements View.OnClickListener {

    Button bRegister;
    EditText eName, eAge, eUsername, ePassword;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eName = (EditText) findViewById(R.id.eName);
        eAge = (EditText) findViewById(R.id.eAge);
        eUsername = (EditText) findViewById(R.id.eUsername);
        ePassword = (EditText) findViewById(R.id.ePassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        userLocalStore = new UserLocalStore(this);

        bRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bRegister:
                String name = eName.getText().toString();
                int age = Integer.parseInt(eAge.getText().toString());
                String username = eUsername.getText().toString();
                String password = ePassword.getText().toString();

                User registeredData = new User(name,username,password,age);
                userLocalStore.storeUserData(registeredData);
                Toast.makeText(this,"Thanks for Registering",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Login.class));

                break;
        }

    }
}
