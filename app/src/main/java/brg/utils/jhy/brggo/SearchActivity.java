package brg.utils.jhy.brggo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import brg.utils.jhy.brggo.data.HotelKeyword;
import brg.utils.jhy.brggo.utils.PriceParser;

public class SearchActivity extends AppCompatActivity {
    WebView webview_searcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_web);

        HotelKeyword keyword = (HotelKeyword)getIntent().getSerializableExtra("keyword");

        webview_searcher = findViewById(R.id.webview_searcher);
        webview_searcher.setWebViewClient(new testClient());
        webview_searcher.setWebChromeClient(new WebChromeClient());

        webview_searcher.getSettings().setJavaScriptEnabled(true);
        webview_searcher.addJavascriptInterface(new MyJavaScriptInterface(this), "HtmlViewer");
    }

    class testClient extends WebViewClient {
        @Override
        public void onPageFinished(final WebView view, String url) {
            Log.i("jhy","page finish");
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
            try {
//            PriceParser.HiltonParser(html);
//            PriceParser.TrivagoParser(html);
//            PriceParser.CombineParser(html);
//            PriceParser.GetaroomParser(html);
//                PriceParser.KayakParser(html);
//PriceParser.TripadvisorParser(html);
            }catch(Exception e) {
                Log.i("jhy","retry!!");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        webview_searcher.loadUrl("javascript:window.HtmlViewer.showHTML" +
                                "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                    }
                });

            }
        }

    }
}
