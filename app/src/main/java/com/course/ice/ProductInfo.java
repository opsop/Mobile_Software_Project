package com.course.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        TextView t1 = (TextView)findViewById(R.id.textView4);
        TextView t2 = (TextView)findViewById(R.id.textView5);
        TextView t3 = (TextView)findViewById(R.id.textView6);
        TextView t4 = (TextView)findViewById(R.id.textView7);
        ImageView i1 = (ImageView)findViewById(R.id.imageView2);
        ImageView i2 = (ImageView)findViewById(R.id.imageView3);
        ImageView i0 = (ImageView)findViewById(R.id.logo);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("name");
        String price = intent.getExtras().getString("price");
        String detail = intent.getExtras().getString("detail");
        String url = intent.getExtras().getString("url");
        int image1 = intent.getExtras().getInt("image1");
        int image2 = intent.getExtras().getInt("image2");
        int image0 = intent.getExtras().getInt("image0");

        t1.setText(String.valueOf(name));
        t2.setText(String.valueOf(price));
        t3.setText(String.valueOf(detail));
        t4.setText(String.valueOf(url));
        i1.setImageResource(image1);
        i2.setImageResource(image2);
        i0.setImageResource(image0);

        t4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent1);
            }
        });

    }
}