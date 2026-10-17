package com.kawanova.takkendrill.data

import kotlinx.serialization.Serializable

/**
 * 宅建試験の4大出題分野
 */
enum class TakkenCategory(
    val code: String,
    val titleJa: String,
    val titleEn: String,
    val questionCountEstimate: Int, // 本試験配点目安 (計50問)
    val colorHex: Long
) {
    RIGHTS(
        code = "RIGHTS",
        titleJa = "権利関係 (民法・借地借家法等)",
        titleEn = "Civil Law & Rights",
        questionCountEstimate = 14,
        colorHex = 0xFF3B82F6 // Blue
    ),
    BUSINESS_LAW(
        code = "BUSINESS_LAW",
        titleJa = "宅建業法 (免許・重説・37条・8種制限)",
        titleEn = "Real Estate Business Act",
        questionCountEstimate = 20,
        colorHex = 0xFFF59E0B // Amber Gold
    ),
    RESTRICTIONS(
        code = "RESTRICTIONS",
        titleJa = "法令上の制限 (都市計画・建基法等)",
        titleEn = "Legal Restrictions (Zoning & Codes)",
        questionCountEstimate = 8,
        colorHex = 0xFF10B981 // Emerald
    ),
    TAX_OTHERS(
        code = "TAX_OTHERS",
        titleJa = "税・その他 (不動産取得税・機構等)",
        titleEn = "Taxes & Appraisal / Finance",
        questionCountEstimate = 8,
        colorHex = 0xFF8B5CF6 // Purple
    )
}

/**
 * 宅建士 演習クイズ設問データモデル
 */
@Serializable
data class TakkenQuestion(
    val id: Int,
    val category: TakkenCategory,
    val titleJa: String,
    val titleEn: String,
    val questionJa: String,
    val questionEn: String,
    val diagramAscii: String,
    val optionsJa: List<String>,
    val optionsEn: List<String>,
    val correctAnswerIndex: Int, // 0-based
    val explanationJa: String,
    val explanationEn: String,
    val examTipJa: String,
    val examTipEn: String
)

/**
 * 早見表（チートシート）項目
 */
@Serializable
data class TakkenCheatItem(
    val id: Int,
    val category: TakkenCategory,
    val topicJa: String,
    val topicEn: String,
    val summaryJa: String,
    val summaryEn: String,
    val keyPointsJa: List<String>,
    val keyPointsEn: List<String>,
    val copyableText: String
)

/**
 * インタラクティブ図解シミュレータのシナリオ
 */
enum class VisualizerScenario(
    val titleJa: String,
    val titleEn: String,
    val descriptionJa: String,
    val descriptionEn: String
) {
    DOUBLE_SALE(
        titleJa = "二重譲渡と背信的悪意者 (登記の対抗関係)",
        titleEn = "Double Sale & Bad Faith (Title Registration)",
        descriptionJa = "AがBとCに同一不動産を売却した場合、原則として先に登記を備えた方が勝つ。ただし背信的悪意者には登記なくして対抗できる。",
        descriptionEn = "When A sells the same real estate to B and C, the one who registers first generally prevails, unless one party is in malicious bad faith."
    ),
    ARTICLE_35_VS_37(
        titleJa = "重要事項説明 (35条) vs 契約書面 (37条)",
        titleEn = "Article 35 (Statement) vs Article 37 (Contract)",
        descriptionJa = "35条書面は「契約成立前」に「宅建士が説明」。37条書面は「契約成立後遅滞なく」「宅建士が記名（説明不要）」で交付する。",
        descriptionEn = "Article 35 disclosure must be explained by a licensed agent BEFORE contract formation. Article 37 contract is delivered promptly AFTER formation (signed only)."
    ),
    COOLING_OFF(
        titleJa = "自ら売主8種制限：クーリング・オフの成立可否",
        titleEn = "Cooling-Off Period & Location Rules",
        descriptionJa = "宅建業者が自ら売主となり、買主が一般人の場合、事務所等「以外」の場所で買受申込みをした時に限り8日以内の書面/電磁的解除が可能。",
        descriptionEn = "Cooling-off applies only when the seller is a broker and buyer is non-broker, contracted outside formal branch offices, within 8 days."
    )
}
