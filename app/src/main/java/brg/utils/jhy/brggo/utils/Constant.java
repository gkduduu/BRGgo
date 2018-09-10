package brg.utils.jhy.brggo.utils;

import brg.utils.jhy.brggo.data.Hotels;

/**
 * Created by hayoung on 2018. 9. 3..
 * gkduduu@naver.com
 */
public class Constant {

    private Hotels hotels;

    public static final int REALM_VERSION = 1;

    private Constant () {}
    private static class Singleton {
        private static final Constant instance = new Constant();
    }

    public static Constant getInstance () {
        return Singleton.instance;
    }

    public Hotels getHotels() {
        return this.hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }


}
