package com.sabarinath.employeeScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {


    @Autowired
    sqlrepository sqlrepository;

    @GetMapping("/employeedets")
    public List<EmployeeTaskDetails> index() {
        return sqlrepository.findAll();
    }

    @GetMapping("/employeedets/{empid}")
    public EmployeeTaskDetails show(@PathVariable String empid) {
        int eid= Integer.parseInt(empid);
        return sqlrepository.findOne(eid);
    }

    @PostMapping("/employeedets/search")
    public List<EmployeeTaskDetails> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return sqlrepository.findBySearch(searchTerm);
    }

    @PostMapping("/employeedets/searchbydate")
    public List<EmployeeTaskDetails> search(@RequestBody Date date){
        return sqlrepository.findScheduleByDate(date);
    }

    @PostMapping("/employeedets/create")
    public EmployeeTaskDetails create(@RequestBody EmployeeTaskDetails employeeTaskDetails)
    {
        int employeeid = employeeTaskDetails.getEmployeeid();
        Date startdate = employeeTaskDetails.getStartdate();
        Date enddate = employeeTaskDetails.getEnddate();
        LocalTime timeoftask = employeeTaskDetails.getTimeoftask();
        int duration = employeeTaskDetails.getDuration();
        String nameofemp = employeeTaskDetails.getNameofemp();
        Frequency frequency = employeeTaskDetails.getFrequency();
        Boolean isrepeat = employeeTaskDetails.getIsRepeat();


        //If RequestBody is rceeived as Map<String, String>:
        //String startdates = body.get("startdate");
       //java.util.Date startdate = null;
       //java.util.Date enddate = null;
       //java.util.Date timeoftask = null;
       //SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

       //try{
       //    startdate = formatter.parse(startdates);
       //}
       //catch (ParseException e){
       //    e.printStackTrace();
       //}

       //String enddates = body.get("enddate");

       //try{
       //    enddate = formatter.parse(enddates);
       //}
       //catch (ParseException e){
       //    e.printStackTrace();
       //}

       //String timeoftasks = body.get("timeoftask");
       //try{
       //    timeoftask = formatter.parse(timeoftasks);
       //}
       //catch (ParseException e){
       //    e.printStackTrace();
       //}
       //String durations = body.get("duration");
       //int duration = Integer.parseInt(durations);
       //String freq  = body.get("frequency");
       //Frequency frequency = Frequency.valueOf(freq);
       //String nameofemp = body.get("nameofemp");
       //String isrepeats = body.get("isrepeat");
       //Boolean isrepeat = Boolean.parseBoolean(isrepeats);

        return sqlrepository.save(new EmployeeTaskDetails(employeeid, startdate, enddate, timeoftask, duration, isrepeat, frequency, nameofemp));
    }

    @PutMapping("/employeedets/update/{id}")
    public EmployeeTaskDetails update(@PathVariable Integer id,@RequestBody EmployeeTaskDetails employeeTaskDetails)
    {
        int employeeid = id;
        Date startdate = employeeTaskDetails.getStartdate();
        Date enddate = employeeTaskDetails.getEnddate();
        LocalTime timeoftask = employeeTaskDetails.getTimeoftask();
        int duration = employeeTaskDetails.getDuration();
        String nameofemp = employeeTaskDetails.getNameofemp();
        Frequency frequency = employeeTaskDetails.getFrequency();
        Boolean isrepeat = employeeTaskDetails.getIsRepeat();

        return sqlrepository.save(employeeTaskDetails);
    }

    @DeleteMapping("/employeedets/delete/{id}")
    public boolean deleteSchedule(@PathVariable Integer id){
        sqlrepository.deleteById(id);
        return true;
    }

    @GetMapping("/")
    public String helloagain(@RequestParam String name) {
        return String.format("Hello %s!", name);
    }
}
