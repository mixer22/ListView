package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    ArrayList<User> users;

    Button b_name;
    Button b_sex;
    Button b_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
//        InputStream stream = getResources().openRawResource(R.raw.users);
        InputStream stream = null;
        try {
            stream = getAssets().open("users.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        User[] users_arr = gson.fromJson(new InputStreamReader(stream), User[].class);
        users = new ArrayList<>(Arrays.asList(users_arr));

        Log.d("mytag", "users:" + users_arr.length);

        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }

    public void onNameClick(View view)
    {
        Collections.sort(users, new NameComparator());
        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }

    public void onNumberClick(View view)
    {
        Collections.sort(users, new NumberComparator());
        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }

    public void onSexClick(View view)
    {
        Collections.sort(users, new SexComparator());
        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }
}