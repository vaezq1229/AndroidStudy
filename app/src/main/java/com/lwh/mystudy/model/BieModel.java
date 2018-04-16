package com.lwh.mystudy.model;

/**
 * Created by ${lwh} on 2017/12/5.
 *
 * @descirbe
 */

public class BieModel {
    private String name;
    private float sweepAngle;
    private int color;

    public BieModel() {
    }

    public BieModel(String name, float sweepAngle, int color) {
        this.name = name;
        this.sweepAngle = sweepAngle;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
