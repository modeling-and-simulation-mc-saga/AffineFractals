package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.util.List;
import java.awt.image.BufferedImage;
import myLib.utils.Utils;

/**
 *
 * @author tadaki
 */
public abstract class BaseModel {

    protected List<double[]> affine;
    protected BufferedImage image;
    protected int width;
    protected Color foreground;
    protected Color background;

    public BaseModel() {
        affine = Utils.createList();
    }

    public void initImage(int width, Color b, Color f) {
        image = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (java.awt.Graphics2D) image.getGraphics();
        g.setBackground(b);
        background = b;
        foreground = f;
        g.setColor(f);
        g.fillRect(0, 0, width, width);
        this.width = width;
    }

    /**
     * Affine変換の定義 角度が逆方向であることに注意
     */
    public abstract void setAffine();

    public BufferedImage oneUpdate() {
        image = updateSub(image);
        return image;
    }

    protected BufferedImage updateSub(BufferedImage img) {
        int k = affine.size();
        // create images for each Affine transformation
        BufferedImage im[] = new BufferedImage[k];
        for (int i = 0; i < k; i++) {//for each Affine transformation
            //define Affine transformation
            AffineTransform tr = new AffineTransform(affine.get(i));
            //prepare transformation
            AffineTransformOp op = new AffineTransformOp(tr,
                    AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            //do transformation
            im[i] = op.filter(img, im[i]);
        }
        BufferedImage myImage = new BufferedImage(width, width,
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = (Graphics2D) myImage.getGraphics();
        Rectangle2D.Double clip = new Rectangle2D.Double(0.,0.,width,width);
        g.setClip(clip);
        // combine all images produced by transformations
        for (int i = 0; i < k; i++) {
            g.drawImage(im[i], null, 0, 0);
        }
        return myImage;
    }

    public BufferedImage showMap() {
        BufferedImage myImage = new BufferedImage(width, width,
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = (Graphics2D) myImage.getGraphics();
        Rectangle2D.Double clip = new Rectangle2D.Double(0.,0.,width,width);
        g.setClip(clip);
        g.setColor(background);
        g.fillRect(0, 0, width, width);
        g.setColor(foreground);
        g.setStroke(new BasicStroke(10));
        g.drawRect(0, 0, width, width);
        g.translate(0, width);
        g.scale(1., -1.);
        g.setFont(new Font("Ariel", Font.PLAIN, 100));
        g.drawString("Map", 10, width - 10);
        g.drawString("Map", width - 300, 100);
        return updateSub(myImage);
    }

    protected double[] parameters(double r, double s,
            double phi, double psi, double e, double f) {
        double p[] = new double[6];
        p[0] = r * Math.cos(-phi);
        p[1] = -s * Math.sin(-psi);
        p[2] = r * Math.sin(-phi);
        p[3] = s * Math.cos(-psi);
        p[4] = e * width;
        p[5] = f * width;
//       System.out.println(p2s(p));
        return p;
    }

    public String p2s(double p[]){
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        for(int i=0;i<p.length-1;i++)sb.append(p[i]).append(",");
        sb.append(p[p.length-1]).append("}");
        return sb.toString();
    }
    public BufferedImage getImage() {
        return image;
    }


    
    public static double d2r(double d){
        return Math.PI*2*d/360.;
    }
}
