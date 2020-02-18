import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MinServlet", urlPatterns = {"/MinServlet"})
public class MinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Requestscope: kortvarig levetid, eksisterer midlertidigt på ens side.
        // Sessionscope: Lever i omkring 30 min (cookie).
        // Applicationscope: Lever så længe programmet/serveren kører.

        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("navn");
        System.out.println(navn);

        HttpSession session = request.getSession();
        session.setAttribute("bruger", navn);
        request.setAttribute("navn", navn.toUpperCase());
        request.getRequestDispatcher("index.jsp").forward(request, response);

        List<String> navne;
        if (servletContext.getAttribute("brugere") == null) {
            navne = new ArrayList<>();
            servletContext.setAttribute("brugere", navne);
        }
        ((List<String>)servletContext.getAttribute("brugere")).add(navn);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("Velkommen.jsp").forward(request, response);

    }
}
