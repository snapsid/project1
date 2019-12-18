package com.example.gy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class ForgetReal extends AppCompatActivity {

    private Button b1;
    private EditText email;
    private String emailst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_real);

        b1=(Button) findViewById(R.id.sendid);
        email=(EditText) findViewById(R.id.emailforid);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailst=email.getText().toString();

                if(TextUtils.isEmpty(emailst))
                {
                    email.setError("Field is empty");
                }

                else {

                    Intent intent = new Intent(ForgetReal.this, OtpndPas.class);
                    intent.putExtra("sid", emailst);
                    startActivity(intent);
                }
            }
        });
    }
}
