package com.kawanova.takkendrill.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawanova.takkendrill.data.TakkenCategory
import com.kawanova.takkendrill.data.TakkenCheatItem
import com.kawanova.takkendrill.ui.components.AdaptiveBannerAd
import com.kawanova.takkendrill.ui.theme.BusinessLawGold
import com.kawanova.takkendrill.ui.theme.GoldLight
import com.kawanova.takkendrill.ui.theme.GoldPrimary
import com.kawanova.takkendrill.ui.theme.RestrictionsEmerald
import com.kawanova.takkendrill.ui.theme.RightsBlue
import com.kawanova.takkendrill.ui.theme.SlateBackground
import com.kawanova.takkendrill.ui.theme.SlateBorder
import com.kawanova.takkendrill.ui.theme.SlateSurface
import com.kawanova.takkendrill.ui.theme.SlateSurfaceLight
import com.kawanova.takkendrill.ui.theme.TaxPurple
import com.kawanova.takkendrill.ui.theme.TextMuted
import com.kawanova.takkendrill.ui.theme.TextPrimary
import com.kawanova.takkendrill.ui.theme.TextSecondary

@Composable
fun TakkenCheatScreen(
    viewModel: TakkenViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isEn = context.resources.configuration.locales[0].language.startsWith("en")

    val uiState by viewModel.uiState.collectAsState()
    var selectedCat by remember { mutableStateOf<TakkenCategory?>(null) }

    val filteredItems = viewModel.allCheatItems.filter { item ->
        val matchCat = selectedCat == null || item.category == selectedCat
        val matchQuery = if (uiState.searchCheatQuery.isBlank()) true else {
            val q = uiState.searchCheatQuery.lowercase()
            item.topicJa.lowercase().contains(q) ||
                    item.topicEn.lowercase().contains(q) ||
                    item.summaryJa.lowercase().contains(q) ||
                    item.summaryEn.lowercase().contains(q) ||
                    item.keyPointsJa.any { it.lowercase().contains(q) } ||
                    item.keyPointsEn.any { it.lowercase().contains(q) }
        }
        matchCat && matchQuery
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SlateBackground)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp)
        ) {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = TextPrimary
                )
            }
            Text(
                text = if (isEn) "Takken Exam Cheat Sheet (24 Items)" else "📋 宅建必須数値・要件早見表 (24選)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        }

        // Search Bar
        OutlinedTextField(
            value = uiState.searchCheatQuery,
            onValueChange = { viewModel.setSearchCheatQuery(it) },
            placeholder = {
                Text(
                    text = if (isEn) "Search formula, dates, articles..." else "速算式、35条、クーリングオフ、面積等を検索...",
                    fontSize = 12.sp,
                    color = TextMuted
                )
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = TextSecondary, modifier = Modifier.size(18.dp))
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = SlateSurface,
                unfocusedContainerColor = SlateSurface,
                focusedBorderColor = GoldPrimary,
                unfocusedBorderColor = SlateBorder,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            )
        )

        // Category Filter Pills
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FilterPill(
                    label = if (isEn) "ALL" else "すべて",
                    isSelected = selectedCat == null,
                    color = GoldPrimary,
                    onClick = { selectedCat = null }
                )
            }
            items(TakkenCategory.entries.size) { idx ->
                val cat = TakkenCategory.entries[idx]
                val color = when (cat) {
                    TakkenCategory.RIGHTS -> RightsBlue
                    TakkenCategory.BUSINESS_LAW -> BusinessLawGold
                    TakkenCategory.RESTRICTIONS -> RestrictionsEmerald
                    TakkenCategory.TAX_OTHERS -> TaxPurple
                }
                FilterPill(
                    label = if (isEn) cat.titleEn.split(" ")[0] else when (cat) {
                        TakkenCategory.RIGHTS -> "権利関係"
                        TakkenCategory.BUSINESS_LAW -> "宅建業法"
                        TakkenCategory.RESTRICTIONS -> "法令制限"
                        TakkenCategory.TAX_OTHERS -> "税・その他"
                    },
                    isSelected = selectedCat == cat,
                    color = color,
                    onClick = { selectedCat = cat }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Cheat List
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(filteredItems.size) { index ->
                val item = filteredItems[index]
                CheatCard(item = item, isEn = isEn, context = context)
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        // Bottom AdMob Banner
        AdaptiveBannerAd()
    }
}

@Composable
fun FilterPill(
    label: String,
    isSelected: Boolean,
    color: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) color.copy(alpha = 0.25f) else SlateSurface)
            .border(1.dp, if (isSelected) color else SlateBorder, RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) color else TextSecondary
        )
    }
}

@Composable
fun CheatCard(
    item: TakkenCheatItem,
    isEn: Boolean,
    context: Context
) {
    val catColor = when (item.category) {
        TakkenCategory.RIGHTS -> RightsBlue
        TakkenCategory.BUSINESS_LAW -> BusinessLawGold
        TakkenCategory.RESTRICTIONS -> RestrictionsEmerald
        TakkenCategory.TAX_OTHERS -> TaxPurple
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SlateSurface)
            .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(catColor)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isEn) item.topicEn else item.topicJa,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }
                IconButton(
                    onClick = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("Takken Cheat", item.copyableText)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, if (isEn) "Copied to clipboard!" else "要点をコピーしました！", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "Copy",
                        tint = GoldPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = if (isEn) item.summaryEn else item.summaryJa,
                fontSize = 12.sp,
                color = GoldLight
            )

            Spacer(modifier = Modifier.height(10.dp))

            val points = if (isEn) item.keyPointsEn else item.keyPointsJa
            points.forEach { pt ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(text = "•", color = catColor, fontSize = 12.sp, modifier = Modifier.padding(end = 6.dp))
                    Text(text = pt, color = TextSecondary, fontSize = 12.sp, lineHeight = 17.sp)
                }
            }
        }
    }
}
