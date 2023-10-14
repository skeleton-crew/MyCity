package com.example.mycity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R


@Composable
fun ExpandedStartScreen(
    viewModel: MyCityViewModel,
    uiState: MyCityUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Card(
            modifier = Modifier
                .weight(1f).fillMaxHeight()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = MaterialTheme.colorScheme.tertiaryContainer
        ) {
            Column {
                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(
                        top = dimensionResource(id = R.dimen.padding_medium),
                        start = dimensionResource(id = R.dimen.padding_large)
                    )
                )
                ExpandedPickCategoryScreen(
                    viewModel = viewModel, uiState = uiState, modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.padding_medium)
                    )
                )
            }

        }
        Card(
            modifier = Modifier
                .weight(1f)
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = MaterialTheme.colorScheme.tertiaryContainer
        ) {
            Column(modifier = Modifier.weight(1f).fillMaxHeight()) {
                ExpandedPickPlaceScreen(
                    viewModel = viewModel,
                    navigateFunction = { },
                    uiState = uiState,
                    modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.padding_medium)
                    )
                )
            }
        }


    }
}

@Preview(
    device = Devices.TABLET,
    showBackground = true
)
@Composable
fun ExpandedStartScreenPreview() {
    ExpandedStartScreen(viewModel = viewModel(), uiState = MyCityUiState())
}
