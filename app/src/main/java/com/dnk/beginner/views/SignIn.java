package com.dnk.beginner.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dnk.beginner.R;
import com.dnk.beginner.db.LoadDbHelper;
import com.dnk.beginner.model.CustomerDTO;

public class SignIn extends AppCompatActivity {

    private LoadDbHelper loadDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadDbHelper=new LoadDbHelper(this,null,null,1);
    }

    public void moveSignUp(View view) {
        Intent intent= new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void loginValidation(View view) {
        EditText name= findViewById(R.id.etxt_name);
        EditText password = findViewById(R.id.etxt_password);

        CustomerDTO customerDTO=loadDbHelper.searchCustomer(name.getText().toString(),password.getText().toString());
//        return customerDTO == null ? Toast.makeText(this,"Account created successfully",Toast.LENGTH_SHORT):
        if (customerDTO == null){
            Toast.makeText(this,"No Such Customer here",Toast.LENGTH_SHORT).show();
        }else {
            moveToContent();
        }


    }

    public void moveToContent(){
        Intent intent = new Intent(this,Content.class);
        startActivity(intent);
    }
}
