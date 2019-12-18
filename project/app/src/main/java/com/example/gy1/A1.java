package com.example.gy1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class A1 extends AppCompatActivity {
    ListView li;

    List<User> userList;
    DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        mDatabase = FirebaseDatabase.getInstance().getReference("user");

        li=(ListView) findViewById(R.id.listid);

        userList= new ArrayList<>();
        //String food[] ={"a", "b", "c", "d", "e"};

    }

    @Override
    protected void onStart() {
        super.onStart();
        mDatabase.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();
                for(DataSnapshot snap : dataSnapshot.getChildren())
                {
                    User user= snap.getValue(User.class);

                    //ListAdapter ll=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, food);
                    userList.add(user);

                }

                ArtistList adapter=new ArtistList(A1.this, userList);
                li.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
