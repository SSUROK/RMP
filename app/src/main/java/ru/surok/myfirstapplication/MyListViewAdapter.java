package ru.surok.myfirstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListViewAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> items;

    public MyListViewAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        Item item = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView img = view.findViewById(R.id.listImageView);
        img.setImageResource(item.getImg());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView = view.findViewById(R.id.listTextView);
        textView.setText(item.getText());
        return view;
    }
}
