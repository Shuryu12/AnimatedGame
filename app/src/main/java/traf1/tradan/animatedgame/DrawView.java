package traf1.tradan.animatedgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.graphics.*;
import java.lang.Math.*;
import android.widget.Toast;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class DrawView extends View {
    Paint paint=new Paint();
    Paint title = new Paint();
    TextView score;
    int scoreCount;
    int y=0,dY=3;//set initial y position and vertical speed
    float x = ((float)Math.random())*getWidth();
    Bitmap icon,resized;
    boolean newGame = false;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        icon = BitmapFactory.decodeResource(getResources(),R.drawable.trashcan);
        resized = Bitmap.createScaledBitmap(icon,550,300, true);
        //score = (TextView)findViewById(R.id.score);
        //scoreCount = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(newGame){
            super.onDraw(canvas);
            title.setColor(Color.YELLOW);
            title.setTextSize(24);
            paint.setColor(Color.GRAY);//set paint to gray
            canvas.drawRect(getLeft(),0,getRight(),getBottom(),paint);//paint background gray
            paint.setColor(Color.RED);//set paint to red
            //draw red circle
            canvas.drawCircle(x,y,getWidth()*.1f,paint);
            if(x > getWidth()*0.25f && x < getWidth()*0.25f + resized.getWidth() && y > getHeight()*0.8f && y < getHeight()*0.8f + resized.getHeight()) {
                Context context = getContext();
                CharSequence text = "Score + 100!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                newGame = false;
                y = 0;
                x = (((float) Math.random())*getWidth());
                //scoreCount += 100;
                //score.setText("Your Score: " + scoreCount);
            }
            if(y > getHeight()){
                Context context = getContext();
                CharSequence text = "Score - 100 :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                newGame = false;
                y = 0;
                x = (((float) Math.random())*getWidth());
                //scoreCount -= 100;
                //score.setText("Your Score: " + scoreCount);
            }
            y+=dY;//increment y position
            canvas.drawBitmap(resized, getWidth()*0.25f,getHeight()*0.8f,paint);
        }
        else {
            paint.setColor(Color.GRAY);
            canvas.drawRect(getLeft(),0,getRight(),getBottom(),paint);
            paint.setColor(Color.RED);//set paint to red
            //draw red circle
            canvas.drawCircle(x,y,getWidth()*.1f,paint);
            canvas.drawBitmap(resized, getWidth()*0.25f,getHeight()*0.8f,paint);
        }

        invalidate();  //redraws screen, invokes onDraw()

    }
}
