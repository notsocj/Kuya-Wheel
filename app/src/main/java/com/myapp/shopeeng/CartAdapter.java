package com.myapp.shopeeng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CartAdapter extends ArrayAdapter<CarModel> {
    private Context context;
    private List<CarModel> cartItems;

    public CartAdapter(Context context, List<CarModel> cartItems) {
        super(context, R.layout.item_cart, cartItems);
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        }

        CarModel car = cartItems.get(position);

        ImageView carImage = convertView.findViewById(R.id.cartItemImage);
        TextView carName = convertView.findViewById(R.id.cartItemName);
        TextView carPrice = convertView.findViewById(R.id.cartItemPrice);

        carImage.setImageResource(car.getImageResId());
        carName.setText(car.getName());
        carPrice.setText(String.format("₱%,d", car.getPrice()));

        return convertView;
    }
}