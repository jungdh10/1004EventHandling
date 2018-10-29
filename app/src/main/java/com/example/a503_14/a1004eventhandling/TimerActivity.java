package com.example.a503_14.a1004eventhandling;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    //텍스트 뷰에 출력할 문자열
    String[] ar = {"오늘", "점심은", "뭐슬", "먹을까요?", "뭣을"};

    //타이머 변수
    CountDownTimer timer;

    //버튼을 눌렀을 때 호출될 메소드 - layout 파일에서 설정
    public void click(View v) {
        timer.start();
        //아래와 같이 하면 배열이 순서대로 출력이 안되고 한꺼번에 되어서 배열의 마지막 요소만 출력
        /*
    }
        TextView txt=(TextView)findViewById(R.id.txt);
        try{
            for(int i=0; i<10; i++){
                txt.setText(ar[i%5]);
                Thread.sleep(1000);
            }
        }catch(Exception e){}
    }
    */
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timer = new CountDownTimer(10000, 1000) {
            TextView txt = (TextView) findViewById(R.id.txt);
            int idx = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                txt.setText(ar[idx % 5]);
                idx = idx + 1;
            }
            @Override
            public void onFinish() {
                txt.setText("타이머 종료");
            }
        };
    }

}