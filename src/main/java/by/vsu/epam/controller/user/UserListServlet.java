package by.vsu.epam.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.vsu.epam.controller.BaseServlet;
import by.vsu.epam.domain.User;
import by.vsu.epam.service.UserService;
import by.vsu.epam.util.Connector;
import by.vsu.epam.util.ServiceFactory;

public class UserListServlet extends BaseServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void init() throws ServletException {
        try {
            Connector.init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/epam_project_db?useUnicode=true&characterEncoding=UTF-8", "root", "");
        } catch(ClassNotFoundException e) {
            logger.fatal("Can't initialize class {}", Connector.class.getName(), e);
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(ServiceFactory factory = getFactory()) {
            UserService service = factory.getUserService();
            List<User> users = service.findAll();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/WEB-INF/jsp/user/list.jsp").forward(req, resp);
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
}
