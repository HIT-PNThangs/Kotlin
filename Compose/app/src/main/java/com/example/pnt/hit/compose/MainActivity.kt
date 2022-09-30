package com.example.pnt.hit.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pnt.hit.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    CardPreview()
                }
            }
        }
    }
}

@Composable
fun OnBoardingCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(27.dp)
    ) {
        Text(text = "Explore ans Mint NTFs")
        Text(text = "You can buy and sell the NTFs of the best artists in the word")
        Spacer(modifier = Modifier.padding(bottom = 27.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Get started now")
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    ComposeTheme {
        OnBoardingCard()
    }
}