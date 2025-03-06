package com.myapp.shopeeng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {
    private Context context;
    private List<CarModel> carList;
    private OnCarClickListener listener;

    public interface OnCarClickListener {
        void onAddToCartClick(CarModel car);
    }

    public CarAdapter(Context context, List<CarModel> carList, OnCarClickListener listener) {
        this.context = context;
        this.carList = carList;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return carList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        }

        CarModel car = carList.get(position);

        ImageView carImage = convertView.findViewById(R.id.carImage);
        TextView carName = convertView.findViewById(R.id.carName);
        TextView carPrice = convertView.findViewById(R.id.carPrice);
        Button addToCartButton = convertView.findViewById(R.id.addToCart);

        carImage.setImageResource(car.getImageResId());
        carName.setText(car.getName());
        carPrice.setText(String.format("₱%,d", car.getPrice()));

        addToCartButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddToCartClick(car);
            }
        });

        return convertView;
    }
}