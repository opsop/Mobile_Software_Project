package com.course.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyPage extends AppCompatActivity {

    Button go_main, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        String name = intent.getExtras().getString("name");
        String phone = intent.getExtras().getString("phone");

        TextView t1 = (TextView) findViewById(R.id.customerID);
        TextView t2 = (TextView) findViewById(R.id.customerName);
        TextView t3 = (TextView) findViewById(R.id.customerPhone);
        t1.setText(String.valueOf(id));
        t2.setText(String.valueOf(name));
        t3.setText(String.valueOf(phone));

        go_main = (Button)findViewById(R.id.go_main);
        logout = (Button)findViewById(R.id.logout);

        go_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPage.this, MainActivity2.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}