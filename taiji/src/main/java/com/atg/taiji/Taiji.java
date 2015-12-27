package com.atg.taiji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Mr_TT on 2015/12/27 0027.
 */
public class Taiji extends View {
    private Paint whitePaint;
    private Paint blackPaint;

    //画笔初始化函数
    private void initPaints() {
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint();
        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);
    }

    //用户直接new一个View时会被调用
    public Taiji(Context context) {
        super(context);
        initPaints();//初始化画笔
    }

    //用户在Layout文件中使用这个View时会被调用
    public Taiji(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    private float degress = 0;

    public void setRotate(float degress) {
        this.degress = degress;
        invalidate();//重绘界面
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布宽度
        int width = canvas.getWidth();
        //画布高度
        int height = canvas.getHeight();
        //画布中心点
        Point centerPoint = new Point(width / 2, height / 2);
        //将画布移动到中心
        canvas.translate(centerPoint.x,centerPoint.y);
        //绘制背景色
        canvas.drawColor(Color.GRAY);
        canvas.rotate(degress);

        //绘制两个半圆
        int radius=Math.min(width,height)/2-100;//太极半径
        RectF rect=new RectF(-radius,-radius,radius,radius);//绘制区域
        canvas.drawArc(rect,90,180,true,blackPaint);//绘制黑色半圆
        canvas.drawArc(rect,-90,180,true,whitePaint);//绘制白色半圆

        //绘制两个小圆
        int smallRadius=radius/2;
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //绘制鱼眼
        canvas.drawCircle(0,-smallRadius,smallRadius/4,whitePaint);
        canvas.drawCircle(0,smallRadius,smallRadius/4,blackPaint);

    }
}
