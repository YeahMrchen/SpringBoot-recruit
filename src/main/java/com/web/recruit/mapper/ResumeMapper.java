package com.web.recruit.mapper;

import com.web.recruit.entity.Resume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ResumeMapper {
    int deleteResumeByUserId(Integer userId);

    int insertResume(Resume resume);

    Resume getResumeByUserId(Integer userId);

    int updateResume(Resume resume);
}