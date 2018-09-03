package brg.utils.jhy.brggo.data;

import java.util.ArrayList;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class HotelCity {
    String cityName;
    ArrayList<HotelName> hotelList;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<HotelName> getHotelList() {
        return hotelList;
    }

    public void setHotelList(ArrayList<HotelName> hotelList) {
        this.hotelList = hotelList;
    }
}
