package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText age,name,email,phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.setUp_btn);
        age = (EditText) findViewById(R.id.setUp_age);
        name = (EditText) findViewById(R.id.setUp_name);
        email = (EditText) findViewById(R.id.setUp_email);
        phoneNumber = (EditText) findViewById(R.id.setUp_password);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String MobilePattern = "[0-9]{10}";
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String namePattern =  "[a-zA-Z]+\\.?";

                if(!TextUtils.isEmpty(age.getText().toString()) &&
                    !TextUtils.isEmpty(name.getText().toString()) &&
                    !TextUtils.isEmpty(email.getText().toString()) &&
                    !TextUtils.isEmpty(phoneNumber.getText().toString())){
                    if(!email.getText().toString().matches(emailPattern)){
                        Toast.makeText(MainActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(!name.getText().toString().matches(namePattern)){
                        Toast.makeText(MainActivity.this, "Invalid Name", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if(!phoneNumber.getText().toString().matches(MobilePattern)){
                        Toast.makeText(MainActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                        return;
                    }

                       int ageN = Integer.parseInt(age.getText().toString());
                       if(ageN < 1  || ageN > 100){
                           Toast.makeText(MainActivity.this, "Invalid Age", Toast.LENGTH_SHORT).show();
                            return;
                       }

                    Toast.makeText(MainActivity.this, "Valid Fields", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Fields are invalid", Toast.LENGTH_SHORT).show();             }
            }
        });
    }
}