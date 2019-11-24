package com.example.movielistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private LayoutInflater myInflater;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context,ArrayList<Movie> movies) {
        this.movies = movies;
        myInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie one_movie = (Movie) getItem(position);
        convertView = myInflater.inflate(R.layout.item_view,null);//利用inflater連結子畫面layout
        //宣告子畫面中的物件與對應id
        ImageView movie_img = convertView.findViewById(R.id.movieImg);
        TextView movie_name = convertView.findViewById(R.id.movieName);
        TextView movie_date = convertView.findViewById(R.id.movieDate);
        TextView movie_info = convertView.findViewById(R.id.movieInfo);
        //設定物件的資料來源
        movie_img.setImageResource(one_movie.img);
        //movie_img.setImageResource(one_movie.getImg());
        movie_name.setText(one_movie.movie_name);
        movie_date.setText(one_movie.date);
        movie_info.setText(one_movie.info);
        return convertView; //將設定好的view回傳給使用中的Activity
    }
}
