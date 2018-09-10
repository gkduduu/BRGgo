package brg.utils.jhy.brggo.utils;

import android.util.Log;

/**
 * Created by hayoung on 2018. 9. 5..
 * gkduduu@naver.com
 */
public class PriceParser {

    public static void HiltonParser(String html) {
        String currency = html.split("Price per night \\(")[1].substring(0, 3);
        String price = html.split("<span class=\"priceamount currencyCode-THB\">")[1].split("</span>")[0].trim();
        Log.i("jhy", "" + price.replaceAll("[^0-9]", "") + currency);
    }

    public static void KayakParser(String html) throws Exception {
        String currency = html.split("<div class=\"FrontDoorFooter__pickerLabel\">Currency</div>")[1].split("<div class=\"FrontDoorFooter__pickerTitle\">")[1].split("</div>")[0];
        String price = html.split("MORE DEALS FROM")[1].split("</div>")[0].trim();
        Log.i("jhy", "" + price.replaceAll("[^0-9.]", "") + currency);
    }

    public static void TrivagoParser(String html) {
        String currency = html.split(",\"currencyCode\":\"")[1].split("\"")[0].trim();
        String price = html.split("bestDeal\":\\{\"price\":")[1].split(",")[0].trim();
        Log.i("jhy", price + currency);
    }

    public static void CombineParser(String html) {
        String format = html.split("<span class=\\\"hc_pr_syb\\\">")[1].split("<span")[0];
        String currency = format.split("</span>")[0];
        String price = format.split("</span>")[1];
        Log.i("jhy", price + currency);
    }

    public static void GetaroomParser(String html) {
        String currency = html.split("\"active_currency\":\"")[1].split("\"")[0].trim();
        String price = html.split("<span class=\"amount\">")[1].split("</span")[0].trim();
        Log.i("jhy", price + currency);
    }

    public static void TripadvisorParser(String html) {
        String currency = html.split("currency_symbol\">₩</span><span>")[1].split("</span>")[0].trim();
        String price = html.split("\"bb_price_text \">")[1].split("</div")[0].trim();
        Log.i("jhy", "" + price.replaceAll("[^0-9.]", "") + currency);
    }
}
