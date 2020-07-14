package com.web.recruit.controller.position;

import com.web.recruit.controller.BaseController;
import com.web.recruit.entity.*;
import com.web.recruit.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/6 18:03
 */
@Controller
@RequestMapping("/position")
public class PositionController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private FavorServiceImpl favorService;

    @Autowired
    private ResumeServiceImpl resumeService;

    @Autowired
    private CategoryServiceImpl categoryService;


    /**
     * 发起职位搜索请求，返回所有职位给页面
     * @param map
     * @return
     */
    @RequestMapping("/searchList")
    public String getAllPositions(Map<String, Object> map) {
        List<Position> positions = positionService.getAllPositions();
        map.put("positions", positions);

        //获取公司
        List<Company> companies = companyService.getAllCompanies();
        map.put("companies", companies);

        logger.info(companies.toString());


        return "forward:/list.html";
    }

    /**
     * 根据关键字搜索职位
     * @param keyword
     * @param map
     * @return
     */
    @RequestMapping("/searchByKey")
    public String searchPositionByKey(@RequestParam("keyword") String keyword,
                                                   Map<String, Object> map) {
        List<Position> positions = positionService.getPositionsByKey(keyword);
        map.put("positions", positions);

        List<Company> companies = companyService.getAllCompanies();
        map.put("companies", companies);

        logger.info("根据keyword查找...");
        return "forward:/list.html";
    }


    /**
     * 根据职位所属种类进行搜索
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/searchByCate/{id}")
    public String searchByCategory(@PathVariable("id") Integer categoryId,
                                                Map<String, Object> map) {
        List<Position> positions = positionService.getPositionsByCategoryId(categoryId);
        logger.info("search by categories");
        map.put("positions", positions);

        List<Company> companies = companyService.getAllCompanies();
        map.put("companies", companies);

        return "forward:/list.html";
    }

    /**
     * 获取职位详细信息
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/{id}")
    public String positionDetail(@PathVariable("id") Integer id,
                                 HttpServletRequest request,
                                 Map<String, Object> map) {
        User user = this.getUser(request);

        Resume resume = resumeService.getResumeByUserId(user.getUserId());

        Favor favor = favorService.getFavorByResumeAndPositionId(resume.getResumeId(), id);
        if (favor != null) {
            map.put("favor", favor);
        }

        Position position = positionService.getPositionById(id);
        map.put("position", position);

        Company company = companyService.getCompanyById(position.getPositionCompanyId());
        map.put("company", company);

        Category category = categoryService.getCategoryById(position.getPositionCategoryId());
        map.put("category", category);

        return "forward:/detail.html";
    }

    /**
     * 用户申请职位，投递简历
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/apply")
    public String applyPosition(HttpServletRequest request,
                                @RequestParam("id") Integer id,
                                Map<String, Object> map) {
        User user = this.getUser(request);

        //通过用户id获取简历
        Resume resume = resumeService.getResumeByUserId(user.getUserId());

        //若用户未编写简历
        if (resume == null) {
            return "redirect:/user/toEditResume";
        }

        Favor favor = favorService.getFavorByResumeAndPositionId(resume.getResumeId(), id);

        //若已经获取过申请
        if (favor != null) {
            map.put("err", "您已提交过申请！");
            return "forward:/position/" + id;
        }

        favor = new Favor();
        //设置申请的职位
        favor.setFavorPositionId(id);
        //设置申请简历的id
        favor.setFavorResumeId(resume.getResumeId());
        //默认申请状态为0
        favor.setFavorState(0);

        favorService.saveFavor(favor);

        return "redirect:/position/searchList";
    }

    /**
     * 跳转至发布职位界面
     * @param request
     * @param map
     * @return
     */
    @GetMapping("/toPublish")
    public String toPublish(HttpServletRequest request, Map<String, Object> map) {
        HR hr = this.getHR(request);

        //获得HR所在公司
        Company company = companyService.getCompanyById(hr.getHrCompanyId());
        //获得所有工作标签
        List<Category> categories = categoryService.getCategories();

        map.put("company", company);
        map.put("categories", categories);

        return "forward:/publish.html";
    }

    /**
     * 发布职位
     * @param position
     * @return
     */
    @RequestMapping("/publish")
    public String publishPosition(Position position) {
        positionService.savePosition(position);

        return "redirect:/hr/unHandle";
    }
}
