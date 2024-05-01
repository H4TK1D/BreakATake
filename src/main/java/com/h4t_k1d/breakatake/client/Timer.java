package com.h4t_k1d.breakatake.client;

public class Timer {
    private int currentTick = 0;
    private int seconds = 40;
    private int minutes = 29;
    private int hours = 0;

    public void tick(){
        currentTick++;
        if (currentTick % 20 != 0) return;
        Second();
    }

    private void Second(){
        seconds++;
        if (seconds % 60 != 0) return;
        seconds = 0;
        Minute();
    }

    private void Minute(){
        minutes++;
        if (minutes % 60 != 0) return;
        minutes = 0;
        Hour();
    }
    private void Hour(){
        hours++;
    }
    public int getTicks(){
        return  currentTick;
    }
    public int getLocalTicks(){
        return  currentTick%20;
    }
    public int getSeconds(){
        return seconds;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getHours(){
        return hours;
    }
}
