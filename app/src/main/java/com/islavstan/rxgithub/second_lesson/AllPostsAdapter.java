package com.islavstan.rxgithub.second_lesson;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islavstan.rxgithub.R;
import com.islavstan.rxgithub.second_lesson.model.Post;

import java.util.ArrayList;
import java.util.List;



public class AllPostsAdapter extends RecyclerView.Adapter<AllPostsAdapter.MyViewHolder> {

    private List<Post> posts = new ArrayList<>();

    public void setData(List<Post> posts) {
        this.posts = posts;
        //telling adapter that data has been changed and redraw recyclerView
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_posts, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Post post = posts.get(position);
        //set data to view
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        //return size of list
        return posts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //declare variables here
        private TextView title;
        private TextView body;

        private MyViewHolder(View view) {
            super(view);
            //reference declared object here.
            title = (TextView) view.findViewById(R.id.tvTitle);
            body = (TextView) view.findViewById(R.id.tvBody);
        }
    }
}