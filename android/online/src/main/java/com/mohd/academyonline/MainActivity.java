package com.mohd.academyonline;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends Activity {
    static final String URL = "https://claude.ai/artifact/Nmy8Zp97TWvNXJWE4JaPAr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = Uri.parse(URL);
        try {
            CustomTabsIntent tab = new CustomTabsIntent.Builder()
                .setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(Color.parseColor("#0E1620"))
                    .setNavigationBarColor(Color.parseColor("#0E1620"))
                    .build())
                .setShowTitle(false)
                .setUrlBarHidingEnabled(true)
                .build();
            tab.launchUrl(this, uri);
        } catch (Exception e) {
            try { startActivity(new Intent(Intent.ACTION_VIEW, uri)); } catch (Exception ignored) {}
        }
        finish();
    }
}
