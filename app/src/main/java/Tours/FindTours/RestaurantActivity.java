package Tours.FindTours;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RestaurantActivity extends AppCompatActivity {

    public String urlPath;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //Задаем внешний вид интерфейса
        setContentView(R.layout.restaurant_info);
        //Добавляем размещение элементов

        final Intent intent = getIntent();
        //Получаем нужные данные
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String type = intent.getStringExtra("type");
        String image = intent.getStringExtra("image");
        String price = intent.getStringExtra("price");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (actionBar != null) {
            actionBar.setTitle(name);
        }

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView typeTextView = (TextView) findViewById(R.id.typeTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        ImageView imageView = (ImageView) findViewById(R.id.movieImage);
        TextView priceTextView = (TextView) findViewById(R.id.priceTextView);

        nameTextView.setText(name);
        typeTextView.setText("Тип кухни: " + type);
        descriptionTextView.setText(description);
        Picasso.get().load(image).into(imageView);
        priceTextView.setText("Цены " + price);

    }
}
