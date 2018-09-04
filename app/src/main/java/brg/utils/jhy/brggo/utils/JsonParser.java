package brg.utils.jhy.brggo.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import brg.utils.jhy.brggo.data.HotelBrand;
import brg.utils.jhy.brggo.data.HotelCity;
import brg.utils.jhy.brggo.data.HotelKeyword;
import brg.utils.jhy.brggo.data.HotelName;
import brg.utils.jhy.brggo.data.HotelRegion;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class JsonParser {
    //https://www.trivago.co.kr/?aDateRange[arr]=2018-09-21&aDateRange[dep]=2018-09-22&aPriceRange[from]=0&aPriceRange[to]=0&iPathId=519&aGeoCode[lat]=13.729005&aGeoCode[lng]=100.509949&iGeoDistanceItem=116046&iGeoDistanceLimit=20000&aCategoryRange=0,1,2,3,4,5&aOverallLiking=1,2,3,4,5&sOrderBy=relevance desc&bTopDealsOnly=false&iRoomType=7&cpt=11604602  &iIncludeAll=0&iViewType=0&bIsSeoPage=false&bIsSitemap=false&
    //https://www.trivago.co.kr/?aDateRange[arr]=2018-09-21&aDateRange[dep]=2018-09-22&aPriceRange[from]=0&aPriceRange[to]=0&iPathId=519&aGeoCode[lat]=13.74821&aGeoCode[lng]=100.542915&iGeoDistanceItem=7823598&aCategoryRange=0,1,2,3,4,5&aOverallLiking=1,2,3,4,5&sOrderBy=relevance desc&bTopDealsOnly=false&iRoomType=7&cpt=782359802                         &iIncludeAll=0   &iViewType=0&bIsSeoPage=false&bIsSitemap=false&

    public static HotelBrand parsingHilton(JSONArray brand) throws JSONException {
        Log.i("jhy","hilton = >" + brand.toString());

        HotelBrand hilton = new HotelBrand();
        hilton.setBrandName("hilton");
        ArrayList<HotelRegion> regions = new ArrayList<>();

        JSONObject regionJson = (brand.getJSONObject(0));
        Iterator iterator = regionJson.keys();
        String key = (String)iterator.next();

        HotelRegion hotelRegion = new HotelRegion();
        hotelRegion.setRegionName(key);

        ArrayList<HotelCity> cities = new ArrayList<>();
        JSONArray cityArray = regionJson.getJSONArray(key);

        HotelCity hotelCity = new HotelCity();
        JSONObject cityJson = (cityArray.getJSONObject(0));
        Iterator iteratorcity = cityJson.keys();
        String keycity = (String)iteratorcity.next();
        hotelCity.setCityName(keycity);

        JSONArray hotelArray = cityJson.getJSONArray(keycity);

        ArrayList<HotelName> hotelNameArrayList = new ArrayList<>();
        for(int i=0; i<hotelArray.length();i++) {
            Log.i("jhy",i + "index hotel = > " + hotelArray.getJSONObject(i));
            HotelName name = new HotelName();

            JSONObject nameJson = (hotelArray.getJSONObject(i));
            Iterator iteratorname = nameJson.keys();
            String hotelname = (String)iteratorname.next();
            name.setName(hotelname);

            JSONArray keyword = nameJson.getJSONArray(hotelname);
            String keywords[] = new String[5];
            Log.i("jhy","keywordarray ==> " +keyword);
            for(int j=0; j<keyword.length();j++) {
                //이름[공홈코드,카약인자,트리바고,호텔스컴바인, 게타룸]
                Log.i("jhy","keyword ==> " +keyword.getString(j));
                keywords[j] = keyword.getString(j);
            }
            HotelKeyword hotelKeyword = new HotelKeyword(keywords);
            name.setKeyword(hotelKeyword);
            hotelNameArrayList.add(name);
        }
        hotelCity.setHotelList(hotelNameArrayList);
        cities.add(hotelCity);
        hotelRegion.setCities(cities);

        regions.add(hotelRegion);
        hilton.setHotelRegions(regions);

        return hilton;
    }
}
