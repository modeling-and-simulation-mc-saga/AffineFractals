package model;

/**
 *
 * @author tadaki
 */
public class TwinChristmasTree extends AbstractFractal {

    @Override
    public void setAffine() {
        double r=1./2.;
        double p = Math.PI/2.;
        affine.add(parameters(r,r,p,p,r,0.));
        affine.add(parameters(r,r,0.,0.,r/2.,r));
        affine.add(parameters(r,r,-p,-p,r,r));
    }

}
