package com.example.matheusmaxwellmeireles.intentimplicita;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setAdjustViewBounds(true);

        return imageView;
    }


    Integer[] images = {R.drawable.map, R.drawable.text, R.drawable.call, R.drawable.ucb};
}
