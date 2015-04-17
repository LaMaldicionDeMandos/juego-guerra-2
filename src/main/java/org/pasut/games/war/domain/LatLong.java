package org.pasut.games.war.domain;

/**
 * Created by marcelo on 17/04/15.
 */
public class LatLong {
    private final static double A = 6378137;
    private final static double B = 6356752.314245;
    private final static double F = 1/298.257223563;

    private final double lat;
    private final double lon;

    public LatLong(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof LatLong)) return false;
        LatLong l = (LatLong)o;
        return this.lat == l.lat && this.lon == l.lon;
    }

    @Override
    public int hashCode(){
        return Double.valueOf(lat).intValue() + Double.valueOf(lon).intValue();
    }

    @Override
    public String toString(){
        return "{lat:" + lat + ", long:" + lon + "}";
    }

    public double distance(double lat, double lon){
        return distance(this.lat, this.lon, lat, lon);
    }

    public double distance(LatLong p){
        return distance(this, p);
    }

    public static double distance(LatLong p1, LatLong p2){
        return distance(p1.lat , p1.lon, p2.lat, p2.lon);
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2){
        double l = Math.toRadians(lon2 - lon1);
        double u1 = Math.atan((1-F)*Math.tan(Math.toRadians(lat1)));
        double u2 = Math.atan((1-F)*Math.tan(Math.toRadians(lat2)));
        double su1 = Math.sin(u1);
        double su2 = Math.sin(u2);
        double cu1 = Math.cos(u1);
        double cu2 = Math.cos(u2);
        double lambda = l;
        double lambdaP;
        int interLimit = 100;
        double cSqAlpha = 0;
        double sSigma = 0;
        double c2SigmaM = 0;
        double cSigma = 0;
        double s = 0;
        do{
            double sLambda = Math.sin(lambda);
            double cLambda = Math.cos(lambda);
            sSigma = Math.sqrt(cu2*sLambda*cu2*sLambda + (cu1*su2-su1*cu2*cLambda)*(cu1*su2-su1*cu2*cLambda));
            if(sSigma==0) return 0;
            cSigma = su1*su2 + cu1*cu2*cLambda;
            s = Math.atan2(sSigma, cSigma);
            double sAlpha = cu1*cu2*sLambda/sSigma;
            cSqAlpha = 1 - sAlpha*sAlpha;
            c2SigmaM = 0;
            if(cSqAlpha!=0)
                c2SigmaM = cSigma - 2*su1*su2/cSqAlpha;
            double c = F/16*cSqAlpha*(4+F*(4-3*cSqAlpha));
            lambdaP = lambda;
            lambda = l + (1-c)*F*sAlpha*(s + c*sSigma*(c2SigmaM + c*cSigma*(-1+2*c2SigmaM*c2SigmaM)));
        }while(Math.abs(lambda-lambdaP) > 1e-12 && --interLimit>0);

        if(interLimit==0) return 0;

        double usq = cSqAlpha*(A*A - B*B)/(B*B);
        double a = 1 + usq/16384*(4096+usq*(-768+usq*(320-175*usq)));
        double b = usq/1024*(256+usq*(-128+usq*(74-47*usq)));
        double deltaSigma = b*sSigma*(c2SigmaM + b/4*(cSigma*(-1+2*c2SigmaM*c2SigmaM)-b/6*c2SigmaM*(-3+4*sSigma*sSigma)*(-3+4*c2SigmaM*c2SigmaM)));

        double res = B*a*(s-deltaSigma);
        return res;

    }
}
