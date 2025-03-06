package com.myapp.shopeeng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class CategoryDetailsActivity extends AppCompatActivity {
    private TextView categoryTitle;
    private GridView carGridView;
    private CarAdapter carAdapter;
    private List<CarModel> carList;
    private static List<CarModel> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_details);

        // Fix the ViewCompat setup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    categoryTitle = findViewById(R.id.categoryTitle);
    carGridView = findViewById(R.id.carGridView);

    // Get the category name from Intent
    Intent intent = getIntent();
    String category = intent.getStringExtra("categoryName");
        categoryTitle.setText(category);

    // Initialize car list
    carList = initializeCarList(category);

    // Set up adapter with cart functionality
    carAdapter = new CarAdapter(this, carList, new CarAdapter.OnCarClickListener() {
        @Override
        public void onAddToCartClick(CarModel car) {
            addToCart(car);
        }
    });
        carGridView.setAdapter(carAdapter);
}

private List<CarModel> initializeCarList(String category) {
    List<CarModel> cars = new ArrayList<>();
    switch (category) {
        case "Mazda":
            cars.add(new CarModel("Mazda 3", R.drawable.logo_mazda3, 1200000));
            cars.add(new CarModel("Mazda RX7", R.drawable.logo_mazdarx7, 1800000));
            cars.add(new CarModel("Mazda Miata", R.drawable.logo_mazdamiata, 1500000));
            cars.add(new CarModel("Mazda 6", R.drawable.logo_mazda6, 2000000));
            cars.add(new CarModel("Mazda CX-50", R.drawable.logo_mazdacx50, 2200000));
            break;
        case "Toyota":
            cars.add(new CarModel("Toyota LC", R.drawable.logo_toyotalandcruise, 1100000));
            cars.add(new CarModel("Toyota Sequoia", R.drawable.logo_toyotasequioa, 2000000));
            cars.add(new CarModel("Toyota Tacoma", R.drawable.logo_toyotatacoma, 1500000));
            break;
        case "Tesla":
            cars.add(new CarModel("Tesla Model X", R.drawable.logo_teslamodelx, 2500000));
            cars.add(new CarModel("Tesla Model Y", R.drawable.logo_teslamodely, 3000000));
            cars.add(new CarModel("Tesla Model 3", R.drawable.logo_teslamodel3, 3500000));
            break;
        case "Ferrari":
            cars.add(new CarModel("Ferrari 458 Italia", R.drawable.logo_ferrari458italia, 12000000));
            cars.add(new CarModel("Ferrari Purosangue", R.drawable.logo_ferraripurosangue, 14000000));
            cars.add(new CarModel("Ferrari Roma", R.drawable.logo_ferrariroma, 16000000));
            break;
        case "Lamborghini":
            cars.add(new CarModel("Lamborghini Urus", R.drawable.logo_lamborghiniurus, 20000000));
            cars.add(new CarModel("Lamborghini Aventador", R.drawable.logo_lamborghiniaventador, 25000000));
            break;
        case "BMW":
            cars.add(new CarModel("BMW M3", R.drawable.logo_bmwm3, 1500000));
            cars.add(new CarModel("BMW M5", R.drawable.logo_bmwm5, 2000000));
            cars.add(new CarModel("Honda Click", R.drawable.logo_hondaclick, 4000));
            break;
    }
    return cars;
    }

    private void addToCart(CarModel car) {
        cartItems.add(car);
        Toast.makeText(this, car.getName() + " added to cart", Toast.LENGTH_SHORT).show();
    }

    public void openCart(View view) {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    // Method to get cart items from other activities
    public static List<CarModel> getCartItems() {
        return cartItems;
    }
    }