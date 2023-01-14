package com.example.uichallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText editTextPersonName, editTextPersonEmail, editTextPersonPassword, editTextPersonRePassword;
    private TextView txtErrName, txtErrEmail, txtErrPass, txtErrRePass;
    private Button btnPickImage, btnRegister;
    private Spinner spinnerCountry;
    private RadioGroup radioGroup;
    private CheckBox checkAgree;
    private RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });
        
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }

    private void initRegister() {
        Log.d(TAG, "initRegister: Started");
        if (validateData()) {
            if (checkAgree.isChecked()) {
                showSnackBar();
            }else {
                Toast.makeText(this, "You need to agree to the license agreement", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar() {
        Log.d(TAG, "showSnackBar: Started");

        txtErrName.setVisibility(View.GONE);
        txtErrEmail.setVisibility(View.GONE);
        txtErrPass.setVisibility(View.GONE);
        txtErrRePass.setVisibility(View.GONE);

        Snackbar.make(mainLayout, "User Registered", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }

    private boolean validateData() {
        Log.d(TAG, "validateData: Started");

        txtErrName.setVisibility(View.GONE);
        txtErrEmail.setVisibility(View.GONE);
        txtErrPass.setVisibility(View.GONE);
        txtErrRePass.setVisibility(View.GONE);

        if (editTextPersonName.getText().toString().equals("")) {
            txtErrName.setVisibility(View.VISIBLE);
            return false;
        }

        if (editTextPersonEmail.getText().toString().equals("")) {
            txtErrEmail.setVisibility(View.VISIBLE);
            return false;
        }

        if (editTextPersonPassword.getText().toString().equals("")) {
            txtErrPass.setVisibility(View.VISIBLE);
            return false;
        }

        if (editTextPersonRePassword.getText().toString().equals("")) {
            txtErrRePass.setVisibility(View.VISIBLE);
            return false;
        }

        return true;
    }

    private void initViews() {
        Log.d(TAG, "initViews: Started");

        editTextPersonName = findViewById(R.id.editTextPersonName);
        editTextPersonEmail = findViewById(R.id.editTextPersonEmail);
        editTextPersonPassword = findViewById(R.id.editTextPersonPassword);
        editTextPersonRePassword = findViewById(R.id.editTextPersonRePassword);

        txtErrName = findViewById(R.id.txtErrName);
        txtErrEmail = findViewById(R.id.txtErrEmail);
        txtErrPass = findViewById(R.id.txtErrPass);
        txtErrRePass = findViewById(R.id.txtErrRePass);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        spinnerCountry = findViewById(R.id.spinnerCountry);

        radioGroup = findViewById(R.id.radioGroup);

        checkAgree = findViewById(R.id.checkAgree);

        mainLayout = findViewById(R.id.mainLayout);
    }
}