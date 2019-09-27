// Author Harry Wang
package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Bubble {
    Random rand = new Random();
    int x;
    int y;
    int _size;

    public Bubble(int size) {
        this.x = 100+rand.nextInt(150);
        this.y = Aquarium.HEIGHT;
        this._size = size;
    }

    public Bubble() {
        this.x = 100+rand.nextInt(150);
        this.y = Aquarium.HEIGHT;
        this._size = rand.nextInt(15)+10;
    }

    public void move() {
        this.y -= rand.nextInt(10); 
        this.x += rand.nextInt(3); //wiggle wiggle wiggle ~~~
        this.x -= rand.nextInt(3);

        if (this.y < -300) {
            this.y = Aquarium.HEIGHT;
            this.x = 100+rand.nextInt(150);
        }
    }

    // public void box(Graphics2D g) {
    //     Color boxColor = new Color(102, 51, 0);
    //     g.setColor(boxColor);

    //     Shape box = new Rectangle2D.Double(0, 0, 90, 50); 
    //     g.fill(box);
    //     g.draw(box);
    //     this.x = 150;
    //     this.y = Aquarium.HEIGHT;
    // }

    public void draw(Graphics2D g) {
        this.move();
        Color bubbleCollor = new Color(0.2f, 0.2f, 0.2f, 0.3f);
        g.setColor(bubbleCollor);
        //centerX - radius, centerY - radius, 2.0 * radius, 2.0 * radius
        Shape bubble = new Ellipse2D.Double(x-2,y-2,(int)(2*(_size)),(int)(2*(_size)));
        g.fill(bubble);
        g.draw(bubble);
    }
}