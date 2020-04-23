package com.donlin.fruiteducation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class FruitIntroduction extends AppCompatActivity {

    //initialize the fruit introduction activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setup the layout on thescreen
        setContentView(R.layout.activity_fruit_introduction);

        //get the fruit information from parent activity
        Bundle e=getIntent().getExtras();

        //create a new fruit object tostore the data
        Fruit fruit = new Fruit(e.getString("name"),e.getInt("img"),e.getString("introduction"));

        //set the data on the views
        TextView fruitName=(TextView)findViewById(R.id.name);
        TextView fruitCptial=(TextView)findViewById(R.id.captial);
        TextView fruitDetail=(TextView)findViewById(R.id.detail);
        ImageView fruitImg=(ImageView)findViewById(R.id.img);

        fruitName.setText(fruit.getName());
        //calculate the first character and show it on the screen
        fruitCptial.setText(fruit.getFirstCharacter());
        fruitDetail.setText(fruit.getIntroduction());
        fruitImg.setImageResource(fruit.getImageId());
        //initialize the button
        Button back=(Button)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
