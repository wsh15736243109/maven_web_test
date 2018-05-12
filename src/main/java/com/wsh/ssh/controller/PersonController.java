package com.wsh.ssh.controller;

import com.wsh.ssh.domain.PersonModel;
import com.wsh.ssh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping("/saveperson")
    public String addPerson(PersonModel personModel) {
        personService.addPerson(personModel);
        return "redirect:main";
    }

    /**
     * 查询所有人员信息
     *
     * @param map 使用的是map保存回显数据
     * @return
     */
    @RequestMapping(value = "/main")
    public String mian(Map<String, Object> map) {
        map.put("personlist", personService.queryPerson());
        /*遍历集合，查看查询到的数据
		 * List<Person> lists = personService.getPersons();
		 * Iterator<Person> it = lists.iterator();
		 * while(it.hasNext()){
		 * 		Person p =it.next();
		 *	 	System.out.println(p.toString());
		 *  }
		 */
        return "main";
    }

    /**
     * 跳转到添加页面
     * savepage.jsp
     *
     * @return
     */
    @RequestMapping(value = "/addperson")
    public String saveperson() {

        return "savepage";
    }


    @RequestMapping("/deletePerson")
    public int deletePerson(String id) {
        personService.deletePerson(id);
        return 0;
    }

    @RequestMapping("/updatePerson")
    public int updatePerson(PersonModel personModel) {
        personService.updatePerson(personModel);
        return 0;
    }
    @RequestMapping("/getPersons")
    @ResponseBody
    public List<PersonModel> queryPerson() {

        return personService.queryPerson();
    }

    @RequestMapping("/queryPersonById")
    @ResponseBody
    public PersonModel queryPersonById(String id) {
        return personService.queryPersonById(id);
    }

    /**
     * 跳转到更新页面，回显数据
     * editpage.jsp
     * @param id
     * @param model 使用的Model保存回显数据
     * @return
     */
    @RequestMapping(value = "/doupdate")
    public String doupdate(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("person", personService.queryPersonById(id));
        return "editpage";
    }

    /**
     * 删除一条数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletePersonById")
    public String deletePersonById(@RequestParam(value = "id") String id) {
        System.out.println("删除单个");
        personService.deletePerson(id);
        return "redirect:main";
    }

    @RequestMapping("toHtml")
    public String toHtml() {
        return "test_html";
    }

    @RequestMapping("tojQueryHtml")
    public String tojQueryHtml() {
        return "jQueryMobileHtml";
    }

//    @RequestMapping("/toJSP")
//    public ModelAndView toIndex(){
//        ModelAndView mv = new ModelAndView();
//
//        mv.setViewName("main");
//
//        return mv;
//
//    }
//
//    @RequestMapping("/toHtml")
//    public ModelAndView toHtml(){
//        ModelAndView mv = new ModelAndView();
//
//        mv.setViewName("test_html");
//
//        return mv;
//
//    }
}
