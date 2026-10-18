package com.example.questtugasuserinput_0197

import android.app.DatePickerDialog
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar

@Composable
fun FormBiodata(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }

    var androidSkill by remember { mutableStateOf(false) }
    var uiuxSkill by remember { mutableStateOf(false) }
    var webSkill by remember { mutableStateOf(false) }

    var menuPengalaman by remember { mutableStateOf(false) }
    var tampilHasil by remember { mutableStateOf(false) }
    var errorEmail by remember { mutableStateOf(false) }

    val purple = colorResource(R.color.purple_primary)
    val white = colorResource(R.color.white)
    val textDark = colorResource(R.color.text_dark)
    val textGray = colorResource(R.color.text_gray)
    val borderGray = colorResource(R.color.border_gray)

    val skills = mutableListOf<String>()

    if (androidSkill) {
        skills.add("Android")
    }

    if (uiuxSkill) {
        skills.add("UI/UX")
    }

    if (webSkill) {
        skills.add("Web")
    }

    val emailValid = Patterns.EMAIL_ADDRESS
        .matcher(email.trim())
        .matches()

    val formValid =
        namaDepan.isNotBlank() &&
                namaBelakang.isNotBlank() &&
                emailValid &&
                tanggalLahir.isNotBlank() &&
                pengalaman.isNotBlank() &&
                skills.isNotEmpty()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.purple_light)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.spiderman),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        dimensionResource(R.dimen.header_height)
                    )
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.88f)
                    .padding(horizontal = dimensionResource(R.dimen.padding_small))
                    .padding(
                        top = dimensionResource(R.dimen.card_top_padding)
                    )
                    .align(Alignment.TopCenter),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.card_corner_radius),
                    topEnd = dimensionResource(R.dimen.card_corner_radius)
                ),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = white
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = dimensionResource(R.dimen.elevation_card)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            horizontal = dimensionResource(R.dimen.padding_form)
                        )
                        .padding(
                            top = dimensionResource(R.dimen.spacing_large),
                            bottom = dimensionResource(R.dimen.spacing_large)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.form_title),
                        fontSize = dimensionResource(R.dimen.title_size).value.sp,
                        fontWeight = FontWeight.Bold,
                        color = purple
                    )

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.spacing_small)
                        )
                    )
                    Text(
                        text = stringResource(R.string.form_subtitle),
                        fontSize = dimensionResource(R.dimen.subtitle_size).value.sp,
                        color = textGray
                    )

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.spacing_large)
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.padding_small)
                        )
                    ) {

                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = {
                                namaDepan = it
                                tampilHasil = false
                            },
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.corner_radius)
                            ),
                            label = {
                                Text(stringResource(R.string.first_name))
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = purple,
                                unfocusedBorderColor = borderGray
                            )
                        )
                }
            }
        }


