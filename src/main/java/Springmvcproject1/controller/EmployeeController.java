package Springmvcproject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Springmvcproject1.Dao.EmployeeDao;
import Springmvcproject1.dto.EmployeeDto;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/insert")
    public String insert(@ModelAttribute EmployeeDto employee) {
        employeeDao.addUser(employee);
        return "data_received";
    }

    @GetMapping("/fetchall")
    public ModelAndView fetchAll() {
        List<EmployeeDto> employees = employeeDao.fetchall();
        ModelAndView view = new ModelAndView("fetchall1.jsp");
        view.addObject("object", employees);
        return view;
    }

    @GetMapping("/fid")
    public ModelAndView fetchById(@RequestParam int id) {
        Object employee = employeeDao.fetchID(id);
        ModelAndView view = new ModelAndView("fetchid.jsp");
        view.addObject("object", employee);
        return view;
    }

    @PostMapping("/did")
    public String deleteById(@RequestParam int id) {
        employeeDao.deleteID(id);
        return "redirect:/fetchall";
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id) {
        employeeDao.deleteID(id);
        return fetchAll();
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestParam int id, @RequestParam String name) {
        employeeDao.updatewith(id, name);
        return fetchAll();
    }
}
