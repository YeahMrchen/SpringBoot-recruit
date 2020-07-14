package com.web.recruit.service;

import com.web.recruit.entity.Resume;

/**
 * @author Tracy
 * @date 2020/6/5 23:30
 */
public interface ResumeService {
    void saveResume(Resume resume);

    void updateResume(Resume resume);

    Resume getResumeByUserId(Integer userId);

    boolean containResume(Integer userId);
}
