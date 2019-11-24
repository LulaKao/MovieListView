package com.example.movielistview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationPage extends AppCompatActivity {
    ImageView pg2_img;
    TextView pg2_name,pg2_date,pg2_info;
    Button btn_back,btn_reservation;
    Intent intent;
    Bundle get_bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        pg2_name = findViewById(R.id.txtName);
        pg2_img = findViewById(R.id.pg2Img);
        pg2_date = findViewById(R.id.txtDate);
        pg2_info = findViewById(R.id.txtInfo);
        btn_back = findViewById(R.id.btnBack);
        btn_reservation = findViewById(R.id.btnReservation);
        intent = new Intent();

        //使用bundle接收資料
        get_bag = getIntent().getExtras(); //這行要打對
        String chosen_name = get_bag.getString("chosenName");
        String chosen_date = get_bag.getString("chosenDate");
        String chosen_info = get_bag.getString("chosenInfo");
        int chosen_img = get_bag.getInt("chosenImg");
        pg2_name.setText(chosen_name);
        pg2_date.setText(chosen_date);
        pg2_info.setText(chosen_info);
        pg2_img.setImageResource(chosen_img);

        //跳回MainActivity
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(InformationPage.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 跳到訂購頁面
        btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(InformationPage.this,ReservationPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
