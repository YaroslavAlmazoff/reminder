package com.example.reminderyoutube

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ReminderItem(reminder: Reminder, viewModel: RemindersViewModel) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .background(colorResource(id = R.color.dark), RoundedCornerShape(25.dp))
            .border(0.5.dp, colorResource(id = R.color.blue), RoundedCornerShape(25.dp))
            .padding(start = 10.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
            .clickable {
                Toast
                    .makeText(context, reminder.text, Toast.LENGTH_LONG)
                    .show()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = reminder.text,
            style = TextStyle(color = Color.White),
            modifier = Modifier.fillMaxWidth(0.50f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = reminder.date,
                style = TextStyle(color = colorResource(id = R.color.blue)),
                modifier = Modifier.padding(start = 7.dp)
            )
            Text(
                text = reminder.time,
                style = TextStyle(color = colorResource(id = R.color.blue)),
                modifier = Modifier.padding(start = 7.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Delete",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 7.dp)
                    .clickable {
                        viewModel.removeReminder(reminder, context)
                    }
            )
        }
    }
}