package brg.utils.jhy.brggo.data;

import java.util.ArrayList;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class HotelRegion {
    String regionName;
    ArrayList<HotelCity> cities;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public ArrayList<HotelCity> getCities() {
        return cities;
    }

    public void setCities(ArrayList<HotelCity> cities) {
        this.cities = cities;
    }
}
