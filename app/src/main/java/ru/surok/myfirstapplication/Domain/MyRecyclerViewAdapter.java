package ru.surok.myfirstapplication.Domain;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.surok.myfirstapplication.Data.ListItem;
import ru.surok.myfirstapplication.R;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<ListItem> items;
    private final int resource;
    private final Context context;
    public MyRecyclerViewAdapter(Context context, int resource, List<ListItem> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
        this.context = context;
    }
    @Override
    public MyRecyclerViewAdapter.ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(resource, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        ListItem item = items.get(position);
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(item.getImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "List clicked toast";
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.show();

                Log.i("Music app top fragment", "List item clicked instance");
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends
            RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.listTextView);
            imageView = view.findViewById(R.id.listImageView);
        } }
}
