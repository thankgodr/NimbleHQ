package com.richard.nimble.feature_authentication.presentation.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.richard.nimble.R

@Composable
fun AuthInput(
    placeHolder : String = "Field",
    transformation: VisualTransformation = VisualTransformation.None,
    onValueChange : (String) -> Unit = {},
    values : State<String>,
    iserror : Boolean = false,
    modifier: Modifier = Modifier

){



  OutlinedTextField(
      value = values.value,
      modifier = modifier
          .padding(16.dp)
          .height(56.dp)
          .background(
              colorResource(id = R.color.input_background),
              RoundedCornerShape(12.dp)
          ),
      visualTransformation = transformation,
      onValueChange = {
          onValueChange(it) },
      textStyle = TextStyle(
          color = Color.White,
      ),
      isError = iserror,
      singleLine = true,
      placeholder = {
          Text(
              text = placeHolder,
              color = colorResource(id = R.color.grey_white)
          )
      },
      colors = TextFieldDefaults.outlinedTextFieldColors(
          focusedBorderColor = Color.Transparent,
          unfocusedBorderColor = Color.Transparent)

  )
}