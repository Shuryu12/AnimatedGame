package traf1.tradan.animatedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.*;


public class MainActivity extends AppCompatActivity {
    Button left,right,start;
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = findViewById(R.id.leftButton);
        right = findViewById(R.id.rightButton);
        start = findViewById(R.id.startbutton);
        drawView=findViewById(R.id.drawView);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawView.x-10> 0){
                    drawView.x-=10;
                    left.setBackgroundColor(Color.GRAY);
                }
                else{
                    left.setBackgroundColor(Color.RED);
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawView.x+10< drawView.getWidth()){
                    drawView.x+=10;
                    left.setBackgroundColor(Color.GRAY);
                    right.setBackgroundColor(Color.GRAY);
                }
                else{
                    right.setBackgroundColor(Color.RED);
                }
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.newGame = true;
            }
        });



    }
}
