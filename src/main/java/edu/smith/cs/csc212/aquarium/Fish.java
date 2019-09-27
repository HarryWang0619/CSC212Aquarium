// Part of the code is from Prof. J.J in lab section.
// Author . Harry Wang 
// ども！
// I want to write something more
// So I just put them here!
// I'm gonna start CAPITALIZATION MODE !!!

package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
    Color _color;
    int x;
    int y;
    boolean _isLittle;
    boolean _facingLeft;
    int destX;
    int destY;
    // int _speed;
    Random rand = new Random();
    

    // CONSTRUCTORS
    public Fish(Color color, int startX, int startY, boolean isLittle, boolean facingLeft) {
        this._color = color;
        // this._speed = speed;
        this.x = startX;
        this.y = startY;
        this._isLittle = isLittle;
        this._facingLeft = facingLeft;
        this.randDest();
    }


    // CONSTRUCTORS
    public Fish(Color color, int startX, int startY, int endX, int endY, boolean isLittle, boolean facingLeft) {
        this._color = color;
        // this._speed = speed;
        this.destX = endX;
        this.destY = endY;
        this.x = startX;
        this.y = startY;
        this._isLittle = isLittle;
        this._facingLeft = facingLeft;
        this.randDest();
    }

    // CONSTRUCTORS
    public Fish(boolean isLittle) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        this._color = new Color(r, g, b);
        this.x = rand.nextInt(Aquarium.WIDTH);
        this.y = rand.nextInt(Aquarium.HEIGHT);
        this._isLittle = isLittle;
        // this._speed = speed;
        this.randDest();
    }

    // CONSTRUCTORS
    public Fish() {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        this._color = new Color(r, g, b);
        this.x = rand.nextInt(Aquarium.WIDTH);
        this.y = rand.nextInt(Aquarium.HEIGHT);
        this._isLittle = this.randBool();
        // this._speed = speed;
        this.randDest();
    }

    // DESTINATION!
    public void randDest() {
        destX = rand.nextInt(Aquarium.WIDTH);
        destY = rand.nextInt(Aquarium.HEIGHT);
        this.direction();
    }

    public boolean randBool() {
        if (rand.nextInt(10) > 5) {
            return true;
        } else {
            return false;
        }
    }


    public void destination() {
        if ((x == destX) || (y == destY)) {
            this.randDest();
            this.direction();
        }
    }

    // WRAP -- AS THE NAME
    public int wrapX(int xIn) {
        return xIn % Aquarium.WIDTH;
    }

    // INCLASS DRAW METHOD
    public void draw(Graphics2D g) {
        if (this._isLittle) {
            if (this._facingLeft) {
                DrawFish.smallFacingLeft(g, this._color, this.x, this.y);
            } else {
                DrawFish.smallFacingRight(g, this._color, this.x, this.y);
            }
        } else {
            if (this._facingLeft) {
                DrawFish.facingLeft(g, this._color, this.x, this.y);
            } else {
                DrawFish.facingRight(g, this._color, this.x, this.y);
            }
        }
        this.swim();
    }

    public void direction() {
        if (this.x < this.destX) {
            this._facingLeft=false;
        } else {
            this._facingLeft=true;
        }
    }
    
    public void swim() { 
        this.destination();   
        if (y < destY) {
            y += 1;
        } else if (y > destY) {
            y -= 1;
        }
        if (x < destX) {
            x += 1;
        } else if (x > destX) {
            x -= 1;
        }
    }
}
