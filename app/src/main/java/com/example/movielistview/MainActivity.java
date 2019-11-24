package com.example.movielistview;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {
    ListView movie_list;
    public MovieAdapter adapter = null;
    public ArrayList<Movie> movie_data = null;
    Intent intent;
    //String toast_display;
    String movie_name, date, info = "";
    int img;
    Bundle bag;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_list = findViewById(R.id.movieList);
        movie_data = new ArrayList<Movie>();
        movie_data.add(new Movie(R.drawable.bee,"蟻人與黃蜂女","2018-07-04","故事接續在《美國隊長3：英雄內戰》之後，史考特朗恩因為參與了內戰判刑，帶上電子腳鐐，居家監禁，在父親和蟻人兩個角色中左支右絀。眼看刑期終於快服滿，皮姆博士和荷普又帶著危急的任務找上門，史考特不得不再次穿上蟻人裝束，與黃蜂女一起對抗來自過去的黑暗秘密。"));
        movie_data.add(new Movie(R.drawable.bookshop,"街角的書店","2018-06-29","芙洛倫絲因為先生去世，決定為自己實現長久以來的夢想：開一間書店。最後來到英國濱海的寧靜小鎮哈博洛，展開她追逐夢想的新生活。芙洛倫絲買下了一間荒廢許久的破舊老屋，經營起鎮上唯一的書店。"));
        movie_data.add(new Movie(R.drawable.champion,"冠軍大叔","2018-06-15","在美國洛杉磯夜店工作的馬克（馬東石飾），一直夢想在腕力比賽中成為世界冠軍，被自認是他經紀人的晉基（權律飾）說服，回到韓國參加全國腕力大賽。"));
        movie_data.add(new Movie(R.drawable.summer,"夏日1993","2018-06-29","★ 代表西班牙角逐2018奧斯卡最佳外語片\n" +
                "★ 2018 西班牙「高第獎」最佳加泰隆尼亞語影片、最佳導演、最佳劇本、最佳女配角、最佳剪輯 五項大獎\n" +
                "★ 2018 西班牙奧斯卡「哥雅獎」最佳新晉導演、最佳男配角、最佳新晉女演員"));
        movie_data.add(new Movie(R.drawable.hades,"鋼鐵墳墓2","2018-06-29","專門測試監獄安全的越獄專家雷布瑞林（席維斯史特龍 飾），為救出突然被綁架並入獄的好友任樹（黃曉明 飾），潛入世界上最滴水不漏的高科技監獄，這座監獄不僅是全電腦控制，空間更會隨意變形，雷遇到史上最強的"));

        adapter = new MovieAdapter(this,movie_data);
        movie_list.setAdapter(adapter);
        movie_list.setOnItemClickListener(this); //要加這句才能run
    }

    // 跳到information頁
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent();
        intent.setClass(MainActivity.this,InformationPage.class);

        //toast_display = movie_data.get(position).getMovie_name();
        //Toast.makeText(MainActivity.this,"您選擇的是："+toast_display, Toast.LENGTH_LONG).show();

        bag = new Bundle();

        movie_name = movie_data.get(position).getMovie_name();
        date = movie_data.get(position).getDate();
        info = movie_data.get(position).getInfo();
        img = movie_data.get(position).getImg();

        bag.putString("chosenName", String.valueOf(movie_name));
        bag.putString("chosenDate", String.valueOf(date));
        bag.putString("chosenInfo", String.valueOf(info));
        bag.putInt("chosenImg", img);

        intent.putExtras(bag); //要加這句才能run
        intent.setClass(MainActivity.this, InformationPage.class);
        startActivity(intent);
        finish();
    }
}