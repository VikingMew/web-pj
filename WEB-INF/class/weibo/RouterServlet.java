package weibo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * The simplest possible servlet.
 *
 * @author VikingMew
 */

public class RouterServlet extends HttpServlet {

    private HashMap<Pattern,Routee> routelist;
    private HashMap<String,String> settings;
    @override 
    public void init() throws ServletException {
    }
    public RouterServlet() {
        routelist.put(Pattern.compile("/(*)"), new MainServlet());
    }
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        // ResourceBundle rb =
        //     ResourceBundle.getBundle("LocalStrings",request.getLocale());
        // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String path = request.getPathInfo();
        // Routee routee;

        // for(Map.Entry<Pattern,Routee> item:routelist.entrySet()) {
        //     Matcher m = item.getKey().matcher(path);
        //     if (m.matches) {

        //         break;
        //     }
        // }
        // routee.get(request,response,args);
        // out.println("<html>");
        // out.println("<head>");

        // String title = rb.getString("helloworld.title");

        out.println("<title>" + "miaowu" + "</title>");
        // out.println("</head>");
        // out.println("<body bgcolor=\"white\">");
    }
}



