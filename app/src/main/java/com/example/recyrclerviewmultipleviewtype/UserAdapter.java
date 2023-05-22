package com.example.recyrclerviewmultipleviewtype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int TYPE_RECTANGLE = 1;
    public static final int TYPE_CIRCLE = 2;
    private List<User> mList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_RECTANGLE == viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rectangle, parent, false);
            return new RectangleViewHolder(v);
        } else if (TYPE_CIRCLE == viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle, parent, false);
            return new CircleViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = mList.get(position);
        if (user == null) {
            return;
        }
        if (TYPE_RECTANGLE == holder.getItemViewType()) {
            RectangleViewHolder rectangleViewHolder = (RectangleViewHolder) holder;
            rectangleViewHolder.img1.setImageResource(user.getImage());
            rectangleViewHolder.tv1.setText(user.getName());
        } else if (TYPE_CIRCLE == holder.getItemViewType()) {
            CircleViewHolder circleViewHolder = (CircleViewHolder) holder;
            circleViewHolder.img2.setImageResource(user.getImage());
            circleViewHolder.tv2.setText(user.getName());
        }

    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        User user = mList.get(position);
        if (user.isType()) {
            return TYPE_RECTANGLE;
        } else {
            return TYPE_CIRCLE;
        }
    }

    public class RectangleViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView tv1;
        public RectangleViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    public class CircleViewHolder extends RecyclerView.ViewHolder {
        ImageView img2;
        TextView tv2;
        public CircleViewHolder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.img2);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    public void setData(List<User> list) {
        this.mList = list;
        notifyDataSetChanged();
    }
}
