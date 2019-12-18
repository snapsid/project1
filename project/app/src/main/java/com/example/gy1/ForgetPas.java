package com.example.gy1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

public class ForgetPas extends AppCompatActivity {

    private Button next;
    private EditText emailForget;
    private EditText otp;
    private EditText newPas;
    private EditText conPas;
    private String butName;
    private String pasSt, conPasSt,emailSt,otpSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pas);

        emailForget=(EditText) findViewById(R.id.forgetEmailid);
        next=(Button) findViewById(R.id.nextId);
        otp=(EditText) findViewById(R.id.otpid);
        newPas=(EditText) findViewById(R.id.newpassid);
        conPas=(EditText) findViewById(R.id.newconfrmpasid);
        next.setText("Get OTP");

        otp.setVisibility(View.INVISIBLE);
        conPas.setVisibility(View.INVISIBLE);
        newPas.setVisibility(View.INVISIBLE);


        butName=next.getText().toString();


            next.setOnClickListener(new View.OnClickListener() {





                @Override
                public void onClick(View view) {
                    pasSt=newPas.getText().toString();
                    conPasSt=conPas.getText().toString();
                    emailSt=emailForget.getText().toString();
                    otpSt=otp.getText().toString();

                    if(butName.equals("Get OTP")) {
                        if(TextUtils.isEmpty(emailSt))
                        {
                            emailForget.setError("Field is empty");
                        }
                        else {
                            forgetPa();
                            next.setText("Verify");
                            butName = "Verify";
                        }

                    }
                    if(butName.equals("Continue"))
                    {
                        if(TextUtils.isEmpty(conPasSt))
                        {
                            conPas.setError("Field is empty");
                        }
                        if(!conPasSt.equals(pasSt))
                        {
                            conPas.setError("Password doesn't match");
                        }
                        else {
                            goTologin();
                        }
                        //butName="CONFIRM";
                    }
                    if(butName.equals("save"))
                    {
                        if(TextUtils.isEmpty(pasSt))
                        {
                            newPas.setError("Field is empty");
                        }

                        else {
                            save();
                            next.setText("Continue");
                            butName = "Continue";
                        }
                    }
                    if(butName.equals("CONFIRM"))
                    {
                        if(TextUtils.isEmpty(otpSt))
                        {
                            otp.setError("Field is empty");
                        }
                        if(otpSt.length()!=6)
                        {
                            otp.setError("otp must be equal to 6");
                        }
                        else {
                            confirm();
                            next.setText("save");
                            butName = "save";
                        }
                    }


                    if(butName.equals("Verify"))
                    {

                        getOtp();
                        next.setText("CONFIRM");
                        butName="CONFIRM";
                    }



                    //if(butName.equals("Get OTP")) {

                    //}
                    //if(butName.equals("Proceed")) {
                    //  otp.setVisibility(View.INVISIBLE);
                    //next.setText("Verify");
                    //}
                }
            });
        /*
        if(next.getText().equals("")) {
            next.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    //if(butName.equals("Get OTP")) {
                    //}
                    //if(butName.equals("Proceed")) {
                     otp.setVisibility(View.INVISIBLE);
                    next.setText("Verify");
                    butName=next.getText().toString();
                    //}
                }
            });
        }*/

    }
    public void forgetPa()
    {
        emailForget.setVisibility(View.INVISIBLE);
        otp.setVisibility(View.VISIBLE);
        //next.setText("Verify");
        //butName = next.getText().toString();
    }
    public void getOtp()
    {

        otp.setVisibility(View.VISIBLE);
        //next.setText("Confirm");
        //butName = next.getText().toString();
    }
    public void confirm()
    {
        //next.setText("SAVE");
        otp.setVisibility(View.INVISIBLE);
        newPas.setVisibility(View.VISIBLE);
        //butName = next.getText().toString();
    }
    public void save()
    {
        //next.setText("SAVE");
        //otp.setVisibility(View.INVISIBLE);
        newPas.setVisibility(View.INVISIBLE);
        conPas.setVisibility(View.VISIBLE);
        //butName = next.getText().toString();
    }
    public void goTologin()
    {
        Intent intent=new Intent(ForgetPas.this, MainActivity.class);
        startActivity(intent);
    }

}