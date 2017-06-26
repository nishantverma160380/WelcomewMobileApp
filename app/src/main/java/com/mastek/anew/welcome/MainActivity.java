package com.mastek.anew.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText eName, eAge, eUsername;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.eName);
        eAge = (EditText) findViewById(R.id.eAge);
        eUsername = (EditText) findViewById(R.id.eUsername);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(authenticate() == true){
            displayUserDetails();
        }
    }

    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        eName.setText(user.getName());
        eAge.setText(user.getAge()+"");
        eUsername.setText(user.getUsername());
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIN();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout: {
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIN(false);
                startActivity(new Intent(this, Login.class));
                break;
            }
        }

    }
}
