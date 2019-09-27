package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class Algae {

    public Algae(){
        
    }

    public static int algaeGreenLevel = Color.blue.getGreen(); // 190?
    Boolean takeFood = false;
    
    public void grow(){
        if (algaeGreenLevel < 254) {
            this.algaeGreenLevel += 1;
        }
    }

    public void eat(){
        if (algaeGreenLevel > 2) {
            this.algaeGreenLevel -= 1;
        }
    }

    public void checkStatus(){
        if (this.algaeGreenLevel > Color.blue.getGreen()+10) {
            takeFood = true;
        } else if (this.algaeGreenLevel < Color.blue.getGreen()){
            takeFood = false;
        }
    }

    public void draw(Graphics2D g) {
        if (takeFood) {
            this.eat();
        } else {
            this.grow();
        }
    }
}