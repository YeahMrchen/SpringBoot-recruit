package com.web.recruit.service;

import com.web.recruit.entity.Favor;

import java.util.List;

/**
 * @author Tracy
 * @date 2020/6/6 22:27
 */
public interface FavorService {
    void saveFavor(Favor favor);

    //批准申请
    void passApply(Integer favorId);

    //拒绝申请
    void rejectApply(Integer favorId);

    //获取某一简历对某一职位发出的申请
    Favor getFavorByResumeAndPositionId(Integer resumeId, Integer positionId);

    List<Favor> getFavorsByResumeId(Integer resumeId);

    //本公司所有申请
    List<Favor> getAllFavorsOfCompany(Integer companyId);

    //未处理的申请
    List<Favor> getUnprocessedFavors(Integer companyId);

    //通过的申请
    List<Favor> getPassedFavors(Integer companyId);

    //被拒绝的申请
    List<Favor> getRejectedFavors(Integer companyId);
}
