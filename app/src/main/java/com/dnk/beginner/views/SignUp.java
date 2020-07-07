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
import com.dnk.beginner.views.SignIn;

public class SignUp extends AppCompatActivity {

    private LoadDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbHelper= new LoadDbHelper(this,null,null,1);
    }

    public void moveSignIn(View view) {
        Intent intent= new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void saveCustomer(View view) {
        EditText nameText=findViewById(R.id.etxt_new_name);
        EditText mobileText=findViewById(R.id.etxt_new_tele);
        EditText pswrdText=findViewById(R.id.etxt_new_pswrd);
        CustomerDTO customerDTO=new CustomerDTO(nameText.getText().toString(),Integer.parseInt(mobileText.getText().toString()),pswrdText.getText().toString());
        Toast.makeText(this,dbHelper.saveCustomer(customerDTO) ? "Account created successfully" :"Account created successfully",Toast.LENGTH_SHORT).show();


    }
}
