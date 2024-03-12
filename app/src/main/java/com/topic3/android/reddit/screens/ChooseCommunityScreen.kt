package com.topic3.android.reddit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.topic3.android.reddit.R
import com.topic3.android.reddit.routing.RedditRouter
import com.topic3.android.reddit.viewmodel.MainViewModel

private const val SEARCH_DELAY_MILLIS = 300L

private val defaultCommunities = listOf("raywenderlich", "androiddev", "puppies")

@Composable
fun ChooseCommunityScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    //TODO Add your code here
}

@Composable
fun SearchedCommunities(
    communities: List<String>,
    viewModel: MainViewModel?,
    modifier: Modifier = Modifier
) {
    communities.forEach{ Community(
        text = it,
        modifier = modifier,
        onCommunityClicked = {
            viewModel?.selectedCommunity?.postValue(it)
            RedditRouter.goBack()
        }
    )
    }
}

@Composable
fun ChooseCommunityTopBar(modifier: Modifier = Modifier) {

    val colors = MaterialTheme.colors

    TopAppBar(
        title = {
            Text(
                fontSize = 16.sp,
                text = stringResource(R.string.choose_community),
                color = colors.primaryVariant
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { RedditRouter.goBack() }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    tint = colors.primaryVariant,
                    contentDescription = stringResource(id = R.string.close)
                )
            }
        },
        backgroundColor = colors.primary,
        elevation = 0.dp,
        modifier = modifier
            .height(48.dp)
            .background(Color.Blue)
    )
}