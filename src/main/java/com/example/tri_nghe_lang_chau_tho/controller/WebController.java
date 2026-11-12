package com.example.tri_nghe_lang_chau_tho.controller;

import com.example.tri_nghe_lang_chau_tho.model.TriThucNghe;
import com.example.tri_nghe_lang_chau_tho.service.TriThucNgheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final TriThucNgheService service;

    // Thông tin định danh sinh viên
    private void addStudentInfo(Model model) {
        model.addAttribute("hoTen", "Nguyễn Văn Khuyến");
        model.addAttribute("maSV", "PH59134");
        model.addAttribute("lop", "C05");
        model.addAttribute("vungVanHoa", "Châu thổ Bắc Bộ");
        model.addAttribute("deTai", "Tri thức nghề của làng nghề châu thổ");
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        addStudentInfo(model);
        List<TriThucNghe> danhSach = service.search(keyword);
        model.addAttribute("danhSach", danhSach);
        model.addAttribute("keyword", keyword);
        model.addAttribute("tongSo", service.count());
        return "index";
    }

    @GetMapping("/tri-thuc/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        addStudentInfo(model);
        Optional<TriThucNghe> opt = service.getById(id);
        if (opt.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("item", opt.get());
        return "detail";
    }

    @GetMapping("/phieu-tu-lieu")
    public String phieuTuLieu(Model model) {
        addStudentInfo(model);
        return "phieu-tu-lieu";
    }

    @GetMapping("/tro-ly-ai")
    public String troLyAi(Model model) {
        addStudentInfo(model);
        return "ai-studio";
    }

    // API phục vụ trợ lý ảo hỏi đáp trực tiếp về tri thức nghề
    @PostMapping("/api/ai-chat")
    @ResponseBody
    public ResponseEntity<Map<String, String>> chatAi(@RequestBody Map<String, String> request) {
        String cauHoi = request.getOrDefault("message", "").toLowerCase();
        String traLoi = "";

        String msg = cauHoi.toLowerCase();
        if (msg.contains("bát tràng") || msg.contains("bat trang") || msg.contains("gốm") || msg.contains("gom")) {
            traLoi = "🏺 **Tri thức gốm Bát Tràng (Gia Lâm, Hà Nội)**:\n" +
                    "- **Kinh nghiệm chọn & luyện đất**: Tuyển lựa đất sét trắng Trúc Thôn dẻo quánh, ngâm lọc qua hệ thống 4 bể (bể đánh, bể lắng, bể phơi, bể ủ) ròng rã hàng tháng để khử sạch oxit sắt và tạp chất.\n" +
                    "- **Bí quyết kỹ thuật độc nhất**: Nổi danh với 5 dòng men cổ, đỉnh cao là men rạn tam thái độc nhất vô nhị. Nghệ nhân vuốt nặn điêu luyện trên bàn xoay thủ công và phóng bút vẽ men lam chìm dưới men bóng.\n" +
                    "- **Kinh nghiệm thẩm định**: Dùng ngón tay gõ nhẹ vào thân gốm; âm phát ra đanh chắc, ngân vang như chuông đồng là gốm chín thấu xương đất.";
        } else if (msg.contains("vạn phúc") || msg.contains("van phuc") || msg.contains("lụa") || msg.contains("lua")) {
            traLoi = "🧵 **Tri thức dệt lụa Vạn Phúc (Hà Đông, Hà Nội)**:\n" +
                    "- **Kỹ nghệ nghìn năm**: Bí quyết dệt lụa Vân - tạo hoa văn chìm nổi tinh vi trên khung cửi cổ truyền. Sợi tơ dâu tằm luộc nhả keo bằng nước mưa tự nhiên mềm mát như nhung.\n" +
                    "- **Kinh nghiệm thẩm định**: Vò mạnh tay rồi buông ra lụa tự bung phẳng phiu không nếp nhăn; áp lên mu bàn tay cảm nhận ngay độ mát rượi đặc trưng.";
        } else if (msg.contains("đại bái") || msg.contains("dai bai") || msg.contains("đồng") || msg.contains("dong")) {
            traLoi = "🔔 **Tri thức đúc đồng Đại Bái (Gia Bình, Bắc Ninh)**:\n" +
                    "- **Bí quyết hợp kim**: Công thức phối đồng đỏ và thiếc cân bằng âm dương bí mật giúp dòng kim loại nóng chảy lấp đầy mọi chi tiết vi diệu; khuôn đúc bằng bùn ao trấu mục nướng chín.\n" +
                    "- **Kinh nghiệm thẩm định**: Thân đúc liền lạc không rỗ chì; tiếng chuông đồng ngân vang thanh thoát kéo dài.";
        } else if (msg.contains("chuông") || msg.contains("chuong") || msg.contains("nón") || msg.contains("non")) {
            traLoi = "👒 **Tri thức làm nón làng Chuông (Thanh Oai, Hà Nội)**:\n" +
                    "- **Kinh nghiệm lá & vành**: Chọn lá cọ non phơi sương sớm 2-3 đêm dẻo dai; là phẳng lá trên gang nóng vừa độ; chuốt 16 vành tre uốn tròn đều tăm tắp.\n" +
                    "- **Bí quyết khâu nón**: Đường khâu giấu mũi cước tài tình, giữ cho chiếc nón thanh thoát mà 'đội mưa ròng rã không một giọt lọt qua'.";
        } else if (msg.contains("phú vinh") || msg.contains("phu vinh") || msg.contains("mây tre") || msg.contains("may tre")) {
            traLoi = "🎋 **Tri thức mây tre đan Phú Vinh (Chương Mỹ, Hà Nội)**:\n" +
                    "- **Kinh nghiệm nguyên liệu**: Ngâm tre bùn ao 3-6 tháng rồi hun khói rơm tạo màu cánh gián tự nhiên, chống mối mọt.\n" +
                    "- **Bí quyết kỹ nghệ**: Chẻ nan mây mỏng mảnh như sợi tơ chỉ; kỹ thuật đan lồng 2-3 lớp trong tre ngoài mây không lộ mối kết thúc.";
        } else {
            traLoi = "Xin chào! Tôi là Trợ lý AI Tri thức nghề làng Châu thổ Bắc Bộ. Tôi nắm vững toàn bộ tri thức về: đất & men Gốm Bát Tràng, lụa Vân Vạn Phúc, đúc đồng Đại Bái, nón lá làng Chuông, mây tre đan Phú Vinh. Bạn hãy đặt câu hỏi về bí quyết kỹ thuật, kinh nghiệm nguyên liệu hoặc cách kiểm tra sản phẩm nhé!";
        }

        return ResponseEntity.ok(Map.of("reply", traLoi));
    }
}
