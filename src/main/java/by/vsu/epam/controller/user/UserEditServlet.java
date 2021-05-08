package by.vsu.epam.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.epam.controller.BaseServlet;
import by.vsu.epam.domain.Role;
import by.vsu.epam.domain.User;
import by.vsu.epam.service.UserService;
import by.vsu.epam.util.ServiceFactory;

public class UserEditServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            try(ServiceFactory factory = getFactory()) {
                UserService service = factory.getUserService();
                User user = service.findById(id);
                req.setAttribute("user", user);
                boolean userCanBeDeleted = service.canDelete(id);
                req.setAttribute("userCanBeDeleted", userCanBeDeleted);
            } catch(Exception e) {
                throw new ServletException(e);
            }
        }
        req.setAttribute("roles", Role.values());
        req.getRequestDispatcher("/WEB-INF/jsp/user/edit.jsp").forward(req, resp);
    }
}
