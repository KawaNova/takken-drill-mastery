package com.kawanova.takkendrill.data

object TakkenCheatData {
    val cheatItems: List<TakkenCheatItem> = listOf(
        // ==========================================
        // 1. 宅建業法 (BUSINESS_LAW)
        // ==========================================
        TakkenCheatItem(
            id = 1,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "売買媒介報酬の速算式 (400万超・消費税10%)",
            topicEn = "Brokerage Commission Quick Formula (Over 4M yen)",
            summaryJa = "売買代金400万円超の物件における媒介報酬の上限計算式",
            summaryEn = "Statutory maximum fee formula for property sales exceeding 4M yen.",
            keyPointsJa = listOf(
                "税抜上限: (売買代金 × 3% + 6万円)",
                "税込上限: (売買代金 × 3% + 6万円) × 1.10",
                "200万以下: 代金 × 5% × 1.10",
                "200万超400万以下: (代金 × 4% + 2万円) × 1.10",
                "低廉な空家等の特例: 800万円以下の物件の売主媒介は最大33万円(税込)"
            ),
            keyPointsEn = listOf(
                "Excl. tax cap: (Price x 3% + 60,000 yen)",
                "Incl. 10% tax: (Price x 3% + 60,000 yen) x 1.10",
                "Up to 2M yen: Price x 5% x 1.10",
                "2M to 4M yen: (Price x 4% + 20,000 yen) x 1.10",
                "Low-cost vacant home exception: Up to 330,000 yen (tax incl) for sales under 8M yen"
            ),
            copyableText = "(売買代金 × 3% + 6万円) × 1.10"
        ),

        TakkenCheatItem(
            id = 2,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "35条書面 (重説) vs 37条書面 (契約書) 完全対比",
            topicEn = "Article 35 (Disclosure) vs Article 37 (Contract) Matrix",
            summaryJa = "交付時期・説明義務・記載事項の最重要対比表",
            summaryEn = "Comprehensive comparison between Art 35 Statement and Art 37 Contract.",
            keyPointsJa = listOf(
                "交付時期: 35条は「契約成立前」 / 37条は「契約成立後遅滞なく」",
                "交付相手: 35条は「買主・借主のみ」 / 37条は「売買双方・貸借双方」",
                "取引士の説明: 35条は「説明必須(証提示)」 / 37条は「説明不要(記名のみ)」",
                "代金の額・支払時期: 35条は「記載不要」 / 37条は「必要的記載事項」",
                "業者間取引: 35条は「説明のみ省略可(交付要)」 / 37条は「省略不可(交付要)」"
            ),
            keyPointsEn = listOf(
                "Timing: Art 35 is BEFORE contract / Art 37 is promptly AFTER contract",
                "Recipient: Art 35 to buyer/tenant only / Art 37 to both contracting parties",
                "Agent explanation: Art 35 requires oral explanation / Art 37 signature only (no explanation)",
                "Price & payment terms: NOT in Art 35 / MANDATORY in Art 37",
                "Between brokers: Art 35 oral explanation skippable / Art 37 delivery cannot be skipped"
            ),
            copyableText = "35条=契約前・買主のみ・説明要・代金記載不要 | 37条=契約後・双方・説明不要・代金必須"
        ),

        TakkenCheatItem(
            id = 3,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "媒介契約 3類型の重要ルール (専属専任・専任・一般)",
            topicEn = "Mediation Contract Rules (Full Exclusive, Exclusive, General)",
            summaryJa = "他社重複・自己発見・レインズ登録・報告義務の整理",
            summaryEn = "Comparative rules for Exclusive, Full Exclusive, and General Mediation.",
            keyPointsJa = listOf(
                "専属専任媒介: 重複✕ / 自己発見✕ / 最長3ヶ月 / レインズ5日以内 / 報告週1回以上",
                "専任媒介: 重複✕ / 自己発見○ / 最長3ヶ月 / レインズ7日以内 / 報告2週に1回以上",
                "一般媒介: 重複○ / 自己発見○ / 期間制限なし / レインズ任意 / 報告義務なし"
            ),
            keyPointsEn = listOf(
                "Full Exclusive: Multiple brokers NO / Self-found NO / Max 3 mos / REINS 5 days / Report weekly",
                "Exclusive: Multiple brokers NO / Self-found YES / Max 3 mos / REINS 7 days / Report bi-weekly",
                "General: Multiple brokers YES / Self-found YES / No period limit / REINS optional / No report"
            ),
            copyableText = "専属専任=5日登録・週1報告・自己発見NG | 専任=7日登録・隔週報告・自己発見OK"
        ),

        TakkenCheatItem(
            id = 4,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "8種制限：クーリング・オフ 成立要件",
            topicEn = "8 Restrictions: Cooling-Off Essential Requirements",
            summaryJa = "事務所等以外の場所での申込みと8日間のカウント",
            summaryEn = "Cooling-off conditions outside broker offices within 8 days.",
            keyPointsJa = listOf(
                "売主が宅建業者 ＆ 買主が一般人（業者間取引には適用除外）",
                "申込み場所: 事務所等以外（喫茶店・ホテル・訪問販売等）",
                "買主自ら申し出た「自宅」「勤務先」はクーリング・オフ不可！",
                "期限: 書面告知から8日以内（書面または電磁的記録で発信）",
                "終了条件: 「物件の引渡し」と「代金全額支払」の両方が完了すると行使不可"
            ),
            keyPointsEn = listOf(
                "Seller is broker & buyer is consumer (exempt between brokers)",
                "Offer made outside formal office (cafe, hotel, cold visit)",
                "Buyer's requested home/workplace is NOT subject to cooling-off",
                "Deadline: Within 8 days of written notice (postmarked or electronic)",
                "Extinguishment: Inapplicable once BOTH delivery and full payment are finished"
            ),
            copyableText = "クーリングオフ: 申込み場所で判定(喫茶店OK・自発自宅NG)・書面告知から8日以内"
        ),

        TakkenCheatItem(
            id = 5,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "8種制限：手付金等の保全措置 基準値",
            topicEn = "8 Restrictions: Earnest Money Protection Thresholds",
            summaryJa = "未完成物件5%・完成物件10%と1,000万円の壁",
            summaryEn = "5% for uncompleted, 10% for completed, or over 10M yen thresholds.",
            keyPointsJa = listOf(
                "工事完了前 (未完成): 代金の5%超 または 1,000万円超",
                "工事完了後 (完成物件): 代金の10%超 または 1,000万円超",
                "保全方法: 銀行等の保証 / 保険事業者の保証保険 / 指定保管機関への寄託(完成物件のみ)",
                "保全不要例外: 買主への所有権移転登記完了後、業者間取引"
            ),
            keyPointsEn = listOf(
                "Uncompleted construction: Over 5% of price OR over 10M yen",
                "Completed construction: Over 10% of price OR over 10M yen",
                "Methods: Bank guarantee, insurance bond, escrow deposit (completed only)",
                "Exemptions: After title registration, or transactions between brokers"
            ),
            copyableText = "手付保全: 未完成=5%超or1,000万超 | 完成=10%超or1,000万超 (登記後は不要)"
        ),

        TakkenCheatItem(
            id = 6,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "8種制限：損害賠償額の予定・手付の額の制限",
            topicEn = "8 Restrictions: Liquidated Damages & Deposit Caps (20%)",
            summaryJa = "代金の2割（20%）を超える特約の効力と超える部分無効",
            summaryEn = "20% cap on liquidated damages and earnest deposits.",
            keyPointsJa = listOf(
                "損害賠償額の予定＋違約金 ≦ 代金の2割 (20%)",
                "2割を超過する特約: 「2割を超える部分のみが無効」（全部無効ではない！）",
                "手付の額の制限: 代金の2割 (20%) を超えて受領することは禁止",
                "自己の所有に属しない宅地建物の売買契約締結制限（他人物売買の原則禁止）"
            ),
            keyPointsEn = listOf(
                "Liquidated damages + penalty <= 20% of price",
                "Exceeding clauses: ONLY the portion exceeding 20% is void (not entire clause)",
                "Earnest deposit cap: Cannot receive more than 20% of price",
                "Restriction on contracting properties not owned by seller (no short sales without deed)"
            ),
            copyableText = "損害賠償予定: 代金の2割上限 (超過部分のみ無効) | 手付上限: 代金の2割"
        ),

        TakkenCheatItem(
            id = 7,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "営業保証金 vs 保証協会 (供託額・分担金額)",
            topicEn = "Security Deposits vs Guarantee Association Contributions",
            summaryJa = "主たる事務所1,000万・従たる500万 vs 本店60万・支店30万",
            summaryEn = "10M/5M statutory deposits vs 600k/300k association contributions.",
            keyPointsJa = listOf(
                "営業保証金 (単独供託): 本店 1,000万円 / 支店 1店につき 500万円",
                "弁済業務保証金分担金: 本店 60万円 / 支店 1店につき 30万円",
                "還付請求権限: 保証協会加入でも「本来の営業保証金額(1000万/500万基準)」まで弁済可能",
                "不足額供託・還付充当金: 通知を受けてから「2週間以内」に納付"
            ),
            keyPointsEn = listOf(
                "Statutory deposit: Head office 10M yen / Branch 5M yen each",
                "Association contribution: Head office 600k yen / Branch 300k yen each",
                "Consumer claim limit: Up to equivalent statutory deposit amount (10M / 5M)",
                "Deficit repayment: Within 2 weeks of receiving notice"
            ),
            copyableText = "営業保証金=本店1000万・支店500万 | 保証協会=本店60万・支店30万 (補充は2週間)"
        ),

        TakkenCheatItem(
            id = 8,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "専任の宅地建物取引士 設置基準",
            topicEn = "Mandatory Licensed Agents (1 in 5 Rule)",
            summaryJa = "業務従事者5人に1人以上の割合・2週間以内の補充",
            summaryEn = "1 licensed agent per 5 employees, 2-week replacement deadline.",
            keyPointsJa = listOf(
                "事務所: 業務に従事する者「5人に1人以上」の専任取引士（端数切り上げ）",
                "契約等を行う案内所: 「少なくとも1人以上」",
                "不足時の是正: 欠格や退職により不足したときは「2週間以内」に補充措置",
                "専任性: 常勤かつ専従（他社常勤役員等は原則兼務不可）"
            ),
            keyPointsEn = listOf(
                "Offices: At least 1 full-time agent per 5 workers (rounded up)",
                "Contract booths: At least 1 full-time agent",
                "Remedy deadline: Within 2 weeks if fallen below required quota",
                "Exclusivity: Full-time and dedicated to the branch office"
            ),
            copyableText = "専任取引士: 事務所=従事者5人に1人 | 契約案内所=1人以上 | 欠員補充=2週間以内"
        ),

        // ==========================================
        // 2. 権利関係 (民法・借地借家法等) (RIGHTS)
        // ==========================================
        TakkenCheatItem(
            id = 9,
            category = TakkenCategory.RIGHTS,
            topicJa = "意思表示の効力と第三者保護 (善意・無過失)",
            topicEn = "Manifestation of Intention & Third-Party Protection",
            summaryJa = "心裡留保・通謀虚偽表示・錯誤・詐欺・強迫の対抗比較",
            summaryEn = "Rescission / Nullity comparison among Mental Reservation, Sham, Mistake, Fraud, Duress.",
            keyPointsJa = listOf(
                "心裡留保 (93条): 原則有効 / 相手方悪意・有過失で無効 / 善意無過失の第三者に対抗不可",
                "虚偽表示 (94条): 当事者間無効 / 善意の第三者に対抗不可（過失があっても保護！）",
                "錯誤 (95条): 取消し可能 / 表意者重過失なら原則取消不可 / 善意無過失の第三者に対抗不可",
                "詐欺 (96条): 取消し可能 / 善意無過失の第三者に対抗不可",
                "強迫 (96条): 取消し可能 / ★善意無過失の第三者にも対抗できる！（絶対的保護）"
            ),
            keyPointsEn = listOf(
                "Mental reservation: Valid unless counterparty in bad faith / Cannot assert against bona fide 3rd party",
                "Sham transaction: Void between parties / Cannot assert against bona fide 3rd party (even with negligence)",
                "Mistake: Rescindable / Cannot assert if gross negligence / Bona fide 3rd party protected",
                "Fraud: Rescindable / Bona fide 3rd party without negligence protected",
                "Duress (threat): Rescindable / CAN be asserted against ANY third party (victim absolute protection)"
            ),
            copyableText = "詐欺=善意無過失に対抗不可 | 強迫=善意無過失にも対抗可能 | 虚偽表示=善意に対抗不可(無過失不要)"
        ),

        TakkenCheatItem(
            id = 10,
            category = TakkenCategory.RIGHTS,
            topicJa = "法定地上権 成立の4大要件 (民法388条)",
            topicEn = "Statutory Surface Rights: 4 Critical Conditions",
            summaryJa = "更地抵当は不成立・設定当時の同一所有者要件",
            summaryEn = "4 legal conditions under Art 388; bare land mortgages never qualify.",
            keyPointsJa = listOf(
                "① 抵当権設定当時に、土地の上に建物が存在すること（更地抵当は✕）",
                "② 抵当権設定当時に、土地と建物が同一の所有者に属すること",
                "③ 土地・建物の一方または双方に抵当権が設定されたこと",
                "④ 競売（実行）により、土地と建物の所有者が別々になったこと"
            ),
            keyPointsEn = listOf(
                "1. Building must exist on the land at the time mortgage is created (not bare land)",
                "2. Land and building must belong to the same owner at mortgage creation",
                "3. Mortgage must be created on land, building, or both",
                "4. Foreclosure auction must result in different owners"
            ),
            copyableText = "法定地上権: 設定時に建物あり ＋ 同一所有者 ＋ 競売で所有者分離 (更地設定は不成立)"
        ),

        TakkenCheatItem(
            id = 11,
            category = TakkenCategory.RIGHTS,
            topicJa = "普通借地 vs 定期借地権 (一般・事業用・建物譲渡)",
            topicEn = "General Leasehold vs Fixed-Term Leasehold",
            summaryJa = "存続期間・更新の有無・公正証書要件の整理",
            summaryEn = "Duration, renewal, and notarization requirements for land leases.",
            keyPointsJa = listOf(
                "普通借地権: 当初30年 (更新1回目20年、以降10年) / 正当事由なき更新拒絶不可",
                "一般定期借地権: 存続期間50年以上 / 書面(公正証書等) / 更新なし・買取請求なし",
                "事業用定期借地権: 10年以上50年未満 / 専ら事業の用 / ★必ず公正証書！",
                "建物譲渡特約付借地権: 30年以上 / 期間満了時に相当対価で地主が建物買取り"
            ),
            keyPointsEn = listOf(
                "Ordinary Leasehold: 30 years initial (20 yrs 1st renewal, 10 yrs thereafter) / Renewal protected",
                "General Fixed-Term: 50+ years / Written contract / No renewal, no buyout demand",
                "Commercial Fixed-Term: 10 to <50 years / Strictly commercial / Mandatory NOTARIAL deed!",
                "Building Transfer Leasehold: 30+ years / Landlord buys building at fair value at expiry"
            ),
            copyableText = "一般定期借地=50年以上(書面) | 事業用定期借地=10〜50年(公正証書必須)"
        ),

        TakkenCheatItem(
            id = 12,
            category = TakkenCategory.RIGHTS,
            topicJa = "定期建物賃貸借 (定期借家) 成立要件",
            topicEn = "Fixed-Term Building Lease (Teiki Shakuya)",
            summaryJa = "事前別紙説明・公正証書等書面・終了通知期間",
            summaryEn = "Prior written notice, written contract, and expiry notice rules.",
            keyPointsJa = listOf(
                "公正証書等の「書面」による契約締結（口頭は無効）",
                "★契約締結に先立って「別紙書面」を事前交付して更新がない旨を説明",
                "期間制限なし（1年未満でも有効！）",
                "期間1年以上の場合: 満了1年前〜6ヶ月前までに「終了通知」が必要",
                "床面積200㎡未満の居住用: 転勤・療養・介護等やむを得ない事情で賃借人からの中途解約可"
            ),
            keyPointsEn = listOf(
                "Contract must be in writing (notarial or standard written deed)",
                "Lessor must deliver SEPARATE written document prior to signing explaining non-renewal",
                "No term restriction (valid even under 1 year)",
                "Terms >= 1 year: Landlord must notify expiry 1 year to 6 months prior",
                "Residential under 200 sqm: Tenant can cancel early for job transfer, medical care, etc."
            ),
            copyableText = "定期借家: 事前に別紙書面で説明 ＋ 契約書面化 (期間制限なし・1年超は1年〜6月前終了通知)"
        ),

        // ==========================================
        // 3. 法令上の制限 (RESTRICTIONS)
        // ==========================================
        TakkenCheatItem(
            id = 13,
            category = TakkenCategory.RESTRICTIONS,
            topicJa = "開発許可の面積基準 (市街化・調整・非線引き・準都市)",
            topicEn = "Development Permission Scale Thresholds",
            summaryJa = "許可を要する開発行為の面積ボーダーライン",
            summaryEn = "Acreage thresholds requiring development permission.",
            keyPointsJa = listOf(
                "市街化区域: 1,000㎡以上 (三大都市圏の指定都市等は500㎡以上)",
                "市街化調整区域: 【面積にかかわらずすべて要許可】 (0㎡超)",
                "非線引き区域: 3,000㎡以上",
                "準都市計画区域: 3,000㎡以上",
                "都市計画区域外: 10,000㎡ (1ヘクタール) 以上",
                "★農林漁業用建築物の特例: 市街化区域「以外」でのみ許可不要！"
            ),
            keyPointsEn = listOf(
                "Urbanization Promotion Area: 1,000 sqm+ (500 sqm+ in major metropolitan centers)",
                "Urbanization Control Area: ALWAYS requires permission (any size > 0)",
                "Non-demarcated Area: 3,000 sqm+",
                "Quasi-City Planning Area: 3,000 sqm+",
                "Outside Planning Area: 10,000 sqm (1 ha)+",
                "Agricultural exemption: Applies ONLY outside Urbanization Promotion Areas!"
            ),
            copyableText = "開発許可: 市街化=1000㎡ | 調整=全規模要許可 | 非線引き・準都市=3000㎡ | 区域外=10000㎡"
        ),

        TakkenCheatItem(
            id = 14,
            category = TakkenCategory.RESTRICTIONS,
            topicJa = "建ぺい率の緩和ルール (角地＋防火・100%特例)",
            topicEn = "Building Coverage Ratio Relaxations (Corner & Fireproof)",
            summaryJa = "+10%加算・+20%加算・無制限(100%)の適用条件",
            summaryEn = "+10%, +20%, and 100% unconditional relaxations.",
            keyPointsJa = listOf(
                "特定行政庁が指定する角地: +10% 緩和",
                "防火地域内の耐火建築物等: +10% 緩和",
                "準防火地域内の耐火・準耐火建築物等: +10% 緩和",
                "角地 ＋ 防火地域内耐火建築物: +10% + 10% = 【+20% 緩和】",
                "指定建ぺい率80%の地域 ＋ 防火地域 ＋ 耐火建築物等: 【建ぺい率100% (制限なし)】"
            ),
            keyPointsEn = listOf(
                "Designated corner lot: +10% bonus",
                "Fireproof building in Fire Prevention District: +10% bonus",
                "Fireproof/quasi-fireproof in Semi-Fire District: +10% bonus",
                "Corner + Fireproof in Fire Prevention District: +20% bonus",
                "80% designated zone + Fire Prevention District + Fireproof: 100% (NO LIMIT)"
            ),
            copyableText = "建ぺい率緩和: 角地(+10%) | 耐火(+10%) | 両方(+20%) | 80%地域+防火+耐火=100%無制限"
        ),

        TakkenCheatItem(
            id = 15,
            category = TakkenCategory.RESTRICTIONS,
            topicJa = "国土利用計画法：事後届出制 面積要件と手続",
            topicEn = "National Land Use Planning Act: Post-Facto Notification",
            summaryJa = "2千・5千・5千・1万の面積基準と買主2週間以内ルール",
            summaryEn = "2k/5k/5k/10k sqm scale thresholds and 2-week buyer deadline.",
            keyPointsJa = listOf(
                "市街化区域: 2,000㎡以上",
                "市街化調整区域: 5,000㎡以上",
                "非線引き都市計画区域: 5,000㎡以上",
                "都市計画区域外: 10,000㎡ (1ha) 以上",
                "届出義務者: 【買主（権利取得者）のみ】",
                "届出期限: 契約締結日から【2週間以内】 (契約日を含む)",
                "未届出の効力: 契約自体は有効 (懲役・罰金の刑事罰あり)"
            ),
            keyPointsEn = listOf(
                "Urbanization Promotion: 2,000 sqm+",
                "Urbanization Control: 5,000 sqm+",
                "Non-demarcated: 5,000 sqm+",
                "Outside planning area: 10,000 sqm+",
                "Obligated party: BUYER ONLY (acquirer)",
                "Deadline: Within 2 weeks of contract date",
                "Validity: Contract remains valid (penalties apply)"
            ),
            copyableText = "国土法事後届出: 市街化=2000㎡ | 調整・非線引き=5000㎡ | 区域外=10000㎡ (買主が2週以内)"
        ),

        TakkenCheatItem(
            id = 16,
            category = TakkenCategory.RESTRICTIONS,
            topicJa = "農地法 3条・4条・5条 完全整理マトリクス",
            topicEn = "Agricultural Land Act: Articles 3, 4 & 5 Matrix",
            summaryJa = "権利移動・転用・転用目的権利移動の許可権者と特例",
            summaryEn = "Conversion, rights transfers, and the Urbanization Area notification rule.",
            keyPointsJa = listOf(
                "3条 (農地➔農地の権利移動): 【農業委員会】の許可 (違反は無効)",
                "4条 (自己農地の転用): 【都道府県知事等】の許可 (違反は原状回復命令等)",
                "5条 (転用目的の権利移動): 【都道府県知事等】の許可 (違反は無効)",
                "★市街化区域内の農地特例: 4条・5条は「農業委員会への事前届出」で知事許可不要！",
                "国・都道府県の取得・転用: 協議成立で許可とみなされる"
            ),
            keyPointsEn = listOf(
                "Art 3 (Farm to Farm transfer): Agricultural Commission permit (void if violated)",
                "Art 4 (Own farm conversion): Governor permit",
                "Art 5 (Transfer for conversion): Governor permit (void if violated)",
                "Urbanization Area Exemption: Art 4 & 5 require only prior notice to Agricultural Commission",
                "Gov acquisitions: Consultation agreement deemed permit"
            ),
            copyableText = "農地法: 3条=農業委 | 4条・5条=知事許可 (市街化区域の4・5条は農業委への事前届出でOK)"
        ),

        TakkenCheatItem(
            id = 17,
            category = TakkenCategory.RESTRICTIONS,
            topicJa = "建築基準法：接道義務と2項道路セットバック",
            topicEn = "Building Standards Act: Road Frontage & Setbacks",
            summaryJa = "幅員4m以上道路に2m接道・中心線2m後退",
            summaryEn = "4m width & 2m frontage rule, 2m centerline setback on Section 2 roads.",
            keyPointsJa = listOf(
                "接道義務の原則: 幅員4m以上の道路に敷地が「2m以上」接しなければならない",
                "2項道路 (みなし道路): 幅員4m未満の道で特定行政庁が指定したもの",
                "セットバック: 道路中心線から「水平距離2m」後退した線が境界線",
                "★セットバック部分の土地: 建ぺい率・容積率計算の「敷地面積に算入不可」！"
            ),
            keyPointsEn = listOf(
                "Frontage rule: Site must touch a 4m+ wide road by at least 2m",
                "Section 2 road: Paths under 4m designated by authority",
                "Setback: 2m horizontal distance from centerline deemed road border",
                "Setback area: EXCLUDED from site area when calculating BCR/FAR!"
            ),
            copyableText = "接道義務: 4m道に2m以上接道 | 2項道路: 中心線から2mセットバック (敷地面積から除外)"
        ),

        // ==========================================
        // 4. 税・その他 (TAX_OTHERS)
        // ==========================================
        TakkenCheatItem(
            id = 18,
            category = TakkenCategory.TAX_OTHERS,
            topicJa = "不動産取得税 vs 固定資産税 比較整理",
            topicEn = "Real Estate Acquisition Tax vs Fixed Asset Tax",
            summaryJa = "都道府県税 vs 市町村税・課税標準・免税点",
            summaryEn = "Prefectural vs Municipal property taxes and assessments.",
            keyPointsJa = listOf(
                "不動産取得税: 【都道府県税】 / 課税標準は台帳登録価格 / 相続は非課税 / 免税点: 土地10万・家屋建築23万・家屋売買12万",
                "固定資産税: 【市町村税】 (東京23区は特例で都税) / 毎年1月1日現在の所有者に課税",
                "固定資産税の住宅用地特例: 小規模住宅用地(200㎡以下)は課税標準1/6、一般住宅用地(200㎡超)は1/3",
                "固定資産税の免税点: 土地30万円未満、家屋20万円未満"
            ),
            keyPointsEn = listOf(
                "Acquisition tax: Prefectural tax / Assessed value basis / Inheritance exempt / Exempt: Land <100k, building <230k/<120k",
                "Fixed asset tax: Municipal tax / Levied on owner as of Jan 1st each year",
                "Residential land relief: Small lots (<=200 sqm) 1/6 tax base, general lots (>200 sqm) 1/3",
                "Property tax exemption: Land <300,000 yen, building <200,000 yen"
            ),
            copyableText = "不動産取得税=都道府県税(相続非課税) | 固定資産税=市町村税(1月1日所有者・小規模住宅1/6)"
        ),

        TakkenCheatItem(
            id = 19,
            category = TakkenCategory.TAX_OTHERS,
            topicJa = "印紙税：課税文書と非課税文書の判別",
            topicEn = "Stamp Tax: Taxable vs Exempt Real Estate Documents",
            summaryJa = "建物賃貸借非課税・領収証5万円・消費税区分記載",
            summaryEn = "Building lease exempt, 50k receipt threshold, net amount excluding tax.",
            keyPointsJa = listOf(
                "土地の売買・賃貸借契約書: 【課税】",
                "建物の賃貸借契約書: ★【非課税】（月額家賃や礼金の額にかかわらず非課税！）",
                "領収証 (金銭受取書): 記載金額「5万円未満」は非課税",
                "消費税額等の区分記載: 消費税額が明記されている場合、税抜金額が記載金額となる",
                "印紙不貼付の効力: 契約自体は有効（過怠税として原則3倍徴収）"
            ),
            keyPointsEn = listOf(
                "Land sales & land lease contracts: Taxable",
                "Building lease contracts: EXEMPT (regardless of rent or deposit amount)",
                "Receipts: Exempt under 50,000 yen",
                "Consumption tax separation: Net price excluding tax becomes the taxable stated amount",
                "Unstamped document: Contract remains valid; 3x penalty tax applies"
            ),
            copyableText = "印紙税: 建物賃貸借=非課税 | 土地賃貸借=課税 | 領収書5万未満非課税 | 印紙漏れも契約有効"
        ),

        TakkenCheatItem(
            id = 20,
            category = TakkenCategory.TAX_OTHERS,
            topicJa = "景品表示法：不動産広告のルール (徒歩80m・新築定義)",
            topicEn = "Fair Competition Code: Advertising Rules (80m & New)",
            summaryJa = "道路距離80mで1分(端数切上)・新築は1年未満未入居",
            summaryEn = "80m = 1 min walking time (rounded up), new = under 1 yr and unoccupied.",
            keyPointsJa = listOf(
                "徒歩所要時間: 「道路距離80mにつき1分」（直線距離ではない！端数は切り上げ！）",
                "新築の定義: 建築後「1年未満」かつ「未入居（居住用に使われたことがない）」",
                "特定事項の明示: 高圧電線下、セットバック要、傾斜地、私道負担の有無は明示必須",
                "予告広告: 価格等の未定事項があっても、取引開始時期を明示すれば認められる"
            ),
            keyPointsEn = listOf(
                "Walking time: 1 minute per 80m of road distance (round up fractions)",
                "New construction: Under 1 year old AND uninhabited",
                "Mandatory disclosures: High-voltage lines, setbacks, steep slopes, private road burdends",
                "Advance ads: Allowed if stating unfinalized prices and scheduled start date"
            ),
            copyableText = "広告表示: 徒歩80m=1分(端数切上) | 新築=建築1年未満かつ未入居 | 高圧線下等は明示必須"
        ),

        TakkenCheatItem(
            id = 21,
            category = TakkenCategory.TAX_OTHERS,
            topicJa = "住宅金融支援機構：主要業務と直接融資の限定",
            topicEn = "Housing Finance Agency: Core Functions & Flat 35",
            summaryJa = "証券化支援業務(買取型・保証型)と直接融資対象",
            summaryEn = "Securitization support and narrow scope of direct lending.",
            keyPointsJa = listOf(
                "主業務: 証券化支援業務（買取型・保証型・フラット35の債権買取）",
                "原則: 民間金融機関と競合する「一般住宅購入資金の直接融資」は行わない！",
                "直接融資の例外: 災害復興住宅資金、財形住宅貸付、耐震改修・都市再生資金",
                "住宅融資保険法に基づく保険業務、住まい情報提供業務"
            ),
            keyPointsEn = listOf(
                "Core function: Securitization support (Flat 35 loan purchase & guarantee)",
                "Principle: NO direct lending competing with commercial banks for normal homes",
                "Direct loan exceptions: Disaster reconstruction, worker asset-building, seismic retrofits",
                "Mortgage loan underwriting and home information services"
            ),
            copyableText = "住宅金融支援機構: 証券化支援(フラット35)が主業務 | 一般住宅の直接融資は行わない！"
        ),

        TakkenCheatItem(
            id = 22,
            category = TakkenCategory.TAX_OTHERS,
            topicJa = "地価公示法：公示価格の効力と基準日",
            topicEn = "Public Notice of Land Prices Act: Standard Dates & Value",
            summaryJa = "毎年1月1日基準日・正常な価格・取引指標",
            summaryEn = "Jan 1st benchmark date, fair market value, and benchmark indicator.",
            keyPointsJa = listOf(
                "価格判定基準日: 毎年「1月1日」 (3月下旬頃に国土交通省が公示)",
                "判定対象: 標準地の単位面積あたりの「正常な価格」（自由な取引で成立する価格）",
                "宅建業者の努力義務: 宅地売買の価格査定を行うにあたっては公示価格を指標として努める",
                "公的評価の基準: 国土利用計画法による土地価格算定や公共用地買収の基準"
            ),
            keyPointsEn = listOf(
                "Benchmark date: January 1st every year (published late March by MLIT)",
                "Target: Fair market value per unit area of standard lots under open market conditions",
                "Broker's duty: Strive to use public land prices as benchmark when assessing properties",
                "Official use: Serves as basis for public land acquisition and land regulation assessments"
            ),
            copyableText = "地価公示: 1月1日基準日・正常な価格 | 宅建業者の価格査定努力義務"
        ),

        TakkenCheatItem(
            id = 23,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "宅建業の免許区分と変更の届出",
            topicEn = "Broker License Types & Modification Notice (30 Days)",
            summaryJa = "知事免許・大臣免許の区分と30日以内の変更届出",
            summaryEn = "Governor vs Minister licenses and 30-day modification notice rule.",
            keyPointsJa = listOf(
                "都道府県知事免許: 1つの都道府県の区域内のみに事務所を設置する場合",
                "国土交通大臣免許: 2つ以上の都道府県の区域内に事務所を設置する場合",
                "免許換え: 支店増設等で管轄が変わる場合（知事➔大臣、大臣➔知事等）",
                "宅建業者名簿の変更届出: 商号・役員・政令使用人・専任取引士の氏名等の変更は「30日以内」",
                "取引士資格登録簿の変更登録: 氏名・住所・本籍・勤務先変更は「遅滞なく」"
            ),
            keyPointsEn = listOf(
                "Prefectural Governor license: All offices located within a single prefecture",
                "MLIT Minister license: Offices located across 2 or more prefectures",
                "License reclassification: Required when crossing prefectural jurisdiction",
                "Broker roster modification: Notify within 30 days for trade name, directors, manager, agents",
                "Agent registration modification: File promptly for name, address, or employer changes"
            ),
            copyableText = "免許: 1都道府県=知事免許 | 2以上都道府県=大臣免許 | 業者名簿変更届=30日以内"
        ),

        TakkenCheatItem(
            id = 24,
            category = TakkenCategory.BUSINESS_LAW,
            topicJa = "廃業等の届出義務者と届出期間 (30日ルール)",
            topicEn = "Brokerage Business Termination Notice (30-Day Rule)",
            summaryJa = "死亡・合併・破産・解散・廃業の届出者整理",
            summaryEn = "Who must notify within 30 days upon death, merger, bankruptcy, dissolution.",
            keyPointsJa = listOf(
                "死亡: 【相続人】が死亡を知った日から「30日以内」",
                "法人の合併による消滅: 【消滅法人の代表役員であった者】が「30日以内」",
                "破産手続開始決定: 【破産管財人】が「30日以内」",
                "合併・破産以外の解散: 【清算人】が「30日以内」",
                "廃業: 【宅建業者であった個人または代表役員】が「30日以内」",
                "★免許の失効時期: 死亡・合併は「その時点」で失効。破産・解散・廃業は「届出時」に失効！"
            ),
            keyPointsEn = listOf(
                "Death: Heirs notify within 30 days of knowing (license expires at death)",
                "Corporate merger: Former representative director of dissolved firm within 30 days",
                "Bankruptcy: Bankruptcy trustee within 30 days",
                "Dissolution other than merger: Liquidator within 30 days",
                "Business cessation: Former individual broker or corporate rep within 30 days"
            ),
            copyableText = "廃業届: 死亡=相続人 | 合併=元代表役員 | 破産=管財人 | 廃業=元代表 (すべて30日以内)"
        )
    )
}
