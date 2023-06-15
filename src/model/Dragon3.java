package model;

/**
 *
 * @author tadaki
 */
public class Dragon3 extends AbstractFractal {


    @Override
    public void setAffine() {
        double r = 0.55;
        double p = Math.PI / 2.;
        affine.add(parameters(r, r, -p, -p, 0., 1.));
        affine.add(parameters(r, r, -p, -p, 0., r));
        affine.add(parameters(r, r, -p, -p, 1. - r, (1. + r) / 2.));
    }

}
