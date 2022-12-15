package com.example.memoryleak

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.memoryleak.ui.theme.MemoryLeakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoryLeakTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeWebView("https://www.google.com")
                }
            }
        }
    }
}

@Composable
fun ComposeWebView(url: String) {
    AndroidView(
        factory = { context ->
            WebView(context)
        },
        update = { webView ->
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MemoryLeakTheme {
        ComposeWebView("https://www.google.com")
    }
}
