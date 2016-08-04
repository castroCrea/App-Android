package paolo.whatthefoot;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

import com.wonderpush.sdk.WonderPush;

public class BlogFoot extends AppCompatActivity implements View.OnClickListener, MoPubInterstitial.InterstitialAdListener, MoPubView.BannerAdListener {

    private WebView mWebView;
    private MoPubView moPubView;
    private MoPubInterstitial mInterstitial;
    private TextView t;
    private ImageView i;
    public static String url = "http://preprod.befoot.pm0s.com";


    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //WonderPush.setLogging(true);

        setContentView(R.layout.activity_blog_foot);

        /**
         * MOPUB
         */

        moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId("816a637d160b4abdbb761f37617ba54f"); // Enter your Ad Unit ID from www.mopub.com
        moPubView.setBannerAdListener(this);
        moPubView.bringToFront();
        moPubView.loadAd();

        mInterstitial = new MoPubInterstitial(this, "3132d3e50c184980afd875896b590803");
        mInterstitial.setInterstitialAdListener(this);
        mInterstitial.load();

        /**
         * END MOPUB
         */

        Toolbar TopToolbar = (Toolbar) findViewById(R.id.top_toolbar);
        TopToolbar.inflateMenu(R.menu.top_menu);//changed
        setSupportActionBar(TopToolbar);
        getSupportActionBar().setTitle("");

        /**
         * SET ALL BUTTON
         */

        t = (TextView)findViewById(R.id.toolbar_title);
        t.setOnClickListener(this);

        i = (ImageView)findViewById(R.id.refresh);
        i.setOnClickListener(this);

        i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                WebSettings webSettings = mWebView.getSettings();
                webSettings.setUserAgentString("webview_android");
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAppCacheEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webSettings.setSupportMultipleWindows(true);
                mWebView.reload();
                mWebView.setWebViewClient(new AppWebViewClient());
            }
        });

        /**
         * All MY BUTTON
         */
        final Button action_actus = (Button) findViewById(R.id.action_actus);
        final Button action_classement = (Button) findViewById(R.id.action_classement);
        final Button action_match = (Button) findViewById(R.id.action_match);

        /**
         * ACTION ON MY BUTTON
         */
        action_actus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                action_actus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setTextColor(getResources().getColor(R.color.black));
                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_classement.setTextColor(getResources().getColor(R.color.black));

                WebSettings webSettings = mWebView.getSettings();
                webSettings.setUserAgentString("webview_android");
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAppCacheEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webSettings.setSupportMultipleWindows(true);
                mWebView.loadUrl(BlogFoot.url);
                mWebView.setWebViewClient(new AppWebViewClient());
            }
        });
        action_classement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                action_classement.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setTextColor(getResources().getColor(R.color.black));
                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setTextColor(getResources().getColor(R.color.black));

                WebSettings webSettings = mWebView.getSettings();
                webSettings.setUserAgentString("webview_android");
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAppCacheEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webSettings.setSupportMultipleWindows(true);
                mWebView.loadUrl(BlogFoot.url + "/classement/");
                mWebView.setWebViewClient(new AppWebViewClient());
            }
        });
        action_match.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                action_match.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setTextColor(getResources().getColor(R.color.black));
                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_classement.setTextColor(getResources().getColor(R.color.black));

                WebSettings webSettings = mWebView.getSettings();
                webSettings.setUserAgentString("webview_android");
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAppCacheEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webSettings.setSupportMultipleWindows(true);
                mWebView.loadUrl(BlogFoot.url + "/direct-resultats/");
                mWebView.setWebViewClient(new AppWebViewClient());
            }
        });

        /**
         * END BUTTON
         */

        /**
         * create the webView
         */

        mWebView = (WebView) findViewById(R.id.activity_blog_foot_webview);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setUserAgentString("webview_android");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        mWebView.loadUrl(BlogFoot.url);
        mWebView.setWebViewClient(new AppWebViewClient());

        action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        action_actus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        action_match.setTextColor(getResources().getColor(R.color.black));
        action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        action_classement.setTextColor(getResources().getColor(R.color.black));

        /**
         * Action bar color
         */
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        WonderPush.initialize(this);
    }

    private class AppWebViewClient extends WebViewClient{

        /**
         * WebView Start
         * @param view
         * @param url
         * @param favicon
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

            /**
             * If connect to internet create a dialog Alerte
             */
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {

            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        BlogFoot.this);

                // set title
                alertDialogBuilder.setTitle("Erreur De connexion");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Connexion au serveur impossible. Veuiller vérifier votre connecion Internet et réessayer.")
                        .setCancelable(false)
                        .setPositiveButton("Réessayer",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                /*
                                * Refresh the app on retry clic
                                 */
                                Intent i = getBaseContext().getPackageManager()
                                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }


        /**
         * Override Webview
         * @param webView
         * @param url
         * @return
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url)
        {
            webView.loadUrl(url);
            return true;
        }


        /**
         * Show of the page
         * @param view
         * @param url
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            progressBar.setVisibility(view.GONE);
            findViewById(R.id.activity_blog_foot_webview).setVisibility(View.VISIBLE);
        }


        /**
         * If error on webview
         * @param view
         * @param request
         * @param error
         */
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    /**
     * Action for native button of smartPhone
     * @param keyCode
     * @param event
     * @return
     */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    { //if back key is pressed
        if((keyCode == KeyEvent.KEYCODE_BACK)&& mWebView.canGoBack())
        {
            mWebView.goBack();
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * Assign the menu to top bar
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    /**
     * on general click (use for the title)
     * @param v
     */

    public void onClick(View v) {
        final Button action_actus = (Button) findViewById(R.id.action_actus);
        final Button action_classement = (Button) findViewById(R.id.action_classement);
        final Button action_match = (Button) findViewById(R.id.action_match);

        findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

        action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        action_actus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        action_match.setTextColor(getResources().getColor(R.color.black));
        action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        action_classement.setTextColor(getResources().getColor(R.color.black));

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setUserAgentString("webview_android");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        mWebView.loadUrl(BlogFoot.url);
        mWebView.setWebViewClient(new AppWebViewClient());
    }

    /**
     * Click action for the item of the menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setUserAgentString("webview_android");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);

        final Button action_actus = (Button) findViewById(R.id.action_actus);
        final Button action_classement = (Button) findViewById(R.id.action_classement);
        final Button action_match = (Button) findViewById(R.id.action_match);

        switch (item.getItemId()) {
            case R.id.action_actus:
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                action_actus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setTextColor(getResources().getColor(R.color.black));
                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_classement.setTextColor(getResources().getColor(R.color.black));

                mWebView.loadUrl(BlogFoot.url);
                mWebView.setWebViewClient(new AppWebViewClient());
                return true;

            case R.id.action_classement:
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                action_classement.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setTextColor(getResources().getColor(R.color.black));
                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setTextColor(getResources().getColor(R.color.black));

                mWebView.loadUrl(BlogFoot.url + "/classement/");
                mWebView.setWebViewClient(new AppWebViewClient());
                return true;

            case R.id.action_match:
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                action_match.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setTextColor(getResources().getColor(R.color.black));
                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_classement.setTextColor(getResources().getColor(R.color.black));

                mWebView.loadUrl(BlogFoot.url + "/direct-resultats/");
                mWebView.setWebViewClient(new AppWebViewClient());
                return true;

            case R.id.action_apropos:
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setTextColor(getResources().getColor(R.color.black));
                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setTextColor(getResources().getColor(R.color.black));
                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_classement.setTextColor(getResources().getColor(R.color.black));

                mWebView.loadUrl(BlogFoot.url +"/a-propos/");
                mWebView.setWebViewClient(new AppWebViewClient());
                return true;

            default:
                findViewById(R.id.activity_blog_foot_webview).setVisibility(View.GONE);

                action_match.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_match.setTextColor(getResources().getColor(R.color.black));
                action_actus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_actus.setTextColor(getResources().getColor(R.color.black));
                action_classement.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                action_classement.setTextColor(getResources().getColor(R.color.black));

                mWebView.loadUrl(BlogFoot.url);
                mWebView.setWebViewClient(new AppWebViewClient());
                return super.onOptionsItemSelected(item);

        }
    }


    /**
     * On back press button of smartphone
     */
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                BlogFoot.this);

        // set title
        alertDialogBuilder.setTitle("Exit");

        // set dialog message
        alertDialogBuilder
                .setMessage("Do you really want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        BlogFoot.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


    /**
     * on close the app
     */

    @Override
    protected void onDestroy() {
        moPubView.destroy();
        mInterstitial.destroy();
        super.onDestroy();
    }

    /**
     * MO PUB VIEW
     */

    /**
     * Inertital load
     * @param interstitial
     */
    @Override
    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        if (interstitial.isReady()) {
//            Toast.makeText(getApplicationContext(),
//                 "Interstial successfully loaded.", Toast.LENGTH_SHORT).show();
            mInterstitial.show();
        } else {}
    }
    /**
     * Interstital failed
     * @param interstitial
     * @param errorCode
     */
    @Override
    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {}
    /**
     * insterstital show
     * @param interstitial
     */
    @Override
    public void onInterstitialShown(MoPubInterstitial interstitial) {}
    /**
     * insterstital click
     * @param interstitial
     */
    @Override
    public void onInterstitialClicked(MoPubInterstitial interstitial) {}
    /**
     * insterstital close
     * @param interstitial
     */
    @Override
    public void onInterstitialDismissed(MoPubInterstitial interstitial) {}

    /**
     * banner load
     * @param banner
     */
    @Override
    public void onBannerLoaded(MoPubView banner) { /*Toast.makeText(getApplicationContext(),"Banner successfully loaded.", Toast.LENGTH_SHORT).show();*/}
    /**
     * banner Failed
     * @param banner
     * @param errorCode
     */
    // Sent when the banner has failed to retrieve an ad. You can use the MoPubErrorCode value to diagnose the cause of failure.
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode){};
    /**
     * banner click
     * @param banner
     */
    // Sent when the user has tapped on the banner.
    public void onBannerClicked(MoPubView banner){};
    /**
     * banner Expanded
     * @param banner
     */
    // Sent when the banner has just taken over the screen.
    public void onBannerExpanded(MoPubView banner){};
    /**
     * banner Collapsed
     * @param banner
     */
    // Sent when an expanded banner has collapsed back to its original size.
    public void onBannerCollapsed(MoPubView banner){};

    /**
     * END MO PUB VIEW
     */
}
