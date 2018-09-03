package brg.utils.jhy.brggo.data;

import java.util.ArrayList;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class HotelBrand {
    String brandName;
    ArrayList<HotelRegion> hotelRegions;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ArrayList<HotelRegion> getHotelRegions() {
        return hotelRegions;
    }

    public void setHotelRegions(ArrayList<HotelRegion> hotelRegions) {
        this.hotelRegions = hotelRegions;
    }
}
