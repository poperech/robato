package Tours.FindTours;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Restaurant> restaurantArrayList;
    RestaurantAdapter adapter;

//    Создаем новый объект и вносим в него данные для приложения
    Restaurant[] restaurants = new Restaurant[] {
        new Restaurant(
                "Noblesse",
                "Ресторан «Noblesse» — это комбинация благородной строгости интерьера, авторской кухни и особой атмосферы комфорта, роскоши и элегантности. Выполненный в графитовых тонах зал ресторана сочетает в себе мягкость бархатных кресел, притягательность состаренных зеркал и очарование деталей интерьера. Здесь вы можете найти как гастрономический мейнстрим, так и эксклюзивные блюда, адресованные тонким ценителям и знатокам кухни стран средиземноморья.",
                "Средиземноморская, Европейская",
                "https://i0.photo.2gis.com/images/branch/55/7740561859958170_18f8.jpg",
                "Выше среднего"
        ),
        new Restaurant(
                "Антресоль Грузинский ресторан",
                "Каждый день мы придерживаемся этого принципа. Для нас важно, что окажется у вас в тарелке, из каких продуктов будет приготовлено, с каким настроем работал повар, как его подал официант, и с каким настроением вы его съедите.\n" +
                        "\n" +
                        "Мы ставим перед собой целью создание доступной городской среды на базе ресторанов. ",
                "Грузинская",
                "https://infanoj.ru/upload/uf/0ef/0efda1fe878a60840b313065b2ea7e49.jpg",
                "Средние"
        ),
        new Restaurant(
                "МишинБар",
                "Весна в #Мишинбаре наступает полным ходом. Открывается весенний сезон вечеринок с самыми яркими диджеями города, незабываемой музыкой и сумасшедшим настроением! Приходи, мы встретим эту весну вместе на вечеринке #МишинБардак уже в эти выходные! ",
                "Американская, Бар, Европейская, Гриль, Паб, Русская",
                "https://scontent-arn2-1.xx.fbcdn.net/v/t1.0-9/56819760_381198342724960_3025756541081878528_n.jpg?_nc_cat=102&_nc_ht=scontent-arn2-1.xx&oh=af894d1d693e4295dd43f4c0e5c4bcf9&oe=5D34B56B",
                "Выше среднего"
        ),
        new Restaurant(
                "Vse Svoi",
                "Это небольшой но очень уютный бар в самом центре Ульяновска. Хороший выбор алкоголя. Vse Svoi одинаково хорошо подходят для того что бы выпить кофе или хорошего виски, что достаточно редкая комбинация.",
                "Бар, Кафе, Паб",
                "https://media-cdn.tripadvisor.com/media/photo-s/11/ed/22/76/20180128-221708-largejpg.jpg",
                "Средние"
        ),
        new Restaurant(
                "OranG",
                "Мы принимаем заказы с 10:00 до 23:30, без перерывов и выходных. Работаем до последнего заказа. Вы всегда можете сделать предзаказ на любое удобное время. Доставка в любую точку Ульяновска (пляжи, парки, остановки), главное - правильные ориентиры.",
                "Итальянская, Японская, Пицца",
                "https://media-cdn.tripadvisor.com/media/photo-p/07/e5/fb/1b/orang-pizza.jpg",
                "Средние"
        ),

    };

    //Связываем данные
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setIcon(R.drawable.ic_action_logo);
            actionBar.setTitle("    " + actionBar.getTitle());
        }

        restaurantArrayList = new ArrayList<>(Arrays.asList(restaurants));
        adapter = new RestaurantAdapter(this, restaurantArrayList);

        ListView restListView = (ListView) findViewById(R.id.restListView);
        restListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        SearchView searchView = searchItem.getActionView() as SearchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Поиск", newText);

                restaurantArrayList.clear();

                if (newText.equals("")) {
                    restaurantArrayList.addAll(Arrays.asList(restaurants));
                } else {
                    for (Restaurant restaurant : restaurants) {
                        if (restaurant.getName().toLowerCase().contains(newText.toLowerCase())) {
                            restaurantArrayList.add(restaurant);
                        }
                    }
                }

                adapter.notifyDataSetChanged();

                return false;
            }
        });
            return super.onCreateOptionsMenu(menu);
    }

}
