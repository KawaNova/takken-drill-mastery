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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lightbulb
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawanova.takkendrill.data.TakkenCategory
import com.kawanova.takkendrill.ui.components.AdaptiveBannerAd
import com.kawanova.takkendrill.ui.theme.BusinessLawGold
import com.kawanova.takkendrill.ui.theme.CorrectGreen
import com.kawanova.takkendrill.ui.theme.DiagramBackground
import com.kawanova.takkendrill.ui.theme.DiagramBorder
import com.kawanova.takkendrill.ui.theme.ErrorRed
import com.kawanova.takkendrill.ui.theme.GoldDark
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
fun QuizScreen(
    viewModel: TakkenViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isEn = context.resources.configuration.locales[0].language.startsWith("en")

    val uiState by viewModel.uiState.collectAsState()
    val questionList by viewModel.currentQuestionList.collectAsState()
    val bookmarkedIds by viewModel.bookmarkedIds.collectAsState()

    if (questionList.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(SlateBackground),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = if (isEn) "No questions found in this category." else "該当する問題が見つかりません。",
                    color = TextSecondary,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onNavigateBack,
                    colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary)
                ) {
                    Text(text = if (isEn) "Go Back" else "戻る", color = SlateBackground)
                }
            }
        }
        return
    }

    val currentIdx = uiState.currentQuestionIndex.coerceIn(0, questionList.size - 1)
    val question = questionList[currentIdx]
    val isBookmarked = bookmarkedIds.contains(question.id)

    val catColor = when (question.category) {
        TakkenCategory.RIGHTS -> RightsBlue
        TakkenCategory.BUSINESS_LAW -> BusinessLawGold
        TakkenCategory.RESTRICTIONS -> RestrictionsEmerald
        TakkenCategory.TAX_OTHERS -> TaxPurple
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SlateBackground)
    ) {
        // Top Bar
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
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(catColor.copy(alpha = 0.2f))
                    .border(1.dp, catColor.copy(alpha = 0.5f), RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
                Text(
                    text = if (isEn) question.category.titleEn else question.category.titleJa,
                    color = catColor,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${currentIdx + 1} / ${questionList.size}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextSecondary,
                modifier = Modifier.padding(end = 6.dp)
            )
            IconButton(onClick = { viewModel.toggleBookmark(question.id) }) {
                Icon(
                    imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = "Bookmark",
                    tint = if (isBookmarked) Color(0xFFF87171) else TextSecondary
                )
            }
        }

        LinearProgressIndicator(
            progress = { (currentIdx + 1).toFloat() / questionList.size },
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp),
            color = catColor,
            trackColor = SlateSurfaceLight,
        )

        // Question & Content Body
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(14.dp))

                // Question Title & Prompt
                Text(
                    text = if (isEn) question.titleEn else question.titleJa,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = GoldLight
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (isEn) question.questionEn else question.questionJa,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = TextPrimary
                )

                // ASCII Diagram Box (When present)
                if (question.diagramAscii.isNotBlank()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(DiagramBackground)
                            .border(1.dp, DiagramBorder, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Text(
                            text = question.diagramAscii.trim(),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            lineHeight = 15.sp,
                            color = Color(0xFFE2E8F0)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (isEn) "Select the correct option:" else "正しいものを1つ選択してください:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextSecondary
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // 4 Options
            val options = if (isEn) question.optionsEn else question.optionsJa
            items(options.size) { optIdx ->
                val optText = options[optIdx]
                val isSelected = uiState.selectedOptionIndex == optIdx
                val isCorrect = optIdx == question.correctAnswerIndex

                val borderColor = when {
                    uiState.isAnswerChecked && isCorrect -> CorrectGreen
                    uiState.isAnswerChecked && isSelected && !isCorrect -> ErrorRed
                    isSelected -> GoldPrimary
                    else -> SlateBorder
                }

                val bgColor = when {
                    uiState.isAnswerChecked && isCorrect -> CorrectGreen.copy(alpha = 0.15f)
                    uiState.isAnswerChecked && isSelected && !isCorrect -> ErrorRed.copy(alpha = 0.15f)
                    isSelected -> SlateSurfaceLight
                    else -> SlateSurface
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(bgColor)
                        .border(1.5.dp, borderColor, RoundedCornerShape(10.dp))
                        .clickable(enabled = !uiState.isAnswerChecked) {
                            viewModel.selectOption(optIdx)
                        }
                        .padding(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.Top) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(if (isSelected || (uiState.isAnswerChecked && isCorrect)) borderColor else SlateSurfaceLight),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${optIdx + 1}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected || (uiState.isAnswerChecked && isCorrect)) SlateBackground else TextSecondary
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = optText,
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = TextPrimary,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Check Answer Button or Explanation Section
            item {
                Spacer(modifier = Modifier.height(10.dp))

                if (!uiState.isAnswerChecked) {
                    Button(
                        onClick = { viewModel.checkAnswer(question) },
                        enabled = uiState.selectedOptionIndex != null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GoldPrimary,
                            disabledContainerColor = SlateSurfaceLight
                        )
                    ) {
                        Text(
                            text = if (isEn) "CHECK ANSWER" else "解答を確認する",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = if (uiState.selectedOptionIndex != null) SlateBackground else TextMuted
                        )
                    }
                } else {
                    // Result & Explanation Card
                    val isUserCorrect = uiState.selectedOptionIndex == question.correctAnswerIndex
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(SlateSurface)
                            .border(
                                1.5.dp,
                                if (isUserCorrect) CorrectGreen else ErrorRed,
                                RoundedCornerShape(12.dp)
                            )
                            .padding(14.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (isUserCorrect) Icons.Default.CheckCircle else Icons.Default.Close,
                                contentDescription = null,
                                tint = if (isUserCorrect) CorrectGreen else ErrorRed,
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isUserCorrect) {
                                    if (isEn) "Correct! Option ${question.correctAnswerIndex + 1}" else "正解！ 肢${question.correctAnswerIndex + 1}"
                                } else {
                                    if (isEn) "Incorrect. Correct is Option ${question.correctAnswerIndex + 1}" else "不正解... 正解は 肢${question.correctAnswerIndex + 1}"
                                },
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isUserCorrect) CorrectGreen else ErrorRed
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = if (isEn) question.explanationEn else question.explanationJa,
                            fontSize = 13.sp,
                            lineHeight = 20.sp,
                            color = TextPrimary
                        )

                        // Exam Tip Box
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(GoldDark.copy(alpha = 0.2f))
                                .border(1.dp, GoldPrimary.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                                .padding(10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.Top) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = null,
                                    tint = GoldLight,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column {
                                    Text(
                                        text = if (isEn) "Exam Tip" else "⚡ 本試験ひっかけのツボ",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = GoldLight
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = if (isEn) question.examTipEn else question.examTipJa,
                                        fontSize = 12.sp,
                                        lineHeight = 17.sp,
                                        color = Color(0xFFFEF3C7)
                                    )
                                }
                            }
                        }
                    }

                    // Navigation Controls
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { viewModel.previousQuestion() },
                            enabled = currentIdx > 0,
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = SlateSurfaceLight),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = if (isEn) "Prev" else "前へ", fontSize = 13.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Button(
                            onClick = {
                                if (currentIdx < questionList.size - 1) {
                                    viewModel.nextQuestion(questionList.size)
                                } else {
                                    onNavigateBack()
                                }
                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = if (currentIdx < questionList.size - 1) {
                                    if (isEn) "Next" else "次へ"
                                } else {
                                    if (isEn) "Finish" else "完了"
                                },
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = SlateBackground
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = SlateBackground,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        // Bottom Banner Ad
        AdaptiveBannerAd()
    }
}
