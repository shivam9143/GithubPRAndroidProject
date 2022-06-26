package com.shivam.githubprs

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shivam.base.AppConstants.SPLASH_TIME_OUT
import com.shivam.githubprs.ui.theme.GithubPrsTheme
import com.shivam.prs.ui.PrActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubPrsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("WELCOME")
                }
            }
        }
        scheduleRedirect()
    }

    private fun scheduleRedirect() {
        Handler(Looper.getMainLooper()).postDelayed({
            redirect()
        }, SPLASH_TIME_OUT)
    }

    private fun redirect() {
        val intent = Intent(this, PrActivity::class.java)
        startActivity(intent)
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        GithubPrsTheme {
            Greeting("Android")
        }
    }
}