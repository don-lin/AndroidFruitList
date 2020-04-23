package com.donlin.fruiteducation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class ImageClickListener implements View.OnClickListener {
    private Fruit fruit;
    private Context context;

    public ImageClickListener(Fruit fruit,Context context){
        this.fruit=fruit;
        this.context=context;
    }
    @Override
    public void onClick(View view) {
        //when the picture is clicked, a toast which will show the picture and name of the fruit.
        Intent intent = new Intent(context,FruitIntroduction.class);

        Toast.makeText(context, fruit.getName(), Toast.LENGTH_SHORT).show();
        intent.putExtra("name",fruit.getName());
        intent.putExtra("img",fruit.getImageId());
        intent.putExtra("introduction",fruit.getIntroduction());
        context.startActivity(intent);
    }
}
