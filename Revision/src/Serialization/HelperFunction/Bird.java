package Serialization.HelperFunction;

import java.io.Serializable;

public class Bird implements Serializable {
    int name;
    int x;
    int y;
    int health;
    int angle;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getOmega() {
        return omega;
    }

    public void setOmega(int omega) {
        this.omega = omega;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    int omega;
    int vx,vy;

    public Bird(int name, int x, int y, int health, int angle, int omega, int vx, int vy) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.angle = angle;
        this.omega = omega;
        this.vx = vx;
        this.vy = vy;
    }
}