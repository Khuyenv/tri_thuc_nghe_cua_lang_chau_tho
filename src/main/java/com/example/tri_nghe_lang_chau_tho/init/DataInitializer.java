package com.example.tri_nghe_lang_chau_tho.init;

import com.example.tri_nghe_lang_chau_tho.model.TriThucNghe;
import com.example.tri_nghe_lang_chau_tho.repository.TriThucNgheRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final TriThucNgheRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() > 0) {
            log.info("Dữ liệu Tri thức nghề làng Châu thổ đã tồn tại, bỏ qua bước khởi tạo.");
            return;
        }

        log.info("Đang nạp dữ liệu mẫu ban đầu cho đề tài Tri thức nghề làng Châu thổ Bắc Bộ...");

        TriThucNghe batTrang = TriThucNghe.builder()
                .tenLangNghe("Làng gốm Bát Tràng")
                .diaChiHanhChinh("Xã Bát Tràng, Huyện Gia Lâm, Thành phố Hà Nội")
                .nhomNghe("Gốm sứ thủ công")
                .tenDiSan("Nghề làm gốm Bát Tràng (Di sản văn hóa phi vật thể Quốc gia)")
                .chuTheNamGiu("Cộng đồng dân cư và các thế hệ nghệ nhân họ Nguyễn, Lê, Trần, Phạm tại Bát Tràng")
                .nguonGocLichSu("Làng gốm Bát Tràng hình thành từ thế kỷ XIV - XV thời Lý - Trần khi người dân từ Bồ Bát (Ninh Bình) di cư theo vua dời đô về Thăng Long, tìm thấy vùng đất bồi phù sa bên bờ sông Hồng với nguồn đất sét trắng dồi dào để lập nghiệp mở lò gốm.")
                .kinhNghiemNguyenLieu("Nghệ nhân dùng đất sét trắng (đất trúc thôn) có độ dẻo cao, chịu nhiệt tốt. Đất đào về phải phơi nỏ, đập nhỏ, ngâm lọc qua 4 bể liên hoàn (bể đánh, bể lắng, bể phơi, bể ủ) ròng rã hàng tháng để loại sạch tạp chất và oxit sắt, chỉ giữ lại phần cốt đất mịn dẻo nhất.")
                .biQuyetKyThuat("Bí quyết pha chế 5 dòng men cổ trứ danh: Men lam, men nâu, men trắng ngà, men ngọc và men rạn tam thái độc nhất vô nhị (tạo vết rạn chân chim hình chữ nhật hoặc tam giác nhờ sự co giãn khác nhau giữa xương đất và lớp men). Kỹ thuật vuốt nặn trên bàn xoay thủ công kết hợp con kê tay điêu luyện; kỹ năng vẽ phóng bút thần tốc họa tiết rồng phượng mây nước bằng men lam chìm dưới men bóng.")
                .quyTrinhThaoTac("1. Xử lý đất (ngâm lọc 4 bể) -> 2. Tạo hình xương gốm (chuốt bàn xoay hoặc đắp nặn) -> 3. Phơi sấy mộc trong bóng râm (tránh nứt vỡ) -> 4. Sửa mộc, tiện gọt chi tiết -> 5. Vẽ họa tiết trang trí thủ công -> 6. Tráng men bí truyền -> 7. Xếp lò và nung đốt -> 8. Để nguội tự nhiên và dỡ lò kiểm định.")
                .cachKiemTraDatChuan("Nghệ nhân dùng ngón tay gõ nhẹ vào thân gốm: tiếng vang phát ra phải đanh chắc, ngân vang như tiếng chuông đồng là gốm chín thấu xương đất; men phủ đều bóng mượt, không sủi bọt khí, không bị co men; đường rạn men nứt đều đặn và sắc nét.")
                .thucTrangBaoTon("Nghề đang được cộng đồng bảo tồn sống động qua việc truyền nghề gia đình, kết hợp mô hình bảo tàng gốm và du lịch trải nghiệm làng nghề truyền thống gắn với công nghiệp sáng tạo Thủ đô.")
                .hinhAnh("https://images.unsplash.com/photo-1565193566173-7a0ee3dbe261?auto=format&fit=crop&w=800&q=80")
                .tomTat("Tri thức chế tác gốm nung và bí quyết dòng men rạn cổ truyền trứ danh vùng ven sông Hồng.")
                .build();

        TriThucNghe vanPhuc = TriThucNghe.builder()
                .tenLangNghe("Làng lụa Vạn Phúc")
                .diaChiHanhChinh("Phường Vạn Phúc, Quận Hà Đông, Thành phố Hà Nội")
                .nhomNghe("Dệt may truyền thống")
                .tenDiSan("Nghề dệt lụa Vạn Phúc (Di sản văn hóa phi vật thể Quốc gia)")
                .chuTheNamGiu("Các dòng họ nghệ nhân dệt lụa Vạn Phúc; Nghệ nhân Nhân dân, Nghệ nhân Ưu tú địa phương")
                .nguonGocLichSu("Làng lụa Vạn Phúc (tên cũ là Vạn Bảo) có lịch sử hơn 1.000 năm, do bà Lã Thị Nga (A Nương) truyền dạy nghề dệt cho dân làng từ thời nhà Đường (thế kỷ thứ IX), sau được tôn làm Thành hoàng làng.")
                .kinhNghiemNguyenLieu("Chọn sợi tơ tằm tự nhiên óng ả từ các vùng trồng dâu nuôi tằm sông Đáy; phân loại tơ nõn, tơ gốc, tơ ngọn; dùng nước mưa tự nhiên để luộc nhả keo sericin giúp sợi tơ mềm như nhung trước khi mắc cửi.")
                .biQuyetKyThuat("Bí quyết dệt lụa Vân - kỹ thuật dệt hoa vân chìm hoa văn nổi tinh vi trên khung cửi thủ công cổ truyền: lụa mỏng nhẹ bay bổng nhưng dai bền, khi nghiêng ra ánh sáng thấy họa tiết hoa cúc, hoa mai, rồng phượng ẩn hiện ảo diệu; bí quyết nhuộm màu tự nhiên bằng củ nâu, lá bàng, vỏ cây rừng giữ màu không phai.")
                .quyTrinhThaoTac("1. Tơ dâu tằm về -> 2. Xe tơ, guồng tơ -> 3. Nấu nhả keo -> 4. Mắc cửi và cài then tạo hoa văn -> 5. Dệt tấm trên khung cửi thủ công -> 6. Tẩy nhuộm màu thủ công -> 7. Căng phơi đón gió đồng tự nhiên.")
                .cachKiemTraDatChuan("Áp tấm lụa lên mu bàn tay cảm nhận độ mát rượi tức thì; khi vò mạnh tay rồi buông ra lụa tự bung phẳng, không hằn nếp nhăn; soi dưới ánh mặt trời sợi dệt khít đều không có sợi lỗi.")
                .thucTrangBaoTon("Làng nghề duy trì hơn 300 khung cửi đang hoạt động, giữ gìn kỹ nghệ dệt lụa Vân cổ truyền song song phát triển tuyến phố nghề sinh thái văn hóa.")
                .hinhAnh("https://images.unsplash.com/photo-1607344645866-009c320c5ab8?auto=format&fit=crop&w=800&q=80")
                .tomTat("Kỹ nghệ dệt lụa Vân độc nhất vô nhị ngàn năm tuổi với chất lụa mát rượi, mềm mượt như mây.")
                .build();

        TriThucNghe daiBai = TriThucNghe.builder()
                .tenLangNghe("Làng đúc đồng Đại Bái")
                .diaChiHanhChinh("Xã Đại Bái, Huyện Gia Bình, Tỉnh Bắc Ninh")
                .nhomNghe("Gò đúc kim khí")
                .tenDiSan("Nghề đúc đồng và gò chạm Đại Bái")
                .chuTheNamGiu("Cộng đồng thợ đúc đồng xã Đại Bái; các gia đình nghệ nhân giữ khuôn đúc gia truyền")
                .nguonGocLichSu("Khởi nguồn từ thế kỷ XI thời Lý, do Tiền Chu Thái úy Nguyễn Công Triều khởi xướng và truyền dạy cho dân 4 thôn (An Vạn, Vực, Tây, Giữa).")
                .kinhNghiemNguyenLieu("Pha chế hợp kim đồng đỏ nguyên chất với tỷ lệ thiếc, kẽm, chì theo công thức cân bằng âm dương bí mật giúp đồng chảy loãng đều, lấp đầy các khe hoa văn nhỏ nhất trên khuôn mà không bị rỗ xỉ.")
                .biQuyetKyThuat("Kỹ thuật làm khuôn đất 2 nửa bằng đất sét trộn bùn ao phơi khô cùng trấu mục và giấy bản để chịu nhiệt cao; bí quyết gò thúc nổi hoa văn đồng lá mỏng tanh mà không rách gãy; kỹ thuật khảm tam khí (đồng - bạc - vàng) và khảm ngũ khí tinh xảo.")
                .quyTrinhThaoTac("1. Thiết kế mẫu đất/sáp -> 2. Tạo khuôn âm bản bằng đất bùn trấu -> 3. Nung chín khuôn -> 4. Nấu chảy đồng trong lò than -> 5. Rót đồng nóng chảy vào khuôn -> 6. Đập dỡ khuôn nguội -> 7. Gò dũa, chạm trổ và khảm kim loại quý -> 8. Làm màu giả cổ bằng nước đồng sunfat.")
                .cachKiemTraDatChuan("Đỉnh đồng, chuông đồng đúc ra bề mặt liền lạc không nứt rỗ chì; khi gõ vào thân chuông âm thanh ngân vang thanh thót kéo dài; hoa văn chạm chìm nổi sắc nét từng sợi râu rồng vảy cá.")
                .thucTrangBaoTon("Đang phát triển mạnh mẽ từ đồ đồng thờ cúng tâm linh truyền thống sang các tác phẩm mỹ nghệ cao cấp phục vụ kiến trúc và văn hóa dân tộc.")
                .hinhAnh("https://images.unsplash.com/photo-1579783902614-a3fb3927b675?auto=format&fit=crop&w=800&q=80")
                .tomTat("Nghệ thuật đúc đồng, gò thúc và khảm tam khí tinh vi nức tiếng vùng Kinh Bắc nghìn năm văn hiến.")
                .build();

        TriThucNghe nonChuong = TriThucNghe.builder()
                .tenLangNghe("Làng nón Chuông")
                .diaChiHanhChinh("Xã Phương Trung, Huyện Thanh Oai, Thành phố Hà Nội")
                .nhomNghe("Đan lát thủ công")
                .tenDiSan("Nghề làm nón lá làng Chuông")
                .chuTheNamGiu("Phụ nữ và các nghệ nhân làng Chuông, xã Phương Trung")
                .nguonGocLichSu("Nghề làm nón làng Chuông có từ thế kỷ VIII, từng là vật phẩm cung tiến dâng hoàng hậu, công chúa và gắn bó keo sơn với biểu tượng người phụ nữ Việt Nam qua nón quai thao và nón chóp.")
                .kinhNghiemNguyenLieu("Chọn lá cọ non trắng xanh hái từ vùng rừng núi Quảng Bình, Hà Tĩnh. Lá đem về phơi sương sớm 2-3 đêm để giữ độ dẻo dai; chọn thanh tre nứa bánh tẻ chẻ làm 16 vành nón uốn tròn chuẩn xác.")
                .biQuyetKyThuat("Kỹ thuật vuốt phẳng từng lá non bằng búi giẻ trên thanh sắt nung nóng vừa tầm (nóng quá thì giòn cháy, nguội quá thì quăn queo); kỹ nghệ khâu giấu mũi cước đều tăm tắp 16 vòng nón sao cho 'đội mưa ròng rã không một giọt lọt qua'.")
                .quyTrinhThaoTac("1. Chọn và phơi lá sương đêm -> 2. Vuốt phẳng lá trên gang nóng -> 3. Chuốt 16 vành nón bằng tre -> 4. Xếp lá lên khuôn nón -> 5. Khâu nón bằng kim dài sợi cước -> 6. Luồn sợi chỉ ngũ sắc trang trí chóp -> 7. Nức vành nón và quét dầu bóng chống thấm nước.")
                .cachKiemTraDatChuan("Soi chiếc nón dưới ánh mặt trời thấy lá đều màu trắng ngà, không gân nổi cộm; vành nón tròn đều tăm tắp, độ thấu quang nhẹ nhàng, đường khâu mũi chỉ phẳng lì không lộ vết gút.")
                .thucTrangBaoTon("Được cộng đồng gìn giữ bền bỉ qua các phiên chợ nón mờ sáng đặc sắc bên dòng sông Đáy, thu hút đông đảo du khách trong nước và quốc tế.")
                .hinhAnh("https://images.unsplash.com/photo-1528127269322-539801943592?auto=format&fit=crop&w=800&q=80")
                .tomTat("Nghệ thuật chuốt vành, là lá, khâu nón lá 16 vành thanh thoát che mưa che nắng xứ Đoài.")
                .build();

        TriThucNghe phuVinh = TriThucNghe.builder()
                .tenLangNghe("Làng mây tre đan Phú Vinh")
                .diaChiHanhChinh("Xã Phú Nghĩa, Huyện Chương Mỹ, Thành phố Hà Nội")
                .nhomNghe("Mây tre đan thủ công")
                .tenDiSan("Nghề mây tre đan Phú Vinh")
                .chuTheNamGiu("Các nghệ nhân mây tre đan xã Phú Nghĩa; gia tộc nghệ nhân nhiều đời")
                .nguonGocLichSu("Làng nghề ra đời từ khoảng thế kỷ XVII thời Lê Trung Hưng, nổi danh khắp kinh kỳ với tài năng đan tranh ảnh chân dung và các đồ dùng sinh hoạt từ mây tre tinh tế.")
                .kinhNghiemNguyenLieu("Tuyển lựa cây mây nếp gióng dài, vỏ vàng óng không sâu mọt; tre nứa đem ngâm bùn ao từ 3-6 tháng để triệt tiêu đường tinh bột chống mối mọt tự nhiên rồi vớt lên hun khói rơm tạo màu cánh gián tự nhiên.")
                .biQuyetKyThuat("Kỹ thuật chẻ nan mây mỏng manh như sợi chỉ tơ bằng dao bài gia truyền; kỹ nghệ đan lồng nhiều lớp (trong tre ngoài mây), đan chữ vạn, mắt cáo, hoa cúc nổi bề mặt mà không thấy mối nối kết thúc.")
                .quyTrinhThaoTac("1. Thu mua mây tre tuyển chọn -> 2. Ngâm bùn ao và hun khói rơm sấy khô -> 3. Róc vỏ, chẻ nan thủ công -> 4. Chuốt bóng nan qua lỗ cữ sắt -> 5. Tạo khung sườn cốt -> 6. Đan hoa văn thủ công -> 7. Nạo gọt ráp bavia -> 8. Sơn phủ bóng tự nhiên.")
                .cachKiemTraDatChuan("Sản phẩm uốn dẻo đàn hồi tốt, bề mặt nhẵn bóng không xơ sợi; đường nan khít chặt không xô lệch, các múi ghép kín khít tự nhiên, ngửi thấy mùi thơm nhẹ của mây hun khói.")
                .thucTrangBaoTon("Nghề đang phát triển mạnh xuất khẩu sang hơn 30 quốc gia, khẳng định giá trị bền vững và tri thức dân gian đỉnh cao của làng nghề Việt.")
                .hinhAnh("https://images.unsplash.com/photo-1590736969955-71cc94801759?auto=format&fit=crop&w=800&q=80")
                .tomTat("Kỹ nghệ chẻ chuốt nan mây tre tinh vi như thêu ren, thổi hồn nghệ thuật vào vật dụng tự nhiên.")
                .build();

        repository.saveAll(List.of(batTrang, vanPhuc, daiBai, nonChuong, phuVinh));
        log.info("Khởi tạo thành công 5 hồ sơ tri thức nghề tiêu biểu làng Châu thổ Bắc Bộ!");
    }
}
