package com.web.recruit.mapper;

import com.web.recruit.entity.Company;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CompanyMapper {
    int deleteCompanyById(Integer companyId);

    int insertCompany(Company company);

    Company getCompanyById(Integer companyId);

    int updateCompany(Company company);

    Company getCompanyByName(String companyName);

    List<Company> getAllCompanies();
}