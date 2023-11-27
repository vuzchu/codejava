/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vu
 */
public class Manager {

    List<Task> taskList = new ArrayList<>();
    Utils valUtils = new Utils();

    public void addTask() {
        try {
            System.out.println("--------------- Add task ---------------");
            int id = 1;
            if (!taskList.isEmpty()) {
                id = taskList.get(taskList.size() - 1).getId() + 1;
            }

            String name = valUtils.checkInputString("^[a-zA-Z]+", "Xin tên người dùng");
            int taskTypeId = valUtils.getInt(4, 1, "Nhap taskID (1-4)");
            String date = valUtils.getDate("Nhập ngày", "dd-MM-yyyy");
            double from = valUtils.getDouble(17.5, 8.0, "Nhập thời gian bắt đầu");
            double to = valUtils.getDouble(17.5, from, "Nhập thời gian kết thúc");
            String assign = valUtils.checkInputString("^[a-zA-Z]+", "Xin tên người Nhận task");
            String reviewer = valUtils.checkInputString("^[a-zA-Z]+", "Xin tên người review");

            Task task = new Task(id, taskTypeId, name, date, from, to, assign, reviewer);
            taskList.add(task);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void displayTask() {
        System.out.println("--------------- Display Task ---------------");
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }

    public void deleteTask() throws IOException {
        System.out.println("--------------- Delete task ---------------");
        int deleteId = valUtils.getInt(Integer.MAX_VALUE, 1, "nhap id muon xoa");
        boolean isExist = false;
        for (Task task : taskList) {

            if (task.getId() == deleteId) {
                isExist = true;
                taskList.remove(task);
                System.out.println("task đã xóa");
                break;
            }
        }

        if (!isExist) {
            System.out.println("id khong tồn tại");
        }

    }

   

    public void menu() throws IOException {
        Manager manager = new Manager();

        boolean check = true;
        while (check) {
            System.out.println("==== Task Program ====");
            System.out.println("1.Add Task");
            System.out.println("2.Delete Task");
            System.out.println("3.Display");
            System.out.println("4.Exit");

            int option = valUtils.getInt(4, 1, "Enter choice");

            switch (option) {
                case 1:
                    manager.addTask();
                    break;
                case 2:
                    manager.deleteTask();
                    break;
                case 3:
                    manager.displayTask();
                    break;
                case 4:
                    check = false;
                    break;
            }

        }

    }

}
