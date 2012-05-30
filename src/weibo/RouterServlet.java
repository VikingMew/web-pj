package weibo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * The simplest possible servlet.
 *
 * @author VikingMew
 */

public class RouterServlet extends HttpServlet {

	private static final long serialVersionUID = 8688660439638329269L;
	private HashMap<Pattern,Routee> routelist;
    private HashMap<String,String> settings;

    public RouterServlet() {
    	routelist = new HashMap<Pattern,Routee>();
        routelist.put(Pattern.compile("^/(.*)"), 
        		new MainServlet());
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
        Vector<String> args = new Vector<String>();
        Routee routee = null;

        for(Map.Entry<Pattern,Routee> item:routelist.entrySet()) {
           Matcher m = item.getKey().matcher(path);
           if (m.matches()) {
        	   routee = item.getValue();
        	   for (int i = 0; i < m.groupCount();i++) {
        		   args.add(m.group(i));
        	   }
               break;
            }
        }
        if(routee != null) {
        	routee.get(request, response, args);
        }
        else {
        	out.println("No such routee");
        }
        // routee.get(request,response,args);
        // out.println("<html>");
        // out.println("<head>");

        // String title = rb.getString("helloworld.title");

        //out.println("<title>" + "miaowu" + "</title>");
        // out.println("</head>");
        // out.println("<body bgcolor=\"white\">");
    }
}



