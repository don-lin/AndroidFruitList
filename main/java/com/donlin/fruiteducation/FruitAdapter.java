package com.donlin.fruiteducation;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    //initialize the fruit adapter with the fruit arraylist
    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    //generate the view of the fruit adapter
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }

        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_img);

        ImageClickListener clickListener=new ImageClickListener(fruit,getContext());
        fruitImage.setOnClickListener(clickListener);

        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        TextView fruitIntroduction = (TextView) view.findViewById(R.id.fruit_introduction);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        fruitIntroduction.setText(fruit.getIntroduction());
        return view;
    }
}