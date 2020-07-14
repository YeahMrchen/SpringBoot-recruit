package com.web.recruit.service.impl;

import com.web.recruit.entity.Position;
import com.web.recruit.mapper.PositionMapper;
import com.web.recruit.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/5 23:39
 */
@CacheConfig(cacheNames = "positions")
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;

    @CacheEvict(allEntries = true, beforeInvocation = true)
    @Override
    public void savePosition(Position position) {
        positionMapper.insertPosition(position);
    }

    @Override
    public Position getPositionById(Integer id) {
        return positionMapper.getPositionById(id);
    }

    @Cacheable(keyGenerator = "byCategoryId")
    @Override
    public List<Position> getPositionsByCategoryId(Integer id) {
        return positionMapper.getPositionsByCategoryId(id);
    }

    @Cacheable(keyGenerator = "byCompanyId")
    @Override
    public List<Position> getPositionsByCompanyId(Integer id) {
        return positionMapper.getPositionsByCompanyId(id);
    }

    @Cacheable(keyGenerator = "byKeyword")
    @Override
    public List<Position> getPositionsByKey(String key) {
        return positionMapper.getPositionsByKey(key);
    }

    @Cacheable(keyGenerator = "allPositions")
    @Override
    public List<Position> getAllPositions() {
        return positionMapper.getPositions();
    }

}
