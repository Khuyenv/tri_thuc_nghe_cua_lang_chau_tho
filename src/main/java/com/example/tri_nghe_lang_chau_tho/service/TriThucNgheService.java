package com.example.tri_nghe_lang_chau_tho.service;

import com.example.tri_nghe_lang_chau_tho.model.TriThucNghe;
import com.example.tri_nghe_lang_chau_tho.repository.TriThucNgheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TriThucNgheService {

    private final TriThucNgheRepository repository;

    public List<TriThucNghe> getAll() {
        return repository.findAll();
    }

    public Optional<TriThucNghe> getById(Long id) {
        return repository.findById(id);
    }

    public List<TriThucNghe> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return repository.findAll();
        }
        return repository.searchByKeyword(keyword.trim());
    }

    public List<TriThucNghe> getByNhomNghe(String nhomNghe) {
        return repository.findByNhomNgheIgnoreCase(nhomNghe);
    }

    public TriThucNghe save(TriThucNghe triThucNghe) {
        return repository.save(triThucNghe);
    }

    public long count() {
        return repository.count();
    }
}
