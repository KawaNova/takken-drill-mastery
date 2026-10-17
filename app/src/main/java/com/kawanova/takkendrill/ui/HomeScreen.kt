package com.kawanova.takkendrill.ui

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawanova.takkendrill.data.TakkenCategory
import com.kawanova.takkendrill.ui.components.AdaptiveBannerAd
import com.kawanova.takkendrill.ui.components.SisterAppsBanner
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
fun HomeScreen(
    viewModel: TakkenViewModel,
    onNavigateToQuiz: () -> Unit,
    onNavigateToVisualizer: () -> Unit,
    onNavigateToCheatSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isEn = context.resources.configuration.locales[0].language.startsWith("en")

    val answeredIds by viewModel.answeredIds.collectAsState()
    val correctIds by viewModel.correctIds.collectAsState()
    val bookmarkedIds by viewModel.bookmarkedIds.collectAsState()

    val totalCount = viewModel.allQuestions.size
    val answeredCount = answeredIds.size
    val correctCount = correctIds.size
    val accuracy = if (answeredCount > 0) (correctCount * 100 / answeredCount) else 0

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SlateBackground)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                // App Header with Badge
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(GoldPrimary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🏡", fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isEn) "Takken Drill Mastery" else "宅建士 突破特訓ドリル",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = if (isEn) "Real Estate License Exam Prep" else "権利関係・宅建業法・法令・税 厳選30問",
                            fontSize = 12.sp,
                            color = GoldLight
                        )
                    }
                    IconButton(onClick = { viewModel.resetProgress() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Reset Progress",
                            tint = TextMuted
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Overall Progress Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(SlateSurface)
                        .border(1.dp, SlateBorder, RoundedCornerShape(14.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = if (isEn) "Mastery Progress" else "全体習得ステータス",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = TextSecondary
                            )
                            Text(
                                text = "$correctCount / $totalCount 問達成 (${(correctCount * 100 / totalCount)}%)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = GoldPrimary
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        LinearProgressIndicator(
                            progress = { correctCount.toFloat() / totalCount },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = GoldPrimary,
                            trackColor = SlateSurfaceLight,
                        )

                        Spacer(modifier = Modifier.height(14.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            MetricItem(
                                label = if (isEn) "Answered" else "解答済み",
                                value = "$answeredCount 問",
                                color = TextPrimary
                            )
                            MetricItem(
                                label = if (isEn) "Accuracy" else "正答率",
                                value = "$accuracy%",
                                color = if (accuracy >= 80) GoldLight else TextPrimary
                            )
                            MetricItem(
                                label = if (isEn) "Bookmarks" else "要復習",
                                value = "${bookmarkedIds.size} 件",
                                color = if (bookmarkedIds.isNotEmpty()) Color(0xFFF87171) else TextSecondary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Primary Action Button (Start All / Bookmark Review)
                Button(
                    onClick = {
                        viewModel.selectCategory(null)
                        onNavigateToQuiz()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = SlateBackground,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isEn) "Start Full Exam Drill (30 Qs)" else "⚡ 全30問 総仕上げ特訓を開始",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = SlateBackground
                    )
                }

                if (bookmarkedIds.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            viewModel.setBookmarkedOnly(true)
                            onNavigateToQuiz()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = SlateSurfaceLight)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = null,
                            tint = Color(0xFFF87171),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isEn) "Review Bookmarks (${bookmarkedIds.size})" else "🔖 ブックマークした苦手問題を復習 (${bookmarkedIds.size}問)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextPrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Section 1: Study Tools (Simulator & Cheat Sheet)
                Text(
                    text = if (isEn) "Interactive Tools" else "🛠️ 実務・合格キラーツール",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ToolCard(
                        icon = Icons.Default.Visibility,
                        title = if (isEn) "Visualizer" else "権利・業法図解",
                        subtitle = if (isEn) "Interactive Sim" else "二重譲渡/35条vs37条",
                        color = RightsBlue,
                        onClick = onNavigateToVisualizer,
                        modifier = Modifier.weight(1f)
                    )
                    ToolCard(
                        icon = Icons.Default.TableChart,
                        title = if (isEn) "Cheat Sheet" else "必須早見表",
                        subtitle = if (isEn) "24 Quick Rules" else "報酬速算/面積24選",
                        color = BusinessLawGold,
                        onClick = onNavigateToCheatSheet,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Section 2: 4 Main Examination Categories
                Text(
                    text = if (isEn) "Exam Domains (4 Categories)" else "📚 出題分野別特訓 (4大科目)",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Category Cards
            items(TakkenCategory.entries.size) { index ->
                val cat = TakkenCategory.entries[index]
                val catQuestions = viewModel.allQuestions.filter { it.category == cat }
                val catCorrectCount = catQuestions.count { correctIds.contains(it.id) }

                CategoryCard(
                    category = cat,
                    totalInCat = catQuestions.size,
                    correctInCat = catCorrectCount,
                    isEn = isEn,
                    onClick = {
                        viewModel.selectCategory(cat)
                        onNavigateToQuiz()
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                SisterAppsBanner()
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        // Persistent Bottom AdMob Banner
        AdaptiveBannerAd()
    }
}

@Composable
fun MetricItem(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 11.sp, color = TextSecondary)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = value, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = color)
    }
}

@Composable
fun ToolCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(SlateSurface)
            .border(1.dp, color.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(14.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(color.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = TextSecondary
            )
        }
    }
}

@Composable
fun CategoryCard(
    category: TakkenCategory,
    totalInCat: Int,
    correctInCat: Int,
    isEn: Boolean,
    onClick: () -> Unit
) {
    val catColor = when (category) {
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
            .clickable(onClick = onClick)
            .padding(14.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(catColor)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (isEn) category.titleEn else category.titleJa,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "$correctInCat / $totalInCat 問",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (correctInCat == totalInCat && totalInCat > 0) catColor else TextSecondary
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                LinearProgressIndicator(
                    progress = { if (totalInCat > 0) correctInCat.toFloat() / totalInCat else 0f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = catColor,
                    trackColor = SlateSurfaceLight,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isEn) "Est. Exam Weight: ${category.questionCountEstimate} Qs" else "本試験目安: 約${category.questionCountEstimate}問配点",
                    fontSize = 10.sp,
                    color = TextMuted
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = TextSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
