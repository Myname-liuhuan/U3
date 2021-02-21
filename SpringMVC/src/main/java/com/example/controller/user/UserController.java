package com.example.controller.user;

import com.example.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/10/31 18:56
 *
 * @Controller : 表示该类是被spring管理的控制层类
 * @RequestMapping : 作用在类上表示该类是springMvc中的核心servlet，接收请求，参数表示为当前路径再添加一段虚拟路径(参数可以没有)
 *即:当前访问的url为 根目录/userServlet/xxx.s(因为在web.xml中定义的是.s结尾)
 *
 * 在springMVC中一个方法就表示一个功能，每个方法都有自定义的路径访问
 */
@Controller
@RequestMapping("/userServlet")
public class UserController {

    /**
     * 该方法测试能否接收到请求并返回
     * 在方法上加上RequestMapping表示再添加一个路径指向当前方法(参数必须有)
     * 如下访问本方法的路径是 : 根目录/userServlet/back.s
     * 结果是虽然会打印文字，但是前台页面上会显示404未找到，因为是没有给页面反馈(方法声明为void)
     */
    @RequestMapping("/back")
    public void toBack(){
        System.out.println("I am get request");
    }

    /**
     * RequestMapping中可以设置多个值 value = {"/back1","/first"} ，通过这些值都可以访问到该方法
     *                              method = {RequestMethod.GET,RequestMethod.POST}表示该方法可以接收的请求类型，
     *                              当没有指明method指时，默认接收所有类型的请求
     * 同时 设置RequestBody 该方法的返回值会被SpringMVC处理，然后返回给前台页面
     * 返回值为 String的时候，以"text"的方式返回
     * 返回值为 map list javabean 的时候，会被springMVC中配置的转化器(默认jackson)转化为相应的json类型
     */
    @RequestMapping(value = {"/back1","/first"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String back1(){
        return "我是你看见的第一个SpringMVC web";
    }

    /**
     * 测试Ajax访问获取数据
     * @return
     */
    @RequestMapping(value = "/back2",method = RequestMethod.GET)
    @ResponseBody
    public String back2(){
        return "true";
    }

    /**
     * 测试将user解析为json
     * @return
     */
    @RequestMapping("/back3")
    @ResponseBody
    public User back3(){
        User user = new User("Henry","男",23);
        return user;
    }

    @RequestMapping("/back4")
    @ResponseBody
    public Map<String,Object> back4(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","Henry");
        map.put("sex","男");
        map.put("age",23);
        return map;
    }

    @RequestMapping("/back5")
    @ResponseBody
    public List<User> back5(){
        User u1 = new User("Henry","男",23);
        User u2 = new User("Adele","女",30);
        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        return userList;
    }

    /**
     * 当没写 @ResponseBody且返回值值为String的时候
     * 返回值的字符串为一个路径时表示转发
     *        字符串前面加"redirect:"的时候表示重定向
     * 本方法 转发 到页面
     * @return
     */
    @RequestMapping("/back6")
    public String back6(){
        return "/pages/user/login.jsp";
    }

    /**
     * 重定向 到页面
     * 需要注意的是重定向只需要在路径前加redirect就可以了，
     * 不同于在手写servlet的时候还需要手动加项目名称，springMvc会自动添加项目名称在路径最前面
     * @return
     */
    @RequestMapping("/back7")
    public String back7(){
        return  "redirect:/pages/user/login.jsp";
    }

    /**
     * 接收表单数据
     * 给方法上面添加参数
     * 返回值void表示不做响应
     */
    @RequestMapping("/back8")
    public void back8(String name,String sex,Integer age){
        System.out.println("name: " + name +
                        "sex: "+ sex +
                        "age: "+ age);
    }

    /**
     * 当方法以JavaBean作为参数的时候，要求必须是JavaBean里面属性名称和表单提交来的参数的name值完全一样，那样数据就会被封装到实体类里面
     * @param user
     */
    @RequestMapping("/back9")
    public void back9(User user){
        System.out.println(user);
    }

    /**
     * 定义参数类型为map,同时要在参数前面加上@RequestParam注解
     * 将数据以map的形式传入
     * 标签的name的值做为map的key
     * 标签的value的值作为map的value
     * @param map
     */
    @RequestMapping("/back10")
    public void back10(@RequestParam Map<String,Object> map){
        System.out.println(map);
    }

    /**
     * 将传入的数据转发到指定页面
     * 该方法：
     * 声明多个参数，其中可以声明域对象参数，该参数就是servlet中的域对象
     * 如下
     * @param user 以怎样的方式接收表单数据
     * @param session 该次会话的session域对象
     * @param request 本次请求的request
     * @param response 本次请求的response
     * 所以可以看出该种传递数据的方式是和servlet是十分相似的
     */
    @RequestMapping("/back11")
    public String back11(User user, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        //将数据保存到域对象种后转发/重定向(取决于域对象的类型)
        session.setAttribute("user",user);
        return "/pages/user/show.jsp";
    }

    /**
     * 使用ModelAndView对象
     * 该类是spring定制的类
     * 既能传入方法接收到的数据，也能将数据解析然后发送到指定页面
     * model表示传入的数据
     * view表示接收数据的页面
     * @return
     */
    @RequestMapping("back12")
    public ModelAndView back12(User user,ModelAndView modelAndView){
        //将接收到的前台页面的数据传入modelAndView对象
        modelAndView.addObject(user);
        //然后给他设置要接收数据的页面
        modelAndView.setViewName("/pages/user/show.jsp");
        //返回一个ModelAndView的对象，将交由spring解析完成将数据转发到指定页面的工作
        return modelAndView;
    }

    /**
     * 使用其它类作为数据传输的载体
     * 因为其它类不具有自动转发的功能，所以这系列的类都是返回Strings手动转发
     * 类型: Map,Model等
     * 这些类有个特点，就是封装数据都是使用键值对的方式，因为 前台页面获取值也是key-value的方式
     * 只需要将数据装入进这些类对象种，在返回要转发的页面，
     * 因为这些类被Spring支持，可以使用这样的模式传递数据
     */
    @RequestMapping("back13")
    public String back13(User user,Map<String,Object> map){
        map.put("user",user);
        return "/pages/user/show.jsp";
    }

    /**
     * 使用Model封装要转发的数据 该类继承了Map类
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("back14")
    public String back14(User user,Model model){
        model.addAttribute("user",user);
        return "/pages/user/show.jsp";
    }
}
