package brg.utils.jhy.brggo.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import brg.utils.jhy.brggo.data.HotelKeyword;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class JsonParser {
    //https://www.trivago.co.kr/?aDateRange[arr]=2018-09-21&aDateRange[dep]=2018-09-22&aPriceRange[from]=0&aPriceRange[to]=0&iPathId=519&aGeoCode[lat]=13.729005&aGeoCode[lng]=100.509949&iGeoDistanceItem=116046&iGeoDistanceLimit=20000&aCategoryRange=0,1,2,3,4,5&aOverallLiking=1,2,3,4,5&sOrderBy=relevance desc&bTopDealsOnly=false&iRoomType=7&cpt=11604602  &iIncludeAll=0&iViewType=0&bIsSeoPage=false&bIsSitemap=false&
    //https://www.trivago.co.kr/?aDateRange[arr]=2018-09-21&aDateRange[dep]=2018-09-22&aPriceRange[from]=0&aPriceRange[to]=0&iPathId=519&aGeoCode[lat]=13.74821&aGeoCode[lng]=100.542915&iGeoDistanceItem=7823598&aCategoryRange=0,1,2,3,4,5&aOverallLiking=1,2,3,4,5&sOrderBy=relevance desc&bTopDealsOnly=false&iRoomType=7&cpt=782359802                         &iIncludeAll=0   &iViewType=0&bIsSeoPage=false&bIsSitemap=false&

    //이름[공홈코드,카약인자,트리바고,호텔스컴바인, 게타룸]
    public static void parsingHilton(JSONArray brand) throws JSONException {
        Log.i("jhy","hilton = >" + brand.toString());


        JSONObject regionJson = (brand.getJSONObject(0));
        Iterator iterator = regionJson.keys();
        String key = (String)iterator.next();



    }
}
