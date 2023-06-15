package model;

/**
 *
 * @author tadaki
 */
public class BarnsleyFern extends AbstractFractal{

    @Override
    public void setAffine() {
        double x=0.1;
        affine.add(parameters(.85,.85,degree2radian(-2.5),degree2radian(-2.5),0.5*(1-.85),.16));
        affine.add(parameters(.3,.34,degree2radian(49.),degree2radian(49.),.4,.07));
        affine.add(parameters(.3,.37,degree2radian(120.),degree2radian(-50.),0.4,.07));
        affine.add(parameters(x,.16,0,0,0.5,0));
    }
 
}
