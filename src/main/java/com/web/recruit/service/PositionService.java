package com.web.recruit.service;

import com.web.recruit.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/5 23:38
 */
public interface PositionService {

    Position getPositionById(Integer id);

    List<Position> getPositionsByCategoryId(Integer id);

    List<Position> getPositionsByCompanyId(Integer id);

    List<Position> getPositionsByKey(String key);

    List<Position> getAllPositions();

    void savePosition(Position position);

}
