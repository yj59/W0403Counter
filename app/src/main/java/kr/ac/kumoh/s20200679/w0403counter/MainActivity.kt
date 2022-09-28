package kr.ac.kumoh.s20200679.w0403counter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20200679.w0403counter.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Counter()
                Counter()
                Counter()
            }
        }
    }
}

@Composable // 실행하는 코드에는 영향을 주지 않으나, 컴파일러는 인식 가능함
fun MyApp(content: @Composable () -> Unit ) {
    W0403CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()   // content를 쓰는 게 좋은 구조라고 함 !
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0)}
    
    Column(modifier = Modifier
        //.fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString(),
            fontSize = 70.sp
        )
        Row(){
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    count++
                    Log.i("Counter", count.toString())
                }
            ){
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    if(count > 0)
                        count--
                    Log.i("Counter", count.toString())
                }
            ){
                Text(text = "감소")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Counter()
    }
}