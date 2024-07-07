package com.sanskar.firstapplication

package com.sanskar.firstapplication



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sanskar.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        val gradientColors = listOf(Cyan, Blue, Red)

                        // Text with gradient
                        Text(
                            text = "This is my first App",
                            style = TextStyle(
                                brush = Brush.linearGradient(
                                    colors = gradientColors
                                )
                            )
                        )

                        // Annotated String with gradient
                        Text(
                            text = buildAnnotatedString {
                                append("This ils my first App\n")
                                withStyle(
                                    SpanStyle(
                                        brush = Brush.linearGradient(
                                            colors = gradientColors
                                        )
                                    )
                                ) {
                                    append("This is my first App")
                                }
                                append("\nThis is my first App")
                            }
                        )

                        val brush = Brush.linearGradient(colors = gradientColors)

                        // Annotated String with partial transparency
                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    brush = brush, alpha = .5f
                                )
                            ) {
                                append("Hello in ")
                            }
                            withStyle(
                                SpanStyle(
                                    brush = brush, alpha = 1f
                                )
                            ) {
                                append("World ❤️")
                            }
                        })

                        // Marquee text
                        Column(Modifier.width(400.dp)) {
                            Text(
                                "Hello World Hello World Hello World Hello World Hello World Hello World Hello World",
                                modifier = Modifier.basicMarquee(),
                                fontSize = 50.sp
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("LifeCycle: onStart method called")
    }

    override fun onResume() {
        super.onResume()
        println("LifeCycle: onResume method called")
    }

    override fun onPause() {
        super.onPause()
        println("LifeCycle: onPause method called")
    }

    override fun onStop() {
        super.onStop()
        println("LifeCycle: onStop method called")
    }
}
