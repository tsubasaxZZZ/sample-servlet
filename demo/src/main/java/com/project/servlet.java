package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class servlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger();

    public void processRequest(HttpServletRequest request, HttpServletResponse response, String h1) throws IOException {
        System.out.println("Hello World");
        
        String logLevel = System.getenv("LOG_LEVEL");
        if (logLevel != null) {
            Configurator.setRootLevel(Level.toLevel(logLevel));
        }
        logger.fatal("FATAL テスト");
        logger.error("ERROR テスト");
        logger.warn("WARN テスト");
        logger.info("INFO テスト");
        logger.debug("DEBUG テスト");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String cssTag = "<link rel='stylesheet' type='text/css' href='./styling/style.css'>";

        out.println("<html><head><title>Servlet Home Page</title>" + cssTag + "</head>");
        out.println("<body>");
        out.println("<h1>" + h1 + "</h1>");
        out.println("<h1>0602a</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String data = "param=" + request.getParameter("param") + " | ENV_PARAM=" + System.getenv("ENV_PARAM") + " | COMPUTERNAME=" + System.getenv("COMPUTERNAME");
        String sessionData = (String) session.getAttribute("data");
        if (sessionData == null) {
            session.setAttribute("data", data);
            sessionData = "Session is null";
        }
        System.out.println(sessionData);
        processRequest(request, response, sessionData);
    }
}
