package com.example.instagramprofileui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileSection(modifier: Modifier=Modifier){
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
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
        ButtonSection(modifier = Modifier.fillMaxWidth())
        HighlightsSection(
            highlights = listOf(
                StoryHighlights(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 20.dp, end = 20.dp)
        )
        PostTabView(
            icons = listOf(
                StoryHighlights(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            ),
            onTabSelected = {selectedTabIndex = it}
        )
        when(selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
//            1 -> PostSection(
//                posts = listOf(
//                    painterResource(id = R.drawable.kmm),
//                    painterResource(id = R.drawable.intermediate_dev),
//                    painterResource(id = R.drawable.master_logical_thinking),
//                    painterResource(id = R.drawable.bad_habits),
//                    painterResource(id = R.drawable.multiple_languages),
//                    painterResource(id = R.drawable.learn_coding_fast),
//                ),
//                modifier = Modifier.fillMaxWidth()
//            )
        }
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
                append("Followed by ")
                pushStyle(boldStyle)
                followedBy.forEachIndexed{index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    //pop()
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

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 35.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.padding(top = 10.dp)
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if(text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightsSection(modifier: Modifier=Modifier,highlights: List<StoryHighlights>){
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundedImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp),
                    contentDescription = "Highlight Stories $it",
                    height = 85.dp,
                    width = 85.dp
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(modifier: Modifier = Modifier,icons : List<StoryHighlights>,onTabSelected:(selectedTabIndex : Int)->Unit){
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val inactive = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        icons.forEachIndexed{index,item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactive,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
            }) {
                Icon(painter = item.image, contentDescription = item.text, tint = if(selectedTabIndex == index) Color.Black else inactive,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp))
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(posts: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}
