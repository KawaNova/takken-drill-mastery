# -*- coding: utf-8 -*-
import os

OUTPUT_FILE = r"c:\Users\Kawamoto\Documents\AgentAIDev\mobile-apps\028_takken-drill\app\src\main\java\com\kawanova\takkendrill\data\TakkenQuestionsData.kt"

content = '''package com.kawanova.takkendrill.data

object TakkenQuestionsData {
    val questions: List<TakkenQuestion> = listOf(
        // ==========================================
        // 分野 1: 権利関係 (民法・借地借家法等) 8問
        // ==========================================
        TakkenQuestion(
            id = 1,
            category = TakkenCategory.RIGHTS,
            titleJa = "意思表示：詐欺と第三者の対抗関係",
            titleEn = "Fraud & Third-Party Protection",
            questionJa = "A所有の甲土地を、Bが詐欺によってAから安値で買い受け、その事情を知らない善意無過失のCに転売して所有権移転登記を完了した。この場合、民法の規定および判例によれば、正しいものはどれか？",
            questionEn = "B purchased land from A at a low price through fraud, and then resold it to C, who was unaware and without negligence (in good faith without fault), completing the registration. According to the Civil Code and precedents, which of the following is correct?",
            diagramAscii = """
   [詐欺]             [転売]
A ───────> B ─────────────────> C (善意・無過失)
(被害者)   (加害者)             (第三者・登記あり)
  │                                ▲
  └──── Aは取消しをCに対抗できるか？ ───┘
            【結論: 対抗できない】
""",
            optionsJa = listOf(
                "Aは詐欺を理由に売買契約を取り消し、Cが登記を備えていても甲土地の返還を請求できる。",
                "Aは詐欺を理由に売買契約を取り消しても、善意無過失の第三者Cに対しては取消しを対抗できない。",
                "詐欺による意思表示は初めから無効であるため、Cの善意・悪意を問わず所有権はAにある。",
                "Cが所有権を主張するためには、善意無過失であるだけでなく、詐欺の事実をあらかじめAに通告する必要がある。"
            ),
            optionsEn = listOf(
                "A can rescind the contract due to fraud and demand return of the land even if C has registered.",
                "A cannot assert rescission due to fraud against third party C who is in good faith and without negligence.",
                "A manifestation of intention by fraud is void from the beginning regardless of C's good faith.",
                "To assert ownership, C must not only be in good faith and without negligence, but also give prior notice to A."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】民法第96条第3項により、詐欺による意思表示の取消しは「善意でかつ過失がない第三者」に対抗することができません。Cは善意無過失であり、登記も備えているため、Aは契約を取り消してもCに対して所有権を主張できません。強迫（善意無過失の第三者にも対抗できる）との違いが超頻出です。",
            explanationEn = "Correct: 2. Under Civil Code Article 96(3), rescission of an expression of intention based on fraud cannot be asserted against a third party acting in good faith without negligence. Since C is in good faith and without fault, A cannot assert ownership against C. Note that duress (threats) CAN be asserted even against a bona fide third party.",
            examTipJa = "【ひっかけ注意】「詐欺」は善意無過失の第三者に対抗できないが、「強迫」は善意無過失の第三者にも対抗できます！「詐欺＝善意無過失は保護」「強迫＝被害者絶対保護」を暗記！",
            examTipEn = "Exam Tip: Rescission due to 'fraud' cannot be asserted against a bona fide party without negligence, whereas rescission due to 'duress' (threat) CAN be asserted against anyone."
        ),

        TakkenQuestion(
            id = 2,
            category = TakkenCategory.RIGHTS,
            titleJa = "制限行為能力者：未成年者の法律行為",
            titleEn = "Minors & Legal Capacity",
            questionJa = "17歳の未成年者Aが、法定代理人（親権者）の同意を得ずに自己所有の甲建物をBに売却する契約を締結した。この場合に関する次の記述のうち、民法の規定によれば、正しいものはどれか？",
            questionEn = "A, a 17-year-old minor, entered into a contract to sell a building owned by A to B without the consent of his statutory agent (parents). Which of the following is correct under the Civil Code?",
            diagramAscii = """
[法定代理人] (親権者)
     │ 同意なし
     ▼
 17歳未成年A ──── 売買契約 ────> 相手方B
 (制限行為能力者)
  ★原則: A自身も法定代理人も単独で取り消すことができる！
""",
            optionsJa = listOf(
                "未成年者Aが単独で行った売買契約は最初から絶対的に無効である。",
                "売買契約を取り消すことができるのは法定代理人だけであり、未成年者A自身は取り消すことができない。",
                "未成年者Aは、法定代理人の同意を得ていなくても、自ら単独で売買契約を取り消すことができる。",
                "相手方Bは、契約締結時にAが未成年者であることを知らなかった（善意の）場合、Aからの取消しを拒絶できる。"
            ),
            optionsEn = listOf(
                "The contract performed by minor A is unconditionally void from the beginning.",
                "Only the statutory agent can rescind the contract; minor A cannot rescind it alone.",
                "Minor A can rescind the sales contract alone without obtaining the consent of the statutory agent.",
                "If party B was unaware that A was a minor at the time of the contract, B can refuse A's rescission."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】民法第120条第1項により、制限行為能力者が単独で行った行為は、法定代理人だけでなく「制限行為能力者本人」も単独で取り消すことができます。取消しには法定代理人の同意は不要です。また、相手方Bが善意であっても未成年者保護が優先され取消しを拒絶できません。",
            explanationEn = "Correct: 3. Under Civil Code Article 120(1), an act performed by a person with limited capacity may be rescinded by the person himself alone without the statutory agent's consent. Even if counterparty B acted in good faith, minor protection takes priority.",
            examTipJa = "【頻出ポイント】未成年者が「契約を結ぶ」には同意が必要ですが、「取り消す」こと自体は単独で可能です（不利益を被らないため）。また未成年者が「詐術（成年と偽る）」を用いた場合は取消権を失います。",
            examTipEn = "Exam Tip: A minor needs parental consent to enter a contract, but can rescind it unilaterally without consent because rescission causes no detriment."
        ),

        TakkenQuestion(
            id = 3,
            category = TakkenCategory.RIGHTS,
            titleJa = "代理：無権代理と本人の単独相続",
            titleEn = "Unauthorized Agency & Inheritance",
            questionJa = "Aの長男B（無権代理人）が、父Aの代理権がないにもかかわらず、A所有の甲土地をCに売却した。その後、父Aが死亡し、無権代理人BがAを単独で相続した。この場合、判例によれば、正しいものはどれか？",
            questionEn = "Son B (unauthorized agent) sold land owned by father A to C without authorization. Later, father A died, and B inherited A as sole heir. According to precedents, which of the following is correct?",
            diagramAscii = """
父 A (本人・死亡) ── [単独相続] ──> 子 B (無権代理人)
     │                                    │
     └── 甲土地売却 (勝手に代理契約) ────────┴──> 相手方 C
   【無権代理人が本人を単独相続した場合: 追認拒絶は信義則上許されない！】
""",
            optionsJa = listOf(
                "Bは本人の地位を相続したため、本人としての資格で追認を拒絶して甲土地の返還を請求できる。",
                "無権代理行為は当然に無効であるため、相続によって契約が有効になることはない。",
                "Bが無権代理行為をした後で本人を単独相続した場合、追認を拒絶することは信義則上許されず、売買契約は当然に有効となる。",
                "相手方Cが契約締結時にBに代理権がないことを知っていた（悪意の）場合、契約は無効となりBは登記移転を拒否できる。"
            ),
            optionsEn = listOf(
                "Since B inherited the status of the principal, B can refuse ratification and demand return of the land.",
                "The unauthorized act is automatically void and cannot become valid upon inheritance.",
                "When the unauthorized agent solely inherits the principal, refusing ratification is barred by good faith; the contract becomes valid.",
                "If counterparty C knew that B had no power of representation (in bad faith), the contract is void."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】判例（最判昭40.6.18）によれば、無権代理人が本人を単独相続した場合、自ら無権代理行為をしておきながら本人の資格で追認を拒絶することは信義則（民法第1条第2項）に反して許されません。したがって、売買契約は何らの行為を要せず当然に有効となります（「本人が無権代理人を相続した場合」は追認拒絶可能という対比が重要！）。",
            explanationEn = "Correct: 3. Precedents hold that if an unauthorized agent solely inherits the principal, refusing ratification in the principal's shoes is contrary to good faith (Civil Code Art 1(2)); therefore, the contract automatically becomes valid.",
            examTipJa = "【超重要対比】①「無権代理人が本人を相続」➔ 追認拒絶できない（有効）！ ②「本人が無権代理人を相続」➔ 本人本来の地位に基づき追認拒絶できる！この主語の違いは毎年出ます。",
            examTipEn = "Exam Tip: (1) Unauthorized agent inherits principal: CANNOT refuse ratification. (2) Principal inherits unauthorized agent: CAN refuse ratification."
        ),

        TakkenQuestion(
            id = 4,
            category = TakkenCategory.RIGHTS,
            titleJa = "物権変動：二重譲渡と背信的悪意者",
            titleEn = "Double Sale & Malicious Bad Faith",
            questionJa = "Aは甲土地をBに売却したが、Bはまだ所有権移転登記を備えていなかった。その後、Aは同一の甲土地をCにも売却し、Cは所有権移転登記を完了した。CがBに対する関係で「背信的悪意者」に当たる場合に関する次の記述のうち、判例に照らし、正しいものはどれか？",
            questionEn = "A sold land to B, but B had not yet registered. Subsequently, A sold the same land to C, and C completed registration. If C is considered a 'malicious bad-faith party' against B, which of the following is correct under court precedents?",
            diagramAscii = """
            [第1譲渡] (登記未了)
         ┌────────────> B
A (売主) │
         └────────────> C (登記あり・背信的悪意者)
            [第2譲渡]
  ★Cが背信的悪意者の場合: Bは「登記なくして」Cに所有権を対抗できる！
  ★Cからの転得者Dが善意の場合: Dは登記があればBに対抗できる！
""",
            optionsJa = listOf(
                "Cは登記を備えているため、たとえ背信的悪意者であっても、登記のないBに対して所有権を対抗できる。",
                "Bは登記を備えていなくても、背信的悪意者であるCに対しては自らの所有権を対抗できる。",
                "Cが背信的悪意者である場合、A・C間の売買契約は公序良俗違反として絶対的無効となり、土地は常にAに復帰する。",
                "背信的悪意者Cから甲土地を買い受けた転得者Dは、D自身が善意であっても、Cが背信的悪意者である以上、登記があってもBに対抗できない。"
            ),
            optionsEn = listOf(
                "Because C has registered, even if C is in malicious bad faith, C can assert ownership against unregistered B.",
                "Even without registration, B can assert ownership against C who is a malicious bad-faith party.",
                "If C is in malicious bad faith, the contract between A and C is void against public order, reverting title to A.",
                "A transferee D who bought from malicious C cannot assert ownership against B even if D is in good faith."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】民法第177条の「第三者」とは、登記の欠缺を主張する正当な利益を有する者を指し、単なる悪意者を超えて実質的背信性を有する「背信的悪意者」は保護されません。したがって、Bは登記なくして背信的悪意者Cに所有権を対抗できます。なお、Cからの善意の転得者Dは登記を備えればBに対抗できます。",
            explanationEn = "Correct: 2. Under Civil Code Article 177, a 'third party' does not include a malicious party acting in bad faith (who lacks legitimate interest). Therefore, B can assert ownership against C without having registered title.",
            examTipJa = "【ひっかけのツボ】「単なる悪意者（知っていただけ）」には登記がなければ対抗できませんが、「背信的悪意者（Bを害する目的等）」には登記なしで勝てます！",
            examTipEn = "Exam Tip: Mere knowledge of the prior sale (simple bad faith) still wins if registered first; only 'malicious bad faith' (acting to harm the prior buyer) loses to an unregistered buyer."
        ),

        TakkenQuestion(
            id = 5,
            category = TakkenCategory.RIGHTS,
            titleJa = "担保物権：法定地上権の成立要件",
            titleEn = "Statutory Surface Rights (Leasehold by Law)",
            questionJa = "抵当権の実行により土地と建物の所有者が異なることとなった場合に成立する「法定地上権」（民法第388条）の成立要件に関する次の記述のうち、判例の趣旨に照らし、正しいものはどれか？",
            questionEn = "Regarding the requirements for the establishment of Statutory Surface Rights (Civil Code Art 388) when land and building come to have different owners through foreclosure, which is correct?",
            diagramAscii = """
【法定地上権 成立の4大要件】
 ① 抵当権設定当時に、土地の上に「建物が存在」すること
 ② 抵当権設定当時に、土地と建物が「同一所有者」であること
 ③ 土地または建物の一方（または双方）に「抵当権が設定」されたこと
 ④ 競売（実行）により、土地と建物の「所有者が別々」になったこと
""",
            optionsJa = listOf(
                "更地に抵当権が設定された後に建物が建築された場合でも、競売時に建物が存在していれば法定地上権が成立する。",
                "抵当権設定当時に土地と建物の所有者が異なっていた場合でも、競売時に同一所有者になっていれば法定地上権が成立する。",
                "抵当権設定当時に土地の上に建物が存在し、土地と建物が同一の所有者に属していた場合、その後に競売されて別々の所有者になれば法定地上権が成立する。",
                "建物にのみ抵当権が設定された場合、土地所有者の書面による事前承諾がなければ法定地上権は成立しない。"
            ),
            optionsEn = listOf(
                "Even if a building was built after a mortgage was placed on vacant land, statutory surface rights are established if a building exists at foreclosure.",
                "Even if owners differed when mortgage was created, statutory surface rights are established if owners are the same at foreclosure.",
                "If a building existed on the land and both belonged to the same owner when mortgaged, statutory surface rights arise when foreclosure separates ownership.",
                "If a mortgage is set only on the building, statutory surface rights cannot arise without the landowner's written consent."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】民法第388条の法定地上権が成立するためには、「抵当権設定当時、土地の上に建物が存在すること」「抵当権設定当時、土地と建物が同一所有者であること」が不可欠です。更地に抵当権設定後の建築（選択肢1）や、設定時に別人所有（選択肢2）では法定地上権は成立しません。",
            explanationEn = "Correct: 3. Under Civil Code Article 388, statutory surface rights require that: (1) a building existed on the land at the time of mortgage creation, and (2) the land and building belonged to the same owner at that time.",
            examTipJa = "【暗記鉄則】「更地に抵当権設定 ➔ 後から建物建築」は絶対に法定地上権不成立！土地抵当権者の担保価値（更地価格）を保護するためです。",
            examTipEn = "Exam Tip: Setting a mortgage on bare/vacant land before constructing a building NEVER produces statutory surface rights."
        ),

        TakkenQuestion(
            id = 6,
            category = TakkenCategory.RIGHTS,
            titleJa = "債務不履行・解除：手付金（解約手付）の性質",
            titleEn = "Earnest Money (Cancellation Deposit)",
            questionJa = "買主Aが売主Bから甲土地を購入し、契約締結時に手付金200万円を交付した。手付の趣旨について特段の合意がない場合、民法の規定および判例によれば、正しいものはどれか？",
            questionEn = "Buyer A purchased land from seller B and delivered 2 million yen as earnest money at signing. With no specific agreement on the deposit type, which of the following is correct?",
            diagramAscii = """
買主 A ─── 手付金交付 ───> 売主 B
  │                          │
  ├─ 買主からの解除:          ├─ 売主からの解除:
  │  【手付の放棄】           │  【手付の倍額を現実に提供】
  │                          │
  └─────────────── 相手方が「履行に着手」するまで可能 ───────────────┘
""",
            optionsJa = listOf(
                "特段の合意がない場合、手付金は違約手付と推定され、解除には債務不履行が必要である。",
                "買主Aは、売主Bが契約の履行に着手するまでは、交付した手付金を放棄して契約を解除できる。",
                "売主Bが解除する場合、受領した手付金と同額（200万円）を返還すれば契約を解除できる。",
                "買主Aが手付放棄により契約を解除した場合、売主Bに実損害が生じていれば、BはAに対して損害賠償を請求できる。"
            ),
            optionsEn = listOf(
                "Without special agreement, earnest money is presumed to be penalty earnest money requiring default.",
                "Buyer A can cancel the contract by forfeiting the earnest money until seller B commences performance.",
                "If seller B cancels, B can do so simply by returning the same amount (2 million yen).",
                "If buyer A cancels by forfeiting earnest money, seller B can claim actual damages if any occurred."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】民法第557条第1項により、手付は原則として「解約手付」と推定されます。相手方が履行に着手するまでは、買主は手付を「放棄」し、売主は「倍額を現実に提供」して契約を解除できます。手付解除をした場合、損害賠償請求はできません（選択肢4誤り）。",
            explanationEn = "Correct: 2. Under Civil Code Art 557(1), earnest money is presumed to be a cancellation deposit. Either party can cancel until the counterparty commences performance (buyer forfeits deposit, seller offers double). No damages can be claimed upon deposit cancellation.",
            examTipJa = "【頻出ポイント】「手付解除したときは、損害賠償請求はできない！」また売主側の解除要件は「倍額の口頭通知」ではなく「倍額の現実の提供」が必要です！",
            examTipEn = "Exam Tip: Canceling via earnest money precludes claiming damages. Also, the seller must physically offer double the amount, not just state intent."
        ),

        TakkenQuestion(
            id = 7,
            category = TakkenCategory.RIGHTS,
            titleJa = "借地借家法：定期建物賃貸借（定期借家）の要件",
            titleEn = "Fixed-Term Building Lease (Teiki Shakuya)",
            questionJa = "建物の賃貸借契約において、契約の更新がなく期間満了により確定的に契約が終了する「定期建物賃貸借」（借地借家法第38条）に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Regarding a Fixed-Term Building Lease (Article 38 of Act on Land and Building Leases) where the lease terminates without renewal, which of the following is correct?",
            diagramAscii = """
【定期建物賃貸借の厳格要件】
 ① 書面（公正証書等）による契約締結が必須
 ② 契約締結に「先立って（事前）」、更新がない旨の【別紙書面】を交付して説明
 ③ 期間1年以上の場合: 満了1年前〜6ヶ月前までに「終了通知」が必要
""",
            optionsJa = listOf(
                "定期建物賃貸借契約は、口頭の合意であっても更新がない旨を明確に合意していれば有効に成立する。",
                "賃貸人は、契約締結に先立って、契約の更新がなく期間満了により終了する旨を記載した書面を交付して説明しなければならない。",
                "期間を1年未満とすることはできず、最短でも1年以上の契約期間を定めなければならない。",
                "床面積が200㎡以上の居住用建物の定期賃貸借において、賃借人はやむを得ない事情があっても中途解約することは一切できない。"
            ),
            optionsEn = listOf(
                "A fixed-term lease is valid even by oral agreement if non-renewal is clearly understood.",
                "Prior to concluding the contract, the landlord must deliver a separate written explanation stating there is no renewal.",
                "The lease period cannot be less than 1 year; at least 1 year is mandatory.",
                "In a residential lease of 200 sqm or more, the tenant can never cancel early even with unavoidable reasons."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】借地借家法第38条第2項により、定期建物賃貸借を締結する際は、あらかじめ賃貸借契約書とは「別の書面」をあらかじめ交付して「更新がなく期間満了により終了する」旨を説明しなければなりません。これを怠ると「普通借家契約（更新あり）」になってしまいます。なお、期間は1年未満でも有効です。",
            explanationEn = "Correct: 2. Under Land and Building Leases Act Art 38(2), the lessor must deliver a prior written explanation stating that the lease does not renew. Failure to do so renders it an ordinary renewable lease. The period can be under 1 year.",
            examTipJa = "【落とし穴】契約書の中に「更新しない」と書いてあってもダメ！契約書とは別の独立した書面を「事前交付＋説明」しないと定期借家にならず普通借家扱いになります！",
            examTipEn = "Exam Tip: Writing non-renewal inside the main lease contract is insufficient! A separate prior written document must be delivered and explained."
        ),

        TakkenQuestion(
            id = 8,
            category = TakkenCategory.RIGHTS,
            titleJa = "不動産登記法：登記の効力と仮登記",
            titleEn = "Real Property Registration: Provisional Registration",
            questionJa = "不動産登記法における「所有権移転の仮登記」に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Provisional Registration of Ownership Transfer under the Real Property Registration Act?",
            diagramAscii = """
[順位1] A所有権登記
[順位2] B所有権移転「仮登記」 (順位保全効あり！)
[順位3] C所有権移転登記 (本登記)
    │
    ▼ Bが本登記をした場合:
    Bが順位2の本登記となり、利害関係人Cの登記は登記官が職権で抹消する！
""",
            optionsJa = listOf(
                "仮登記には対抗力があるため、仮登記を備えれば第三者に対して自己の所有権を対抗できる。",
                "仮登記には対抗力はないが、将来本登記をしたときに備えて「順位を保全する効力」がある。",
                "仮登記をした後に第三者Cが本登記を経由した場合、仮登記権利者はもはや本登記を申請することができない。",
                "所有権移転の仮登記に基づく本登記を申請する場合、登記上の利害関係を有する第三者の承諾は一切不要である。"
            ),
            optionsEn = listOf(
                "Provisional registration has perfection power (assertive power) against third parties.",
                "Provisional registration lacks perfection power, but possesses ranking preservation power for future main registration.",
                "If third party C completes main registration after provisional registration, the provisional holder can no longer apply.",
                "To upgrade to main registration, consent from third parties with conflicting registered interests is never needed."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】仮登記には第三者に対する「対抗力」はありませんが、後日要件が整って本登記をした際に、仮登記の順位で本登記がなされる「順位保全効」があります。なお、仮登記に基づく本登記をするには、登記上の利害関係を有する第三者（Cなど）の承諾が必要です（選択肢4誤り）。",
            explanationEn = "Correct: 2. Provisional registration does not confer perfection against third parties, but preserves priority rank when converted to main registration. Consent of interested third parties is required for conversion.",
            examTipJa = "【重要】「仮登記に対抗力はない！あるのは順位保全効のみ！」本登記に昇格すると、間の第三者登記は職権抹消されます（そのため第三者の承諾が必要）。",
            examTipEn = "Exam Tip: Provisional registration has NO perfection power on its own; it only secures priority rank for when it is promoted to main registration."
        ),

        // ==========================================
        // 分野 2: 宅建業法 (免許・重説・37条・8種制限) 12問
        // ==========================================
        TakkenQuestion(
            id = 9,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "宅建業の定義：免許を要する行為",
            titleEn = "Definition of Real Estate Brokerage Business",
            questionJa = "宅地建物取引業法第2条に規定する「宅地建物取引業」の免許に関する次の記述のうち、免許を必要とするものはどれか？",
            questionEn = "Which of the following activities requires a Real Estate Brokerage License under Article 2 of the Building Lots and Buildings Transaction Business Act?",
            diagramAscii = """
【宅建業の免許要否マトリクス】
 行為＼対象  │  自ら当事者 (売買・交換) │  媒介・代理 (売買・貸借)
 ───────────┼──────────────────────────┼──────────────────────
 宅地・建物  │  要免許！                │  要免許！
 自ら賃貸    │  ★免許不要！(アパート経営)│  -
""",
            optionsJa = listOf(
                "自己所有のマンションを不特定多数の者に反復継続して賃貸する行為（自ら賃貸）。",
                "農業協同組合が、組合員の所有する宅地の売買の媒介を反復継続して行う行為。",
                "破産管財人が、破産財団に属する宅地建物の換価のために自ら売主となって売却する行為。",
                "国や地方公共団体が、公有地を分譲して不特定多数の者に売却する行為。"
            ),
            optionsEn = listOf(
                "Leasing one's own apartment units repeatedly to an unspecified number of tenants (landlording).",
                "An agricultural cooperative acting as an intermediary for sales of land owned by members.",
                "A bankruptcy trustee selling land belonging to a bankruptcy estate to liquidate assets.",
                "National or local governments selling and parceling public lands to the public."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】「宅地建物取引業」とは、不特定多数を相手に「宅地建物の売買・交換（自らまたは媒介・代理）」および「貸借の媒介・代理」を反復継続して行う行為を指します。農業協同組合であっても宅地売買の媒介を行うには免許が必要です（信託銀行等の特例とは異なる）。「自ら賃貸（大家業）」は免許不要（選択肢1誤り）、国・地方自治体や破産管財人は適用除外です。",
            explanationEn = "Correct: 2. An agricultural cooperative acting repeatedly as an intermediary for selling residential lots requires a license. Acting as a direct landlord ('self-leasing') never requires a broker license, nor does government disposition.",
            examTipJa = "【超頻出】「自ら貸借（アパート経営・ビルオーナー・転貸）」は絶対に宅建業に該当しない（免許不要）！試験で最も引っ掛かるポイントです。",
            examTipEn = "Exam Tip: 'Direct leasing' (leasing one's own real estate as landlord or subleasing) NEVER constitutes brokerage business and NEVER requires a license."
        ),

        TakkenQuestion(
            id = 10,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "免許の基準：欠格事由と5年の壁",
            titleEn = "Disqualification from Licensing (5-Year Rule)",
            questionJa = "宅地建物取引業の免許の基準に関する次の記述のうち、免許を受けることができるものはどれか？",
            questionEn = "Which of the following persons is eligible to receive a Real Estate Brokerage License?",
            diagramAscii = """
【欠格事由の5年ルール】
 ① 禁錮以上の刑（刑務所刑） ➔ 罪名を問わず、刑の執行終了から5年経過が必要
 ② 罰金刑 ➔ 「宅建業法違反」「暴力団排除法」「刑法（傷害・暴行・背任等）」は5年経過が必要
    ※ 過失傷害や道路交通法違反の罰金刑なら ➔ 免許取得可能！
""",
            optionsJa = listOf(
                "刑法第204条（傷害罪）により懲役1年・執行猶予3年の判決を受け、執行猶予期間を経過していない者。",
                "道路交通法違反により罰金30万円に処せられ、その刑の執行が終わった日から2年を経過した者。",
                "宅地建物取引業法違反により罰金20万円に処せられ、その刑の執行が終わった日から3年を経過した者。",
                "暴力団員による不当な行為の防止等に関する法律に違反して罰金に処せられ、その執行を終えてから4年を経過した者。"
            ),
            optionsEn = listOf(
                "A person sentenced to 1 year imprisonment with 3 years probation for injury, whose probation has not expired.",
                "A person fined 300,000 yen for violating the Road Traffic Act, with 2 years passed since payment.",
                "A person fined 200,000 yen for violating the Real Estate Brokerage Act, with 3 years passed since payment.",
                "A person fined under the Anti-Boryokudan Act, with 4 years passed since paying the fine."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】罰金刑で欠格事由となるのは、「宅建業法違反」「暴力団排除関係法」「刑法の特定の暴力的・財産罪（傷害・暴行・脅迫・背任など）」に限られます。道路交通法違反による罰金刑は欠格事由に該当しないため、5年を待たずに直ちに免許を受けることができます。執行猶予中（選択肢1）や業法・暴対法違反の罰金後5年未満（選択肢3, 4）は欠格です。",
            explanationEn = "Correct: 2. Traffic fines under the Road Traffic Act do not disqualify an applicant from obtaining a license. Fines under the Real Estate Act or for violent penal crimes trigger a 5-year disqualification.",
            examTipJa = "【暗記公式】「禁錮以上はすべての罪でアウト（5年）」「罰金刑は業法・暴対・暴力系刑法のみアウト（5年）」「道交法・過失傷害の罰金はセーフ（直ちにOK）」！",
            examTipEn = "Exam Tip: Imprisonment or higher disqualifies regardless of crime; fines disqualify only for Real Estate Act violations and violent/property crimes."
        ),

        TakkenQuestion(
            id = 11,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "宅地建物取引士：設置義務と専任性",
            titleEn = "Mandatory Licensed Agents (1 in 5 Rule)",
            questionJa = "宅地建物取引業者が設置すべき「専任の宅地建物取引士」の法定人数に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding the required number of full-time licensed agents under the Real Estate Brokerage Act?",
            diagramAscii = """
【事務所ごとの専任宅建士 設置基準】
  業務に従事する者「5人」ごとに「1人以上」の専任取引士が必要！
  (例: 業務従事者12人の事務所 ➔ 12÷5 = 2.4 ➔ 切り上げ「3人」必要)
  ★不足した場合: 「2週間以内」に必要な措置をとらなければならない！
""",
            optionsJa = listOf(
                "1つの事務所において業務に従事する者の数が13人である場合、専任の宅地建物取引士は最低2人置けば足りる。",
                "専任の宅地建物取引士が退職して法定人数を欠くこととなった場合、宅建業者は2週間以内に補充等の必要な措置を執らなければならない。",
                "案内所（契約を締結しない単なる物件案内の施設）であっても、業務従事者5人につき1人以上の専任取引士を置かなければならない。",
                "他の法人の常勤役員を兼任している者は、勤務時間帯が重複していなければ、自社の専任の取引士として認められる。"
            ),
            optionsEn = listOf(
                "If an office has 13 workers, having at least 2 full-time licensed agents is sufficient.",
                "If an agent leaves causing a deficit in required agents, the broker must take remedial action within 2 weeks.",
                "Even at an information booth that does not conclude contracts, 1 agent per 5 workers is required.",
                "A full-time director of another corporation can be a full-time agent if hours do not overlap."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】法第31条の3第3項により、専任の取引士の数が不足したときは、「2週間以内」に補充等必要な措置をとらなければなりません。13人の場合は「13÷5＝2.6」で切り上げて3人必要です（選択肢1誤り）。契約締結等を行わない案内所には設置義務はありません（選択肢3誤り）。他社常勤役員は専任性が認められません（選択肢4誤り）。",
            explanationEn = "Correct: 2. Under Art 31-3(3), if an office falls short of the required ratio, it must remedy the shortage within 2 weeks. For 13 workers, 13/5 = 2.6 -> 3 agents are required.",
            examTipJa = "【数値暗記】「事務所は従事者5人に1人」「契約を行う案内所は最低1人」「欠員補充は2週間以内」！この3大数字は必ず出ます。",
            examTipEn = "Exam Tip: Key numbers: 1 per 5 workers at offices; at least 1 at contract-signing booths; 2 weeks to replace vacant positions."
        ),

        TakkenQuestion(
            id = 12,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "媒介契約：専属専任・専任・一般の3類型",
            titleEn = "Types of Mediation (Brokerage) Contracts",
            questionJa = "宅地建物取引業法第34条の2に規定する「媒介契約」の3類型（専任媒介・専属専任媒介・一般媒介）に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Regarding the three types of mediation contracts (Exclusive, Full Exclusive, General) under Article 34-2 of the Act, which is correct?",
            diagramAscii = """
【媒介契約の3類型 比較表】
 項目          │ 一般媒介     │ 専任媒介     │ 専属専任媒介
 ─────────────┼──────────────┼──────────────┼──────────────
 他社への重ね依頼│ ○ 可能      │ ✕ 不可      │ ✕ 不可
 自己発見取引  │ ○ 可能      │ ○ 可能      │ ✕ 不可
 有効期間      │ 制限なし     │ 最長3ヶ月    │ 最長3ヶ月
 レインズ登録  │ 義務なし     │ 7日以内      │ 5日以内 (休業日除)
 報告義務      │ 義務なし     │ 2週間に1回以上│ 1週間に1回以上
""",
            optionsJa = listOf(
                "専任媒介契約を締結した依頼者は、自ら発見した相手方（自己発見取引）と直接売買契約を締結することができない。",
                "専属専任媒介契約の有効期間は最長6ヶ月であり、特約でこれを延長することができる。",
                "専属専任媒介契約を締結した宅建業者は、契約締結の日から休業日を除き5日以内に指定流通機構（レインズ）に登録しなければならない。",
                "一般媒介契約（明示型）を締結した場合でも、宅建業者は依頼者に対して週に1回以上の業務処理状況報告義務を負う。"
            ),
            optionsEn = listOf(
                "A client who entered an Exclusive Mediation contract cannot directly contract with a buyer found on their own.",
                "The maximum validity of a Full Exclusive contract is 6 months, extendable by agreement.",
                "Under a Full Exclusive contract, the broker must register with the Designated Real Estate Network (REINS) within 5 business days.",
                "Even under a General Mediation contract, the broker must report status at least once a week."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】専属専任媒介契約では、休業日を除き「5日以内」にレインズ登録義務があります（専任媒介は7日以内）。専任媒介では「自己発見取引」は可能（選択肢1誤り、不可なのは専属専任のみ）。有効期間はどちらも「最長3ヶ月」（選択肢2誤り）。一般媒介には報告義務はありません（選択肢4誤り）。",
            explanationEn = "Correct: 3. In Full Exclusive mediation, the broker must register with REINS within 5 business days (excluding holidays). Self-found buyers are permitted in standard Exclusive mediation. Max duration is 3 months.",
            examTipJa = "【暗記表】専任＝「7日登録・2週に1度報告・自己発見OK」。専属専任＝「5日登録・1週に1度報告・自己発見NG」。この違いを反射的に出せるように！",
            examTipEn = "Exam Tip: Exclusive: 7 days REINS, report every 2 weeks, self-found OK. Full Exclusive: 5 days REINS, report every 1 week, self-found NO."
        ),

        TakkenQuestion(
            id = 13,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "重要事項説明 (35条)：実施時期と説明主体",
            titleEn = "Article 35 Disclosure: Timing & Agent",
            questionJa = "宅地建物取引業法第35条の「重要事項の説明（重説）」に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Article 35 Important Matters Disclosure under the Act?",
            diagramAscii = """
【35条書面（重説）のルール】
 時期: 【契約が成立する前】に行う（契約後は遅すぎる！）
 相手: 買主・借主（取得しようとする者・借りようとする者）に対して行う
 主体: 【宅地建物取引士】が【宅建士証を提示】して説明する（記名も必要）
 例外: 相手方が「宅建業者（プロ）」の場合は、書面交付のみで【説明は省略可能】！
""",
            optionsJa = listOf(
                "重要事項の説明は、契約締結後遅滞なく、売主および買主の双方に対して行わなければならない。",
                "相手方が宅建業者（プロ）である場合、35条書面の交付も説明も一切行う必要がない。",
                "宅地建物取引士は、相手方から請求がない限り、宅地建物取引士証を提示せずに重要事項説明を行ってもよい。",
                "重要事項説明は、契約が成立する前までに、宅建士が相手方に取引士証を提示して行わなければならない。"
            ),
            optionsEn = listOf(
                "Disclosure must be performed promptly after contract conclusion to both seller and buyer.",
                "If the counterparty is a licensed broker, neither document delivery nor explanation is required.",
                "Unless requested, the licensed agent does not need to present their license card during explanation.",
                "Disclosure must be conducted BEFORE contract formation by an agent presenting their license card."
            ),
            correctAnswerIndex = 3,
            explanationJa = "【正解: 4】35条重要事項説明は、「契約が成立する前」に、宅地建物取引士が「宅建士証を提示」して行わなければなりません（法第35条第1項・第4項）。取引士証の提示は請求がなくても義務です（選択肢3誤り）。業者間取引の場合でも「書面の交付」は必要で、「説明」のみ省略可能です（選択肢2誤り）。",
            explanationEn = "Correct: 4. Article 35 disclosure must be conducted prior to contract conclusion by a licensed agent who presents their license card. Presentation of the card is mandatory even without request.",
            examTipJa = "【超頻出】「業者間取引（プロ同士）」では、35条書面の【交付】は必要だが【説明】は省略できる！37条書面は業者間でも省略不可！この引っかけは毎年の鉄板です。",
            examTipEn = "Exam Tip: Between licensed brokers, the oral explanation of Article 35 can be omitted, but physical delivery of the document CANNOT be omitted."
        ),

        TakkenQuestion(
            id = 14,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "37条書面 (契約書面)：必要的記載事項と重説との対比",
            titleEn = "Article 37 Contract Document vs Article 35",
            questionJa = "宅地建物取引業法第37条の書面（契約書面）に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Article 37 written contracts under the Act?",
            diagramAscii = """
【35条（重説） vs 37条（契約書） 決定的違い】
 項目        │ 35条書面 (重説)       │ 37条書面 (契約書)
 ───────────┼───────────────────────┼─────────────────────────
 交付時期    │ 契約成立「前」        │ 契約成立後「遅滞なく」
 交付相手    │ 買主・借主のみ        │ 契約当事者の「双方」
 取引士の説明│ 説明が必要            │ ★説明は「不要」（記名のみ！）
 代金の額    │ ★記載不要！(実費等のみ)│ ★必要的記載事項！
""",
            optionsJa = listOf(
                "37条書面は、契約締結後遅滞なく、宅地建物取引士がその内容を契約当事者に口頭で説明しなければならない。",
                "代金の額並びにその支払の時期及び方法は、37条書面の必要的記載事項であるが、35条書面の記載事項ではない。",
                "37条書面の交付は、売主に対しては不要であり、買主に対してのみ行えば足りる。",
                "相手方が宅地建物取引業者である場合、37条書面の交付を省略することができる。"
            ),
            optionsEn = listOf(
                "Content of the Article 37 document must be orally explained by an agent promptly after contract signing.",
                "Purchase price and timing/method of payment are mandatory in Art 37 documents, but NOT required in Art 35 disclosures.",
                "Delivery of Art 37 document is only required for the buyer, not the seller.",
                "If the counterparty is a licensed broker, delivery of Art 37 document can be omitted."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】「代金の額・支払時期・方法」は契約そのものの条件であるため37条書面には必須ですが、35条書面（物件や権利の説明）には記載不要です（交換差金・借賃は35条でも必要）。37条書面は「取引士の記名」は必要ですが「説明」は一切不要です（選択肢1誤り）。また売買双方に交付が必要（選択肢3誤り）で、業者間取引でも交付省略不可です（選択肢4誤り）。",
            explanationEn = "Correct: 2. Purchase price and payment terms are mandatory in Art 37 contracts, but not in Art 35 disclosures. Art 37 requires an agent's signature, but NO oral explanation is required.",
            examTipJa = "【一発判別】「代金の額」➔ 35条には書かない！37条には必ず書く！「取引士の説明」➔ 35条は必要！37条は説明不要！これを覚えるだけで2点取れます。",
            examTipEn = "Exam Tip: 'Purchase price': NEVER in Art 35, ALWAYS in Art 37. 'Oral explanation': REQUIRED in Art 35, NEVER required in Art 37."
        ),

        TakkenQuestion(
            id = 15,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "報酬額の制限：売買媒介の速算式計算",
            titleEn = "Brokerage Fee Limits: Quick Formula",
            questionJa = "宅建業者Aが、依頼者Bから依頼を受け、B所有の甲宅地を代金1,000万円（消費税等別）で売買する媒介契約を締結し、成約させた。AがBから受領できる報酬の限度額（消費税10%を含む）はいくらか？",
            questionEn = "Broker A mediated the sale of land for 10,000,000 yen (excluding tax). What is the maximum statutory fee (including 10% consumption tax) broker A can collect from the client?",
            diagramAscii = """
【売買代金400万円超の報酬 速算式】
  報酬限度額 = (売買代金 × 3% + 6万円) × 1.10 (消費税10%)
  
  代金1,000万円の場合:
   1,000万 × 3% = 30万円
   30万 + 6万円 = 36万円 (税抜上限)
   36万円 × 1.10 = 39.6万円 (税込上限)
""",
            optionsJa = listOf(
                "330,000円",
                "360,000円",
                "396,000円",
                "792,000円"
            ),
            optionsEn = listOf(
                "330,000 yen",
                "360,000 yen",
                "396,000 yen",
                "792,000 yen"
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】代金が400万円を超える場合の売買媒介報酬の速算式は「（代金×3％＋6万円）×1.10」です。1,000万円×3％＝30万円、これに6万円を加えて36万円。消費税10％（×1.1）を乗じると「396,000円」となります（一方の依頼者から受領できる上限額）。",
            explanationEn = "Correct: 3. For sales exceeding 4M yen, the formula is (Price x 3% + 60,000 yen) x 1.10 tax. (10,000,000 x 0.03 + 60,000) x 1.1 = 396,000 yen per party.",
            examTipJa = "【速算式暗記】200万以下＝5%、200万超400万以下＝4%+2万、400万超＝「3%+6万」！これに必ず消費税（×1.10）を掛けるのを忘れないこと！",
            examTipEn = "Exam Tip: Over 4M yen: (Price x 3% + 60,000) x 1.10. Remember to multiply by 1.10 for consumption tax!"
        ),

        TakkenQuestion(
            id = 16,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "8種制限：クーリング・オフの適用場所と期間",
            titleEn = "8 Special Restrictions: Cooling-Off Rules",
            questionJa = "宅建業者Aが自ら売主となり、宅建業者でない買主Bに分譲マンションを売却した。Bが宅建業法第37条の2に基づく「クーリング・オフ」により契約を解除できる場合はどれか？",
            questionEn = "Broker A, acting as direct seller, sold a condo to non-broker buyer B. In which of the following cases can buyer B cancel the contract under Cooling-off rules?",
            diagramAscii = """
【クーリング・オフができる場所／できない場所】
  ✕ できない場所: 業者の事務所、専任取引士のいる案内所、買主自ら申し出た「自宅・勤務先」
  ○ できる場所:   ホテルのロビー、喫茶店、レストラン、テント張り案内所、業者都合の買主自宅
  
  ★解除期限: クーリングオフ書面告知から「8日以内」＆「引渡し＋代金全額支払」前！
""",
            optionsJa = listOf(
                "買主Bが自ら「自宅で契約したい」と申し出て、Bの自宅で買受けの申込みおよび契約を締結した場合。",
                "買主Bがホテルのロビーで買受けの申込みを行い、翌日Aの事務所で売買契約を締結した場合。",
                "買主Bが専任の宅地建物取引士が設置されたAのモデルルーム案内所で申込みおよび契約を締結した場合。",
                "クーリング・オフについて書面で告知された日から10日を経過した後に解除を申し出た場合。"
            ),
            optionsEn = listOf(
                "Buyer B requested meeting at home, and signed both offer and contract at B's home.",
                "Buyer B made the purchase offer in a hotel lobby, then signed the contract at A's office the next day.",
                "Buyer B made the offer and contract at A's model room booth with a full-time agent assigned.",
                "Buyer B offered cancellation 10 days after receiving written notice of cooling-off."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】クーリング・オフの可否は「買受けの申込みをした場所」で判断します。申込みをホテルのロビー（事務所等以外の場所）で行った場合、その後に業者の事務所で契約を締結したとしても、クーリング・オフによる解除が可能です。買主自ら申し出た自宅（選択肢1）や専任取引士のいる案内所（選択肢3）は不可。告知から8日経過後（選択肢4）も行使できません。",
            explanationEn = "Correct: 2. The applicability of cooling-off is determined by the location where the PURCHASE OFFER was made. Because the offer was made at a hotel lobby, cooling-off is valid even if signing occurred at the broker's office.",
            examTipJa = "【鉄則】「申込み場所」と「契約場所」が異なる場合は、必ず【申込みをした場所】で判定する！申込みが喫茶店なら契約が事務所でもクーリング・オフ可能！",
            examTipEn = "Exam Tip: If the offer location and contract location differ, always judge based on where the OFFER was submitted."
        ),

        TakkenQuestion(
            id = 17,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "8種制限：手付金等の保全措置の要否",
            titleEn = "Protection of Deposits (Completed vs Uncompleted)",
            questionJa = "宅建業者Aが自ら売主となり、宅建業者でない買主Bと代金4,000万円の新築マンション（工事完了前）の売買契約を締結した。AがBから受領する手付金等の保全措置に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Broker A sold an uncompleted condo to non-broker B for 40M yen. Regarding statutory protection measures for earnest money, which is correct?",
            diagramAscii = """
【手付金等の保全措置 基準値マトリクス】
 工事完了「前」 (未完成物件) ➔ 代金の【5%超】 または 【1,000万円超】
 工事完了「後」 (完成物件)   ➔ 代金の【10%超】 または 【1,000万円超】
  
  代金4,000万円・未完成物件の場合:
  5% = 200万円 ➔ 200万円を超える手付金を受け取るには保全措置が必須！
""",
            optionsJa = listOf(
                "工事完了前であるため、手付金の額にかかわらず、受領前に必ず保全措置を講じなければならない。",
                "受領する手付金が150万円（代金の3.75%）である場合、Aは保全措置を講じることなく受領できる。",
                "受領する手付金が300万円（代金の7.5%）である場合、1,000万円以下であるためAは保全措置を講じる必要がない。",
                "Aが保全措置を講じる場合、信用保証委託契約、保証保険契約のほか、手付金等寄託契約によることもできる。"
            ),
            optionsEn = listOf(
                "Because construction is uncompleted, protection measures are required regardless of deposit amount.",
                "If the deposit is 1.5M yen (3.75%), broker A can receive it without protection measures.",
                "If the deposit is 3M yen (7.5%), no protection is needed because it is under 10M yen.",
                "Broker A can also use a designated escrow deposit agreement for uncompleted construction."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】工事完了前（未完成物件）では、「代金の5％超」または「1,000万円超」の手付金等を受領する場合に保全措置が必要です。150万円は4,000万円の3.75％であり、5％（200万円）以下かつ1,000万円以下であるため保全措置不要で受領できます。300万円（選択肢3）は5％を超えているため保全が必要です。未完成物件では指定保管機関への寄託は使えません（選択肢4誤り）。",
            explanationEn = "Correct: 2. For uncompleted buildings, protection is required if the deposit exceeds 5% of price OR exceeds 10M yen. 1.5M yen is under 5% (2M yen) and under 10M yen, so no protection is required.",
            examTipJa = "【超重要数値】未完成は「5％または1,000万超」、完成後は「10％または1,000万超」！また「買主への所有権登記完了後」または「業者間取引」なら保全不要！",
            examTipEn = "Exam Tip: Uncompleted: over 5% or over 10M yen. Completed: over 10% or over 10M yen. No protection needed if title is transferred or between brokers."
        ),

        TakkenQuestion(
            id = 18,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "8種制限：損害賠償額の予定等の制限（2割ルール）",
            titleEn = "Liquidated Damages Limit (20% Cap)",
            questionJa = "宅建業者Aが自ら売主となり、宅建業者でない買主Bと代金5,000万円の土地付建物の売買契約を締結する際、債務不履行による損害賠償額の予定および違約金に関する特約を定めた。この場合、業法の規定によれば、有効なものはどれか？",
            questionEn = "Broker A sold a house to non-broker B for 50M yen. Regarding a clause specifying liquidated damages and contractual penalties, which is valid under the Act?",
            diagramAscii = """
【損害賠償額の予定等の2割制限 (法第38条)】
  損害賠償額の予定 ＋ 違約金 の合算額 ≦ 代金の【20% (2割)】
  代金5,000万円の場合:
  5,000万 × 20% = 【1,000万円】 が上限！
  ★2割を超える特約を定めた場合: 2割を超える部分のみが「無効」となる！
""",
            optionsJa = listOf(
                "損害賠償額の予定額を1,200万円（代金の24%）とする特約を定めた場合、特約全体が無効となり賠償額は実損害額による。",
                "損害賠償額の予定額を800万円、違約金を400万円（合計1,200万円）とする特約を定めた場合、1,000万円を超える200万円の部分が無効となる。",
                "買主が宅建業者である場合であっても、損害賠償額の予定額は代金の20%を超えてはならない。",
                "損害賠償額の予定を定めた場合でも、実際の損害が予定額を上回ったときは、売主は実損害額との差額を追加請求できる。"
            ),
            optionsEn = listOf(
                "If set at 12M yen (24%), the entire clause is void and damages revert to actual proven losses.",
                "If liquidated damages are 8M and penalty is 4M (total 12M), only the 2M yen portion exceeding 10M is void.",
                "Even when the buyer is a licensed broker, damages cannot exceed 20%.",
                "If actual damages exceed the scheduled amount, the seller can claim the excess."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】損害賠償額の予定と違約金の合計は代金の「2割（20％）」を超えてはならず、これを超える特約をした場合は「2割を超える部分が無効」となります（全部無効ではないので選択肢1誤り）。5,000万円の2割は1,000万円なので、合計1,200万円のうち超過分の200万円が無効となり、1,000万円まで有効です。8種制限は業者間取引には適用されません（選択肢3誤り）。予定額を定めたら実損害が多くても追加請求不可です（選択肢4誤り）。",
            explanationEn = "Correct: 2. The combined sum of liquidated damages and penalties cannot exceed 20% of the purchase price. Any portion exceeding 20% is void (not the entire clause). For 50M yen, the cap is 10M yen.",
            examTipJa = "【頻出ひっかけ】「2割を超えた特約は全部無効になる」は✕！「超える部分のみが無効」が正解です！業者間取引では2割超の特約も完全に有効です。",
            examTipEn = "Exam Tip: Clauses exceeding 20% are NOT completely void; only the portion exceeding 20% is void. Does not apply between brokers."
        ),

        TakkenQuestion(
            id = 19,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "営業保証金と弁済業務保証金分担金",
            titleEn = "Business Security Deposit vs Guarantee Association",
            questionJa = "宅建業者の営業保証金制度および保証協会制度に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Business Security Deposits and the Guarantee Association?",
            diagramAscii = """
【営業保証金 vs 保証協会分担金】
 項目        │ 単独供託 (営業保証金) │ 保証協会加入 (弁済分担金)
 ───────────┼────────────────────────┼───────────────────────────
 主たる事務所│ 1,000万円              │ 60万円
 従たる事務所│ 1店につき 500万円      │ 1店につき 30万円
 供託場所    │ 主たる事務所最寄りの供託所│ 保証協会が一括供託
""",
            optionsJa = listOf(
                "営業保証金を供託所に供託した宅建業者は、供託した旨を免許権者に届け出ることなく直ちに営業を開始できる。",
                "本店1箇所と支店2箇所を有する宅建業者が保証協会に加入する場合、納付すべき弁済業務保証金分担金の額は合計120万円である。",
                "保証協会の社員（会員）である宅建業者と取引した者は、その業者が納付した分担金の額を上限として弁済を受けることができる。",
                "営業保証金の還付により不足額が生じた場合、業者は通知を受けてから2週間以内にその不足額を供託しなければならない。"
            ),
            optionsEn = listOf(
                "A broker who deposited business security funds can immediately start business without notifying the licensing authority.",
                "A broker with 1 head office and 2 branch offices joining the Guarantee Association must pay a total of 1.2M yen.",
                "A consumer dealing with an association member can only claim damages up to the amount of the deposit contribution.",
                "If a deficit occurs after a refund, the broker must deposit the deficit within 2 weeks of receiving notice."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】保証協会の弁済業務保証金分担金は、主たる事務所（本店）「60万円」、その他の事務所（支店）1店につき「30万円」です。本店1＋支店2＝60万＋(30万×2)＝「120万円」となり正しいです。供託後の届出前に営業開始は禁止（選択肢1誤り）。取引相手は営業保証金と同額（本店1,000万＋支店各500万換算）まで弁済を受けられます（選択肢3誤り）。不足額供託は通知から「2週間以内」ですが、保証協会社員の場合は「還付充当金」を納付します。",
            explanationEn = "Correct: 2. For the Guarantee Association, the required contribution is 600,000 yen for the head office and 300,000 yen per branch. 600k + (300k x 2) = 1,200,000 yen.",
            examTipJa = "【金額暗記】供託所＝「本店1,000万・支店500万」。保証協会＝「本店60万・支店30万」。保証協会に入っても消費者が弁済を受けられる枠は1,000万＋500万基準です！",
            examTipEn = "Exam Tip: Standalone: 10M yen head / 5M yen branch. Guarantee Association: 600k yen head / 300k yen branch. Consumer claim capacity remains 10M / 5M."
        ),

        TakkenQuestion(
            id = 20,
            category = TakkenCategory.BUSINESS_LAW,
            titleJa = "監督処分と罰則：指示・業務停止・免許取消し",
            titleEn = "Supervisory Dispositions: Instruction, Suspension & Revocation",
            questionJa = "宅建業法に基づく国土交通大臣または都道府県知事の監督処分に関する次の記述のうち、誤っているものはどれか？",
            questionEn = "Which of the following is INCORRECT regarding supervisory dispositions by the Minister or Prefectural Governors under the Act?",
            diagramAscii = """
【監督処分と聴聞のルール】
 ① 指示処分 / 業務停止処分 (最長1年) / 免許取消処分
 ② 監督処分を行うときは、原則としてあらかじめ【聴聞（弁明の機会）】を行わなければならない！
 ③ 業務停止・免許取消処分をしたときは、必ず【公告】しなければならない（指示処分は公告不要）。
""",
            optionsJa = listOf(
                "国土交通大臣または都道府県知事は、指示処分、業務停止処分、免許取消処分のいずれを行う場合であっても、原則としてあらかじめ公開による聴聞を行わなければならない。",
                "都道府県知事は、自らの管轄区域内で業務を行う他の知事免許の宅建業者に対しても、その区域内の業務に関して指示処分または1年以内の業務停止処分を命ずることができる。",
                "都道府県知事は、自らの管轄区域内で不正行為を行った他の知事免許の宅建業者に対して、その免許を取り消すことができる。",
                "国土交通大臣または都道府県知事は、業務停止処分または免許取消処分をしたときは、その旨を公告しなければならない。"
            ),
            optionsEn = listOf(
                "The Minister or Governor must in principle conduct a public hearing prior to issuing an instruction, suspension, or revocation.",
                "A Governor can issue an instruction or suspension up to 1 year against a broker licensed by another governor for acts within their prefecture.",
                "A Governor can revoke the license of a broker licensed by another governor who committed misconduct within their prefecture.",
                "When issuing a business suspension or revocation, the Minister or Governor must make a public notice."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【誤り（正解）: 3】「免許取消処分」を行うことができるのは、その免許を与えた【免許権者】（その業者の知事または大臣）だけです。業務地を管轄する知事は「指示処分」や「業務停止処分」は命ずることができますが、他県知事の免許を勝手に取り消すことは絶対にできません。したがって記述3が誤りです。",
            explanationEn = "Incorrect (Answer): 3. License revocation can ONLY be ordered by the specific licensing authority (the issuing Governor or Minister). A local governor where misconduct occurred can only issue an instruction or suspension, not revoke another governor's license.",
            examTipJa = "【超頻出引っかけ】「業務地知事は、指示と業務停止はできるが、免許取消しはできない（免許権者のみ）！」指示処分は公告不要、業務停止と免許取消は公告必須も併せて覚えましょう。",
            examTipEn = "Exam Tip: The governor of the place of business can issue instructions and suspensions, but CANNOT revoke a license issued by another governor."
        ),

        // ==========================================
        // 分野 3: 法令上の制限 (都市計画・建基法等) 6問
        // ==========================================
        TakkenQuestion(
            id = 21,
            category = TakkenCategory.RESTRICTIONS,
            titleJa = "都市計画法：市街化区域と用途地域13種類",
            titleEn = "City Planning Act: Urbanization Areas & Zoning",
            questionJa = "都市計画法に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding the City Planning Act?",
            diagramAscii = """
【都市計画区域の区分】
  都市計画区域
  ├── 市街化区域 ➔ すでに市街地、または10年以内に優先的・計画的に市街化を図る区域 (必ず用途地域を定める！)
  ├── 市街化調整区域 ➔ 市街化を【抑制】すべき区域 (原則として用途地域は定めない！)
  └── 非線引き区域 ➔ 区分が定められていない都市計画区域
""",
            optionsJa = listOf(
                "市街化調整区域は、すでに市街地を形成している区域及びおおむね10年以内に優先的かつ計画的に市街化を図るべき区域である。",
                "用途地域は、市街化区域内においては少なくともいずれか1つの用途地域を定めなければならず、市街化調整区域内では原則として定めない。",
                "工業専用地域内においては、住宅や学校のほか、工場の従業員のための病院を建築することができる。",
                "準都市計画区域内においては、市街化区域と市街化調整区域との区分（線引き）を定めることができる。"
            ),
            optionsEn = listOf(
                "Urbanization Control Areas are areas already urbanized or planned for priority urbanization within 10 years.",
                "Zoning must always be designated in Urbanization Promotion Areas, and is generally NOT designated in Urbanization Control Areas.",
                "In Exclusive Industrial Zones, hospitals can be built for factory employees.",
                "In Quasi-City Planning Areas, boundary demarcation between promotion and control areas can be established."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】市街化区域には「必ず用途地域を定める」こととされており、市街化を抑制する市街化調整区域には「原則として用途地域を定めない」とされています。選択肢1は市街化区域の定義です。工業専用地域には病院・学校・住宅は一切建築できません（選択肢3誤り）。準都市計画区域には線引きを定めることはできません（選択肢4誤り）。",
            explanationEn = "Correct: 2. Zoning districts must be designated in Urbanization Promotion Areas, but are generally not designated in Urbanization Control Areas. Hospitals and residences cannot be built in Exclusive Industrial Zones.",
            examTipJa = "【暗記ルール】「工業専用地域に建てられないもの：住宅・学校・病院・ホテル」！また「市街化区域＝用途地域必須」「市街化調整区域＝原則用途地域なし」は必出知識です。",
            examTipEn = "Exam Tip: Facilities never permitted in Exclusive Industrial Zones: Residences, Schools, Hospitals, Hotels."
        ),

        TakkenQuestion(
            id = 22,
            category = TakkenCategory.RESTRICTIONS,
            titleJa = "都市計画法：開発許可の規模要件と例外",
            titleEn = "Development Permission Scale Requirements",
            questionJa = "都市計画法第29条の開発許可に関する次の記述のうち、知事等の開発許可を受けなければならないものはどれか？",
            questionEn = "Which of the following development activities requires development permission from the Governor under Article 29 of the City Planning Act?",
            diagramAscii = """
【開発許可の面積基準 (これ以上で要許可)】
  ・市街化区域: 【1,000㎡以上】 (三大都市圏では500㎡以上の場合あり)
  ・市街化調整区域: 【規模にかかわらずすべて要許可】 (0㎡超)
  ・非線引き区域: 【3,000㎡以上】
  ・準都市計画区域: 【3,000㎡以上】
  ・都市計画区域外: 【10,000㎡ (1ha) 以上】
  
  ★例外: 農林漁業用建築物、公益施設（駅・図書館・公民館等）は市街化区域以外なら許可不要！
""",
            optionsJa = listOf(
                "市街化調整区域内において、農業を営む者の居住の用に供する建築物の建築を目的とする500㎡の開発行為。",
                "市街化区域内において、医療法に規定する病院の建築の用に供する目的で行う1,500㎡の開発行為。",
                "市街化区域内において、農林漁業の用に供する温室の建築を目的とする800㎡の開発行為。",
                "準都市計画区域内において、住宅の建築の用に供する目的で行う2,500㎡の開発行為。"
            ),
            optionsEn = listOf(
                "Development of 500 sqm in an Urbanization Control Area to build a home for a person engaged in agriculture.",
                "Development of 1,500 sqm in an Urbanization Promotion Area to build a medical hospital.",
                "Development of 800 sqm in an Urbanization Promotion Area to build an agricultural greenhouse.",
                "Development of 2,500 sqm in a Quasi-City Planning Area to construct residences."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】市街化区域では1,000㎡以上の開発行為は原則として許可が必要です。病院は駅や公民館のような「公益上必要な建築物の例外（許可不要）」には含まれないため、1,500㎡の開発行為は許可が必要です。農林漁業用建築物の特例は「市街化区域以外の区域」にのみ適用されるため注意（市街化調整区域の農業用住宅は許可不要で選択肢1は除外）。準都市計画区域は3,000㎡未満は許可不要です（選択肢4）。",
            explanationEn = "Correct: 2. In Urbanization Promotion Areas, development of 1,000 sqm or more requires permission. Hospitals are not exempt public utility facilities. Note that agricultural exemptions do NOT apply in Urbanization Promotion Areas.",
            examTipJa = "【猛烈ひっかけ】「農林漁業用建築物の特例（許可不要）」は【市街化区域には適用されない】！市街化区域内なら農家の家でも1,000㎡以上なら許可が必要です！",
            examTipEn = "Exam Tip: The agricultural exemption does NOT apply in Urbanization Promotion Areas. Even a farmer's house requires permission if >= 1,000 sqm."
        ),

        TakkenQuestion(
            id = 23,
            category = TakkenCategory.RESTRICTIONS,
            titleJa = "建築基準法：接道義務と2項道路セットバック",
            titleEn = "Building Standards Act: Road Access & Setback",
            questionJa = "建築基準法第42条および第43条に規定する道路および敷地の接道義務に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding road definitions and road frontage requirements under Articles 42 & 43 of the Building Standards Act?",
            diagramAscii = """
【接道義務の原則】
  建築物の敷地は、道路（幅員4m以上）に「2m以上」接しなければならない！
  
【2項道路 (みなし道路・セットバック)】
  幅員4m未満の道で特定行政庁が指定したもの:
  道の中央線から「水平距離2m」後退（セットバック）した線が道路境界線とみなされる！
  ★後退した部分（セットバック部分）は「敷地面積に算入できない」！
""",
            optionsJa = listOf(
                "建築物の敷地は、幅員4m以上の道路に少なくとも3m以上接していなければ建築することができない。",
                "幅員が4m未満であっても、建築基準法適用時に現に建築物が立ち並んでいた道で特定行政庁が指定したものは、道路とみなされる（2項道路）。",
                "2項道路に面する敷地においてセットバック（道路後退）した部分の土地は、建ぺい率および容積率の計算において敷地面積に算入することができる。",
                "接道義務は、都市計画区域および準都市計画区域の指定の有無にかかわらず、日本国内のすべての建築物に適用される。"
            ),
            optionsEn = listOf(
                "The site must touch a road of at least 4m width by 3m or more.",
                "Even if width is under 4m, existing paths designated by administrative authorities are deemed roads (Section 2 Roads).",
                "Setback land ceded along a Section 2 road can be included in site area calculations for Building Coverage and FAR.",
                "The road frontage obligation applies nationwide to all buildings regardless of City Planning designations."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】幅員4m未満であっても特定行政庁が指定した道は「2項道路（みなし道路）」とされ、中心線から2m後退することで道路とみなされます。接道幅は原則「2m以上」です（選択肢1誤り）。セットバック部分は「敷地面積から除外」され、建ぺい率・容積率の計算に算入できません（選択肢3誤り）。接道義務は都市計画区域・準都市計画区域内にのみ適用されます（集団規定のため選択肢4誤り）。",
            explanationEn = "Correct: 2. Roads under 4m width designated by the authority are deemed roads (Section 2 roads), requiring a setback of 2m from centerline. Setback areas cannot be counted toward site area for building calculations.",
            examTipJa = "【計算頻出】「セットバックした面積は敷地面積から除外する！」これを知らないと建ぺい率・容積率の計算問題で全滅します。接道長は「2m以上」です。",
            examTipEn = "Exam Tip: Land ceded by road setback is EXCLUDED from site area when calculating Building Coverage Ratio and Floor Area Ratio."
        ),

        TakkenQuestion(
            id = 24,
            category = TakkenCategory.RESTRICTIONS,
            titleJa = "建築基準法：建ぺい率の緩和（角地・防火地域）",
            titleEn = "Building Coverage Ratio Relaxations (Corner lots / Fireproof)",
            questionJa = "建築基準法第53条に規定する「建ぺい率の緩和」に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding relaxations of Building Coverage Ratio under Article 53 of the Building Standards Act?",
            diagramAscii = """
【建ぺい率緩和の2大ルール (+10% / 100%)】
 ① 特定行政庁が指定する「角地」 ➔ +10%
 ② 防火地域内の「耐火建築物等」 ➔ +10%
   ★両方に該当する場合: +10% + 10% = 【+20%】緩和！
 ③ 指定建ぺい率が80%の地域 ＋ 防火地域 ＋ 耐火建築物等 ➔ 【建ぺい率100% (制限なし)！】
""",
            optionsJa = listOf(
                "特定行政庁が指定する角地にある敷地については、都市計画で定められた建ぺい率の数値に一律で20%を加えることができる。",
                "指定建ぺい率が80%の地域内において、防火地域内にあり、かつ耐火建築物等を建築する場合、建ぺい率の制限は適用されない（実質100%）。",
                "商業地域（建ぺい率80%）内にある敷地は、建物の構造や防火地域の指定にかかわらず、常に建ぺい率100%が適用される。",
                "防火地域内にある敷地であれば、建築物が準耐火建築物であっても建ぺい率が10%緩和される。"
            ),
            optionsEn = listOf(
                "For designated corner lots, 20% is unconditionally added to the designated ratio.",
                "In an 80% designated zone, if located in a Fire Prevention District and built as fireproof, the coverage limit does not apply (100%).",
                "In commercial zones (80%), 100% coverage always applies regardless of building structure.",
                "In a Fire Prevention District, quasi-fireproof buildings always receive a 10% relaxation."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】指定建ぺい率が80％の地域内で、「防火地域」かつ「耐火建築物等」を建築する場合、建ぺい率制限は適用されず100％となります（法第53条第6項）。角地緩和は＋10％（選択肢1誤り）。商業地域であっても耐火建築物等でなければ100％にはなりません（選択肢3誤り）。防火地域内で緩和されるのは原則として「耐火建築物等」です（準耐火建築物は特定防災街区等に限られるため選択肢4誤り）。",
            explanationEn = "Correct: 2. If designated coverage is 80%, located in a Fire Prevention District, and built as a fireproof structure, the building coverage ratio restriction does not apply (effectively 100%).",
            examTipJa = "【黄金ルール】「80%地域 ＋ 防火地域 ＋ 耐火建築物 ＝ 建ぺい率100%（建蔽率無制限）！」角地（+10%）と耐火（+10%）のダブル適用（+20%）も頻出！",
            examTipEn = "Exam Tip: Golden rule: 80% zone + Fire Prevention District + Fireproof building = 100% coverage limit (no limit)."
        ),

        TakkenQuestion(
            id = 25,
            category = TakkenCategory.RESTRICTIONS,
            titleJa = "国土利用計画法：事後届出制の面積要件と手続き",
            titleEn = "National Land Use Planning Act: Post-Facto Notification",
            questionJa = "国土利用計画法第23条に基づく土地売買等の「事後届出」に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding post-facto land transaction notification under Article 23 of the National Land Use Planning Act?",
            diagramAscii = """
【事後届出の面積基準 (以上で届出必要)】
  ・市街化区域:       【2,000㎡以上】
  ・市街化調整区域:   【5,000㎡以上】
  ・非線引き都市計画: 【5,000㎡以上】
  ・都市計画区域外:   【10,000㎡ (1ha) 以上】
  
  届出人: 【買主（権利取得者）のみ】
  届出期間: 契約締結日から【2週間以内】 (契約締結日を含む！)
""",
            optionsJa = listOf(
                "市街化区域内において、一団の土地である1,500㎡の土地を買い受けた者は、知事に対して事後届出を行わなければならない。",
                "土地売買等の契約を締結した当事者の双方が、契約締結日から2週間以内に共同で知事に届け出なければならない。",
                "市街化調整区域内において、6,000㎡の土地について売買契約を締結した買主は、契約締結日から起算して2週間以内に事後届出を行わなければならない。",
                "事後届出が必要な土地売買契約を締結したにもかかわらず届出をしなかった場合、その売買契約は無効となる。"
            ),
            optionsEn = listOf(
                "A buyer acquiring 1,500 sqm in an Urbanization Promotion Area must file post-facto notification.",
                "Both parties must jointly submit notification within 2 weeks of signing.",
                "A buyer contracting for 6,000 sqm in an Urbanization Control Area must notify within 2 weeks of the contract date.",
                "If post-facto notification is omitted, the underlying sales contract becomes void."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】市街化調整区域では「5,000㎡以上」の土地取引で事後届出が必要です。6,000㎡はこれに該当し、買主は契約締結日から2週間以内に知事に届け出なければなりません。市街化区域は2,000㎡以上（選択肢1誤り）。届出義務者は「買主（権利取得者）のみ」で共同届出ではありません（選択肢2誤り）。届出を怠っても「契約自体は有効」であり、懲役・罰金の刑事罰が科されます（選択肢4誤り）。",
            explanationEn = "Correct: 3. In Urbanization Control Areas, transactions of 5,000 sqm or more require post-facto notification by the buyer within 2 weeks of contract conclusion. Omitting notification does not invalidate the contract, but incurs criminal penalties.",
            examTipJa = "【超頻出4大ポイント】①面積基準「2千・5千・5千・1万」②届出義務者は「買主のみ」③期限は「契約から2週間」④届出を忘れても「契約は有効（罰則あり）」！",
            examTipEn = "Exam Tip: Key numbers: 2,000 / 5,000 / 5,000 / 10,000 sqm. Buyer only submits. 2 weeks deadline. Contract remains valid even if unnotified."
        ),

        TakkenQuestion(
            id = 26,
            category = TakkenCategory.RESTRICTIONS,
            titleJa = "農地法：3条・4条・5条の許可要件と権限者",
            titleEn = "Agricultural Land Act: Articles 3, 4 & 5",
            questionJa = "農地法第3条、第4条、第5条に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Articles 3, 4, and 5 of the Agricultural Land Act?",
            diagramAscii = """
【農地法 3条・4条・5条の整理マトリクス】
 条文 │ 目的                     │ 許可権者
 ─────┼──────────────────────────┼───────────────────────
 3条  │ 農地を農地のまま権利移動 │ 【農業委員会】
 4条  │ 自分の農地を転用 (宅地等)│ 【都道府県知事等】
 5条  │ 転用目的で権利移動 (売買)│ 【都道府県知事等】
 
 ★市街化区域内の農地特例: 4条・5条は知事許可不要で【農業委員会への事前届出】で足りる！
""",
            optionsJa = listOf(
                "農地を農地のまま売買する場合（第3条）、都道府県知事等の許可を受けなければならない。",
                "自己所有の農地を宅地に転用する場合（第4条）、農地が市街化区域内にあるときは、都道府県知事の許可を受けなければならない。",
                "市街化区域内にある農地を宅地に転用する目的で買い受ける場合（第5条）、あらかじめ農業委員会に届け出れば知事等の許可は不要である。",
                "農地法第3条の許可を受けずに締結した農地の売買契約であっても、当事者間においては私法上有効である。"
            ),
            optionsEn = listOf(
                "Selling agricultural land to remain as agricultural land (Article 3) requires Prefectural Governor permission.",
                "Converting own farm land to housing (Article 4) in an Urbanization Promotion Area requires Governor permission.",
                "Purchasing farmland to convert to housing (Article 5) in an Urbanization Promotion Area requires only prior notification to Agricultural Commission.",
                "Contracts concluded without Article 3 permission remain privately valid between parties."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】市街化区域内の農地については、市街化を推進する区域であるため、第4条および第5条の転用について「あらかじめ農業委員会へ届出」をすれば、都道府県知事等の許可を受ける必要はありません。第3条（農地➔農地）の許可権者は「農業委員会」です（選択肢1誤り）。3条および5条の許可のない売買契約は「無効（効力を生じない）」です（選択肢4誤り）。",
            explanationEn = "Correct: 3. For farmland within an Urbanization Promotion Area, Articles 4 and 5 conversions do not require Governor permission if prior notification is made to the Agricultural Commission. Contracts violating Art 3 or 5 are void.",
            examTipJa = "【一発整理】3条は「農業委員会」、4条・5条は「知事等」。ただし「市街化区域内」の4条・5条は「農業委員会への事前届出」でOK！許可なし3条・5条契約は「無効」！",
            examTipEn = "Exam Tip: Art 3: Agricultural Commission. Art 4 & 5: Governor. Exemption: In Urbanization Promotion Areas, Art 4 & 5 only require prior notice to Agricultural Commission."
        ),

        // ==========================================
        // 分野 4: 税・その他 (不動産取得税・機構等) 4問
        // ==========================================
        TakkenQuestion(
            id = 27,
            category = TakkenCategory.TAX_OTHERS,
            titleJa = "不動産取得税：課税標準と免税点",
            titleEn = "Real Estate Acquisition Tax: Tax Base & Exemptions",
            questionJa = "地方税法に規定する「不動産取得税」に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Real Estate Acquisition Tax under the Local Tax Act?",
            diagramAscii = """
【不動産取得税のポイント】
 課税主体: 【都道府県】 (市町村ではない！)
 課税標準: 【固定資産課税台帳の登録価格】 (実際の売買価格や建築費ではない！)
 免税点:
  ・土地: 10万円未満
  ・家屋(建築): 23万円未満
  ・家屋(売買・贈与): 12万円未満
 ★相続による不動産取得: 【非課税】！
""",
            optionsJa = listOf(
                "不動産取得税は、不動産の所在する市町村が課税する市町村税である。",
                "不動産取得税の課税標準は、不動産を実際に購入したときの実際の売買価格面である。",
                "相続により不動産を取得した場合、登記の有無にかかわらず不動産取得税が課税される。",
                "土地の取得に係る不動産取得税の免税点は、取得した土地の課税標準となるべき額が10万円未満の場合である。"
            ),
            optionsEn = listOf(
                "Real Estate Acquisition Tax is a municipal tax levied by local cities.",
                "The tax base is the actual purchase price paid for the real estate.",
                "Acquiring real estate through inheritance is subject to Real Estate Acquisition Tax.",
                "The tax exemption threshold for land acquisition is a tax base of less than 100,000 yen."
            ),
            correctAnswerIndex = 3,
            explanationJa = "【正解: 4】不動産取得税の免税点は、土地「10万円未満」、新築・増改築家屋「23万円未満」、売買・贈与等による家屋取得「12万円未満」です。課税主体は「都道府県」です（市町村税である固定資産税との混同に注意・選択肢1誤り）。課税標準は「固定資産税課税台帳の登録価格」です（選択肢2誤り）。相続による取得は「非課税」です（選択肢3誤り）。",
            explanationEn = "Correct: 4. The tax exemption limit for land acquisition is less than 100,000 yen. It is a prefectural tax, based on the registered assessment value, and inheritance is completely exempt from this tax.",
            examTipJa = "【暗記ポイント】「不動産取得税＝都道府県税」「固定資産税＝市町村税」「課税標準＝台帳登録価格（時価・実勢価格ではない）」「相続＝非課税」！",
            examTipEn = "Exam Tip: Acquisition tax = Prefectural tax. Property tax = Municipal tax. Tax base = Assessed value (not market price). Inheritance = Exempt."
        ),

        TakkenQuestion(
            id = 28,
            category = TakkenCategory.TAX_OTHERS,
            titleJa = "印紙税：課税文書と記載金額の判定",
            titleEn = "Stamp Tax: Taxable Documents & Stated Amounts",
            questionJa = "印紙税法における課税文書および印紙税の納付に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding Stamp Tax under the Stamp Tax Act?",
            diagramAscii = """
【印紙税の課税判定】
 ① 売買契約書（1号文書）、工事請負契約書（2号文書） ➔ 課税！
 ② 領収証（17号文書） ➔ 5万円未満は非課税！営業に関しないものは非課税！
 ③ 記載金額:
   ・消費税額が明記されている場合 ➔ 【消費税抜きの金額】が記載金額！
   ・建物の賃貸借契約書 ➔ 【非課税】（土地の賃貸借契約書は課税！）
""",
            optionsJa = listOf(
                "建物の賃貸借契約書を作成した場合、月額賃料や敷金の額にかかわらず、印紙税が課税される。",
                "土地の売買契約書に「売買金額5,500万円（うち消費税等500万円）」と明記されている場合、印紙税の課税標準となる記載金額は5,000万円となる。",
                "印紙税の課税文書に収入印紙を貼り付けなかった場合、その文書に基づく契約自体が無効となる。",
                "契約書の「写し（コピー）」を作成した場合、当事者の署名押印や契約成立の証明目的であっても、常に非課税である。"
            ),
            optionsEn = listOf(
                "Building lease contracts are subject to stamp tax regardless of monthly rent.",
                "In a land sales contract stating '55M yen (including 5M consumption tax)', the taxable stated amount is 50M yen.",
                "If revenue stamps are not attached, the contract itself becomes legally void.",
                "Duplicate copies (photocopies) of a contract are always exempt even if signed and sealed."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【正解: 2】消費税額等が区分記載されている場合、印紙税の記載金額は「消費税抜き」の金額となります。5,500万円から500万円を控除した「5,000万円」が記載金額です。「建物の賃貸借契約書」は印紙税法上非課税です（土地賃貸借は課税・選択肢1誤り）。印紙を貼らなくても過怠税（原則3倍）が徴収されるだけで「契約は有効」です（選択肢3誤り）。契約の成立を証するコピーは課税文書です（選択肢4誤り）。",
            explanationEn = "Correct: 2. When consumption tax is clearly broken out, the taxable stated amount is the net amount excluding tax (50M yen). Building lease contracts are tax-exempt. Failure to attach stamps does NOT invalidate contracts.",
            examTipJa = "【超頻出】「建物の賃貸借契約書は非課税！土地の賃貸借契約書は課税！」「印紙を貼らなくても契約は有効（3倍の過怠税）！」この2問は鉄板です。",
            examTipEn = "Exam Tip: Building lease contracts are tax-exempt; land lease contracts are taxable. Failure to affix stamps triggers penalty tax but contract remains valid."
        ),

        TakkenQuestion(
            id = 29,
            category = TakkenCategory.TAX_OTHERS,
            titleJa = "住宅金融支援機構：業務範囲とフラット35",
            titleEn = "Japan Housing Finance Agency (Flat 35)",
            questionJa = "独立行政法人住宅金融支援機構法に基づく住宅金融支援機構の業務に関する次の記述のうち、誤っているものはどれか？",
            questionEn = "Which of the following is INCORRECT regarding the operations of the Japan Housing Finance Agency under the law?",
            diagramAscii = """
【住宅金融支援機構の業務範囲】
 ○ 証券化支援業務（買取型・保証型・フラット35）
 ○ 災害復興住宅資金の直接融資
 ○ 財形住宅貸付業務
 ✕ 民間金融機関と競合する「一般の住宅新築・購入資金の直接融資」は行わない！
""",
            optionsJa = listOf(
                "機構は、民間金融機関が貸し付けた長期固定金利の住宅ローン債権を買い取る証券化支援業務（買取型）を行っている。",
                "機構は、自ら居住する住宅を建設または購入しようとする一般の個人に対して、民間金融機関と競合する通常の住宅ローンの直接融資を幅広く行っている。",
                "機構は、災害により住宅に被害を受けた者に対する災害復興建築物の建設資金の直接貸付け業務を行っている。",
                "機構は、住宅融資保険法に基づく保険関係の成立の引受けを行っている。"
            ),
            optionsEn = listOf(
                "The Agency conducts securitization support operations (purchase type) buying long-term fixed-rate mortgage loans from private banks.",
                "The Agency broadly offers direct financing for general home purchases in direct competition with private financial institutions.",
                "The Agency provides direct loans to victims of disasters for disaster-recovery housing reconstruction.",
                "The Agency underwrites housing loan insurance under the Housing Loan Insurance Act."
            ),
            correctAnswerIndex = 1,
            explanationJa = "【誤り（正解）: 2】住宅金融支援機構は、民間金融機関の活動を支援することを主眼としており、民間と競合する「一般の住宅取得資金の直接融資」は行っていません（民間ローンの債権買取によるフラット35を支援）。直接融資を行うのは「災害復興資金」「都市再生・耐震改修」「財形住宅融資」などの限定的な分野に限られます。",
            explanationEn = "Incorrect (Answer): 2. The Agency does NOT provide direct general home purchase loans competing with commercial banks. It supports private lenders through securitization (Flat 35 purchase/guarantee). Direct loans are strictly limited to disaster recovery, seismic retrofits, etc.",
            examTipJa = "【定番ひっかけ】「機構は一般個人への直接融資を行っている」は原則✕！民間銀行のローンを買い取る「証券化支援」が主業務です。直接融資は災害復興など例外のみ。",
            examTipEn = "Exam Tip: The Agency generally does NOT lend directly to individuals; its primary role is purchasing mortgage bonds from private banks (securitization)."
        ),

        TakkenQuestion(
            id = 30,
            category = TakkenCategory.TAX_OTHERS,
            titleJa = "景品表示法：不動産の表示規約（徒歩所要時間・特定事項）",
            titleEn = "Fair Competition Code: Walking Time & Disclosures",
            questionJa = "「不当景品類及び不当表示防止法」に基づく「不動産の表示に関する公正競争規約」に関する次の記述のうち、正しいものはどれか？",
            questionEn = "Which of the following is correct regarding the Fair Competition Code for Real Estate Representations under the Act Against Unjustifiable Premiums and Misleading Representations?",
            diagramAscii = """
【不動産広告の表示ルール】
 ・駅からの徒歩所要時間: 【道路距離80mにつき1分】 (端数は切り上げ！)
   (例: 駅まで道路距離350m ➔ 350÷80 = 4.375 ➔ 切り上げて「5分」！)
 ・「新築」と表示できる条件:
   ① 建築後【1年未満】
   ② 【未入居】（誰も住んだことがない）
   ※ 建築後6ヶ月でも1度でも居住されたら「新築」不可！
""",
            optionsJa = listOf(
                "駅から物件までの徒歩所要時間は、直線距離80mにつき1分として計算し、1分未満の端数は切り捨てて表示する。",
                "駅から物件までの道路距離が450mである場合、徒歩所要時間は「徒歩5分」と表示することができる。",
                "建築後1年未満であっても、既に人が居住したことのある住宅は「新築」と表示することはできない。",
                "高圧電線下の土地であっても、電力会社の送電に支障がなければ、広告において高圧線下である旨を明示する必要はない。"
            ),
            optionsEn = listOf(
                "Walking time from the station is calculated as 1 minute per 80m of straight-line distance, truncating fractions.",
                "If road distance from the station is 450m, walking time may be displayed as '5 minutes walk'.",
                "Even within 1 year after construction, a house that has been inhabited can never be advertised as 'New'.",
                "High-voltage power line lands need not disclose line presence if power transmission is unaffected."
            ),
            correctAnswerIndex = 2,
            explanationJa = "【正解: 3】規約において「新築」とは、「建築後1年未満」かつ「未入居（居住の用に供されたことがない）」の双方を満たす必要があります。一度でも人が住んだ住宅は建築後1年未満であっても新築と表示できません。徒歩時間は「道路距離80m＝1分」で計算し端数は「切り上げ」です（450÷80＝5.625 ➔ 徒歩6分となり選択肢2誤り）。高圧電線下は明示義務があります（選択肢4誤り）。",
            explanationEn = "Correct: 3. Under the code, 'New Construction' requires being under 1 year old AND uninhabited. Once lived in, it can no longer be advertised as new. Walking time uses road distance (80m = 1 min), rounding up any fraction.",
            examTipJa = "【暗記公式】「徒歩時間は道路距離80mで1分、端数は切り上げ！」「新築＝建築1年未満 ＋ 未入居（住んだら即中古）！」実務でも役立つ必須知識です。",
            examTipEn = "Exam Tip: Walking distance: 80 meters of road distance = 1 minute (round UP any fraction). 'New' = built within 1 year AND never occupied."
        )
    )
}
'''

with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
    f.write(content)

print(f"Generated {OUTPUT_FILE} with 30 comprehensive questions.")
