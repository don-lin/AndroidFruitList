package com.donlin.fruiteducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    //an array list which will store all the fruits information
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    //initialize the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the fruit list layout on the screen
        setContentView(R.layout.activity_fruit_list);

        //initialize the fruit list
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.fruit_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Fruit fruit = fruitList.get(position);

                Intent intent = new Intent(ListViewActivity.this,FruitIntroduction.class);

                LayoutInflater mInflater=LayoutInflater.from(getApplicationContext());
                View v=mInflater.inflate(R.layout.fruit_item,null);
                ((ImageView)v.findViewById(R.id.fruit_img)).setImageResource(fruit.getImageId());
                ((TextView)v.findViewById(R.id.fruit_name)).setText(fruit.getName());
                Toast toast=new Toast(ListViewActivity.this);
                toast.setView(v);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();

                //Toast.makeText(ListViewActivity.this, fruit.getName()+", "+getString(R.string.hint), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //put everyting into the fruits array list
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(this.getString(R.string.apple), R.drawable.apple,this.getString(R.string.apple_intro));
            fruitList.add(apple);

            Fruit banana = new Fruit(getString(R.string.banana), R.drawable.banana,this.getString(R.string.banana_intro));
            fruitList.add(banana);

            Fruit cherry = new Fruit(this.getString(R.string.cherry), R.drawable.cherry,this.getString(R.string.cherry_intro));
            fruitList.add(cherry);

            Fruit lemon = new Fruit(this.getString(R.string.lemon), R.drawable.lemon,this.getString(R.string.lemon_intro));
            fruitList.add(lemon);

            Fruit orange = new Fruit(this.getString(R.string.orange), R.drawable.orange,this.getString(R.string.orange_intro));
            fruitList.add(orange);

            Fruit pineapple = new Fruit(this.getString(R.string.pineapple), R.drawable.pineapple,this.getString(R.string.pineapple_intro));
            fruitList.add(pineapple);

            Fruit watermelon = new Fruit(this.getString(R.string.watermelon), R.drawable.watermelon,this.getString(R.string.watermelon_intro));
            fruitList.add(watermelon);
        }
    }
}
