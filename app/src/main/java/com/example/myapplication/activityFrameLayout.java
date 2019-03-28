package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
import android.view.View;

public class activityFrameLayout extends AppCompatActivity
{
    private FrameLayout frameLayout;

    private ImageView main_imageview;

    private Button button;

    private int i = 0;

    Timer timer = new Timer();

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {

            Log.e("@@@", i + "");
            //index=msg.what;
            if (i > 5)
            {
                i = 0;
            }
            else
            {
                switch (i)
                {
                    case 1:
                        main_imageview.setImageResource(R.drawable.freak);
                        break;
                    case 2:
                        main_imageview.setImageResource(R.drawable.dream);
                        break;
                    case 3:
                        main_imageview.setImageResource(R.drawable.execute_4k);
                        break;
                    case 4:
                        main_imageview.setImageResource(R.drawable.mirror);
                        break;
                    case 5:
                        main_imageview.setImageResource(R.drawable.ball2_8k);
                        break;
                    default:
                        break;
                }
                frameLayout.invalidate();
            }
            super.handleMessage(msg);
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);
        Button button26 = (Button)findViewById(R.id.button26);
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();

    }

    public void initView()
    {
        frameLayout = (FrameLayout) findViewById(R.id.background_main);
        main_imageview = (ImageView) findViewById(R.id.image_view);

        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                i++;
                Message mesasge = new Message();
                mesasge.what = i;
                handler.sendMessage(mesasge);
            }
        }, 0, 2000);

    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        timer.cancel();
        super.onDestroy();
    }

}
