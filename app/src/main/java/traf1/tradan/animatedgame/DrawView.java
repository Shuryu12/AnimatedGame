package traf1.tradan.animatedgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint paint=new Paint();
    int y=0,dY=1;//set initial y position and vertical speed
    float x = getWidth()*.5f;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);//set paint to gray
        canvas.drawRect(getLeft(),0,getRight(),getBottom(),paint);//paint background gray
        paint.setColor(Color.RED);//set paint to red
        //draw red circle
        canvas.drawCircle(x,y,getWidth()*.3f,paint);
        y+=dY;//increment y position
        invalidate();  //redraws screen, invokes onDraw()
    }
}
