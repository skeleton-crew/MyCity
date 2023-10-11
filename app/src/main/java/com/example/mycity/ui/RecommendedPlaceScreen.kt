package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mycity.R
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceScreen(uiState: MyCityUiState, onClick: () -> Unit, modifier: Modifier = Modifier) {

    Scaffold(bottomBar = { PlaceNavigationAppBar(nextFunction =  onClick ) }) { innerPadding->
        ConstraintLayout(modifier = modifier.padding(innerPadding)) {
            val (image, card) = createRefs()
            Image(painter = painterResource(id = uiState.currentPlace.photo),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    })
            Card(shape = RoundedCornerShape(topEnd = dimensionResource(id = R.dimen.padding_place_card)),
                modifier = Modifier
                    .constrainAs(card) {
                        top.linkTo(image.bottom, margin = (-60).dp)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    }
                    .shadow(
                        dimensionResource(id = R.dimen.shadow_elevation),
                        shape = Shapes.large,
                        ambientColor = Color.Cyan
                    )) {

                Text(
                    text = stringResource(id = uiState.currentPlace.name),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(
                        end = dimensionResource(id = R.dimen.padding_place_card),
                        bottom = dimensionResource(id = R.dimen.padding_small),
                        top = dimensionResource(id = R.dimen.padding_large),
                        start = dimensionResource(id = R.dimen.padding_medium)
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(
                        end = dimensionResource(id = R.dimen.padding_place_card),
                        bottom = dimensionResource(id = R.dimen.padding_large),
                        start = dimensionResource(id = R.dimen.padding_medium)
                    )

                ) {

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.location_icon),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(id = uiState.currentPlace.address),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Text(
                    text = stringResource(id = uiState.currentPlace.description),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(
                            end = dimensionResource(id = R.dimen.padding_large),
                            start = dimensionResource(id = R.dimen.padding_medium)
                        )
                        .verticalScroll(rememberScrollState())
                )

            }
        }

    }

}

@Composable
fun PlaceNavigationAppBar(nextFunction: () -> Unit, modifier: Modifier = Modifier) {
    BottomAppBar {
        Row(horizontalArrangement = Arrangement.End, modifier = modifier.fillMaxWidth()) {
            Button(
                onClick = { nextFunction },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(text = "Next")
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PlaceScreenPreview() {
    MyCityTheme {
        PlaceScreen(uiState = MyCityUiState(), onClick = {}, modifier = Modifier.fillMaxSize())
    }

}