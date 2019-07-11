package model;

/**
 *
 * @author tadaki
 */
public class BarnsleyFern extends BaseModel{

    @Override
    public void setAffine() {
        double x=0.1;
        affine.add(parameters(.85,.85,d2r(-2.5),d2r(-2.5),0.5*(1-.85),.16));
        affine.add(parameters(.3,.34,d2r(49.),d2r(49.),.4,.07));
        affine.add(parameters(.3,.37,d2r(120.),d2r(-50.),0.4,.07));
        affine.add(parameters(x,.16,0,0,0.5,0));
    }
 
}
