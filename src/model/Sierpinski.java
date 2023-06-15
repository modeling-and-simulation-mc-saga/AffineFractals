package model;

/**
 *
 * @author tadaki
 */
public class Sierpinski extends AbstractFractal {

    @Override
    public void setAffine() {
        double r =1./2.;
        affine.add(parameters(r,r,0.,0.,0.,0.));
        affine.add(parameters(r,r,0.,0.,r,0.));
        affine.add(parameters(r,r,0.,0.,r/2.,r*Math.sqrt(3.) / 2.));
    }

}
