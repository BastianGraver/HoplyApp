package com.example.hoply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static android.util.Log.d;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoply.database.Posts;
import com.example.hoply.database.PostsDao;
import com.example.hoply.database.Users;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Posts> postList;

    public recyclerAdapter(ArrayList<Posts> postList) {
        this.postList = postList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;
        private TextView userTxt;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.DatabaseName);
            userTxt = view.findViewById(R.id.Name);
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
        String content = postList.get(position).content;
        String name = MainActivity.userDao.findId(postList.get(position).user_id).get(0).name;
        holder.nameTxt.setText(content);
        holder.userTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

}
