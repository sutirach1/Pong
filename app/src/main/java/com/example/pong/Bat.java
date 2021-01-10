package com.example.pong;

import android.graphics.RectF;
public class Bat {

    private RectF mRect;
    private float mLength;
    private float mXCoord;
    private float mBatSpeed;
    private int mScreenX;
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    private int mBatMoving = STOPPED;

    Bat(int sx, int sy){
        mScreenX = sx;
        mLength =mScreenX / 8;
        float height = sy / 40;
        mXCoord = mScreenX / 2;
        float mYCoord = sy - height;
        mRect = new RectF(mXCoord, mYCoord,
                mXCoord + mLength,
                mYCoord + height);
        mBatSpeed =mScreenX;
    }
    void setMovementState(int state){
        mBatMoving = state;
    }
    RectF getRect(){
        return mRect;
    }
    void update(long fps){
        if(mBatMoving == LEFT){
            mXCoord = mXCoord - mBatSpeed / fps;
        }
        if(mBatMoving == RIGHT) {
            mXCoord = mXCoord + mBatSpeed / fps;
        }
        if(mXCoord < 0){
            mXCoord = 0;
        }
        else if(mXCoord + mLength > mScreenX) {
            mXCoord = mScreenX - mLength;
        }
        mRect.left = mXCoord;
        mRect.right = mXCoord + mLength;
    }

}