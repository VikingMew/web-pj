package weibo;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;

public interface Routee {
    public void get(HttpServletRequest request,
                      HttpServletResponse response,
                      Vector<String> args)
    throws IOException, ServletException;
    public void post(HttpServletRequest request,
                      HttpServletResponse response,
                      Vector<String> args)
    throws IOException, ServletException;

}