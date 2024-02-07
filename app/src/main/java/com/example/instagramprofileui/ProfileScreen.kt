package com.example.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "_gdastu", modifier = Modifier)
        ProfileSection()
    }
}

@Composable
fun TopBar(name:String,modifier: Modifier=Modifier){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 15.dp)) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back", tint = Color.Black, modifier = Modifier.size(25.dp))
        Text(modifier = Modifier.width(200.dp),text = name, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp), textAlign = TextAlign.Left ,overflow = TextOverflow.Ellipsis)
        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription = "Notifications", modifier = Modifier.size(25.dp))
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu), contentDescription = "Menu",modifier = Modifier.size(24.dp))
    }
}

@Composable
fun ProfileSection(modifier: Modifier=Modifier){
    Column(modifier = Modifier.fillMaxWidth()){
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)){
            RoundedImage(image = painterResource(id = R.drawable.mypict), contentDescription = "Picture Profile", width = 100.dp, height = 100.dp)
            Spacer(modifier = Modifier.width(15.dp))
            StatSection(
                modifier
                    .weight(7f)
                    .fillMaxWidth())
        }
        ProfileDescription(
            displayName = "Front-End Dev & Mobile Dev",
            description = "Almost 3 years of coding\nWant me to make your app? Send me an email!\nFollow to my Github: 👇",
            url = "https://github.com/gedeastu",
            followedBy = listOf("flutterindo","androidcompose","philliplackner"),
            otherCount = 18
        )
    }
}

@Composable
fun RoundedImage(image: Painter, modifier: Modifier=Modifier, contentDescription: String, width: Dp,height: Dp){
    Image(
        painter = image ,
        contentDescription = contentDescription,
        modifier = modifier
            .width(width)
            .height(height)
            .aspectRatio(1f, matchHeightConstraintsFirst = false)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()) {
        ItemStatSection(nummberText = "601", text = "Posts")
        ItemStatSection(nummberText = "99.8K", text = "Followers")
        ItemStatSection(nummberText = "72", text = "Following")
    }
}

@Composable
fun ItemStatSection(modifier: Modifier = Modifier,nummberText: String,text: String){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = nummberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier.height(5.dp))
        Text(
            text = text,
        )
    }
}

@Composable
fun ProfileDescription(displayName : String, description: String, url:String, followedBy : List<String>, otherCount:Int){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 5.dp)) {
        Text(text = displayName, fontWeight = FontWeight.Bold, letterSpacing = letterSpacing, lineHeight = lineHeight)
        Text(text = description, letterSpacing = letterSpacing, lineHeight = lineHeight)
        Text(text = url, color = Color(0xFF3D3D91), letterSpacing = letterSpacing, lineHeight = lineHeight)
        if (followedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by")
                pushStyle(boldStyle)
                followedBy.forEachIndexed{index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < followedBy.size - 1) {
                    append(", ")
                    }
                }
                if (otherCount > 2){
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}