import os
from PIL import Image, ImageDraw, ImageFont

def create_feature_graphic(width=1024, height=500):
    img = Image.new('RGBA', (width, height), (15, 23, 42, 255)) # #0F172A
    draw = ImageDraw.Draw(img)

    # Ambient Glow
    glow_overlay = Image.new('RGBA', (width, height), (0, 0, 0, 0))
    glow_draw = ImageDraw.Draw(glow_overlay)
    
    # Left amber glow
    for r in range(250, 0, -10):
        alpha = int(30 * (1.0 - r / 250))
        glow_draw.ellipse([180 - r, 250 - r, 180 + r, 250 + r], fill=(245, 158, 11, alpha))
        
    # Right blue glow
    for r in range(280, 0, -10):
        alpha = int(25 * (1.0 - r / 280))
        glow_draw.ellipse([850 - r, 200 - r, 850 + r, 200 + r], fill=(30, 58, 138, alpha))
        
    img = Image.alpha_composite(img, glow_overlay)
    draw = ImageDraw.Draw(img)

    # Architectural Badge Symbol on the Left (x: 80 ~ 300)
    # Background High-rise building
    b_l, b_t, b_r, b_b = 200, 110, 290, 350
    draw.rounded_rectangle([b_l, b_t, b_r, b_b], radius=10, fill=(30, 58, 138, 230), outline=(56, 189, 248, 255), width=4)
    for row in range(5):
        for col in range(2):
            wx = b_l + 18 + col * 36
            wy = b_t + 25 + row * 40
            draw.rounded_rectangle([wx, wy, wx + 24, wy + 22], radius=4, fill=(56, 189, 248, 220))

    # Foreground House
    h_cx = 140
    roof_peak = (h_cx, 130)
    roof_l = (60, 210)
    roof_r = (220, 210)
    draw.rounded_rectangle([75, 205, 205, 350], radius=8, fill=(217, 119, 6, 250), outline=(251, 191, 36, 255), width=5)
    draw.polygon([roof_peak, roof_r, roof_l], fill=(245, 158, 11, 255))
    draw.line([roof_l, roof_peak, roof_r], fill=(254, 243, 199, 255), width=6)
    
    # Door & Window
    draw.rounded_rectangle([115, 260, 165, 350], radius=6, fill=(15, 23, 42, 255), outline=(251, 191, 36, 255), width=3)
    draw.ellipse([h_cx - 16, 175 - 16, h_cx + 16, 175 + 16], fill=(254, 243, 199, 255), outline=(180, 83, 9, 255), width=3)

    # Verification Seal Badge
    seal_cx, seal_cy, seal_r = 260, 310, 48
    draw.ellipse([seal_cx - seal_r, seal_cy - seal_r, seal_cx + seal_r, seal_cy + seal_r], fill=(251, 191, 36, 255), outline=(254, 243, 199, 255), width=4)
    draw.ellipse([seal_cx - 38, seal_cy - 38, seal_cx + 38, seal_cy + 38], fill=(16, 185, 129, 255))
    draw.line([(seal_cx - 16, seal_cy + 2), (seal_cx - 5, seal_cy + 14), (seal_cx + 18, seal_cy - 12)], fill=(255, 255, 255, 255), width=6, joint="curve")

    # Fonts
    font_bold = "C:/Windows/Fonts/meiryob.ttc"
    if not os.path.exists(font_bold):
        font_bold = "C:/Windows/Fonts/arialbd.ttf"
        
    font_title = ImageFont.truetype(font_bold, 40)
    font_subtitle = ImageFont.truetype(font_bold, 22)
    font_body = ImageFont.truetype(font_bold, 17)
    font_badge = ImageFont.truetype(font_bold, 13)

    # Right Content Area (x: 350 ~ 980)
    # Category Pills
    categories = [("権利関係", (59, 130, 246)), ("宅建業法", (245, 158, 11)), ("法令制限", (16, 185, 129)), ("税・その他", (139, 92, 246))]
    cx_pill = 360
    for cat_name, col in categories:
        bbox = draw.textbbox((0, 0), cat_name, font=font_badge)
        pw = bbox[2] - bbox[0] + 16
        draw.rounded_rectangle([cx_pill, 70, cx_pill + pw, 96], radius=6, fill=col)
        draw.text((cx_pill + 8, 73), cat_name, fill=(255, 255, 255), font=font_badge)
        cx_pill += pw + 12

    # Main Titles
    draw.text((360, 115), "宅建士 突破特訓ドリル", fill=(255, 255, 255), font=font_title)
    draw.text((360, 175), "権利関係・宅建業法・法令制限・税 頻出30問", fill=(251, 191, 36), font=font_subtitle)

    # Feature Bullet Points
    bullets = [
        "⚡ 全問ASCII当事者関係図 ＆ 本試験ひっかけのツボ (Exam Tip)",
        "📐 インタラクティブ図解: 二重譲渡・35条vs37条・クーリングオフ",
        "📋 宅建必須早見表 (24選): 報酬速算式・手付保全・農地法等ワンタップコピー",
        "🛡️ 完全オフライン動作 ＆ 100%プライバシー保護 ＆ 日英完全対応"
    ]
    for i, b in enumerate(bullets):
        by = 230 + i * 36
        draw.text((360, by), b, fill=(226, 232, 240), font=font_body)

    # Bottom Gradient Bar
    for bx in range(width):
        ratio = bx / float(width)
        r = int(245 * (1 - ratio) + 56 * ratio)
        g = int(158 * (1 - ratio) + 189 * ratio)
        b = int(11 * (1 - ratio) + 248 * ratio)
        draw.line([(bx, height - 6), (bx, height)], fill=(r, g, b, 255))

    return img

if __name__ == "__main__":
    fg = create_feature_graphic()
    out_dir = r"c:\Users\Kawamoto\Documents\AgentAIDev\mobile-apps\028_takken-drill\store_assets\play"
    os.makedirs(out_dir, exist_ok=True)
    fg.save(os.path.join(out_dir, "feature_graphic.png"))
    fg.save(os.path.join(out_dir, "feature_graphic_1024x500.png"))
    print("Feature graphics generated successfully!")
