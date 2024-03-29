package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittercode.model.UserRole;
import com.bittercode.util.StoreUtil;

// Http Servlet extended class for showing the about information
public class AboutServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        // If the store is logged in as customer or seller show about info
        if (StoreUtil.isLoggedIn(UserRole.CUSTOMER, req.getSession())) {
            RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.html");
            rd.include(req, res);
            StoreUtil.setActiveTab(pw, "about");
            pw.println("<div style=\"text-align:center;\">");
            pw.println("<h2>About Me</h2>");
            pw.println("<img src=\"\" alt=\"https://th.bing.com/th/id/OIP.KniGhXTX-xdK5oH98OzkKwHaLG?w=683&h=1024&rs=1&pid=ImgDetMain\" style=\"width:300px;height:300px;\">");
            pw.println("<p>Welcome to my personal website! Feel free to explore.</p>");
            pw.println("<p>Check out my <a href=\"https://github.com/KarnatiHemalatha\">GitHub Profile</a>.</p>");
            pw.println("</div>");

        } else if (StoreUtil.isLoggedIn(UserRole.SELLER, req.getSession())) {
            RequestDispatcher rd = req.getRequestDispatcher("SellerHome.html");
            rd.include(req, res);
            StoreUtil.setActiveTab(pw, "about");
            pw.println("<div style=\"text-align:center;\">");
            pw.println("<h2>About Me</h2>");
            pw.println("<img src=\"https://th.bing.com/th/id/OIP.KniGhXTX-xdK5oH98OzkKwHaLG?w=683&h=1024&rs=1&pid=ImgDetMain\" alt=\"Your Picture\" style=\"width:300px;height:300px;\">");
            pw.println("<p>Welcome to my personal website! Feel free to explore.</p>");
            pw.println("<p>Check out my <a href=\"https://github.com/KarnatiHemalatha\">GitHub Profile</a>.</p>");
            pw.println("</div>");

        } else {
            // If the user is not logged in, ask to login first
            // Proceed only if logged in or forward to login page
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
            pw.println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
        }

    }

}