package com.myapp.shopeeng;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private ListView cartListView;
    private TextView totalPriceText;
    private Button checkoutButton;
    private List<CarModel> cartItems;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize views
        cartListView = findViewById(R.id.cartListView);
        totalPriceText = findViewById(R.id.totalPriceText);
        checkoutButton = findViewById(R.id.checkoutButton);

        // Get cart items from CategoryDetailsActivity
        cartItems = CategoryDetailsActivity.getCartItems();
        cartAdapter = new CartAdapter(this, cartItems);
        cartListView.setAdapter(cartAdapter);

        updateTotalPrice();

        checkoutButton.setOnClickListener(v -> processCheckout());
    }

    private void updateTotalPrice() {
        int total = 0;
        for (CarModel car : cartItems) {
            total += car.getPrice();
        }
        totalPriceText.setText(String.format("Total: ₱%,d", total));
    }


    private void processCheckout() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.qr_code_popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button closeButton = dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    // Method to add item to cart
    public void addToCart(CarModel car) {
        cartItems.add(car);
        cartAdapter.notifyDataSetChanged();
        updateTotalPrice();
    }

}