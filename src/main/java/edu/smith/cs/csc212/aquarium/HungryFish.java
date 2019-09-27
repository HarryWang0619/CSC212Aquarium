package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class HungryFish extends Fish {
    int hungryLevel = 100;
    
    
    // CONSTRUCTORS
    // public Fish(Color color, int startX, int startY, boolean isLittle, boolean facingLeft) {
    //     this._color = color;
    //     // this._speed = speed;
    //     this.x = startX;
    //     this.y = startY;
    //     this._isLittle = isLittle;
    //     this._facingLeft = facingLeft;
    //     this.randDest();
    // }


    // CONSTRUCTORS
    // public Fish(Color color, int startX, int startY, int endX, int endY, boolean isLittle, boolean facingLeft) {
    //     this._color = color;
    //     // this._speed = speed;
    //     this.destX = endX;
    //     this.destY = endY;
    //     this.x = startX;
    //     this.y = startY;
    //     this._isLittle = isLittle;
    //     this._facingLeft = facingLeft;
    //     this.randDest();
    // }

    // CONSTRUCTORS
    // public Fish(boolean isLittle) {
    //     float r = rand.nextFloat();
    //     float g = rand.nextFloat();
    //     float b = rand.nextFloat();
    //     this._color = new Color(r, g, b);
    //     this.x = rand.nextInt(Aquarium.WIDTH);
    //     this.y = rand.nextInt(Aquarium.HEIGHT);
    //     this._isLittle = isLittle;
    //     // this._speed = speed;
    //     this.randDest();
    // }

    // CONSTRUCTORS
    // public Fish() {
    //     float r = rand.nextFloat();
    //     float g = rand.nextFloat();
    //     float b = rand.nextFloat();
    //     this._color = new Color(r, g, b);
    //     this.x = rand.nextInt(Aquarium.WIDTH);
    //     this.y = rand.nextInt(Aquarium.HEIGHT);
    //     this._isLittle = this.randBool();
    //     // this._speed = speed;
    //     this.randDest();
    // }

    // DESTINATION!

    public boolean isHungry() {
        if (this.hungryLevel < 20) {
            return true;
        } else {
            return false;
        }
    }

    public void currColor() {
        float r = this._color.getRed();
        float g = this._color.getGreen();
        float b = this._color.getBlue();
        float a = (float)hungryLevel*0.01f;
        this._color = new Color(r, g, b, a);
    }

    public void progressBar() {

    }

    @Override
    public void destination() {
        if (this.isHungry()) {
            this.randDest();
            this.direction();
        }
        //TODO OVERRIDE IT
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
