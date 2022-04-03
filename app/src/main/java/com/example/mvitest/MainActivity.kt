package com.example.mvitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvitest.ui.theme.MVITestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVITestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(
    viewModel: GreetingViewModel = remember {
        GreetingViewModel()
    }
) {
    val uiState = viewModel.uiState.collectAsState().value
    Column {
        TextField(value = uiState.name, onValueChange = {
            viewModel.handleAction(
                GreetingViewModel.UiAction.NameChanged(it)
            )
        })
        Text(text = "Hello ${uiState.name}!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVITestTheme {
        Greeting()
    }
}