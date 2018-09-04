package brg.utils.jhy.brggo.data;

import java.util.ArrayList;

/**
 * Created by hayoung on 2018. 9. 3..
 * gkduduu@naver.com
 */
public class Hotel {
    public ArrayList<HotelBrand> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<HotelBrand> hotels) {
        this.hotels = hotels;
    }

    ArrayList<HotelBrand> hotels = new ArrayList<>();
}
