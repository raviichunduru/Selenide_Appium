package enums;

public enum WebViews
{
    WEBVIEW_IN_GENERALSTORE_APP ("WEBVIEW_com.androidsample.generalstore"),
    WEBVIEW_IN_WEBDRIVERIO_APP ("WEBVIEW_com.wdiodemoapp");

    String webView;

    WebViews(String webView)
    {
        this.webView = webView;
    }

    public String getWebView()
    {
        return webView;
    }
}
