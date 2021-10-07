package com.example.projecthomestay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthomestay.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import Category.ListCategoryAdapter;
import Category.categoryA;
import Popular.Popular;
import Product.Product;
import Product.ProductAdapter;
import homestay.homestay;


public class AppActivity extends AppCompatActivity  {

    private BottomNavigationView navigationView;
    private RecyclerView recyclerViewCategoryList,recyclerViewProductList;
    private ListCategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private Button btnShowDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
//
//        recyclerViewCategoryList = findViewById(R.id.categories);
//        categoryAdapter = new ListCategoryAdapter(this);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL , false);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//        categoryAdapter.setData(GetCategory());
//        recyclerViewCategoryList.setAdapter(categoryAdapter);
//
//        recyclerViewProductList = findViewById(R.id.product_rec);
//        productAdapter = new ProductAdapter(this);
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL , false);
//        recyclerViewProductList.setLayoutManager(linearLayoutManager1);
//        productAdapter.setData(getProduct());
//        recyclerViewProductList.setAdapter(productAdapter);

        navigationView = findViewById(R.id.navigationBottom);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomePage()).commit();
        navigationView.setSelectedItemId(R.id.homepage);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.homepage:
                        selectedFragment = new HomePage();

                        break;
                    case R.id.productpage:
                        selectedFragment = new ProductPage();
                        break;
                    case R.id.searchpage:
                        selectedFragment = new searchPage();
                        break;
                    case R.id.customerpage:
                        selectedFragment = new CustomerPage();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,
                        selectedFragment).commit();

                return true;
            }
        });



    }


    private List<categoryA> GetCategory() {
        List<categoryA> list = new ArrayList<>();

        List<homestay> listCategory = new ArrayList<>();

        listCategory.add(new homestay("Homestay 1",R.drawable.category4));
        listCategory.add(new homestay("Homestay 2",R.drawable.category4));
        listCategory.add(new homestay("Homestay 3",R.drawable.category2));
        listCategory.add(new homestay("Homestay 4",R.drawable.category2));
        listCategory.add(new homestay("Homestay 5",R.drawable.category2));

        list.add(new categoryA("Category", listCategory));


        return list;
    }




}

