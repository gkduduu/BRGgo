package brg.utils.jhy.brggo.data;

import java.util.ArrayList;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class Brand {
    String brandName;
    ArrayList<Region> regions;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }
}
