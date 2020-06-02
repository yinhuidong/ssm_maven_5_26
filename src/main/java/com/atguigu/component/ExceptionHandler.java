package com.atguigu.component;

import com.google.gson.Gson;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-22:01
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException
            (HttpServletRequest request,
             HttpServletResponse response, Object o, Exception e) {

        boolean isAjax = JudgeRequestType.judgeIsAjax(request);
        if (isAjax){
            try {
                String message=e.getMessage();

                Gson gson = new Gson();
                String json = gson.toJson(message);
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",e.getMessage());
        System.out.println(e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
class JudgeRequestType {

    public static boolean judgeIsAjax(HttpServletRequest request){
        String accept = request.getHeader("Accept");
        String header = request.getHeader("X-Requested-With");
        return
                (accept!=null &&accept.length()>0&&accept.contains("application/json"))
                        ||
                        (header!=null&&header.length()>0&&header.equals("XMLHttpRequest"));
    }
}
