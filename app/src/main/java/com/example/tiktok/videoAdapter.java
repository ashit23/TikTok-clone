package com.example.tiktok;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.myViewHolder>{

    ArrayList<VideoModel> videos;

    public videoAdapter(ArrayList<VideoModel> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video_row,parent,false);


        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.setData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        VideoView videoview;
        TextView title,desc;
        ProgressBar pBar;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

          videoview = itemView.findViewById(R.id.videoView);
          title=itemView.findViewById(R.id.TextVideoTitle);
          desc=itemView.findViewById(R.id.TextVideoDesc);
          pBar=itemView.findViewById(R.id.progressBar);


        }
        void setData(VideoModel obj){
            videoview.setVideoPath(obj.getUrl());
            title.setText(obj.getTitle());
            desc.setText(obj.getDesc());

            videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    pBar.setVisibility(View.GONE);
                    mediaPlayer.start();

                }
            });
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
