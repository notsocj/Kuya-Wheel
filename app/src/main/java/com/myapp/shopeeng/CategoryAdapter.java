package com.myapp.shopeeng;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<CategoryModel> {

    private Context context;
    private List<CategoryModel> categoryList;

    public CategoryAdapter(Context context, List<CategoryModel> categoryList) {
        super(context, R.layout.item_category, categoryList);
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        }

        CategoryModel category = categoryList.get(position);

        ImageView categoryImage = convertView.findViewById(R.id.categoryImage);
        TextView categoryName = convertView.findViewById(R.id.categoryName);
        Button shopbutton = convertView.findViewById(R.id.shopButton);

        categoryImage.setImageResource(category.getImageResId());
        categoryName.setText(category.getName());

        shopbutton.setOnClickListener(v -> {
            Intent intent = new Intent(context, CategoryDetailsActivity.class);
            intent.putExtra("categoryName", category.getName());
            context.startActivity(intent);
        });

        return convertView;
    }
}
