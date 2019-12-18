package com.example.gy1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button log;
    private TextView register,forget;
    private String na,pa;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.userid);
        pass=(EditText) findViewById(R.id.passid);
        log=(Button) findViewById(R.id.logid);
        register=(TextView) findViewById(R.id.registerid);
        forget=(TextView) findViewById(R.id.forgetid);

        mAuth=FirebaseAuth.getInstance();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                na=name.getText().toString();
                pa=pass.getText().toString();

                //intent.

                if (TextUtils.isEmpty(na)||TextUtils.isEmpty(pa)) {
                    if(TextUtils.isEmpty(na)) {
                        name.setError("Field is empty");
                    }
                    if(TextUtils.isEmpty(pa))
                    {
                    pass.setError("Field is empty");
                }}
                else {
                    attemptLogin();
                }


//                Intent intent=new Intent(MainActivity.this, A1.class);
//
//
//                na=name.getText().toString();
//                pa=pass.getText().toString();
//                intent.putExtra("sid", na);
//                //intent.
//
//                if (TextUtils.isEmpty(na)||TextUtils.isEmpty(pa)) {
//                    if(TextUtils.isEmpty(na)) {
//                        name.setError("Field is empty");
//                    }
//                    if(TextUtils.isEmpty(pa))
//                    {
//                    pass.setError("Field is empty");
//                }}
//                else{
//                    startActivity(intent);
//                }





            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //String na=name.getText().toString();
                //intent.putExtra("sid", na);
                //intent.

                    Intent intent=new Intent(MainActivity.this, Register.class);
                    startActivity(intent);

            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ForgetReal.class);
                startActivity(intent);
            }
        });
    }

    private void attemptLogin()
    {
        String email=name.getText().toString();
        String password=pass.getText().toString();


//        if(email.equals("") || password.equals("")){
//            return;
//        }
//        else{
//            Toast.makeText(this, "login in progress", Toast.LENGTH_SHORT).show();
//        }

        // TODO: Use FirebaseAuth to sign in with email & password

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("msg1", "signInWithEmail complete"+ task.isSuccessful());
                if(!task.isSuccessful()){

                    Log.d("msg1","problem signing in"+task.getException());
                    showAlert("There was a problem in signing in...");

                }
                else{
                    Intent intent=new Intent(MainActivity.this, A1.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    private void showAlert(String mes){
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("oops");
        alert.setPositiveButton(android.R.string.ok,null);
        alert.setMessage(mes);
        alert.setIcon(android.R.drawable.ic_dialog_alert);
        alert.show();


    }
}
