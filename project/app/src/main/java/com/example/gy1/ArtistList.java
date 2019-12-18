package com.example.gy1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ArtistList extends ArrayAdapter<User> {

    private Activity context;
    private List<User> userlist;

    public ArtistList(Activity context, List<User> userlist) {
        super(context, R.layout.list_layout, userlist);
        this.context = context;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflator =context.getLayoutInflater();
        View listViewItem=inflator.inflate(R.layout.list_layout, null, true);

        TextView t1=(TextView) listViewItem.findViewById(R.id.t1id);
        TextView t2=(TextView) listViewItem.findViewById(R.id.t2id);
        TextView t3=(TextView) listViewItem.findViewById(R.id.t3id);
        TextView t4=(TextView) listViewItem.findViewById(R.id.t4id);

        User user=userlist.get(position);

        t1.setText(user.getName());
        t2.setText(user.getCourse());
        t3.setText(user.getEmail());
        t4.setText(user.getYear());

        return listViewItem;
    }
}
