import os
from PIL import Image, ImageDraw, ImageFont

def create_takken_icon(size=512):
    # Base image with Midnight Slate background
    img = Image.new('RGBA', (size, size), (15, 23, 42, 255)) # #0F172A
    draw = ImageDraw.Draw(img)
    
    # Scale factor based on 512
    s = size / 512.0
    
    # Glow / subtle radial background accent
    glow_center = (int(256 * s), int(210 * s))
    glow_radius = int(170 * s)
    glow_overlay = Image.new('RGBA', (size, size), (0, 0, 0, 0))
    glow_draw = ImageDraw.Draw(glow_overlay)
    for r in range(glow_radius, 0, -6):
        alpha = int(24 * (1.0 - r / glow_radius))
        glow_draw.ellipse(
            [glow_center[0] - r, glow_center[1] - r, glow_center[0] + r, glow_center[1] + r],
            fill=(245, 158, 11, alpha) # Subtle Warm Gold Glow
        )
    img = Image.alpha_composite(img, glow_overlay)
    draw = ImageDraw.Draw(img)

    # --- Architectural Elements (House & Building) ---
    # 1. High-rise Building (Right/Back) in Cool Sky Blue / Slate Blue
    # Building body
    b_left = int(280 * s)
    b_top = int(120 * s)
    b_right = int(370 * s)
    b_bottom = int(320 * s)
    draw.rounded_rectangle([b_left, b_top, b_right, b_bottom], radius=int(8*s), fill=(30, 58, 138, 240), outline=(56, 189, 248, 255), width=int(4*s))
    
    # Building Windows (3x4 grid)
    for row in range(4):
        for col in range(2):
            wx = b_left + int(18*s) + col * int(38*s)
            wy = b_top + int(24*s) + row * int(38*s)
            draw.rounded_rectangle([wx, wy, wx + int(24*s), wy + int(22*s)], radius=int(3*s), fill=(56, 189, 248, 200))

    # 2. Modern Gable House (Front / Center-Left) in Warm Gold / Amber
    h_cx = int(205 * s)
    roof_peak = (h_cx, int(110 * s))
    roof_left = (int(120 * s), int(190 * s))
    roof_right = (int(290 * s), int(190 * s))
    
    # House Body
    draw.rounded_rectangle(
        [int(135 * s), int(185 * s), int(275 * s), int(320 * s)],
        radius=int(6*s),
        fill=(217, 119, 6, 250), # #D97706
        outline=(251, 191, 36, 255), # #FBBF24
        width=int(5*s)
    )
    
    # House Roof (Triangle polygon)
    draw.polygon([roof_peak, roof_right, roof_left], fill=(245, 158, 11, 255)) # #F59E0B
    # Roof border
    draw.line([roof_left, roof_peak, roof_right], fill=(254, 243, 199, 255), width=int(6*s))

    # Door with arch
    door_left = int(175 * s)
    door_top = int(230 * s)
    door_right = int(235 * s)
    door_bottom = int(320 * s)
    draw.rounded_rectangle([door_left, door_top, door_right, door_bottom], radius=int(6*s), fill=(15, 23, 42, 255), outline=(251, 191, 36, 255), width=int(3*s))
    # Door knob
    draw.ellipse([int(220*s), int(275*s), int(228*s), int(283*s)], fill=(251, 191, 36, 255))

    # House Attic Window (Round)
    win_cx = h_cx
    win_cy = int(160 * s)
    win_r = int(16 * s)
    draw.ellipse([win_cx - win_r, win_cy - win_r, win_cx + win_r, win_cy + win_r], fill=(254, 243, 199, 255), outline=(180, 83, 9, 255), width=int(3*s))

    # --- Legal & License Seal / Badge (Foreground Right) ---
    # A gleaming verification seal / certificate rosette with ribbon
    seal_cx = int(330 * s)
    seal_cy = int(280 * s)
    seal_r = int(48 * s)
    
    # Outer gold ring with shadow
    draw.ellipse(
        [seal_cx - seal_r, seal_cy - seal_r, seal_cx + seal_r, seal_cy + seal_r],
        fill=(251, 191, 36, 255),
        outline=(254, 243, 199, 255),
        width=int(4*s)
    )
    # Inner emerald / deep navy core
    inner_r = int(38 * s)
    draw.ellipse(
        [seal_cx - inner_r, seal_cy - inner_r, seal_cx + inner_r, seal_cy + inner_r],
        fill=(16, 185, 129, 255) # Emerald Green (Pass / Verification)
    )
    
    # Checkmark / Scale symbol inside seal
    # Let's draw a bold white checkmark
    chk_p1 = (seal_cx - int(16*s), seal_cy + int(2*s))
    chk_p2 = (seal_cx - int(5*s), seal_cy + int(14*s))
    chk_p3 = (seal_cx + int(18*s), seal_cy - int(12*s))
    draw.line([chk_p1, chk_p2, chk_p3], fill=(255, 255, 255, 255), width=int(7*s), joint="curve")

    # Ribbon tails under seal
    ribbon_pts1 = [(seal_cx - int(12*s), seal_cy + inner_r), (seal_cx - int(24*s), seal_cy + inner_r + int(28*s)), (seal_cx - int(12*s), seal_cy + inner_r + int(20*s)), (seal_cx, seal_cy + inner_r)]
    ribbon_pts2 = [(seal_cx, seal_cy + inner_r), (seal_cx + int(12*s), seal_cy + inner_r + int(20*s)), (seal_cx + int(24*s), seal_cy + inner_r + int(28*s)), (seal_cx + int(12*s), seal_cy + inner_r)]
    draw.polygon(ribbon_pts1, fill=(217, 119, 6, 255))
    draw.polygon(ribbon_pts2, fill=(217, 119, 6, 255))

    # --- Horizontal Base Line ---
    draw.line([int(100*s), int(325*s), int(412*s), int(325*s)], fill=(100, 116, 139, 200), width=int(3*s))

    # --- Bottom Text: Takken Drill ---
    font_size = int(46 * s)
    font_path = "C:/Windows/Fonts/segoeuib.ttf"
    if not os.path.exists(font_path):
        font_path = "C:/Windows/Fonts/arialbd.ttf"
    
    try:
        font = ImageFont.truetype(font_path, font_size)
    except:
        font = ImageFont.load_default()

    text = "Takken Drill"
    bbox = draw.textbbox((0, 0), text, font=font)
    t_w = bbox[2] - bbox[0]
    t_h = bbox[3] - bbox[1]
    
    tx = (size - t_w) // 2
    ty = int(395 * s)
    
    # Text glow / outline for maximum contrast
    for dx, dy in [(-2,0), (2,0), (0,-2), (0,2), (-1,-1), (1,1), (-1,1), (1,-1)]:
        draw.text((tx+dx, ty+dy), text, fill=(15, 23, 42, 220), font=font)
        
    draw.text((tx, ty), text, fill=(255, 255, 255, 255), font=font)
    
    # Subtle sub-bar under text
    bar_w = int(120 * s)
    bar_x = (size - bar_w) // 2
    bar_y = int(460 * s)
    draw.rounded_rectangle([bar_x, bar_y, bar_x + bar_w, bar_y + int(4*s)], radius=int(2*s), fill=(245, 158, 11, 255))

    return img

if __name__ == "__main__":
    icon_512 = create_takken_icon(512)
    
    # Save to artifacts for inspection
    artifact_path = r"C:\Users\Kawamoto\.gemini\antigravity\brain\85f914b0-2e74-4dde-88b5-7aefe5547cc8\takken_icon_test.png"
    icon_512.save(artifact_path)
    print("Saved test icon to", artifact_path)
    
    # Save to store_assets
    store_dir = r"c:\Users\Kawamoto\Documents\AgentAIDev\mobile-apps\028_takken-drill\store_assets\play"
    os.makedirs(store_dir, exist_ok=True)
    icon_512.save(os.path.join(store_dir, "app_icon_512.png"))
    
    # Generate Android mipmap sizes
    res_dir = r"c:\Users\Kawamoto\Documents\AgentAIDev\mobile-apps\028_takken-drill\app\src\main\res"
    densities = {
        "mipmap-mdpi": 48,
        "mipmap-hdpi": 72,
        "mipmap-xhdpi": 96,
        "mipmap-xxhdpi": 144,
        "mipmap-xxxhdpi": 192
    }
    for folder, px in densities.items():
        folder_path = os.path.join(res_dir, folder)
        os.makedirs(folder_path, exist_ok=True)
        resized = icon_512.resize((px, px), Image.Resampling.LANCZOS)
        resized.save(os.path.join(folder_path, "ic_launcher.png"))
        resized.save(os.path.join(folder_path, "ic_launcher_round.png"))
    
    # Save foreground drawable
    drawable_dir = os.path.join(res_dir, "drawable")
    os.makedirs(drawable_dir, exist_ok=True)
    icon_512.resize((432, 432), Image.Resampling.LANCZOS).save(os.path.join(drawable_dir, "ic_launcher_foreground_img.png"))
    print("All Android mipmap icons generated successfully!")
