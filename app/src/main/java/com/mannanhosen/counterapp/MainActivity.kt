package com.mannanhosen.counterapp
import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.mutableIntSetOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
         CounterScreen()
        }
    }
}
@Composable
fun CounterScreen() {

    var counter2 by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row {
            Text(
                text = "Counter :",
                color = Color.White,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = counter2.toString(),
                color = Color.White,
                fontSize = 30.sp
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Button(
                onClick = {
                   counter2++
                },
                colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                )

            ){
             Text(text = "Increment",
                 fontSize = 16.sp,
                 color = Color.Blue)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                   if (counter2 > 0) {
                       counter2--
                   }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )

            ){
                Text(text = "Decrement",
                    fontSize = 16.sp,
                    color = Color.Blue)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                counter2 = 0
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            )

        ){
            Text(text = "Reset",
                fontSize = 16.sp,
                color = Color.Blue)
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CounterScreenPreview(){
    CounterScreen()
}

