package model;

/**
 *
 * @author tadaki
 */
public class KochCurve extends AbstractFractal {

    @Override
    public void setAffine() {
        double s=1./3.;
        double p=Math.PI/3.;
        affine.add(parameters(s,s,0.,0.,0.,0.));
        affine.add(parameters(s,s,p,p,s,0.));
        affine.add(parameters(s,s,-p,-p,1./2.,Math.sqrt(3.) / 6.));
        affine.add(parameters(s,s,0.,0.,2.*s,0.));
    }

}
