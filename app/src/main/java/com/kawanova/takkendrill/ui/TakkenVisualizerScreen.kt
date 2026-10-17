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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
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
import com.kawanova.takkendrill.data.VisualizerScenario
import com.kawanova.takkendrill.ui.components.AdaptiveBannerAd
import com.kawanova.takkendrill.ui.theme.BusinessLawGold
import com.kawanova.takkendrill.ui.theme.CorrectGreen
import com.kawanova.takkendrill.ui.theme.DiagramBackground
import com.kawanova.takkendrill.ui.theme.DiagramBorder
import com.kawanova.takkendrill.ui.theme.ErrorRed
import com.kawanova.takkendrill.ui.theme.GoldLight
import com.kawanova.takkendrill.ui.theme.GoldPrimary
import com.kawanova.takkendrill.ui.theme.RightsBlue
import com.kawanova.takkendrill.ui.theme.RoyalSky
import com.kawanova.takkendrill.ui.theme.SlateBackground
import com.kawanova.takkendrill.ui.theme.SlateBorder
import com.kawanova.takkendrill.ui.theme.SlateSurface
import com.kawanova.takkendrill.ui.theme.SlateSurfaceLight
import com.kawanova.takkendrill.ui.theme.TextMuted
import com.kawanova.takkendrill.ui.theme.TextPrimary
import com.kawanova.takkendrill.ui.theme.TextSecondary

@Composable
fun TakkenVisualizerScreen(
    viewModel: TakkenViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isEn = context.resources.configuration.locales[0].language.startsWith("en")

    val uiState by viewModel.uiState.collectAsState()
    val scenarios = VisualizerScenario.entries

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SlateBackground)
    ) {
        // Top Header
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
                text = if (isEn) "Interactive Legal Simulator" else "⚡ 権利関係・業法シミュレータ",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        }

        // Scenario Tabs
        ScrollableTabRow(
            selectedTabIndex = scenarios.indexOf(uiState.selectedScenario),
            containerColor = SlateSurface,
            contentColor = GoldPrimary,
            edgePadding = 12.dp
        ) {
            scenarios.forEachIndexed { idx, scen ->
                val selected = uiState.selectedScenario == scen
                Tab(
                    selected = selected,
                    onClick = { viewModel.selectScenario(scen) },
                    text = {
                        Text(
                            text = if (isEn) scen.titleEn.split(" ")[0] else when (scen) {
                                VisualizerScenario.DOUBLE_SALE -> "二重譲渡と登記"
                                VisualizerScenario.ARTICLE_35_VS_37 -> "35条 vs 37条"
                                VisualizerScenario.COOLING_OFF -> "クーリング・オフ"
                            },
                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                            color = if (selected) GoldPrimary else TextSecondary,
                            fontSize = 12.sp
                        )
                    }
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            item {
                // Scenario Overview Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(SlateSurface)
                        .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
                        .padding(14.dp)
                ) {
                    Column {
                        Text(
                            text = if (isEn) uiState.selectedScenario.titleEn else uiState.selectedScenario.titleJa,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldLight
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = if (isEn) uiState.selectedScenario.descriptionEn else uiState.selectedScenario.descriptionJa,
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = TextSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Interactive Content per Scenario
                when (uiState.selectedScenario) {
                    VisualizerScenario.DOUBLE_SALE -> {
                        DoubleSaleSimulator(
                            step = uiState.simDoubleSaleStep,
                            onStepChange = { viewModel.setSimDoubleSaleStep(it) },
                            isEn = isEn
                        )
                    }
                    VisualizerScenario.ARTICLE_35_VS_37 -> {
                        Article35vs37Simulator(
                            step = uiState.simArticle35Step,
                            onStepChange = { viewModel.setSimArticle35Step(it) },
                            isEn = isEn
                        )
                    }
                    VisualizerScenario.COOLING_OFF -> {
                        CoolingOffSimulator(
                            location = uiState.simCoolingOffLocation,
                            onLocationChange = { viewModel.setSimCoolingOffLocation(it) },
                            isEn = isEn
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        // Bottom AdMob Banner
        AdaptiveBannerAd()
    }
}

@Composable
fun DoubleSaleSimulator(
    step: Int,
    onStepChange: (Int) -> Unit,
    isEn: Boolean
) {
    val steps = if (isEn) {
        listOf(
            "1. A sells land to B (No Deed)",
            "2. A double-sells to C",
            "3. C registers (Simple Bad Faith)",
            "4. C is Malicious Bad Faith",
            "5. Bona fide Transferee D appears"
        )
    } else {
        listOf(
            "① AがBに土地を売却 (B登記なし)",
            "② Aが同一土地をCに二重譲渡",
            "③ Cが先に登記完了 (単なる悪意者)",
            "④ Cが「背信的悪意者」だった場合",
            "⑤ 悪意Cから善意のDが買い受けた場合"
        )
    }

    val asciiDiagram = when (step) {
        0 -> """
[売主 A] ──(第1売買)──> [第1買主 B]
 (所有者)                 (引渡しを受けたが登記はまだ未了)
"""
        1 -> """
         ┌──(第1売買)──> [第1買主 B] (登記なし)
[売主 A] │
         └──(第2売買)──> [第2買主 C] (二重譲渡発生！)
"""
        2 -> """
         ┌──(登記なし)──> [第1買主 B] ───【✕ 敗訴！】
[売主 A] │
         └──(登記完了)──> [第2買主 C] ───【○ 勝訴！(完全所有権取得)】
  ★Cが「Bの買受けを知っていた(単なる悪意者)」でも、登記があればCが勝ち！
"""
        3 -> """
         ┌──(登記なし)──> [第1買主 B] ───【○ 勝訴！(登記なくして勝てる！)】
[売主 A] │
         └──(登記完了)──> [背信的悪意者 C] ─【✕ 敗訴！(登記の保護なし)】
  ★Cが「Bを害する目的等の背信的悪意者」の場合、Bは登記なくしてCに対抗可能！
"""
        else -> """
         ┌──(登記なし)──> [第1買主 B] ───【✕ 敗訴！】
[売主 A] │
         └──(背信悪意)──> [ C ] ───(転売)──> [善意の転得者 D] (登記済)
                                             【○ 勝訴！】
  ★背信的悪意者Cから買ったDが「善意(事情を知らない)」なら、登記があればBに勝つ！
"""
    }

    val explanation = when (step) {
        0 -> if (isEn) "A sold land to B. B has valid contract rights, but has not yet registered the deed." else "AがBに甲土地を売却しました。Bは契約上有効に所有権を取得しますが、第三者に対抗するための登記はまだしていません。"
        1 -> if (isEn) "A double-sells to C. Under Japanese Civil Code, ownership transfer is valid with consent, creating competing rights between B and C." else "売主Aが同一の甲土地をCにも二重に売却しました。BとCは互いに対抗関係（登記の早い者勝ち）となります。"
        2 -> if (isEn) "C registers first. Even if C knew about the prior sale to B (simple bad faith), C prevails because registration decides priority." else "Cが先に登記を備えました。CがBへの先行売買を知っていた（単なる悪意）としても、登記を先に取ったCが確定的に勝ちます！"
        3 -> if (isEn) "C acted maliciously (intent to harm B). The Supreme Court holds C cannot rely on lack of B's deed; B wins even without deed!" else "CがBを高値で脅迫する目的など「背信的悪意者」である場合、Cは登記の欠缺を主張する正当な利益を欠くため、Bは【登記なくして】Cに勝てます！"
        else -> if (isEn) "D buys from malicious C in good faith. If D registers, D is fully protected and prevails over unregistered B!" else "背信的悪意者Cからの転得者Dが「善意（実質的背信性なし）」である場合、Dは自ら登記を備えることで、登記のないBに勝訴できます！"
    }

    Column {
        Text(
            text = if (isEn) "Simulation Step:" else "シミュレーションステップ:",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Step buttons
        steps.forEachIndexed { idx, label ->
            val isCurrent = step == idx
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (isCurrent) RightsBlue.copy(alpha = 0.2f) else SlateSurface)
                    .border(1.dp, if (isCurrent) RightsBlue else SlateBorder, RoundedCornerShape(8.dp))
                    .clickable { onStepChange(idx) }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(if (isCurrent) RightsBlue else SlateSurfaceLight),
                    contentAlignment = Alignment.Center
                ) {
                    if (isCurrent) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = SlateBackground, modifier = Modifier.size(12.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = label,
                    fontSize = 12.sp,
                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                    color = if (isCurrent) TextPrimary else TextSecondary
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Diagram Result Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(DiagramBackground)
                .border(1.dp, DiagramBorder, RoundedCornerShape(10.dp))
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = asciiDiagram.trim(),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    lineHeight = 15.sp,
                    color = Color(0xFFE2E8F0)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = explanation,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    color = GoldLight
                )
            }
        }
    }
}

@Composable
fun Article35vs37Simulator(
    step: Int,
    onStepChange: (Int) -> Unit,
    isEn: Boolean
) {
    val tabs = if (isEn) listOf("Timing & Agent", "Price & Terms", "Broker-to-Broker") else listOf("① 交付時期と説明主体", "② 代金の額と契約条件", "③ 業者間取引 (プロ同士)")

    Column {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            tabs.forEachIndexed { idx, title ->
                val isSelected = step == idx
                Button(
                    onClick = { onStepChange(idx) },
                    modifier = Modifier.weight(1f).height(38.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) BusinessLawGold else SlateSurfaceLight
                    )
                ) {
                    Text(
                        text = title,
                        fontSize = 10.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) SlateBackground else TextSecondary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        val contentText = when (step) {
            0 -> """
【35条 (重要事項説明書)】
  ・時期: 【契約が成立する前】 (手付金支払や調印の前)
  ・相手: 買主・借主のみ (権利を取得しようとする者)
  ・主体: 【宅地建物取引士】が【宅建士証を提示】して口頭説明
  
【37条 (契約成立書面)】
  ・時期: 契約成立後【遅滞なく】交付
  ・相手: 売買の【双方】 (売主・買主・貸主・借主)
  ・主体: 宅建士の【記名】が必要。★口頭説明は「一切不要」！
"""
            1 -> """
【代金の額・支払時期・方法の記載】
  ・35条 (重説): ★記載不要！(代金そのものは条件交渉中であり得るため不要。実費・交換差金・借賃額は必要)
  ・37条 (契約書): ★必要的記載事項！(代金の額、支払日、支払方法は必ず記載)
  
【契約不適合責任・解除特約】
  ・35条: 定めがあるときはその内容を説明
  ・37条: 定めがあるときは必ず記載
"""
            else -> """
【宅建業者間の取引 (プロ同士の売買)】
  ・35条 (重説): 書面の【交付】は必要！★【説明】のみ省略可能！
  ・37条 (契約書): 書面の【交付】は【省略不可】！必ず双方に交付！
  
  ★ひっかけの急所: 「業者間だから35条書面を交付しなかった」➔ 業法違反！
  「説明」を省けるだけで、書面自体の作成・交付は免除されません。
"""
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(DiagramBackground)
                .border(1.dp, DiagramBorder, RoundedCornerShape(10.dp))
                .padding(12.dp)
        ) {
            Text(
                text = contentText.trim(),
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Color(0xFFE2E8F0)
            )
        }
    }
}

@Composable
fun CoolingOffSimulator(
    location: Int,
    onLocationChange: (Int) -> Unit,
    isEn: Boolean
) {
    val locations = if (isEn) {
        listOf(
            "Hotel Lobby / Cafe",
            "Broker's Office",
            "Buyer's Home (Requested by Buyer)",
            "Buyer's Home (Unsolicited Visit)"
        )
    } else {
        listOf(
            "① ホテルのロビー / 喫茶店",
            "② 宅建業者の事務所・常設モデルルーム",
            "③ 買主自ら申し出た「買主の自宅・勤務先」",
            "④ 業者都合で訪問された「買主の自宅」"
        )
    }

    val (canCancel, verdictTitle, verdictDesc) = when (location) {
        0 -> Triple(
            true,
            if (isEn) "COOLING-OFF PERMITTED" else "○ クーリング・オフ可能！",
            if (isEn) "Outside broker premises without buyer's unilateral formal request. 8-day cancel window applies." else "事務所等以外の場所での買受け申込みに該当するため、書面告知から8日以内であれば契約解除可能！"
        )
        1 -> Triple(
            false,
            if (isEn) "COOLING-OFF NOT PERMITTED" else "✕ クーリング・オフ不可！",
            if (isEn) "Broker's registered office or staffed booth with full-time agent is exempt from cooling-off." else "業者の本店・支店や専任取引士のいる案内所は「冷静に判断できる場所」とされるため、クーリング・オフは一切できません。"
        )
        2 -> Triple(
            false,
            if (isEn) "COOLING-OFF NOT PERMITTED" else "✕ クーリング・オフ不可！",
            if (isEn) "When the buyer unilaterally requested meeting at home or office, buyer is deemed prepared." else "買主自らが「自宅で話を聞きたい」「勤務先に来てほしい」と申し出た場合、不意打ちではないためクーリング・オフ適用除外となります！"
        )
        else -> Triple(
            true,
            if (isEn) "COOLING-OFF PERMITTED" else "○ クーリング・オフ可能！",
            if (isEn) "Unsolicited cold visit to home is treated as non-office solicitation; cancellation valid." else "買主の希望ではなく業者の都合・訪問販売で自宅に来た場合、事務所等以外の場所とみなされクーリング・オフが可能です！"
        )
    }

    Column {
        Text(
            text = if (isEn) "Select Offer Location:" else "買受けの申込み場所を選択:",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(8.dp))

        locations.forEachIndexed { idx, label ->
            val isSelected = location == idx
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (isSelected) SlateSurfaceLight else SlateSurface)
                    .border(1.dp, if (isSelected) GoldPrimary else SlateBorder, RoundedCornerShape(8.dp))
                    .clickable { onLocationChange(idx) }
                    .padding(horizontal = 12.dp, vertical = 9.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) GoldPrimary else SlateBorder)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = label,
                    fontSize = 12.sp,
                    color = if (isSelected) TextPrimary else TextSecondary,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Verdict Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(if (canCancel) CorrectGreen.copy(alpha = 0.15f) else ErrorRed.copy(alpha = 0.15f))
                .border(1.5.dp, if (canCancel) CorrectGreen else ErrorRed, RoundedCornerShape(10.dp))
                .padding(14.dp)
        ) {
            Column {
                Text(
                    text = verdictTitle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (canCancel) CorrectGreen else ErrorRed
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = verdictDesc,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = TextPrimary
                )
            }
        }
    }
}
