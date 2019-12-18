package com.example.gy1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private TextView alreadyHave;
    private EditText first,email1,createPas,confirmPas;
   // private EditText pas,conPas;
    private String firstSt, emailSt, createPasSt,confirmPasSt, sapSt, courseSt, yearSt;
    private String firstSt1, emailSt1, createPasSt1,confirmPasSt1, sapSt1, courseSt1, yearSt1;
    //private  String pasSt, conPasSt;
    private Button createBut;

    private EditText sap, course, year;

    private FirebaseAuth mAuth;
     DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        alreadyHave=findViewById(R.id.alreadyid);
        first=(EditText) findViewById(R.id.firstid);
        createPas=(EditText) findViewById(R.id.lastid);
        //pas=(EditText) findViewById(R.id.passid);
        //conPas=(EditText) findViewById(R.id.confpassid);
        confirmPas=(EditText) findViewById(R.id.phoneid);
        email1=(EditText) findViewById(R.id.emailid);
        createBut=(Button) findViewById(R.id.creid);

        sap=(EditText) findViewById(R.id.sapid);
        course=(EditText) findViewById(R.id.courseid);
        year=(EditText) findViewById(R.id.yearid);

        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("user");

//        createBut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //alreadyHave.setText("hi");
//                firstSt=first.getText().toString();
//                lastSt=last.getText().toString();
//                //pasSt=pas.getText().toString();
//                //conPasSt=conPas.getText().toString();
//                emailSt=email.getText().toString();
//                phoneSt=phone.getText().toString();
//
//                if(TextUtils.isEmpty(firstSt)||TextUtils.isEmpty(lastSt)/*||TextUtils.isEmpty(pasSt)||TextUtils.isEmpty(conPasSt)
//                        */||TextUtils.isEmpty(emailSt)||TextUtils.isEmpty(phoneSt)
//                        ||phoneSt.length()!=10 )/*
//                        ||!pasSt.equals(conPasSt)pasSt.length()<6)*/ {
//                    if(TextUtils.isEmpty(firstSt))
//                    {
//                        first.setError("Field is empty");
//                    }
//                    if(TextUtils.isEmpty(lastSt))
//                    {
//                        last.setError("Field is empty");
//                    }
//                    /*
//                    if(TextUtils.isEmpty(pasSt))
//                    {
//                        pas.setError("Field is empty");
//                    }
//                    if(TextUtils.isEmpty(conPasSt))
//                    {
//                        conPas.setError("Field is empty");
//                    }*/
//                    if(TextUtils.isEmpty(emailSt))
//                    {
//                        email.setError("Field is empty");
//                    }
//                    if(TextUtils.isEmpty(phoneSt))
//                    {
//                        phone.setError("Field is empty");
//                    }/*
//                    if(!pasSt.equals(conPasSt))
//                    {
//                        conPas.setError("Password doesn't match");
//                        pas.setError("Password doesn't match");
//                    }*/
//                    if(phoneSt.length()!=10)
//                    {
//                        phone.setError("Invalid phone no.");
//                    }/*
//                    if(pas.length()<6)
//                    {
//                        pas.setError("Minimum length 6");
//                        conPas.setError("Minimum length 6");
//                    }*/
//
//
//                }
//
//
//                else {
//                    //if(pasSt.equals(conPasSt))
//                    //{
//                      //  conPas.setError("Password doesn't match");
//                    //}
//                    //else {
//                        Intent intent = new Intent(Register.this, OtpndPas.class);
//                    intent.putExtra("sid", emailSt);
//                        startActivity(intent);
//                    //}
//                }
//            }
//        });
        /*
        registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                firstSt=first.getText().toString();
                lastSt=last.getText().toString();
                pasSt=pas.getText().toString();
                conPasSt=conPas.getText().toString();
                emailSt=email.getText().toString();
                phoneSt=phone.getText().toString();

                if(TextUtils.isEmpty(firstSt)||TextUtils.isEmpty(lastSt)||TextUtils.isEmpty(pasSt)||TextUtils.isEmpty(conPasSt)
                        ||TextUtils.isEmpty(emailSt)||TextUtils.isEmpty(phoneSt)) {
                    first.setError("Enter name");
                    last.setError("Enter password");
                    pas.setError("Enter name");
                    conPas.setError("Enter password");
                    email.setError("Enter name");
                    phone.setError("Enter password");

                }

                else
                {
                    Intent intent=new Intent(Register.this, A1.class);
                    startActivity(intent);
                }
                Intent intent=new Intent(Register.this, A1.class);
                startActivity(intent);

            }
        });*/

        alreadyHave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        createBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                firstSt=first.getText().toString();
                emailSt=email1.getText().toString();
                createPasSt=createPas.getText().toString();
                confirmPasSt=confirmPas.getText().toString();

                sapSt=sap.getText().toString();
                courseSt=course.getText().toString();
                yearSt=year.getText().toString();

                if(TextUtils.isEmpty(firstSt)||TextUtils.isEmpty(emailSt)/*||TextUtils.isEmpty(pasSt)||TextUtils.isEmpty(conPasSt)
                        */||TextUtils.isEmpty(createPasSt)||TextUtils.isEmpty(confirmPasSt)
                        ||createPasSt.length()<5 || !createPasSt.equals(confirmPasSt)||TextUtils.isEmpty(sapSt)||TextUtils.isEmpty(courseSt)||TextUtils.isEmpty(yearSt)) {
                    if(TextUtils.isEmpty(firstSt))
                    {
                        first.setError("Field is empty");
                    }
                    if(TextUtils.isEmpty(emailSt))
                    {
                        email1.setError("Field is empty");
                    }
                    /*
                    if(TextUtils.isEmpty(pasSt))
                    {
                        pas.setError("Field is empty");
                    }
                    if(TextUtils.isEmpty(conPasSt))
                    {
                        conPas.setError("Field is empty");
                    }*/
                    if(TextUtils.isEmpty(createPasSt))
                    {
                        createPas.setError("Field is empty");
                    }
                    if(TextUtils.isEmpty(confirmPasSt))
                    {
                        confirmPas.setError("Field is empty");
                    }/*
                    if(!pasSt.equals(conPasSt))
                    {
                        conPas.setError("Password doesn't match");
                        pas.setError("Password doesn't match");
                    }*/
                    if(createPas.length()<5)
                    {
                        createPas.setError("Min length = 6 ");
                    }

                    if(!createPasSt.equals(confirmPasSt)){
                        confirmPas.setError("Pass do not match");
                    }
                    /*
                    if(pas.length()<6)
                    {
                        pas.setError("Minimum length 6");
                        conPas.setError("Minimum length 6");
                    }*/


                    if(TextUtils.isEmpty(sapSt))
                    {
                        sap.setError("Field is empty");
                    }
                    if(TextUtils.isEmpty(courseSt))
                    {
                        course.setError("Field is empty");
                    }
                    if(TextUtils.isEmpty(yearSt))
                    {
                        year.setError("Field is empty");
                    }

                    if(sapSt.length()!=9)
                    {
                        sap.setError("LENGTH MUST 9");
                    }
                }


                else {
                    //if(pasSt.equals(conPasSt))
                    //{
                      //  conPas.setError("Password doesn't match");
                    //}
                    //else {

                    //}
                    createFirebaseUser();
                    writeNewUser();
                }
            }





        });
    }

    private void writeNewUser() {

        firstSt1=first.getText().toString();
        emailSt1=email1.getText().toString();
        createPasSt1=createPas.getText().toString();
        confirmPasSt1=confirmPas.getText().toString();

        sapSt1=sap.getText().toString();
        courseSt1=course.getText().toString();
        yearSt1=year.getText().toString();
        User user=new User(firstSt1, courseSt1, yearSt1, emailSt1);

        //String id= mDatabase.push().getKey();

        //mDatabase.child(id).setValue(user);
        //mDatabase.setValue("hi");
        mDatabase.child(sapSt1).setValue(user);

    }


    private void createFirebaseUser(){
        String email=email1.getText().toString();
        String password=createPas.getText().toString();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("msg1", "create user onComplete: "+ task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.d("msg1", "user creation failed");
                    showAlertDialog("Registration failed");
                }
                else{
                    Intent intent=new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });





    }

    private void showAlertDialog(String message){

        new AlertDialog.Builder(this )
                .setTitle("oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
