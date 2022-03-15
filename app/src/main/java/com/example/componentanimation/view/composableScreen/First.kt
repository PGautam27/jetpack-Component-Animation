package com.example.componentanimation.view.composableScreen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun First() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(targetState = count) { targetCount ->
                Text(text = "Count: $targetCount")
        }
        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {
            GlobalScope.launch {
                while (count<=99){
                    count++
                    delay(1000)
                }
            }
        }) {
            Text("Add")
        }
    }
}
