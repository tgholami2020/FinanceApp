package com.example.myfinanceapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfinanceapp.ui.theme.*

@Composable
fun ProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(listOf(CustomDarkGray, CustomLightGreen))
        )
        .padding(25.dp),
        verticalArrangement = Arrangement.SpaceBetween        //space equally between all child
    )
    {
        Row(modifier = Modifier.fillMaxWidth(),                        //heading Row
        horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.more), contentDescription = "More",
                tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                    )
            }
            Box(modifier = Modifier                        //a Box to contain an image in left side
                .size(50.dp)
                .border(
                    width = 1.dp,
                    color = CustomOrange,
                    shape = RoundedCornerShape(20f)
                ),
                contentAlignment = Alignment.Center
            ) {                                //add image profile here inside the box
                Image(painter = painterResource(id = R.drawable.david), contentDescription ="profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(5.dp))
                    )
            }

        }
        Column {
            Text(text = "Hello David",
            fontSize = 40.sp,                      //for font use sp
                color= Color.White,
                fontFamily = FontFamily(Font(R.font.ubuntu))  //add your font here by use of font family
                )
            Text(text = "Welcome Back",
                fontSize = 22.sp,                      //for font use sp
                color= Color.White,
                fontFamily = FontFamily(Font(R.font.ubuntu))  //add your font here by use of font family
            )
        }
        //first box
         ProfileInfoCard(
             heading = "Sales",
             subHeading = "total Sales today",
             valueText = "$500",
             percentage = 55,
             color = CustomOrange,
             isIncreasing = true

         )//second box
        ProfileInfoCard(
            heading = "Profit",
            subHeading = "Per day ratio",
            valueText = "$150",
            percentage = 30,
            color = CustomGreen,
            isIncreasing = false

        )//third box
        ProfileInfoCard(
            heading = "Orders",
            subHeading = "Total Order Today",
            valueText = "1258",
            percentage = 80,
            color = CustomCyan,
            isIncreasing = true

        )
        Row(modifier = Modifier.fillMaxWidth(),                        //bottom Row
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription ="Home",
                tint = Color.White,
                    modifier = Modifier.size(30.dp)
                    )
            }
            //sec
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.wallet), contentDescription ="Wallet",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            //third
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.finance), contentDescription ="Finance",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            //forth
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.user), contentDescription ="User",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
@Composable
fun ProfileInfoCard(   //box design
    heading: String,
    subHeading: String,
    valueText: String,
    percentage:Int,
    color: Color,
    isIncreasing: Boolean
){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(30.dp))
        .fillMaxWidth()
        .height(140.dp)
        .background(Color.White.copy(0.1f))
        .padding(
            start = 30.dp,
            top = 10.dp,
            end = 10.dp,
            bottom = 10.dp
        )
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier
                .weight(7f)
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            )
            {//we will have three Text here
                Text(text = heading ,
                fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color=Color.White
                    )
                Text(text = subHeading,
                    fontSize = 12 .sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color=Color.LightGray
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(text = valueText,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color= Color.White
                )
            }
            Box(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
            ) {
                Icon(imageVector = Icons.Default.ArrowForward,
                    contentDescription ="Arrow",
                    tint= color,
                    modifier= Modifier
                        .align(Alignment.TopEnd)

                        .rotate(if (isIncreasing) -45f else 45f )
                    )
                Text(modifier=Modifier.align(Alignment.Center),
                    text = "$percentage%",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color=color
                    )
                Canvas(modifier = Modifier
                    .align(Alignment.Center)
                    .size(70.dp)
                    )
                {
                    drawArc(
                        color= color,
                        startAngle = -120f,
                        sweepAngle = 360 * percentage/100f,
                        useCenter= false,
                        style= Stroke(
                            width= 10f,
                            cap= StrokeCap.Round
                        )
                    )
                }

            }
        }
    }
}
@Preview
@Composable
fun Prev(){
    ProfileScreen()
}
