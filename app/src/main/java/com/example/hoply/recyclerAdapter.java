package com.example.hoply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoply.database.Users;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Users> userslist;

    public recyclerAdapter(ArrayList<Users> userslist){
        this.userslist = userslist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.databaseName);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = userslist.get(position).name;
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return userslist.size();
    }
}
