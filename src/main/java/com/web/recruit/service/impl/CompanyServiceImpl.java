package com.web.recruit.service.impl;

import com.web.recruit.entity.Company;
import com.web.recruit.mapper.CompanyMapper;
import com.web.recruit.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/6 18:09
 */
@CacheConfig(cacheNames = "companies")
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company getCompanyByName(String name) {
        return companyMapper.getCompanyByName(name);
    }

    @Override
    public Company getCompanyById(Integer companyId) {
        return companyMapper.getCompanyById(companyId);
    }

    @Cacheable(keyGenerator = "allCompanies")
    @Override
    public List<Company> getAllCompanies() {
        System.out.println("getAll...");
        return companyMapper.getAllCompanies();
    }

}
