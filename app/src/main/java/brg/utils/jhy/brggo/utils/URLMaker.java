package brg.utils.jhy.brggo.utils;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
public class URLMaker {
    /*
    밀튼
    https://secure3.hilton.com/en_US/hi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKHITW&arrivalDay=31&arrivalMonth=10&arrivalYear=2018&departureDay=01&departureMonth=10&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKHITW7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    월도프
    https://secure3.hilton.com/en_US/gi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKWAWA&arrivalDay=27&arrivalMonth=09&arrivalYear=2018&departureDay=28&departureMonth=09&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKWAWA7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    콘래드
    https://secure3.hilton.com/en_US/gi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKCICI&arrivalDay=27&arrivalMonth=09&arrivalYear=2018&departureDay=28&departureMonth=09&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKCICI7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    콘래드 레지던스
    https://secure3.hilton.com/en_US/gi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKRECI&arrivalDay=27&arrivalMonth=09&arrivalYear=2018&departureDay=28&departureMonth=09&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKRECI7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    스쿰빗
    https://secure3.hilton.com/en_US/gi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKSUHI&arrivalDay=27&arrivalMonth=09&arrivalYear=2018&departureDay=28&departureMonth=09&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKSUHI7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    더블트리
    https://secure3.hilton.com/en_US/gi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKSSDI&arrivalDay=13&arrivalMonth=12&arrivalYear=2018&departureDay=14&departureMonth=12&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKSSDI7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    후아힌
    https://secure3.hilton.com/en_US/gi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=HHQHIHI&arrivalDay=13&arrivalMonth=12&arrivalYear=2018&departureDay=14&departureMonth=12&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6HHQHIHI7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta
    */
    public static void goHilton(String hotelCode,String arrMonth, String arrDay,String arrYear, String num) {
        String hiltonDomain = "https://secure3.hilton.com/en_US/hi/reservation/book.htm?inputModule=HOTEL_SEARCH&";

        String hiltonWhere = "ctyhocn=" + hotelCode + "W&";
        String hiltonArrive =  "arrivalDay="+ arrDay +"&arrivalMonth=" + arrMonth + "&arrivalYear="+arrYear;
        String hiltonDeparture = "&departureDay=01&departureMonth=10&departureYear=2018";
        String hiltonNum = "&numRooms=1&room1NumAdults="+ num +"&room1NumChildren=0&";
        String hiltonKey = "WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKHITW7_202296021";
        String hiltonSuffix = "&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta";
    }

    //https://www.kayak.com/hotels/Millennium-Hilton-Bangkok,Bangkok,Thailand--c26166-h149890/2018-09-03/2018-09-05/2adults?sort=rank_a
    public static void goKayak(String hotelCode,String arrDate, String depDate, String num) {
        String kayakDomain = "https://www.kayak.com/hotels/";
        String kayakWhere = hotelCode;
        String kayakDate = "/" + arrDate + "/" + depDate + "/";
        String kayakNum = num + "adults?sort=rank_a";
    }

    //https://www.trivago.co.kr/?aDateRange[arr]=2018-09-21&aDateRange[dep]=2018-09-22&aPriceRange[from]=0&aPriceRange[to]=0&iPathId=519&aGeoCode[lat]=13.74821&aGeoCode[lng]=100.542915&iGeoDistanceItem=7823598&aCategoryRange=0,1,2,3,4,5&aOverallLiking=1,2,3,4,5&sOrderBy=relevance desc&bTopDealsOnly=false&iRoomType=7&cpt=782359802                         &iIncludeAll=0   &iViewType=0&bIsSeoPage=false&bIsSitemap=false&
    public static void goTrivago(String arrDate, String depDate, String hotelCode) {
        String triDomain = "https://www.trivago.co.kr/?";
        String triArrive = "aDateRange[arr]=" + arrDate + "&";
        String triDeparture = "aDateRange[dep]=" + depDate + "&aPriceRange[from]=0&aPriceRange[to]=0&iPathId=519&aGeoCode[lat]=13.74821&aGeoCode[lng]=100.542915&";
        String triWhere = "iGeoDistanceItem=" + hotelCode + "&aCategoryRange=0,1,2,3,4,5&aOverallLiking=1,2,3,4,5&sOrderBy=relevance desc&bTopDealsOnly=false&iRoomType=7&cpt=" + hotelCode + "&iIncludeAll=0&iViewType=0&bIsSeoPage=false&bIsSitemap=false&";
    }

    //https://www.hotelscombined.com/Hotel/Search?checkin=2018-09-07&checkout=2018-09-08&Rooms=1&adults_1=2&languageCode=KO&currencyCode=THB&fileName=Millennium_Hilton_Bangkok
    public static void goCombine(String arrDate, String depDate, String num, String hotelCode) {
        String combineDomain = "https://www.hotelscombined.com/Hotel/Search?";
        String combineArrive = "checkin=2018-09-07";
        String combineDeparture = "&checkout=2018-09-08";
        String combineNum = "&Rooms=1&adults_1=" + num + "&languageCode=KO&currencyCode=THB&";
        String combineWhere = "fileName=" + hotelCode;
    }

    //https://www.getaroom.com/hotels/millennium-hilton-bangkok?check_in=09/13/2018&check_out=09/14/2018&rinfo=[[18,18]]
    public static void goGetaroom(String hotelCode,String arrDate, String DepDate) {
        String getaDomain = "https://www.getaroom.com/hotels/";
        String getaWhere = hotelCode;
        String getaArrive = "?check_in=" + arrDate;
        String getaDeparture = "&check_out=" + DepDate;
        String getaSuffix = "&rinfo=[[18,18]]";
    }
}
