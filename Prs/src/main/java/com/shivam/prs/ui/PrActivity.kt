package com.shivam.prs.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.coil.rememberCoilPainter
import com.shivam.base.AppUtils.DateTimeParser
import com.shivam.prs.R
import com.shivam.prs.models.PullRequest
import com.shivam.prs.ui.ui.theme.GithubPrsTheme
import com.shivam.prs.viewmodel.PrViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class PrActivity : ComponentActivity() {

    val prViewModel: PrViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubPrsTheme {
                PrList(viewModel = prViewModel, context = this)
            }
        }
    }
}

@Composable
fun PrList(modifier: Modifier = Modifier, viewModel: PrViewModel, context: Context) {
    UserInfoList(modifier, prList = viewModel.prList, context)
}

@Composable
fun UserInfoList(modifier: Modifier, prList: Flow<PagingData<PullRequest>>, context: Context) {
    val prListItems: LazyPagingItems<PullRequest> = prList.collectAsLazyPagingItems()

    LazyColumn {
        items(prListItems.itemCount) { item ->
            prListItems.getAsState(index = item)?.let {
                it.value?.let { it1 ->
                    PrRequestItem(prData = it1, onClick = {
                        Toast.makeText(context, it1.title.toString(), Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
        prListItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    //You can add modifier to manage load state when first time response page is loading
                }
                loadState.append is LoadState.Loading -> {
                    //You can add modifier to manage load state when next response page is loading
                }
                loadState.append is LoadState.Error -> {
                    //You can use modifier to show error message
                }
            }
        }
    }
}


@Composable
fun PrRequestItem(prData: PullRequest, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(
                bottom = 5.dp, top = 5.dp,
                start = 5.dp, end = 5.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(15.dp),
        elevation = 12.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
        ) {
            Surface(
                modifier = Modifier.size(130.dp),
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colors.surface.copy(
                    alpha = 0.2f
                )
            ) {
                val image = rememberCoilPainter(
                    request = prData.user.avatar_url,
                    fadeIn = true
                )
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colors.surface)
                ) {
                    Text(
                        text = stringResource(R.string.pr_title),
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )

                    Text(
                        text = prData.title.toString(),
                        fontWeight = FontWeight.Light,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colors.surface)
                ) {
                    Text(
                        text = stringResource(R.string.pr_created_date),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )

                    Text(
                        text = DateTimeParser(prData.created_date.toString()),
                        fontWeight = FontWeight.Light,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, , start = 5.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colors.surface)
                ) {
                    Text(
                        text = stringResource(R.string.pr_closed_date),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        text = DateTimeParser(prData.closed_date.toString()),
                        fontWeight = FontWeight.Light,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, , start = 5.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colors.surface)
                ) {
                    Text(
                        text = stringResource(R.string.user_name),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        text = prData.user.name,
                        style = TextStyle(fontSize = 22.sp),
                        fontWeight = FontWeight.Light,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                    )
                }
            }
        }
    }
}



