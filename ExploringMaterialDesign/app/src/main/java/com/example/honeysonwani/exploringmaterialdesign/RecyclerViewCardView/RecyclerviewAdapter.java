package com.example.honeysonwani.exploringmaterialdesign.RecyclerViewCardView;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.honeysonwani.exploringmaterialdesign.R;

/**
 * Created by honeysonwani on 4/26/2018.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.myViewHolder> {
    String[] nameIDs;
    int[] imageIDs;
    ImageView imageView;
    TextView textView;
    public RecyclerviewAdapter(String[] nameIDs, int[] imageIDs) {
        this.nameIDs = nameIDs;
        this.imageIDs = imageIDs;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cardview,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        CardView v = holder.cv;
        imageView = v.findViewById(R.id.image);
        textView = v.findViewById(R.id.textview);
        textView.setText(nameIDs[position]);

        imageView.setImageResource(imageIDs[position]);
    }

    @Override
    public int getItemCount() {
        return nameIDs.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        public myViewHolder(CardView itemView) {
            super(itemView);
            cv = itemView;
        }
    }

}
