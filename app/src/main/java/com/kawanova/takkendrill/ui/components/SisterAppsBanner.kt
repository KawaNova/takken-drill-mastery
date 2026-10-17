package com.kawanova.takkendrill.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawanova.takkendrill.ui.theme.GoldPrimary
import com.kawanova.takkendrill.ui.theme.SlateBorder
import com.kawanova.takkendrill.ui.theme.SlateSurface
import com.kawanova.takkendrill.ui.theme.TextPrimary
import com.kawanova.takkendrill.ui.theme.TextSecondary

data class SisterApp(
    val nameJa: String,
    val nameEn: String,
    val descJa: String,
    val descEn: String,
    val icon: String,
    val packageName: String
)

val sisterApps = listOf(
    SisterApp(
        nameJa = "情報セキュリティマネジメント超入門",
        nameEn = "SG Drill",
        descJa = "SG過去問特訓 ＆ セキュリティ早見表",
        descEn = "InfoSec Management Mastery & Cheat Sheet",
        icon = "🛡️",
        packageName = "com.kawanova.sgdrill"
    ),
    SisterApp(
        nameJa = "基本情報技術者 科目A 突破",
        nameEn = "FE Subject A Drill",
        descJa = "新シラバス・全肢詳細解説",
        descEn = "Fundamental Info Tech Exam Prep",
        icon = "🎓",
        packageName = "com.kawanova.fekamokua"
    ),
    SisterApp(
        nameJa = "モバイルAPIテスター",
        nameEn = "API Tester",
        descJa = "スマホで即時REST APIテスト・JSON整形",
        descEn = "Mobile REST Client & JSON Viewer",
        icon = "⚡",
        packageName = "com.kawanova.apitester"
    ),
    SisterApp(
        nameJa = "AWS クラウド超入門",
        nameEn = "AWS Drill",
        descJa = "CLF-C02 突破 ＆ 構成図シミュレータ",
        descEn = "AWS Cloud Practitioner Prep",
        icon = "☁️",
        packageName = "com.kawanova.awsclfdrill"
    ),
    SisterApp(
        nameJa = "日商簿記3級 仕訳ミニドリル",
        nameEn = "Boki Journal 3",
        descJa = "借方・貸方サクサク反復演習",
        descEn = "Bookkeeping Grade 3 Journaling",
        icon = "💼",
        packageName = "com.kawanova.bokijournal"
    )
)

@Composable
fun SisterAppsBanner(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val isEn = context.resources.configuration.locales[0].language.startsWith("en")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SlateSurface)
            .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (isEn) "KawaNova Learning Series" else "KawaNova 資格・学習シリーズ",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = GoldPrimary
            )
            Text(
                text = if (isEn) "Free Study Apps" else "無料学習アプリ",
                fontSize = 11.sp,
                color = TextSecondary
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        sisterApps.forEach { app ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        try {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=${app.packageName}")
                            ).apply {
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            }
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            val webIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=${app.packageName}")
                            ).apply {
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            }
                            context.startActivity(webIntent)
                        }
                    }
                    .padding(vertical = 8.dp, horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = app.icon,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (isEn) app.nameEn else app.nameJa,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary
                    )
                    Text(
                        text = if (isEn) app.descEn else app.descJa,
                        fontSize = 11.sp,
                        color = TextSecondary
                    )
                }
                Text(
                    text = if (isEn) "VIEW" else "確認",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = GoldPrimary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}
