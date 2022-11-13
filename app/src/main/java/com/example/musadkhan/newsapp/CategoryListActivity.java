package com.example.musadkhan.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musadkhan.newsapp.Models.NewsApiResponse;
import com.example.musadkhan.newsapp.Models.NewsHeadlines;

import java.util.List;

public class CategoryListActivity extends AppCompatActivity implements SelectListener{

    RecyclerView recyclerView;
    CustomAdapter adapter;
    LinearLayout bb;
    ProgressDialog dialog;
    TextView CategoryName;
    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        backImg = findViewById(R.id.backImg);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryListActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching News Articles For You..");
        dialog.show();

        String loadString = getIntent().getStringExtra("category");
        CategoryName = findViewById(R.id.cate_name);
        CategoryName.setText(loadString.toString());

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,loadString,null);

    }


private final onFetchDataListener<NewsApiResponse> listener = new onFetchDataListener<NewsApiResponse>() {
    @Override
    public void onFetchData(List<NewsHeadlines> list, String message) {
        if (list.isEmpty()){
            Toast.makeText(CategoryListActivity.this,"No Data Found",Toast.LENGTH_LONG).show();
        }else {
            showNews(list);
            dialog.dismiss();
        }
    }

    @Override
    public void onError(String message) {
        Toast.makeText(CategoryListActivity.this,"An Error Occure !!",Toast.LENGTH_LONG).show();
    }
};

    private void showNews(List<NewsHeadlines> list) {

        recyclerView = findViewById(R.id.categoryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onNewsCLicked(NewsHeadlines newsHeadlines) {
        startActivity(new Intent(CategoryListActivity.this,DetailsActivity.class)
                .putExtra("data",newsHeadlines));
    }
}