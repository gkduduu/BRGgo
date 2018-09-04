package brg.utils.jhy.brggo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SearchWebActivity extends AppCompatActivity {
    WebView aaaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_web);

         aaaa = findViewById(R.id.aaaa);
        aaaa.setWebViewClient(new testClient());
        aaaa.setWebChromeClient(new WebChromeClient());
//        WebView bbbb= findViewById(R.id.bbbb);
//        aaaa.loadUrl("https://www.hotelscombined.com/Hotel/Search?checkin=2018-09-07&checkout=2018-09-08&Rooms=1&adults_1=2&languageCode=KO&currencyCode=THB&fileName=Millennium_Hilton_Bangkok");
        final String URL = "https://secure3.hilton.com/en_US/hi/reservation/book.htm?inputModule=HOTEL_SEARCH&ctyhocn=BKKHITW&arrivalDay=31&arrivalMonth=10&arrivalYear=2018&departureDay=01&departureMonth=10&departureYear=2018&numRooms=1&room1NumAdults=2&room1NumChildren=0&WT.mc_id=zINDA0US1XX2OLX3DA4MS5Kayak6BKKHITW7_202296021&utm_source=intlmeta&utm_medium=intlmeta&utm_campaign=intlmeta";
        aaaa.loadUrl(URL);
        aaaa.getSettings().setJavaScriptEnabled(true);
        aaaa.addJavascriptInterface(new MyJavaScriptInterface(this), "HtmlViewer");

    }

    class testClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            Log.i("jhy","finish");
            view.loadUrl("javascript:window.HtmlViewer.showHTML" +
                    "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
    }

    class MyJavaScriptInterface {

        private Context ctx;

        MyJavaScriptInterface(Context ctx) {
            this.ctx = ctx;
        }

        @JavascriptInterface
        public void showHTML( String html) {
            String a = html.split("<span class=\"priceamount currencyCode-THB\">")[1].split("</span>")[0].trim();
            Log.i("jhy","" + a);
        }

    }
}
