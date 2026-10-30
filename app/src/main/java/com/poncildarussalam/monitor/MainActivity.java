package com.poncildarussalam.monitor;

import android.app.*;import android.os.*;import android.webkit.*;import android.net.*;import android.content.*;import android.view.*;import android.widget.*;import android.graphics.Bitmap;

public class MainActivity extends Activity {
  private WebView web; private static final String HOME = "https://poncildarussalam.free.nf/monitor-kamar/?i=1";
  @Override public void onCreate(Bundle b) { super.onCreate(b); getWindow().setStatusBarColor(0xFF123F32); getWindow().setNavigationBarColor(0xFF123F32); web=new WebView(this); setContentView(web); WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setDatabaseEnabled(true); s.setLoadsImagesAutomatically(true); s.setJavaScriptCanOpenWindowsAutomatically(true); s.setSupportMultipleWindows(false); s.setAllowFileAccess(true); s.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW); CookieManager.getInstance().setAcceptCookie(true); CookieManager.getInstance().setAcceptThirdPartyCookies(web,true);
    web.setWebViewClient(new WebViewClient() { @Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r) { Uri u=r.getUrl(); String host=u.getHost(); if(host!=null && (host.equals("poncildarussalam.free.nf") || host.endsWith(".free.nf"))) return false; try { startActivity(new Intent(Intent.ACTION_VIEW,u)); } catch(Exception e) {} return true; } @Override public void onPageStarted(WebView v,String u,Bitmap f){super.onPageStarted(v,u,f);} });
    web.setWebChromeClient(new WebChromeClient() { @Override public boolean onShowFileChooser(WebView v,ValueCallback<Uri[]> cb,FileChooserParams p) { return false; } });
    web.setDownloadListener((u,ua,cd,m,l)->{try{startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(u)));}catch(Exception e){Toast.makeText(this,"Tidak dapat membuka unduhan",Toast.LENGTH_SHORT).show();}});
    web.loadUrl(HOME);
  }
  @Override public void onBackPressed() { if(web!=null && web.canGoBack()) web.goBack(); else super.onBackPressed(); }
  @Override protected void onPause(){if(web!=null)CookieManager.getInstance().flush();super.onPause();}
}
