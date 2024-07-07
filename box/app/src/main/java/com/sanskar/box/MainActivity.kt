package com.sanskar.box

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity() : ComponentActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Sample Text")
                    Row {
                        Text(text = " this")
                        Text(text = " is")
                        Text(text = " a")
                        Text(text = " row")
                        Text(text = " text")
                    }
                    Column {
                        Text(text = " this")
                        Text(text = " is")
                        Text(text = " a")
                        Text(text = " column")
                        Text(text = " text")
                    }

                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color.Gray)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Color.Yellow)
                        ) {
                            Text(text = " this")
                            Text(text = " is")
                            Text(text = " a")
                            Text(text = " column")
                            Text(text = " 1")
                            Text(text = "with")
                            Text(text = " modifier")
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Color.Blue)
                        ) {
                            Text(text = " this")
                            Text(text = " is")
                            Text(text = " a")
                            Text(text = " column")
                            Text(text = " 2")
                            Text(text = "with")
                            Text(text = " modifier")
                        }
                    }

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .size(220.dp)
                                .padding(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(Color.Magenta)
                                    .size(110.dp)
                                    .align(Alignment.Center)
                            ) {
                                Text(text = "Box 2", color = Color.White, modifier = Modifier.align(Alignment.Center))
                            }
                            Text(text = "Box 1", modifier = Modifier.align(Alignment.TopStart))
                        }
                    }
                }
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
