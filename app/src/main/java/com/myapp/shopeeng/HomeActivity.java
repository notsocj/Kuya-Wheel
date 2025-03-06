package com.myapp.shopeeng;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.recyclerview.widget.GridLayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class HomeActivity extends AppCompatActivity {
    private GridView categoryGridView;
    private List<CategoryModel> categoryList;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        categoryGridView = findViewById(R.id.categoryGridView); // Make sure this matches your XML ID
        categoryList = new ArrayList<>();

        // Adding categories
        categoryList.add(new CategoryModel("Mazda", R.drawable.logo_mazda));
        categoryList.add(new CategoryModel("Toyota", R.drawable.logo_toyota));
        categoryList.add(new CategoryModel("Tesla", R.drawable.logo_tesla));
        categoryList.add(new CategoryModel("Ferrari", R.drawable.logo_ferrari));
        categoryList.add(new CategoryModel("Lamborghini", R.drawable.logo_lamborghini));
        categoryList.add(new CategoryModel("BMW", R.drawable.logo_bmw));
        categoryList.add(new CategoryModel("Mercedes", R.drawable.logo_mercedes));
        categoryList.add(new CategoryModel("Audi", R.drawable.logo_audi));
        categoryList.add(new CategoryModel("Ford", R.drawable.logo_ford));

        adapter = new CategoryAdapter(this, categoryList);
        categoryGridView.setAdapter(adapter);

        // Handle click events
        categoryGridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(HomeActivity.this, CategoryDetailsActivity.class);
            intent.putExtra("categoryName", categoryList.get(position).getName());
            startActivity(intent);
        });
    }
}