package com.web.recruit.mapper;

import com.web.recruit.entity.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PositionMapper {
    int deletePositionById(Integer positionId);

    int insertPosition(Position position);

    Position getPositionById(Integer positionId);

    int updatePosition(Position position);

    //根据工作种类选择出所有职位
    List<Position> getPositionsByCategoryId(Integer id);

    //选出某公司的所有岗位
    List<Position> getPositionsByCompanyId(Integer id);

    //根据关键词选出所有岗位
    List<Position> getPositionsByKey(String key);

    //选出所有岗位
    List<Position> getPositions();
}