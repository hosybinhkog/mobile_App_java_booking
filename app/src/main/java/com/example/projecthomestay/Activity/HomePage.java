package com.example.projecthomestay.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projecthomestay.R;

import java.util.ArrayList;
import java.util.List;

import Category.ListCategoryAdapter;
import Category.categoryA;
import Popular.Popular;
import Product.Product;
import Product.ProductAdapter;
import homestay.homestay;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnShowDetail;
    Context thiscontext;

    private RecyclerView recyclerViewCategoryList,recyclerViewProductList;
    private ListCategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;

    public HomePage() {
        // Required empty public constructor

    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePage.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePage newInstance(String param1, String param2) {
        HomePage fragment = new HomePage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context thiscontext = container.getContext();
        View view =  inflater.inflate(R.layout.fragment_home_page, container, false);

        recyclerViewCategoryList = view.findViewById(R.id.categories);
        categoryAdapter = new ListCategoryAdapter(thiscontext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(thiscontext, RecyclerView.VERTICAL , false);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(GetCategory());
        recyclerViewCategoryList.setAdapter(categoryAdapter);

        recyclerViewProductList = view.findViewById(R.id.product_rec);
        productAdapter = new ProductAdapter(thiscontext);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(thiscontext, RecyclerView.VERTICAL , false);
        recyclerViewProductList.setLayoutManager(linearLayoutManager1);
        productAdapter.setData(getProduct());
        recyclerViewProductList.setAdapter(productAdapter);

        View view1 =  inflater.inflate(R.layout.view_card_mathparent, container, false);


        return view;
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
    private List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        List<Popular> listPopular = new ArrayList<>();

        listPopular.add(new Popular("Dalat 1","Dalat lanh lam em oi a nho em nhieu lam hehe",R.drawable.category4,"Nghệ An ấm áp",760,"loại 1"));
        listPopular.add(new Popular("Popular 3","Hanoi hom nay nho  3em",R.drawable.popular2,"Nghệ An ấm áp",760,"loại 1"));
        listPopular.add(new Popular("Popular 4","Hanoi hom nay nho 2 em",R.drawable.category4,"Nghệ An ấm áp",760,"loại 1"));
        listPopular.add(new Popular("Popular 5","Hanoi hom nay nho 3 em",R.drawable.category4,"Nghệ An ấm áp",760,"loại 1"));
        listPopular.add(new Popular("Popular 1","Hanoi hom nay nho em",R.drawable.category4,"Nghệ An ấm áp",760,"loại 1"));


        list.add(new Product(listPopular,"Popular"));

        return list;
    }

}