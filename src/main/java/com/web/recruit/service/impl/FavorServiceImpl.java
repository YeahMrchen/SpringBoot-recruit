package com.web.recruit.service.impl;

import com.web.recruit.entity.Favor;
import com.web.recruit.mapper.FavorMapper;
import com.web.recruit.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tracy
 * @date 2020/6/6 22:27
 */
@Service
public class FavorServiceImpl implements FavorService {
    @Autowired
    private FavorMapper favorMapper;

    @Override
    public void saveFavor(Favor favor) {
        favorMapper.insertFavor(favor);
    }

    @Override
    public void passApply(Integer favorId) {
        favorMapper.passFavor(favorId);
    }

    @Override
    public void rejectApply(Integer favorId) {
        favorMapper.rejectFavor(favorId);
    }

    @Override
    public Favor getFavorByResumeAndPositionId(Integer resumeId, Integer positionId) {
        return favorMapper.getFavorByResumeAndPositionId(resumeId, positionId);
    }

    @Override
    public List<Favor> getFavorsByResumeId(Integer resumeId) {
        return favorMapper.getFavorsByResumeId(resumeId);
    }

    @Override
    public List<Favor> getAllFavorsOfCompany(Integer companyId) {
        return favorMapper.getFavorsByCompanyId(companyId);
    }

    @Override
    public List<Favor> getUnprocessedFavors(Integer companyId) {
        return favorMapper.getUnprocessedFavors(companyId);
    }

    @Override
    public List<Favor> getPassedFavors(Integer companyId) {
        return favorMapper.getPassedFavors(companyId);
    }

    @Override
    public List<Favor> getRejectedFavors(Integer companyId) {
        return favorMapper.getRejectedFavors(companyId);
    }

}
