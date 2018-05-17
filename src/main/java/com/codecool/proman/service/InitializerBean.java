package com.codecool.proman.service;

import com.codecool.proman.model.Project;
import com.codecool.proman.model.Task;
import com.codecool.proman.model.Users;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class InitializerBean {

    public InitializerBean(UserService userService, ProjectService projectService, TaskService taskService) {

        //GET DATE INSTANCES
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //PROJECT DATE INSTANCES
        java.util.Date project1StartDate = Calendar.getInstance().getTime();
        java.util.Date project1EndDate = Calendar.getInstance().getTime();
        java.util.Date project2StartDate = Calendar.getInstance().getTime();
        java.util.Date project2EndDate = Calendar.getInstance().getTime();
        java.util.Date project3StartDate = Calendar.getInstance().getTime();
        java.util.Date project3EndDate = Calendar.getInstance().getTime();

        //TASK DATE INSTANCES
        java.util.Date task1StartDate = Calendar.getInstance().getTime();
        java.util.Date task1EndDate = Calendar.getInstance().getTime();
        java.util.Date task2StartDate = Calendar.getInstance().getTime();
        java.util.Date task2EndDate = Calendar.getInstance().getTime();
        java.util.Date task3StartDate = Calendar.getInstance().getTime();
        java.util.Date task3EndDate = Calendar.getInstance().getTime();
        java.util.Date task2per1StartDate = Calendar.getInstance().getTime();
        java.util.Date task2per1EndDate = Calendar.getInstance().getTime();


        try {
            //SET DATE INSTANCES TO PROJECTS
            project1StartDate = sdf.parse("2018-05-14");
            project1EndDate = sdf.parse("2018-06-30");
            project2StartDate = sdf.parse("2019-01-01");
            project2EndDate = sdf.parse("2020-01-01");
            project3StartDate = sdf.parse("2022-01-01");
            project3EndDate = sdf.parse("2022-02-01");

            //SET DATE INSTANCES TO PROJECTS
            task1StartDate = sdf.parse("2018-05-17");
            task1EndDate = sdf.parse("2018-05-24");
            task2StartDate = sdf.parse("2018-06-12");
            task2EndDate = sdf.parse("2018-07-21");
            task3StartDate = sdf.parse("2019-01-02");
            task3EndDate = sdf.parse("2019-12-11");
            task2per1StartDate = sdf.parse("2019-01-02");
            task2per1EndDate = sdf.parse("2019-12-11");

        //CATCH PARSE EXCEPTION IS A MUST
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //CREATE AND PERSIST USER INSTANCES
        Users user1 = new Users("user1","1234","valami@valami.hu");
        userService.save(user1);

        Users user2 = new Users("u2","0000","inv@inv.hu");
        userService.save(user2);


        //CREATE SET AND PERSIST PROJECT INSTANCES
        Project project1 = new Project("Project1", user1);
        project1.setProjectStartDate(project1StartDate);
        project1.setProjectEndDate(project1EndDate);
        project1.setProjectDescription("rajtavagyok a projecten de nagyon");
        project1.setProjectUserNotes("project1-hez tartozó note");
        projectService.save(project1);

        Project project2 = new Project("p2", user1);
        project2.setProjectStartDate(project2StartDate);
        project2.setProjectEndDate(project2EndDate);
        project2.setProjectDescription("tök másik project");
        project2.setProjectUserNotes("Note a p2 höz");
        projectService.save(project2);

        Project project3 = new Project("Pro3", user2);
        project3.setProjectStartDate(project3StartDate);
        project3.setProjectEndDate(project3EndDate);
        project3.setProjectDescription("xxxxxxxx");
        project3.setProjectUserNotes("éajdflékafj");
        projectService.save(project3);

        //CREATE SET AND PERSIST TASK INSTANCES
        Task task1 = new Task("task1", user1, project1);
        task1.setTaskStartDate(task1StartDate);
        task1.setTaskFinishDate(task1EndDate);
        task1.setTaskDescription("ez egy egyszerű feladat. Vagy mégsem?!");
        task1.setTaskUserNotes("note a Taskhoz");

        Task task2 = new Task("task2", user1, project1);
        task2.setTaskStartDate(task2StartDate);
        task2.setTaskFinishDate(task2EndDate);
        task2.setTaskDescription("Ez a következő feladat, de előbb is meg lehet csinálni");
        task2.setTaskUserNotes("Másik note");

        Task task3 = new Task("task3", user1, project2);
        task3.setTaskStartDate(task3StartDate);
        task3.setTaskFinishDate(task3EndDate);
        task3.setTaskDescription("Project2 höz tartozó feladat");
        task3.setTaskUserNotes("Ide note-ot kell írni");

        Task task4 = new Task("task4", user2, project3);
        task4.setTaskStartDate(task2per1StartDate);
        task4.setTaskFinishDate(task2per1EndDate);
        task4.setTaskDescription("Pro3 task");
        task4.setTaskUserNotes("NOTE HELYE");

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

        Users user3 = new Users("userthree","xxxx","xyz@xyz.hu");
        userService.save(user3);

        project1.addUserToProject(user3);
        projectService.save(project1);

        task2.addUserToTask(user3);
        taskService.save(task2);

    }
}
