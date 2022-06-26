package com.shivam.githubprs

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shivam.base.AppConstants.SPLASH_TIME_OUT
import com.shivam.githubprs.ui.theme.GithubPrsTheme
import com.shivam.prs.ui.PrActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubPrsTheme {
                // A surface container using the 'background' color from the theme
                SplashScreen()
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("WELCOME")
//                }
            }
        }
        scheduleRedirect()
    }

    @Composable
    fun SplashScreen() {
        val scale = remember {
            androidx.compose.animation.core.Animatable(0f)
        }

        // Animation
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                // tween Animation
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            // Customize the delay time
            delay(2000L)
        }

        // Image
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Change the logo
//            Surface(
//                modifier = Modifier.size(130.dp),
//                shape = RoundedCornerShape(12.dp),
//                color = MaterialTheme.colors.surface.copy(
//                    alpha = 0.2f
//                )
//            ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_git_pull_request),
                    contentDescription = "Logo",
                    modifier = Modifier.scale(scale.value)
                )
                Text(
                    text = "Github Closed PR's",
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 5.dp)
                )
                Text(
                    text = "Shivam Kanodia(shivam9143)",
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 5.dp)
                )
                Text(
                    text = "9044224967(shivamkanodia01@gmail.com)",
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }

    }

    private fun scheduleRedirect() {
        Handler(Looper.getMainLooper()).postDelayed({
            redirect()
        }, SPLASH_TIME_OUT)
    }

    private fun redirect() {
        val intent = Intent(this, PrActivity::class.java)
        startActivity(intent)
        finish()
    }

}