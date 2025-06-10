package com.example.joblink_project.Services;

import com.example.joblink_project.Models.CVLanguage;

import java.util.List;

public interface CVLanguageService {
    CVLanguage getById(Long id);
    List<CVLanguage> getByCvId(Long cvId);
    CVLanguage create(CVLanguage cvLanguage);
    CVLanguage update(Long id, CVLanguage cvLanguage);
    void delete(Long id);
}
