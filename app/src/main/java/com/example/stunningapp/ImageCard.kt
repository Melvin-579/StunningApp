package com.example.stunningapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.ui.Alignment
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random
@Composable
@ExperimentalLayoutApi
fun ImageCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier

) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Image(
            painter = painterResource(id = R.drawable.neo),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                Modifier
                    .fillMaxWidth(1f)
                    .wrapContentHeight(align = Alignment.Top),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                maxItemsInEachRow = 3
            ) {
                repeat(10) {
                    Box(
                        Modifier
                            .align(Alignment.CenterVertically)
                            .width(50.dp)
                            .height(50.dp)
                            .background(Color.Green)
                    ) {
                       AssistChip(
                           onClick = { },
                           colors = AssistChipDefaults.assistChipColors(
                               leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                           ),
                           leadingIcon = {
                               Icon(
                                   imageVector = Icons.Outlined.FavoriteBorder,
                                   contentDescription = null
                               )
                           },
                           label = {
                               Text(text = "Mark as favorite")
                           }
                       )
                        AssistChip(
                            onClick = { },
                            colors = AssistChipDefaults.assistChipColors(
                                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.FavoriteBorder,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(text = "Share with others")
                            }
                        )
                    }
                }
            }

        }
    }
}

@Composable
@ExperimentalLayoutApi
inline fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    maxItemsInEachRow: Int = Int.MAX_VALUE,
    content: @Composable FlowRowScope.() -> Unit
): Unit{}