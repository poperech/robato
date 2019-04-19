package Tours.FindTours;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Класс для упрощения связывания данных с элементов управдения
class RestaurantAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Restaurant> restaurantArrayList;
    private LayoutInflater inflater;

    RestaurantAdapter(Activity activity, ArrayList<Restaurant> restaurantArrayList) {
        this.activity = activity;
        this.restaurantArrayList = restaurantArrayList;
    }

    @Override
    public int getCount() {
        return this.restaurantArrayList.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return this.restaurantArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.restaurant_list, null);

        TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView type = (TextView) convertView.findViewById(R.id.typeTextView);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        TextView price = (TextView) convertView.findViewById(R.id.priceTextView);

        final Restaurant restaurant = getItem(position);
        name.setText(restaurant.getName());
        type.setText("Тип кухни: " + restaurant.getType());
        price.setText("Цены: " + restaurant.getPrice());


        Picasso.get().load(restaurant.getImage()).into(image);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, RestaurantActivity.class);
                intent.putExtra("name", restaurant.getName());
                intent.putExtra("description", restaurant.getDescription());
                intent.putExtra("type", restaurant.getType());
                intent.putExtra("image", restaurant.getImage());
                intent.putExtra("price", restaurant.getPrice());

                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
