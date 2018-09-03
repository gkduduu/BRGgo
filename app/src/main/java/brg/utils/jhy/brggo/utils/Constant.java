package brg.utils.jhy.brggo.utils;

import brg.utils.jhy.brggo.data.Hotel;

/**
 * Created by hayoung on 2018. 9. 3..
 * gkduduu@naver.com
 */
public class Constant {

    private Hotel hotels;

    private Constant () {}
    private static class Singleton {
        private static final Constant instance = new Constant();
    }

    public static Constant getInstance () {
        return Singleton.instance;
    }

    public Hotel getHotels() {
        return this.hotels;
    }

    public void setHotels(Hotel hotel) {
        this.hotels = hotel;
    }
}
