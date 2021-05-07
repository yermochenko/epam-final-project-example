package by.vsu.epam.controller;

import javax.servlet.http.HttpServlet;

import by.vsu.epam.util.MainServiceFactoryImpl;
import by.vsu.epam.util.ServiceFactory;

abstract public class BaseServlet extends HttpServlet {
    public ServiceFactory getFactory() {
        return new MainServiceFactoryImpl();
    }
}
