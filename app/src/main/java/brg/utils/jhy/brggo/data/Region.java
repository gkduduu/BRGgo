package brg.utils.jhy.brggo.data;

import java.util.ArrayList;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class Region {
    String regionName;
    ArrayList<City> cities;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }
}
