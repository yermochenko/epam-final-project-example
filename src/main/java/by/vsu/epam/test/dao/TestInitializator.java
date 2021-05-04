package by.vsu.epam.test.dao;

import by.vsu.epam.util.Connector;

public class TestInitializator {
    public static void init() {
        try {
            Connector.init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/epam_project_db?useUnicode=true&characterEncoding=UTF-8", "root", "");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
