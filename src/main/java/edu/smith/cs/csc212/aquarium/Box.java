// Author Harry Wang
package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Box {
    int x;
    int y;

    public Box() {
        this.x = 150;
        this.y = Aquarium.HEIGHT-50;
    }

    public void draw(Graphics2D g) {
        Color boxColor = new Color(102, 51, 0);
        g.setColor(boxColor);
        
        Shape box = new Rectangle2D.Double(this.x, this.y, 90, 50); 
        g.fill(box);
        g.draw(box);
    }
}