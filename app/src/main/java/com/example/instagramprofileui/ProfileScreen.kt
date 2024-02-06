package com.example.instagramprofileui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "_gdastu", modifier = Modifier)
    }
}

@Composable
fun TopBar(name:String,modifier: Modifier=Modifier){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 24.dp)) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back", tint = Color.Black, modifier = Modifier.size(25.dp))
        Text(modifier = Modifier.width(200.dp),text = name, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp), overflow = TextOverflow.Ellipsis)
        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription = "Notifications", modifier = Modifier.size(25.dp))
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu), contentDescription = "Menu",modifier = Modifier.size(24.dp))
    }
}