package com.example.week_8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.MyHolder> {

    Context context;
    ArrayList<modelClass> arrayList;
    LayoutInflater layoutInflater;

    public searchAdapter(Context context, ArrayList<modelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.searchName.setText(arrayList.get(position).getSearchItemName());
        holder.searchNum.setText(arrayList.get(position).getSearchItemNum());
        holder.itemDetail.setText(arrayList.get(position).getSearchDetail());
        holder.img.setImageResource(arrayList.get(position).getImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelClass selectedItem = arrayList.get(position);

                Intent intent = new Intent(context, DetailActivity.class); // Assuming DetailActivity is your detail screen
                intent.putExtra("itemName", selectedItem.getSearchItemName());
                intent.putExtra("itemdetails", selectedItem.getSearchDetail());
                intent.putExtra("itemNum", selectedItem.getSearchItemNum());
                intent.putExtra("itemImage", selectedItem.getImg());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView searchName, searchNum, itemDetail;
        ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            searchName = itemView.findViewById(R.id.txt);
            searchNum = itemView.findViewById(R.id.txt2);
            itemDetail = itemView.findViewById(R.id.txt3);
            img = itemView.findViewById(R.id.searchimg);
        }
    }
}
