package com.example.gy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtpndPas extends AppCompatActivity {
    private EditText otp;
    private EditText newPas;
    private EditText conPas;
    private String butName,newPasst,conPasst,otpst,s;
    private Button b1;
    private TextView emailDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpnd_pas);

        //s="sid";
        //Bundle xtra = getIntent().getExtras();
         //s = xtra.getString("sid");
        //emailDis.setVisibility(View.VISIBLE);
         //emailDis.setText("hi");

        b1=(Button) findViewById(R.id.butid);
        otp=(EditText) findViewById(R.id.otid);
        newPas=(EditText) findViewById(R.id.npassid);
        conPas=(EditText) findViewById(R.id.nconfrmpasid);
        emailDis=(TextView) findViewById(R.id.emailDis);


        Bundle xtra = getIntent().getExtras();
        s = xtra.getString("sid");

        emailDis.setText("OTP has been sent to: "+s);

        b1.setText("Confirm");
        butName=b1.getText().toString();

        newPas.setVisibility(View.INVISIBLE);
        conPas.setVisibility(View.INVISIBLE);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPasst=newPas.getText().toString();
                conPasst=conPas.getText().toString();
                otpst=otp.getText().toString();

                if(butName.equals("Save"))
                {

                    if(TextUtils.isEmpty(newPasst)||TextUtils.isEmpty(conPasst)||!conPasst.equals(newPasst)) {
                        if (TextUtils.isEmpty(newPasst)) {
                            newPas.setError("Field is empty");
                        }
                        if (TextUtils.isEmpty(conPasst)) {
                            conPas.setError("Field is empty");
                        }
                        if (!conPasst.equals(newPasst)) {
                            conPas.setError("Password doesn't match");
                        }
                        if(newPas.length()<6)
                        {
                            newPas.setError("Minimum length 6");
                            //conPas.setError("Minimum length 6");
                        }
                    }
                    else {
                        goTologin();
                    }

                }
                if(butName.equals("Confirm"))
                {
                    //if (TextUtils.isEmpty(otpst) || otp.length() != 6) {


                        if (TextUtils.isEmpty(otpst)) {
                            otp.setError("Field is empty");
                        }
                        if (otp.length() != 6) {
                            otp.setError("otp must be equal to 6");
                        }
                    //}
                    else {
                        getOtp();
                        b1.setText("Save");
                        butName = "Save";
                    }
                }

            }
        });
    }
    public void getOtp()
    {

        emailDis.setVisibility(View.INVISIBLE);
        otp.setVisibility(View.INVISIBLE);
        newPas.setVisibility(View.VISIBLE);
        conPas.setVisibility(View.VISIBLE);
        //next.setText("Confirm");
        //butName = next.getText().toString();
    }
    public void goTologin()
    {
        Intent intent=new Intent(OtpndPas.this, MainActivity.class);
        startActivity(intent);
    }
}
