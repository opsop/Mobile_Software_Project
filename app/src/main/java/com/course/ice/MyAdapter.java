package com.course.ice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture, myLogo;
        TextView myText;

        MyViewHolder(View view){
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
            myLogo = view.findViewById(R.id.imageLogo);
        }
    }

    private ArrayList<Shoes> myShoesList;
    MyAdapter(ArrayList<Shoes> shoes_list){
        this.myShoesList = shoes_list;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.myLogo.setImageResource(myShoesList.get(position).getImageLogo());
        myViewHolder.myPicture.setImageResource(myShoesList.get(position).getImageID1());
        myViewHolder.myText.setText(myShoesList.get(position).getShoesName());

        if(myShoesList.get(position).getImageLogo() != 0) {
            myViewHolder.myLogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    String name = myShoesList.get(position).getShoesName();
                    int image0 = myShoesList.get(position).getImageLogo();
                    int image1 = myShoesList.get(position).getImageID1();
                    int image2 = myShoesList.get(position).getImageID2();
                    String price = myShoesList.get(position).getShoesPrice();
                    String url = myShoesList.get(position).getShoesUrl();
                    String detail = myShoesList.get(position).getShoesDetail();

                    Intent intent = new Intent(context.getApplicationContext(), ProductInfo.class);
                    intent.putExtra("image0", image0);
                    intent.putExtra("name", name);
                    intent.putExtra("image1", image1);
                    intent.putExtra("image2", image2);
                    intent.putExtra("price", price);
                    intent.putExtra("url", url);
                    intent.putExtra("detail", detail);
                    context.startActivity(intent);
                }
            });


            myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    String name = myShoesList.get(position).getShoesName();
                    int image0 = myShoesList.get(position).getImageLogo();
                    int image1 = myShoesList.get(position).getImageID1();
                    int image2 = myShoesList.get(position).getImageID2();
                    String price = myShoesList.get(position).getShoesPrice();
                    String url = myShoesList.get(position).getShoesUrl();
                    String detail = myShoesList.get(position).getShoesDetail();

                    Intent intent = new Intent(context.getApplicationContext(), ProductInfo.class);
                    intent.putExtra("image0", image0);
                    intent.putExtra("name", name);
                    intent.putExtra("image1", image1);
                    intent.putExtra("image2", image2);
                    intent.putExtra("price", price);
                    intent.putExtra("url", url);
                    intent.putExtra("detail", detail);
                    context.startActivity(intent);
                }
            });

            myViewHolder.myText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    int image0 = myShoesList.get(position).getImageLogo();
                    String name = myShoesList.get(position).getShoesName();
                    int image1 = myShoesList.get(position).getImageID1();
                    int image2 = myShoesList.get(position).getImageID2();
                    String price = myShoesList.get(position).getShoesPrice();
                    String url = myShoesList.get(position).getShoesUrl();
                    String detail = myShoesList.get(position).getShoesDetail();

                    Intent intent = new Intent(context.getApplicationContext(), ProductInfo.class);
                    intent.putExtra("image0", image0);
                    intent.putExtra("name", name);
                    intent.putExtra("image1", image1);
                    intent.putExtra("image2", image2);
                    intent.putExtra("price", price);
                    intent.putExtra("url", url);
                    intent.putExtra("detail", detail);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return myShoesList.size();
    }
}