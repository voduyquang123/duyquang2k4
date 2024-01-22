package com.example.appdocbao;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdocbao.model.Item;

import java.util.List;

public class RecycleViewAdapter  extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Context context;
    private List<Item>list;

    public RecycleViewAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    public List<Item>getItems(){
        return list;
    }

    public Item getItem(int postion){
        return list.get(postion);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(view);
    }

    /*ublic ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.item) ,parent ,;
        return new ViewHolder(view);
    }*/

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item i = list.get(position);
        holder.title.setText(i.getTitle());
        holder.pubDate.setText(i.getPubDate());
        holder.desc.setText(i.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                String link=i.getLink();
                intent.putExtra("link",link);
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,desc,pubDate;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTile);
            desc = itemView.findViewById(R.id.tvDesc);
            pubDate = itemView.findViewById(R.id.tvpubDate);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
