package com.example.projecthomestay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projecthomestay.R;

import Popular.Popular;

public class ShowDetailHomeStay extends AppCompatActivity {

    private TextView txtName;
    private TextView location;
    private ImageView imgView;
    private TextView desc;
    private TextView categoryName;
    private TextView price;
    private Button backHome;
    private Button addToCart;
    private Popular object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_home_stay);
        mappingView();
        bandle();

    }

    public void mappingView(){
        txtName = findViewById(R.id.title_detail);
        location = findViewById(R.id.location_detail);
        imgView = findViewById(R.id.img_product_detailt);
        desc = findViewById(R.id.desc_detail);
        categoryName = findViewById(R.id.categoriesID_detail);
        price = findViewById(R.id.price_detail);
        backHome = findViewById(R.id.ButtonBackHome);
        addToCart = findViewById(R.id.addCartDetail);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open();

            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void bandle(){
        object = (Popular)getIntent().getSerializableExtra("object");
        imgView.setImageResource(object.getResourceId());
        desc.setText(object.getDesc());
        txtName.setText(object.getTitle());
        location.setText(object.getLocation());
        price.setText("$"+ object.getPrice());
        categoryName.setText(object.getCategoryName());
    }

    public void open(){
        Intent intent = new Intent(this,AppActivity.class);
        startActivity(intent);
    }
}