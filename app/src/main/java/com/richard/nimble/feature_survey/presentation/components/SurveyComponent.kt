package com.richard.nimble.feature_survey.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richard.nimble.R
import com.richard.nimble.feature_survey.domain.Survey
import com.richard.nimble.ui.theme.Neuzit
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SurveyComponent(survey: Survey){
    //Get Scrren sice
    val resources = LocalContext.current.resources
    val width = resources.displayMetrics.widthPixels
    Box(
        modifier = Modifier.fillMaxWidth()

    ){
        GlideImage(
            modifier = Modifier
                .fillMaxSize(),
            imageModel = survey.image_url,

            contentScale = ContentScale.FillBounds
        )

        Divider(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            colorResource(id = R.color.grey_black)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),

            verticalArrangement = Arrangement.SpaceBetween

        ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = "Moday, June 15",
                        fontSize = 13.sp,
                        color = Color.White,
                        fontFamily = Neuzit,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.W800,
                        letterSpacing = 0.08.sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Today",
                            fontWeight = FontWeight.W800,
                            fontFamily = Neuzit,
                            color = Color.White,
                            fontSize = 34.sp,
                            lineHeight = 41.sp,
                            letterSpacing = -1.sp
                        )


                        Image(
                            modifier = Modifier
                                .height(38.dp)
                                .width(38.dp),
                            painter = painterResource(id = R.drawable.userpic),
                            contentDescription = stringResource(id = R.string.userPic),
                        )
                    }
                }
            
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = survey.title,
                    fontSize = 28.sp,
                    lineHeight = 34.sp,
                    fontFamily = Neuzit,
                    color = Color.White,
                    fontWeight = FontWeight.W800,
                    letterSpacing = 0.5.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier.width(250.dp),
                        text =  survey.details,
                        color = colorResource(id = R.color.grey_white),
                        fontSize = 17.sp,
                        fontFamily = Neuzit,
                        lineHeight = 22.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )

                    CirculerButton()
                }
            }

        }
    }
}