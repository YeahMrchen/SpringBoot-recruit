package com.web.recruit.controller.hr;

import com.web.recruit.controller.BaseController;
import com.web.recruit.entity.*;
import com.web.recruit.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/6 11:24
 */
@Controller
@RequestMapping("/hr")
public class HRController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HRServiceImpl hrService;

    @Autowired
    private FavorServiceImpl favorService;

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private ResumeServiceImpl resumeService;


    /**
     * HR登录
     * @param account
     * @param password
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String hrLogin(@RequestParam("hrAccount") String account,
                            @RequestParam("hrPassword") String password,
                            HttpSession session,
                            Map<String, Object> map) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            map.put("errMsg", "请完整输入");
            return "forward:/login.html";
        }

        int result = hrService.loginHR(account, password);
        if (result == 1) {
            session.setAttribute("hr", hrService.getHRByAccount(account));
            return "redirect:/hr/unHandle";
        }
        if (result == 0)
            map.put("errMsg", "密码错误");
        if (result == -1)
            map.put("errMsg", "用户不存在");

        return "forward:/login.html";
    }

    /**
     * 私有方法，根据条件获取申请的相关信息（用户，职位名等）
     * @param map
     * @param favors
     */
    private void getFavorsByStep(Map<String, Object> map, List<Favor> favors) {
        User user;
        Position position;
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> tmp;
        for (Favor favor : favors) {
            tmp = new HashMap<>();

            position  = positionService.getPositionById(favor.getFavorPositionId());
            user = userService.getUserByResumeId(favor.getFavorResumeId());

            tmp.put("user", user);
            tmp.put("position", position);

            maps.add(tmp);
        }
        map.put("maps", maps);
    }

    /**
     * hr请求修改基本信息页面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/toEditInfo")
    public String toEdit(HttpServletRequest request, Map<String, Object> map) {
        HR hr = this.getHR(request);

        map.put("hr", hr);

        Company company = companyService.getCompanyById(hr.getHrCompanyId());

        map.put("company", company);

        return "forward:/hr_info.html";
    }

    /**
     * hr提交修改信息请求
     * @param hr
     * @return
     */
    @RequestMapping("/updateInfo")
    public String update(HR hr, HttpServletRequest request) {
        HR thisHR = this.getHR(request);

        thisHR.setHrName(hr.getHrName());
        thisHR.setHrGender(hr.getHrGender());
        thisHR.setHrMobile(hr.getHrMobile());
        thisHR.setHrEntryDate(hr.getHrEntryDate());

        //修改信息
        hrService.updateHR(thisHR);

        return "redirect:/hr/toEditInfo";
    }

    /**
     * 获取未被处理的申请
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/unHandle")
    public String showUnHandled(HttpServletRequest request, Map<String, Object> map) {
        HR hr = this.getHR(request);

        Integer companyId = hr.getHrCompanyId();
        List<Favor> favors = favorService.getUnprocessedFavors(companyId);
        map.put("unHandle", favors);

        this.getFavorsByStep(map, favors);

        return "forward:/hr_unhandled.html";
    }

    /**
     * 获取已通过的申请
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/passed")
    public String showPassed(HttpServletRequest request, Map<String, Object> map) {
        HR hr = this.getHR(request);

        Integer companyId = hr.getHrCompanyId();
        List<Favor> favors = favorService.getPassedFavors(companyId);
        map.put("passed", favors);

        this.getFavorsByStep(map, favors);

        return "forward:/hr_passed.html";
    }

    /**
     * 获取被拒绝的申请
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/rejected")
    public String showRejected(HttpServletRequest request, Map<String, Object> map) {
        HR hr = this.getHR(request);

        Integer companyId = hr.getHrCompanyId();
        List<Favor> favors = favorService.getRejectedFavors(companyId);
        map.put("rejected", favors);

        this.getFavorsByStep(map, favors);

        return "forward:/hr_rejected.html";
    }

    /**
     * 显示用户的简历
     * @param userId
     * @return
     */
    @RequestMapping(value = "/showResume")
    public String showUserResume(Integer userId, Integer positionId,
                                 Map<String, Object> map) {

        logger.info("show user resume...");
        User user = userService.getUserById(userId);
        map.put("user", user);

        Resume resume = resumeService.getResumeByUserId(userId);
        map.put("resume", resume);

        Favor favor = favorService.getFavorByResumeAndPositionId(resume.getResumeId(), positionId);
        map.put("favor", favor);

        return "/hr/hr_showResume";
    }

    /**
     * 接受用户的申请
     * @param favorId
     * @return
     */
    @RequestMapping("/accept")
    public String accept(Integer favorId) {

        logger.info(favorId + ": accept..");
        favorService.passApply(favorId);

        return "redirect:/hr/passed";
    }

    /**
     * 拒绝用户的申请
     * @param favorId
     * @return
     */
    @RequestMapping("/reject")
    public String reject(Integer favorId) {

        logger.info(favorId + ": reject...");
        favorService.rejectApply(favorId);

        return "redirect:/hr/rejected";
    }
}
