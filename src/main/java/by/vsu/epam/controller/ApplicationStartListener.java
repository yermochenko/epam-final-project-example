package by.vsu.epam.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.vsu.epam.util.Connector;

public class ApplicationStartListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Connector.init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/epam_project_db?useUnicode=true&characterEncoding=UTF-8", "root", "");
        } catch(ClassNotFoundException e) {
            logger.fatal("Can't initialize class {}", Connector.class.getName(), e);
        }
    }
}
