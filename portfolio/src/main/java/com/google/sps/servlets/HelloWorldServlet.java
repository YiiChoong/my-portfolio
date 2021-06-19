package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> list = new ArrayList<String>();
    list.add("I used to interested in art and I considered myself good at sketching, I supposed...");
    list.add("I am a slow to warm up person, I will need a while to get comfortable to whom I just meet.");
    list.add("I like to binge-watch tv or movie series whenever I have nothing else to do.");

    // convert to Json
    String json = convertJsonByGson(list);

    // send the Json as response
    response.setContentType("text/html;");
    response.getWriter().print(json);
  }

  private String convertJsonByGson(ArrayList<String> fact){
    Gson gson = new Gson();
    String json = gson.toJson(fact);
    return json;
  }
}
