package kr.co.mikarusoft.findbookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class BookstoreMap extends AppCompatActivity {

    private WebView webView;

    private static final String URL_MAP = "http://kanjangramen999.cafe24.com/bookstore_upload/show_bookstore.php/#map";

    private Button go_to_main;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstore_map);

        webView = (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용을 허용한다.
        webView.setWebViewClient(new WebViewClient());  // 새로운 창을 띄우지 않고 내부에서 웹뷰를 실행시킨다.

        webView.loadUrl(URL_MAP);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
                callback.invoke(origin, true, false);
            }
        });

        go_to_main = (Button) findViewById(R.id.go_to_main);
        go_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
