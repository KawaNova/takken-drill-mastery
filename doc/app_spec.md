# 宅建士 突破特訓 (Takken Drill) アプリ仕様書

## 1. 概要
- **アプリ名 (日本語)**: 宅建士 突破特訓 (権利関係・宅建業法 過去問対策ドリル)
- **アプリ名 (英語)**: Takken Drill - Real Estate License Mastery
- **パッケージ名**: `com.kawanova.takkendrill`
- **対象プラットフォーム**: Android (minSdk 24, targetSdk 36)
- **開発言語**: Kotlin 2.0.21
- **UIフレームワーク**: Jetpack Compose (Material3)
- **ターゲットユーザー**:
  - 宅地建物取引士（宅建士）国家試験の合格を目指す受験生（年間約20万人規模）
  - 不動産業界・金融・建設・信託銀行の実務従事者、新入社員、就活生
  - 独学で法律（民法・借地借家法・都市計画法等）をマスターしたい社会人・初学者

---

## 2. コア機能要件

### 2.1 頻出厳選30問 一問一答クイズ
- **出題4大科目**:
  1. 権利関係 (民法・借地借家法・不動産登記法): 8問 (配点目安約14点)
  2. 宅建業法 (免許・重説・37条書面・8種制限等): 12問 (配点目安約20点・満点必須科目)
  3. 法令上の制限 (都市計画法・建築基準法・国土法・農地法): 6問 (配点目安約8点)
  4. 税・その他 (取得税・固定資産税・印紙税・機構・景表法): 4問 (配点目安約8点)
- **全問ASCII当事者関係図**: A・B・Cの二重譲渡、抵当権、無権代理などをクリアに図解
- **全肢詳細解説**: 正解肢のみならず誤答肢の理由・根拠法令を明記
- **⚡ 本試験ひっかけのツボ (Exam Tip)**: 試験委員が仕掛けるトラップを全問で徹底解説

### 2.2 ⚡ インタラクティブ権利関係・業法シミュレータ
1. **二重譲渡と登記 (DOUBLE_SALE)**:
   - ステップ実行による勝敗判定（AからB売却 ➔ AからC二重譲渡 ➔ C単なる悪意者で登記 ➔ C背信的悪意者 ➔ 善意転得者D）
2. **重要事項説明 (35条) vs 契約書面 (37条) (ARTICLE_35_VS_37)**:
   - 交付時期・交付相手・取引士口頭説明の要否・代金記載の有無・業者間取引の特例をインタラクティブ対比
3. **クーリング・オフ成立判定 (COOLING_OFF)**:
   - 申込み場所（ホテルロビー、事務所、買主自発自宅、訪問自宅）を切り替えて即座に解除可否を判定

### 2.3 宅建必須早見表 (24選・Cheat Sheet)
- 媒介報酬額の速算式（400万超 3%+6万+税、200万超、空き家特例）
- 媒介契約3類型（専任・専属専任・一般）比較表
- 手付金等保全措置の基準（未完成5%・完成10%・1000万超）
- 開発許可面積基準（市街化1000㎡・調整全規模・非線引き3000㎡等）
- 国土利用計画法事後届出（2千・5千・5千・1万）
- 農地法3条・4条・5条整理マトリクス
- 建築基準法セットバック、印紙税・不動産取得税早見表
- キーワード検索 ＆ 分野フィルタ ＆ ワンタップクリップボードコピー

### 2.4 学習管理・弱点復習
- 全体進捗率・正答率・分野別ステータス
- ブックマーク機能による苦手問題の絞り込み演習
- Jetpack Preferences DataStoreによるローカル永続化（完全プライバシー保護）

---

## 3. アーキテクチャと技術スタック

### 3.1 技術スタック
- **言語**: Kotlin 2.0.21
- **UI**: Jetpack Compose + Material3
- **状態管理**: Kotlin Coroutines + Flow (`StateFlow` / `asStateFlow`)
- **永続化**: Android Jetpack Preferences DataStore
- **広告**: Google Mobile Ads SDK (AdMob)
- **多言語対応**: 日本語 (`values/strings.xml`) / 英語 (`values-en/strings.xml`)

### 3.2 パッケージ構成
```
com.kawanova.takkendrill/
├── data/
│   ├── TakkenModels.kt           // TakkenCategory, TakkenQuestion, TakkenCheatItem, VisualizerScenario
│   ├── TakkenQuestionsData.kt    // 厳選頻出30問データ
│   ├── TakkenCheatData.kt        // 必須早見表24項目データ
│   └── TakkenQuizRepository.kt   // DataStore進捗・ブックマーク保存
├── ui/
│   ├── theme/
│   │   ├── Color.kt              // ミッドナイトスレート、ゴールド、ネイビー
│   │   ├── Theme.kt              // TakkenDrillTheme
│   │   └── Type.kt               // Typography
│   ├── components/
│   │   ├── SisterAppsBanner.kt   // KawaNova資格・学習シリーズ相互送客
│   │   └── AdaptiveBannerAd.kt   // AdMobバナー
│   ├── TakkenViewModel.kt        // UI状態管理
│   ├── HomeScreen.kt             // 全体進捗・科目カード・クイックアクション
│   ├── QuizScreen.kt             // 一問一答演習・ASCII図解・解説・Exam Tip
│   ├── TakkenVisualizerScreen.kt // 権利・業法図解シミュレータ
│   ├── TakkenCheatScreen.kt      // 必須数値早見表
│   └── navigation/
│       └── NavGraph.kt           // 画面遷移定義
└── MainActivity.kt
```

---

## 4. セキュリティとプライバシー
- 外部APIへの個人データ送信なし（完全オンデバイス完結）
- 解答履歴やブックマークは端末内Preferences DataStoreに暗号化保存
- インターネット通信はAdMob広告バナー配信のみに使用
