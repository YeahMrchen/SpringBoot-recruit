package com.web.recruit.service.impl;

import com.web.recruit.entity.Resume;
import com.web.recruit.mapper.ResumeMapper;
import com.web.recruit.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tracy
 * @date 2020/6/5 23:31
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public void saveResume(Resume resume) {
        resumeMapper.insertResume(resume);
    }

    @Override
    public Resume getResumeByUserId(Integer userId) {
        return resumeMapper.getResumeByUserId(userId);
    }

    @Override
    public boolean containResume(Integer userId) {
        Resume resume = this.getResumeByUserId(userId);

        return resume != null;
    }

    @Override
    public void updateResume(Resume resume) {
        resumeMapper.updateResume(resume);
    }
}
