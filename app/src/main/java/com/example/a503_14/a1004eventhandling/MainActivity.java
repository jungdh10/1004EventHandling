package com.example.a503_14.a1004eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //마우스 오른쪽 클릭->generate->이미 있는 메소드니까 override methods
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //x는 소수점 한 자리까지, y는 int로 형변환해서 소수점없이 출력
        float x=event.getX();
        int y=(int)event.getY();

        String message =String.format("x:%.1f y:%d 터치", x, y);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn1=(Button)findViewById(R.id.btn1);
        final Button btn2=(Button)findViewById(R.id.btn2);


        //객체를 2개 생성
        //Button의 click -View.OnClickListener
        /*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            //(View v)는 btn1과 같지만 자료형은 다름(v는 View, btn1은 Button.)(View는 상위라서 누구든 받아줄 수 있으니까)
            //비교할 경우에는 View를 Button으로 변환할 수 있지만 Button을 View로 변환해주기(작은->큰 거)
            //(View v)첫 번째 매개변수는 이벤트가 발생할 객체의 주소.
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "첫 번째 버튼을 클릭하셨습니다.", Toast.LENGTH_LONG).show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "두 번째 버튼을 클릭하셨습니다.", Toast.LENGTH_LONG).show();
            }
        });
        */

        /*
        //이 방법은 객체를 1개 생성(버튼이 많을 경우)
        View.OnClickListener eventHandler=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button btn=(Button)v;
                String msg="";
                //btn1이 지역변수라 사용 못하니까 버튼 불러올 때 final을 붙여줘야 함
                if(btn==btn1){
                    msg="첫 번째 버튼";
                }else if(btn==btn2){
                    msg="두 번째 버튼";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        };

        //이벤트 처리 객체 연결
        btn1.setOnClickListener(eventHandler);
        btn2.setOnClickListener(eventHandler);
    }
    */

        //위 와 같지만 toString()해주면 if문으로 계속 작성해줄 필요없이 가능(출력메세지는 xml파일에 text에 바로 출력)
        //이 방법은 객체를 1개 생성(버튼이 많을 경우)
        View.OnClickListener eventHandler=new View.OnClickListener(){
          @Override
            public void onClick(View v) {
                Button btn=(Button)v;
                String msg=btn.getText().toString();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
          }
        };

        //이벤트 처리 객체 연결
        btn1.setOnClickListener(eventHandler);
        btn2.setOnClickListener(eventHandler);
    }


}
