# 宅建士 突破特訓 (Takken Drill) 🏡
> Real Estate License Mastery for Android

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple.svg)
![Compose](https://img.shields.io/badge/Jetpack_Compose-Material3-blue.svg)
![minSdk](https://img.shields.io/badge/minSdk-24-brightgreen.svg)
![targetSdk](https://img.shields.io/badge/targetSdk-36-orange.svg)
![License](https://img.shields.io/badge/License-Proprietary-lightgrey.svg)

年間20万人以上が受験する国家資格「宅地建物取引士（宅建士）」試験の合格を勝ち取るためのAndroid学習アプリです。  
権利関係（民法・借地借家法等）、宅建業法、法令上の制限、税・その他の4大出題科目から頻出30問を完全収録。複雑な当事者関係を可視化するASCII相関図、全肢詳細解説、試験委員のトラップを見抜く「本試験ひっかけのツボ (Exam Tip)」、インタラクティブ権利・業法図解シミュレータ、宅建必須早見表（24選）を搭載しています。

---

## 📱 主な機能

- **頻出厳選30問 一問一答クイズ**: 権利関係（8問）、宅建業法（12問）、法令上の制限（6問）、税・その他（4問）を網羅
- **全問ASCII当事者関係図**: 二重譲渡、抵当権、無権代理などの複雑な関係をクリアに図解
- **全肢解説 ＆ ひっかけのツボ (Exam Tip)**: 正誤理由と条文・判例根拠を詳細解説
- **⚡ インタラクティブ権利関係・業法シミュレータ**:
  - 二重譲渡と登記（背信的悪意者と善意転得者の優先判定）
  - 35条書面 (重説) vs 37条書面 (契約書) 対比
  - 自ら売主8種制限：クーリング・オフ成立可否判定
- **📋 宅建必須早見表 (24選・ワンタップコピー)**: 報酬速算式、35条/37条、手付保全、開発許可面積など
- **完全オフライン動作 ＆ 100%プライバシー保護**: 通勤電車や移動中でもストレスなく学習可能
- **日英バイリンガル対応**: 端末言語に合わせて自動切り替え

---

## 🛠 技術スタック

| コンポーネント | 技術仕様 |
|:---|:---|
| 言語 | Kotlin 2.0.21 |
| UI | Jetpack Compose (Material 3) |
| アーキテクチャ | MVVM (StateFlow, ViewModel) |
| 永続化 | Android Jetpack Preferences DataStore |
| 広告 | Google Mobile Ads SDK (AdMob) |
| 最小 / ターゲット SDK | Android 7.0 (API 24) / Android 16 (API 36) |

---

## 📂 ディレクトリ構成

```
028_takken-drill/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kawanova/takkendrill/
│   │   │   │   ├── data/                 # データモデル、設問データ、早見表
│   │   │   │   ├── ui/                   # Compose画面、ViewModel、テーマ
│   │   │   │   └── MainActivity.kt       # エントリーポイント
│   │   │   ├── res/                      # アイコン、多言語文字列、テーマ
│   │   │   └── AndroidManifest.xml
│   │   └── test/                         # JVMユニットテスト
│   └── build.gradle.kts
├── doc/
│   └── app_spec.md                       # アプリ詳細仕様書
├── store_assets/play/                    # Play Store掲載用画像・メタデータ
│   ├── app_icon_512.png                  # 512x512 高解像度アプリアイコン
│   ├── feature_graphic_1024x500.png       # 1024x500 フィーチャーグラフィック
│   ├── screenshot_1.png ~ 4.png          # 1080x2400 スクリーンショット
│   ├── listing_ja.md                     # 日本語掲載情報
│   ├── listing_en.md                     # 英語掲載情報
│   ├── release_notes.md                  # リリースノート
│   └── data_safety.yml                   # データセーフティ宣言
└── settings.gradle.kts
```

---

## 🚀 ビルド＆テスト

### ユニットテスト実行
```bash
./gradlew testDebugUnitTest
```

### リリースバンドル (AAB) 生成
```bash
./gradlew bundleRelease
```

### リリースAPK生成
```bash
./gradlew assembleRelease
```

---

## 🛡 ライセンス
Copyright © 2026 KawaNova. All Rights Reserved.
