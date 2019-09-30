package traf1.tradan.animatedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button left,right;
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = findViewById(R.id.leftButton);
        right = findViewById(R.id.rightButton);
        drawView=findViewById(R.id.drawView);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawView.x-5> 0){
                    drawView.x-=5;
                    left.setBackgroundColor(Color.WHITE);
                }
                else{
                    left.setBackgroundColor(Color.RED);
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawView.x+5< drawView.getWidth()){
                    drawView.x+=5;
                    left.setBackgroundColor(Color.WHITE);
                    right.setBackgroundColor(Color.WHITE);
                }
                else{
                    right.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}
