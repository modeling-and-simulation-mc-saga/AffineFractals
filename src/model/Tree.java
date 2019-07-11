package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tadaki
 */
public class Tree extends BaseModel {


    @Override
    public void setAffine() {
        affine.add(parameters(0.6, 0.8, -0.15, -0.1, 0.2, 0.2));
        affine.add(parameters(0.5, 0.3, -0.5, -0.3, 0.28, 0.2));
        affine.add(parameters(0.6, 0.5, 0.4, 0.4, 0.22, 0.02));
    }

    @Override
    public BufferedImage oneUpdate() {
        super.oneUpdate();
        Graphics2D g = (java.awt.Graphics2D) image.getGraphics();
        g.setColor(foreground);
        Line2D.Double line = new Line2D.Double(width / 2., 0., 
                width / 2., 0.2 * width);
        g.setStroke(new BasicStroke(10));
        g.draw(line);
        return image;
    }

}
