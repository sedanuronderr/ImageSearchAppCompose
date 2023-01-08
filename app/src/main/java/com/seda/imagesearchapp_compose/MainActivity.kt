package com.seda.imagesearchapp_compose

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.seda.imagesearchapp_compose.ui.theme.ImageSearchAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSearchAppComposeTheme {
              MyApp {
                  MainContent()
              }  // A surface container using the 'background' color from the theme

            }
        }
    }
}
@Composable
fun MyApp(content: @Composable ()->Unit) {
    content()
}




