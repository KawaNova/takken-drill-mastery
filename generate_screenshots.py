import os
from PIL import Image, ImageDraw, ImageFont

def make_screenshot(title_text, subtitle_text, content_type, filename):
    w, h = 1080, 2400
    img = Image.new('RGBA', (w, h), (15, 23, 42, 255)) # #0F172A
    draw = ImageDraw.Draw(img)

    # Fonts
    font_bold = "C:/Windows/Fonts/meiryob.ttc"
    if not os.path.exists(font_bold):
        font_bold = "C:/Windows/Fonts/arialbd.ttf"
        
    font_header_title = ImageFont.truetype(font_bold, 54)
    font_header_sub = ImageFont.truetype(font_bold, 34)
    font_card_title = ImageFont.truetype(font_bold, 36)
    font_card_body = ImageFont.truetype(font_bold, 28)
    font_mono = ImageFont.truetype("C:/Windows/Fonts/consola.ttf", 26)

    # Header Banner
    draw.text((60, 100), title_text, fill=(255, 255, 255), font=font_header_title)
    draw.text((60, 180), subtitle_text, fill=(251, 191, 36), font=font_header_sub)

    # Phone Frame Container (x: 60 ~ 1020, y: 280 ~ 2300)
    fx_l, fy_t, fx_r, fy_b = 60, 280, 1020, 2280
    draw.rounded_rectangle([fx_l, fy_t, fx_r, fy_b], radius=40, fill=(30, 41, 59, 255), outline=(71, 85, 105, 255), width=4)

    # Top Status Bar inside phone
    draw.rounded_rectangle([fx_l + 30, fy_t + 25, fx_r - 30, fy_t + 70], radius=10, fill=(15, 23, 42, 200))
    draw.text((fx_l + 50, fy_t + 32), "🏡 宅建士 突破特訓 (Takken Drill)", fill=(245, 158, 11), font=font_card_body)

    if content_type == "home":
        # Mastery progress box
        draw.rounded_rectangle([fx_l + 30, fy_t + 100, fx_r - 30, fy_t + 380], radius=24, fill=(15, 23, 42, 255), outline=(71, 85, 105, 255), width=2)
        draw.text((fx_l + 60, fy_t + 130), "全体習得ステータス", fill=(148, 163, 184), font=font_card_body)
        draw.text((fx_l + 60, fy_t + 180), "24 / 30 問達成 (80%)", fill=(251, 191, 36), font=font_card_title)
        
        # Progress bar
        draw.rounded_rectangle([fx_l + 60, fy_t + 250, fx_r - 60, fy_t + 275], radius=12, fill=(51, 65, 85))
        draw.rounded_rectangle([fx_l + 60, fy_t + 250, fx_l + 60 + int((fx_r - 120) * 0.8), fy_t + 275], radius=12, fill=(245, 158, 11))
        
        # Stat items
        draw.text((fx_l + 80, fy_t + 305), "正答率: 88%", fill=(255, 255, 255), font=font_card_body)
        draw.text((fx_l + 420, fy_t + 305), "要復習: 3件", fill=(248, 113, 113), font=font_card_body)
        draw.text((fx_l + 700, fy_t + 305), "早見表: 24選", fill=(56, 189, 248), font=font_card_body)

        # Big CTA Button
        draw.rounded_rectangle([fx_l + 30, fy_t + 410, fx_r - 30, fy_t + 520], radius=20, fill=(245, 158, 11))
        draw.text((fx_l + 250, fy_t + 445), "⚡ 全30問 総仕上げ特訓を開始", fill=(15, 23, 42), font=font_card_title)

        # 4 Category cards
        cats = [
            ("権利関係 (民法・借地借家法等)", "8問収録 / 本試験配点 約14点", (59, 130, 246)),
            ("宅建業法 (免許・重説・37条・8種)", "12問収録 / 本試験配点 約20点", (245, 158, 11)),
            ("法令上の制限 (都市計画・建基法等)", "6問収録 / 本試験配点 約8点", (16, 185, 129)),
            ("税・その他 (取得税・印紙税・機構)", "4問収録 / 本試験配点 約8点", (139, 92, 246))
        ]
        for i, (cname, csub, col) in enumerate(cats):
            cy = fy_t + 560 + i * 230
            draw.rounded_rectangle([fx_l + 30, cy, fx_r - 30, cy + 200], radius=20, fill=(15, 23, 42, 255), outline=col, width=2)
            draw.ellipse([fx_l + 60, cy + 40, fx_l + 84, cy + 64], fill=col)
            draw.text((fx_l + 105, cy + 35), cname, fill=(255, 255, 255), font=font_card_title)
            draw.text((fx_l + 105, cy + 95), csub, fill=(148, 163, 184), font=font_card_body)
            # mini bar
            draw.rounded_rectangle([fx_l + 105, cy + 145, fx_r - 80, cy + 160], radius=8, fill=(51, 65, 85))
            draw.rounded_rectangle([fx_l + 105, cy + 145, fx_l + 105 + int((fx_r - 185) * (0.75 - i*0.1)), cy + 160], radius=8, fill=col)

    elif content_type == "quiz":
        # Question card
        draw.text((fx_l + 40, fy_t + 110), "第4問: 二重譲渡と背信的悪意者", fill=(251, 191, 36), font=font_card_title)
        q_text = "Aは甲土地をBに売却したがBは未登記。その後AはCに同一土地を二重売却しCが先に登記完了した。CがBに対する背信的悪意者の場合、正しいものはどれか？"
        # simple wrap
        draw.text((fx_l + 40, fy_t + 170), q_text[:38], fill=(255, 255, 255), font=font_card_body)
        draw.text((fx_l + 40, fy_t + 220), q_text[38:], fill=(255, 255, 255), font=font_card_body)

        # ASCII diagram box
        draw.rounded_rectangle([fx_l + 30, fy_t + 290, fx_r - 30, fy_t + 620], radius=16, fill=(10, 15, 29), outline=(30, 58, 138), width=2)
        diagram_lines = [
            " [第1売買] (未登記)",
            "A ───────────────> B",
            "│",
            "└────────────────> C (背信的悪意者・登記あり)",
            " [第2売買]",
            "★Cが背信的悪意者の場合: Bは登記なくして勝てる！"
        ]
        for idx, line in enumerate(diagram_lines):
            draw.text((fx_l + 60, fy_t + 320 + idx * 45), line, fill=(226, 232, 240), font=font_mono)

        # 4 Options
        options = [
            (False, "1. Cは登記を備えているため、Bに対して所有権を対抗できる。"),
            (True, "2. Bは登記を備えていなくても、背信的悪意者Cに所有権を対抗できる。"),
            (False, "3. A・C間の売買契約は公序良俗違反として絶対的無効となる。"),
            (False, "4. 善意の転得者Dであっても、登記があってもBに対抗できない。")
        ]
        for idx, (is_ans, opt_str) in enumerate(options):
            oy = fy_t + 660 + idx * 190
            border_col = (16, 185, 129) if is_ans else (71, 85, 105)
            bg_col = (16, 185, 129, 40) if is_ans else (15, 23, 42)
            draw.rounded_rectangle([fx_l + 30, oy, fx_r - 30, oy + 160], radius=16, fill=bg_col, outline=border_col, width=3 if is_ans else 2)
            draw.text((fx_l + 50, oy + 45), opt_str[:26], fill=(255, 255, 255), font=font_card_body)
            draw.text((fx_l + 50, oy + 95), opt_str[26:], fill=(255, 255, 255), font=font_card_body)

    elif content_type == "explanation":
        # Success badge
        draw.rounded_rectangle([fx_l + 30, fy_t + 100, fx_r - 30, fy_t + 220], radius=20, fill=(16, 185, 129, 40), outline=(16, 185, 129), width=3)
        draw.text((fx_l + 60, fy_t + 140), "正解！ 肢2が正しい記述です", fill=(16, 185, 129), font=font_card_title)

        # Full explanation
        draw.rounded_rectangle([fx_l + 30, fy_t + 250, fx_r - 30, fy_t + 850], radius=20, fill=(15, 23, 42), outline=(71, 85, 105), width=2)
        draw.text((fx_l + 60, fy_t + 290), "【判例・民法177条の解説】", fill=(251, 191, 36), font=font_card_title)
        expl_lines = [
            "民法177条の「第三者」とは、登記の欠缺を主張する",
            "正当な利益を有する者を指します。",
            "単なる悪意者（知っていただけ）なら登記が優先しますが、",
            "実質的背信性を有する「背信的悪意者」は保護されません。",
            "したがって、第1買主Bは登記なくしてCに所有権を",
            "対抗することができます。",
            "",
            "なお、背信的悪意者Cからの転得者Dが善意である場合、",
            "Dは登記を備えればBに対抗することができます。"
        ]
        for idx, line in enumerate(expl_lines):
            draw.text((fx_l + 60, fy_t + 360 + idx * 48), line, fill=(226, 232, 240), font=font_card_body)

        # Exam Tip Box
        draw.rounded_rectangle([fx_l + 30, fy_t + 890, fx_r - 30, fy_t + 1300], radius=20, fill=(180, 83, 9, 50), outline=(245, 158, 11), width=3)
        draw.text((fx_l + 60, fy_t + 930), "⚡ 本試験ひっかけのツボ (Exam Tip)", fill=(251, 191, 36), font=font_card_title)
        tip_lines = [
            "「単なる悪意者」と「背信的悪意者」を絶対に混同しないこと！",
            "",
            "・単なる悪意者（知っているだけ） ➔ 登記で勝敗決定（登記勝ち）",
            "・背信的悪意者（害する目的等）   ➔ 未登記でもBの勝ち！",
            "",
            "【過去問頻出トラップ】",
            "「背信的悪意者からの転得者は常に負ける」は✕！",
            "転得者D自身が善意なら登記があればBに勝てます！"
        ]
        for idx, line in enumerate(tip_lines):
            draw.text((fx_l + 60, fy_t + 1000 + idx * 42), line, fill=(254, 243, 199), font=font_card_body)

    elif content_type == "tools":
        # Interactive Simulator Section
        draw.text((fx_l + 40, fy_t + 100), "📐 権利関係・業法シミュレータ", fill=(251, 191, 36), font=font_card_title)
        draw.rounded_rectangle([fx_l + 30, fy_t + 160, fx_r - 30, fy_t + 700], radius=20, fill=(10, 15, 29), outline=(30, 58, 138), width=2)
        
        sim_lines = [
            "【35条 (重説) vs 37条 (契約書) 対比】",
            "・35条: 契約成立「前」に「宅建士が説明(証提示)」",
            "・37条: 契約成立後「遅滞なく」双方に交付",
            "         ★宅建士の記名のみ！説明は一切不要！",
            "",
            "【代金の額の記載】",
            "・35条: ★記載不要！",
            "・37条: ★必要的記載事項！"
        ]
        for idx, line in enumerate(sim_lines):
            draw.text((fx_l + 60, fy_t + 190 + idx * 52), line, fill=(226, 232, 240), font=font_mono)

        # Cheat sheet list preview
        draw.text((fx_l + 40, fy_t + 750), "📋 宅建必須早見表 (全24選・コピー対応)", fill=(56, 189, 248), font=font_card_title)
        
        cheats = [
            ("報酬額速算式 (400万超)", "(売買代金 × 3% + 6万円) × 1.10", (245, 158, 11)),
            ("手付金保全措置", "未完成: 5%超 / 完成: 10%超 または1000万超", (16, 185, 129)),
            ("クーリング・オフ", "事務所等以外・買主自発自宅NG・8日以内", (239, 68, 68)),
            ("開発許可面積", "市街化: 1000㎡ / 調整: 全規模要許可", (139, 92, 246)),
            ("専任の宅建士", "従事者5人に1人以上・不足時2週間以内", (59, 130, 246))
        ]
        for idx, (title, formula, col) in enumerate(cheats):
            cy = fy_t + 820 + idx * 190
            draw.rounded_rectangle([fx_l + 30, cy, fx_r - 30, cy + 160], radius=16, fill=(15, 23, 42), outline=(71, 85, 105), width=2)
            draw.text((fx_l + 60, cy + 30), title, fill=(255, 255, 255), font=font_card_title)
            draw.text((fx_l + 60, cy + 90), formula, fill=col, font=font_card_body)

    out_dir = r"c:\Users\Kawamoto\Documents\AgentAIDev\mobile-apps\028_takken-drill\store_assets\play"
    os.makedirs(out_dir, exist_ok=True)
    out_path = os.path.join(out_dir, filename)
    img.save(out_path)
    print("Saved", out_path)

if __name__ == "__main__":
    make_screenshot("宅建士 突破特訓", "権利・業法・法令・税 全30問完全制覇", "home", "screenshot_1.png")
    make_screenshot("ASCII相関図 ＆ 4択演習", "本試験の複雑な当事者関係をクリアに可視化", "quiz", "screenshot_2.png")
    make_screenshot("全肢解説 ＆ ひっかけのツボ", "合否を分ける重要トラップをExam Tipで完全攻略", "explanation", "screenshot_3.png")
    make_screenshot("合格ツール ＆ 必須早見表", "35条vs37条シミュレータ＆報酬速算式24選", "tools", "screenshot_4.png")
    print("All 4 screenshots generated successfully!")
