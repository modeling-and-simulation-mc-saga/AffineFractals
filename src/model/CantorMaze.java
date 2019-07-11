package model;

/**
 *
 * @author tadaki
 */
public class CantorMaze extends BaseModel {


    @Override
    public void setAffine() {
        double r = 1./3.;
        double p = Math.PI/2.;
        affine.add(parameters(r,1,p,p,r,0.));
        affine.add(parameters(r,r,0.,0.,r,2*r));
        affine.add(parameters(r,1.,-p,-p,2*r,1.));
    }

}
