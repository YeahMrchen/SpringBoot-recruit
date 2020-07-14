package com.web.recruit.mapper;

import com.web.recruit.entity.Favor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FavorMapper {
    int deleteFavorById(Integer favorId);

    int insertFavor(Favor favor);

    Favor getFavorById(Integer favorId);

    Favor getFavorByResumeAndPositionId(@Param("resumeId") Integer resumeId, @Param("positionId") Integer positionId);

    List<Favor> getFavorsByResumeId(Integer resumeId);

    int updateFavor(@Param("favorId") Integer favorId, @Param("favorState") Integer state);

    //批准申请
    void passFavor(Integer favorId);

    //拒绝申请
    void rejectFavor(Integer favorId);

    //获取本公司所有申请
    List<Favor> getFavorsByCompanyId(Integer companyId);

    //获取未处理的申请
    List<Favor> getUnprocessedFavors(Integer companyId);

    //获取已批准的申请
    List<Favor> getPassedFavors(Integer companyId);

    //获取拒绝的申请
    List<Favor> getRejectedFavors(Integer companyId);
}