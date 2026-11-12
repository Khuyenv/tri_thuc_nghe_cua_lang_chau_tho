package com.example.tri_nghe_lang_chau_tho.repository;

import com.example.tri_nghe_lang_chau_tho.model.TriThucNghe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TriThucNgheRepository extends JpaRepository<TriThucNghe, Long> {

    List<TriThucNghe> findByNhomNgheIgnoreCase(String nhomNghe);

    @Query("SELECT t FROM TriThucNghe t WHERE " +
           "LOWER(t.tenLangNghe) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.tenDiSan) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.nhomNghe) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.diaChiHanhChinh) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.biQuyetKyThuat) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<TriThucNghe> searchByKeyword(@Param("keyword") String keyword);
}
