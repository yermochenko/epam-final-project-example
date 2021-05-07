package by.vsu.epam.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.epam.controller.BaseServlet;
import by.vsu.epam.domain.User;
import by.vsu.epam.service.UserService;
import by.vsu.epam.util.ServiceFactory;

public class UserListServlet extends BaseServlet {
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
