package com.web.recruit.controller.user;

import com.web.recruit.controller.BaseController;
import com.web.recruit.entity.*;
import com.web.recruit.service.impl.*;
import com.web.recruit.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tracy
 * @date 2020/6/5 22:16
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResumeServiceImpl resumeService;

    @Autowired
    private FavorServiceImpl favorService;

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private CompanyServiceImpl companyService;


    /**
     * 用户注册
     * @param user
     * @param map
     * @return
     */
    @PostMapping("/register")
    public String userRegister(User user, Map<String, Object> map) {
        if (StringUtils.isEmpty(user.getUserAccount())|| StringUtils.isEmpty(user.getUserName())
                || StringUtils.isEmpty(user.getUserPassword())
                || user.getUserBirth().toString().equals("1900/00/00")
                || (user.getUserGender().toString()).equals("-1")
                || StringUtils.isEmpty(user.getUserEduDegree())
                || StringUtils.isEmpty(user.getUserGraduation())) {
            logger.info("error...");
            map.put("err", "请完整输入！");
            return "/user/register";
        }

        logger.info(user.toString());
        int result = userService.saveUser(user);
        if (result == 0) {
            map.put("err", "用户已存在！");
            return "/user/register";
        }

        return "redirect:/login.html";
    }

    /**
     * 用户登录
     * @param account
     * @param password
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String userLogin(@RequestParam("userAccount") String account,
                            @RequestParam("userPassword") String password,
                            HttpSession session,
                            Map<String, Object> map) {
        //登录
        int result = userService.loginUser(account, password);

        if (result == 1) {
            session.setAttribute("user", userService.getUserByAccount(account));
            return "redirect:/index.html";
        }
        if (result == 0)
            map.put("errMsg", "密码错误");
        if (result == -1)
            map.put("errMsg", "用户不存在");

        return "/user/user_login";
    }

    /**
     * 修改用户的基本信息
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/updateInfo")
    public String update(User user, HttpServletRequest request) {
        User thisUser = this.getUser(request);

        thisUser.setUserName(user.getUserName());
        thisUser.setUserPassword(user.getUserPassword());
        thisUser.setUserGender(user.getUserGender());
        thisUser.setUserGraduation(user.getUserGraduation());
        thisUser.setUserEduDegree(user.getUserEduDegree());
        thisUser.setUserBirth(user.getUserBirth());

        userService.updateUser(thisUser);

        return "redirect:/user/toEditResume";
    }


    /**
     * 用户请求编辑简历界面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/toEditResume")
    public String toResume(HttpServletRequest request, Map<String, Object> map) {
        User user = this.getUser(request);

        map.put("user", user);

        Resume resume;
        //如果不存在简历则先创建
        if (!resumeService.containResume(user.getUserId())) {
            resume = new Resume();
            resume.setResumeUserId(user.getUserId());
            resumeService.saveResume(resume);
        } else {
            resume = resumeService.getResumeByUserId(user.getUserId());
        }

        map.put("resume", resume);

        //判断用户是否入职
        if (user.getUserPositionId() != 0) {
            Position position = positionService.getPositionById(user.getUserPositionId());
            map.put("entry", position);
        }

        //获取用户发出的所有申请
        List<Favor> favors = favorService.getFavorsByResumeId(resume.getResumeId());
        map.put("favors", favors);
        logger.info(favors.toString());

        //获取用户所有已发出申请的职位
        List<Position> positions = new ArrayList<>();
        Position position;
        for (Favor favor : favors) {
            position = positionService.getPositionById(favor.getFavorPositionId());
            positions.add(position);
        }
        map.put("positions", positions);
        logger.info(positions.toString());

        List<Company> companies = companyService.getAllCompanies();
        map.put("companies", companies);
        logger.info(companies.toString());

        return "forward:/info.html";
    }


    /**
     * 编辑简历
     * @param resume
     * @return
     */
    @RequestMapping("/editResume")
    public String userEditResume(Resume resume) {
        resumeService.updateResume(resume);

        return "redirect:/user/toEditResume";
    }

    /**
     * 用户登出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String userLogout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();

        return "redirect:/login.html";
    }

    /**
     * 用户入职
     * @param positionId
     * @param request
     * @return
     */
    @GetMapping("/entry")
    public String entryPosition(@RequestParam("positionId") Integer positionId,
                                HttpServletRequest request) {
        User user = this.getUser(request);

        user.setUserPositionId(positionId);
        userService.updateUser(user);

        request.getSession().setAttribute("user", user);

        return "redirect:/user/toEditResume";
    }


    @Autowired  //注入邮件工具类
    private MailUtil mailUtil;

    @Autowired  //java邮件工具类
    private JavaMailSenderImpl mailSender;

    /**
     * 用户提交反馈
     * @param title
     * @param content
     * @param file
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/sendMsg")
    public String sendMsg(String title, String content,
                          MultipartFile file) {
        String res = null;
        boolean hasFile = false;
        String target = null;   //上传文件的路径

        //判断邮件及邮件内容是否为空
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content)) {
            if (StringUtils.isEmpty(title)) {
                res = "请输入邮件主题！";
            }
            if (StringUtils.isEmpty(content)) {
                res = "请输入邮件内容！";
            }

            return res;
        }

        //判断是否上传文件
        if (file != null && file.getSize() > 0) {
            hasFile = true;
            String path = mailUtil.getUploadPath() + mailUtil.getDate() + "/";
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdirs();
            }
            target = path + file.getOriginalFilename();
            try {
                file.transferTo(new File(target));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, hasFile);
            //设置邮件主题
            helper.setSubject(title);
            //设置邮件内容
            helper.setText(content);
            //设置邮件发送方
            helper.setFrom(mailUtil.getSender());
            //设置邮件目的地
            helper.setTo(mailUtil.getReceiver());
            //上传附件
            if (hasFile) {
                helper.addAttachment(file.getOriginalFilename(), new File(target));
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //发送邮件
        mailSender.send(message);

        return "success";
    }
}
