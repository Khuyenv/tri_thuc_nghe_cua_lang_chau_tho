package com.example.tri_nghe_lang_chau_tho.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tri_thuc_nghe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriThucNghe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên làng nghề (ví dụ: Làng gốm Bát Tràng)
    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String tenLangNghe;

    // Địa danh hành chính chuẩn sau sắp xếp (ví dụ: Xã Bát Tràng, Huyện Gia Lâm, Thành phố Hà Nội)
    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String diaChiHanhChinh;

    // Nhóm nghề thủ công (Gốm sứ, Dệt lụa, Đúc đồng, Mây tre đan, v.v.)
    @Column(nullable = false, columnDefinition = "NVARCHAR(100)")
    private String nhomNghe;

    // Tên chính xác di sản văn hóa phi vật thể
    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String tenDiSan;

    // Lịch sử & Nguồn gốc hình thành, Tổ nghề
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String nguonGocLichSu;

    // Chủ thể nắm giữ tri thức (Nghệ nhân, gia đình nghệ nhân, cộng đồng dân cư)
    @Column(columnDefinition = "NVARCHAR(255)")
    private String chuTheNamGiu;

    // Kinh nghiệm chọn và sơ chế nguyên liệu
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String kinhNghiemNguyenLieu;

    // Bí quyết kỹ thuật & thao tác thủ công (Bí quyết gia truyền không thương mại hóa)
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String biQuyetKyThuat;

    // Quy trình các bước thực hiện sản phẩm
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String quyTrinhThaoTac;

    // Cách thức kiểm tra và đánh giá sản phẩm đạt chuẩn
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String cachKiemTraDatChuan;

    // Tình trạng bảo tồn trong đời sống thực tế đương đại
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String thucTrangBaoTon;

    // Đường dẫn hình ảnh minh họa
    @Column(columnDefinition = "NVARCHAR(500)")
    private String hinhAnh;

    // Tóm tắt ngắn gọn
    @Column(columnDefinition = "NVARCHAR(500)")
    private String tomTat;
}
