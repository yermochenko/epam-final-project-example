package by.vsu.epam.controller.user.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.epam.controller.BaseServlet;
import by.vsu.epam.domain.User;
import by.vsu.epam.service.UserService;
import by.vsu.epam.util.ServiceFactory;

public class PasswordResetServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(ServiceFactory factory = getFactory()) {
            UserService service = factory.getUserService();
            User user = service.findById(Long.parseLong(req.getParameter("id")));
            if(user != null) {
                service.changePassword(user.getId(), user.getPassword(), null);
            }
            resp.sendRedirect(req.getContextPath() + "/user/list.html");
        } catch(NumberFormatException e) {
            resp.sendError(400);
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
}
