package com.hxp.controller;

import com.hxp.service.SqlQueryService;
import com.hxp.vo.SqlHistory;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hxp on 2020/3/24.
 */
@Controller
public class SqlQueryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlQueryController.class);

    @Autowired
    private SqlQueryService sqlQueryService;

    @RequestMapping("/sqlquery/check")
    public String checkSql(String sql){
        boolean result = false;
       try{
           result  =  sqlQueryService.checkSql(sql);
       }catch (Exception e){
           // TODO 处理check 错误之后的逻辑
       }
        return  "";
    }

    @RequestMapping("/sqlquery/format")
    public String formatSql(String sql){
        String  resutlSql = sqlQueryService.formatSql(sql);

        return null;
    }

    @RequestMapping("/sqlquery/execute")
    public String executeSql(String sql, HttpServletRequest request){
        UserVO user = (UserVO) request.getSession().getAttribute("user");
        SqlHistory sqlHistory = new SqlHistory();
        sqlHistory.setUsername(user.getUsername());
        sqlHistory.setSql(sql);
        sqlHistory.setStatus(1);

        //保存sql
        sqlQueryService.insertSql(sqlHistory);

        //执行sql
        sqlQueryService.executeSql(sql);
        //TODO 返回结果和日志
        return "";
    }

    @RequestMapping("/sqlquery/queryall")
    public String queryAllSql(Model model){
        List resultList =  sqlQueryService.querySqlAll();
        model.addAttribute("sqlList", resultList);
        return "/sql-query-all";
    }
}
