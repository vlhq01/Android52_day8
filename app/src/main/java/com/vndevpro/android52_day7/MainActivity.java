package com.vndevpro.android52_day7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView rvDemo;
    private ArrayList<Product> mListProduct;
    private ProductAdapter mProductAdapter;
    private SqliteHelper mSqliteHelper;
    int selectedid = -1;
    Button flbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flbtn = findViewById(R.id.btnmainadd);
        handleAddButton();
        initData();
        initView();


    }
    private void handleAddButton(){
        flbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,add.class);
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();

        String title = bundle.getString("title");
        Integer price = bundle.getInt("price");
        String des = bundle.getString("des");


        Product product = new Product();
        product.setTitle(title);
        product.setDescription(des);
        product.setPrice(price);
        product.setDiscountPercentage(12.96);
        product.setRating(4.69);
        product.setStock(94);
        product.setBrand("Apple");
        product.setCategory("smartphones");
        product.setThumbnail("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
        product.setImages("[https://i.dummyjson.com/data/products/1/1.jpg" + ",https://i.dummyjson.com/data/products/1/2.jpg" + ",https://i.dummyjson.com/data/products/1/3.jpg" + ", https://i.dummyjson.com/data/products/1/4.jpg" + ", https://i.dummyjson.com/data/products/1/thumbnail.jpg]");
        if(requestCode==100 && resultCode==200){

            mListProduct.add(product);
            mSqliteHelper.insertNewProduct(product);
        }
        else if(requestCode == 200 && resultCode == 201) {
            Product product1 = product;
        product1.setTitle(title);
        product1.setDescription(des);
        product1.setPrice(price);
        mSqliteHelper.updateNewProduct(3,product1);
        }

<<<<<<< HEAD

=======
        mListProduct = mSqliteHelper.getListProduct();
        mProductAdapter.notifyDataSetChanged();
        rvDemo.setAdapter(mProductAdapter);
>>>>>>> 4ca4411 (Initial commit)

    }
    private void initView() {
        rvDemo = findViewById(R.id.rvDemo);
        mProductAdapter = new ProductAdapter(mListProduct);
        mProductAdapter.setCallback(clickListener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvDemo.setLayoutManager(linearLayoutManager);
        rvDemo.setHasFixedSize(true);
//        rvDemo.setItemViewCacheSize(10);
        rvDemo.setAdapter(mProductAdapter);
    }

    private IItemClickListener clickListener = new IItemClickListener() {
        @Override
        public void onItemClick(int pos) {

        }

        @Override
        public void onChangeWishList(int position) {
            Product productModel = mListProduct.get(position);
            productModel.setWish(!productModel.isWish());
            mListProduct.set(position, productModel);
//            mProductAdapter.notifyDataSetChanged();
            mProductAdapter.notifyItemChanged(position);
        }

        @Override
        public void onDelete(int position) {
            mListProduct.remove(position);
//            mProductAdapter.notifyDataSetChanged();
            mProductAdapter.notifyItemRemoved(position);

        }

        @Override
        public void onUpdate(int position) {
            Product productModel = mListProduct.get(position);
            productModel.setTitle(productModel.getTitle() + " new");
            mListProduct.set(position, productModel);
            mProductAdapter.notifyDataSetChanged();
        }
    };

    private void initData() {
//        mListProduct = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            ProductModel productModel = new ProductModel();
//            productModel.setProductName("Product " + i);
//            productModel.setProductImage("https://play-lh.googleusercontent.com/j9zl-GpzBaNY_nAE4XJ5LquJihqK3FqrhwEKNwwdFsp7RcIz0b-CNFGL5OEk_hiSPKnr");
//            productModel.setProductPrices("$" + (i + 1 * 1000));
//            productModel.setRate(new Random().nextInt(5) + "");
//            productModel.setWish(false);
//            mListProduct.add(productModel);
//        }
        mSqliteHelper = new SqliteHelper(this);

//        Product product = new Product();
//        product.setTitle("iPhone 9");
//        product.setDescription("An apple mobile ");
//        product.setPrice(549);
//        product.setDiscountPercentage(12.96);
//        product.setRating(4.69);
//        product.setStock(94);
//        product.setBrand("Apple");
//        product.setCategory("smartphones");
//        product.setThumbnail("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
//        product.setImages("[https://i.dummyjson.com/data/products/1/1.jpg" + ",https://i.dummyjson.com/data/products/1/2.jpg" + ",https://i.dummyjson.com/data/products/1/3.jpg" + ", https://i.dummyjson.com/data/products/1/4.jpg" + ", https://i.dummyjson.com/data/products/1/thumbnail.jpg]");

//        mSqliteHelper.insertNewProduct(product);
//        Product product1 = product;
//        product1.setTitle("Iphone 8");
//        mSqliteHelper.updateNewProduct(3,product1);
//
//        Product product2 = product;
//        product1.setTitle("Iphone 7");
//        mSqliteHelper.updateNewProduct(4,product2);

//        mSqliteHelper.deleteProduct(1);

        mListProduct = mSqliteHelper.getListProduct();
    }
}