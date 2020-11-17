package com.example.mediapipemultihandstrackingapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class DeveloperActivity extends AppCompatActivity {
    VideoView videoView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_developer);

//        //꽃가루 효과
//        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.celebration_animation_view);
//        animationView.setAnimation("celebration.json");
//        animationView.loop(true);
//        animationView.playAnimation();


        //배경 애니메이션
        LottieAnimationView backAnimationView = (LottieAnimationView) findViewById(R.id.dev_background);
        backAnimationView.setAnimation("background1.json");
        backAnimationView.loop(true);
        backAnimationView.playAnimation();


        //비디오 뷰
        videoView = findViewById(R.id.junsoo);
        Uri videoUri;
        videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sing_junsoo_cutting);
        //비디오뷰 재생,일시정지 등 할수있는 컨트롤바
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(videoUri);
        //동영상 읽어오는 시간이 좀 걸리므로
        //비디오 로딩준비 끝났을때 실행하도록 리스너 설정
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

    }
    //화면이 안보일때
    protected void onPause(){
        super.onPause();

        if(videoView != null && videoView.isPlaying())videoView.pause();
    }
    //엑티비티가 메모리에서 사라질때
    protected void Destroy(){
        super.onDestroy();
        if(videoView != null)videoView.stopPlayback();
    }
}