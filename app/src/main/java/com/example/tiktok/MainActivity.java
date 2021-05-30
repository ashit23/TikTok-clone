package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<VideoModel> videos;
    ImageView image,like,comment,share,home,search,add,message,account;
    int count,likecount =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        image=findViewById(R.id.follow);
        like=findViewById(R.id.like);
        comment=findViewById(R.id.comment);
        share=findViewById(R.id.share);
        home=findViewById(R.id.home);
        search=findViewById(R.id.search);
        add=findViewById(R.id.newVideo);
        message=findViewById(R.id.message);
        account=findViewById(R.id.me);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is just a dummy app",Toast.LENGTH_SHORT).show();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is just a dummy app",Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is just a dummy app",Toast.LENGTH_SHORT).show();
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is just a dummy app",Toast.LENGTH_SHORT).show();
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is just a dummy app",Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Sharing is blocked for now",Toast.LENGTH_SHORT).show();
            }
        });
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Comments not allowed on this video",Toast.LENGTH_SHORT).show();
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0){
                    image.setImageResource(R.drawable.ic_baseline_add_circle_24);
                    Toast.makeText(MainActivity.this,"Following",Toast.LENGTH_SHORT).show();
                    count++;
                }else{
                    image.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT).show();
                    count=0;
                }
            }
        });
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likecount==0) {
                    like.setImageResource(R.drawable.ic_like);
                    Toast.makeText(MainActivity.this, "Added to liked videos", Toast.LENGTH_SHORT).show();
                    likecount++;
                }else {
                    like.setImageResource(R.drawable.ic_unlike);
                    Toast.makeText(MainActivity.this,"Removed from liked videos",Toast.LENGTH_SHORT).show();
                    likecount=0;
                }
            }
        });
        viewPager2=(ViewPager2)findViewById(R.id.view_pager);
        videos= new ArrayList<>();

        VideoModel ob3 = new VideoModel("https://firebasestorage.googleapis.com/v0/b/chatapp-6cd23.appspot.com/o/6.mp4?alt=media&token=1de4cfc4-5fd7-47c8-b536-7e421450839f","Iron Man","Stark Industries");
        videos.add(ob3);

        VideoModel ob2 = new VideoModel("https://firebasestorage.googleapis.com/v0/b/chatapp-6cd23.appspot.com/o/2.mp4?alt=media&token=435c7f91-f509-4874-8d06-a5a4c2d76b5b","Jon Snow","Game of Thrones");
        videos.add(ob2);

        VideoModel ob1 = new VideoModel("https://firebasestorage.googleapis.com/v0/b/chatapp-6cd23.appspot.com/o/1.mp4?alt=media&token=2b3e33ac-d8c7-4c8b-81e7-1182581cc949","James Bond","Agent 007");
        videos.add(ob1);

        VideoModel ob4 = new VideoModel("https://firebasestorage.googleapis.com/v0/b/chatapp-6cd23.appspot.com/o/7.mp4?alt=media&token=644a3c5d-79db-4af7-954d-1160e2021180","Godzilla","Biggest Ape");
        videos.add(ob4);

        VideoModel ob5 = new VideoModel("https://firebasestorage.googleapis.com/v0/b/chatapp-6cd23.appspot.com/o/5.mp4?alt=media&token=b3fe24ad-d5f9-4fb1-8188-a758e5d6507f","Cristiano Ronaldo","Best football player");
        videos.add(ob5);

        viewPager2.setAdapter(new videoAdapter(videos));



    }
}