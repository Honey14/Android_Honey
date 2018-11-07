package com.example.honey.getbooks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BooksAdapter extends ArrayAdapter<BooksDetail> {
    Context context;
    List<BooksDetail> booksDetails;
    public BooksAdapter(@NonNull Context context, List<BooksDetail> objects) {
        super(context, 0, objects);
        this.context = context;
        this.booksDetails = objects;

    }
// progress bar in asyntask and layout with thumbnail image in a grid view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        view = LayoutInflater.from(getContext()).inflate(R.layout.bookdetail_row, parent, false);
        TextView textbookname, textauthor;
        textbookname = view.findViewById(R.id.textbookname);
        textauthor = view.findViewById(R.id.textauthor);
        BooksDetail detail = getItem(position);
        textbookname.setText(detail.title);
        textauthor.setText(detail.authors);
        return view;
    }
}
