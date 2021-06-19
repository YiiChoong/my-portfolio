package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.sps.data.Task;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;


/** Servlet responsible for creating new tasks. */
@WebServlet("/contact-message")
public class ContactServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Sanitize user input to remove HTML tags and JavaScript.
    String userName = Jsoup.clean(request.getParameter("userName"), Whitelist.none());
    String userEmail = Jsoup.clean(request.getParameter("userEmail"), Whitelist.none());
    String message = Jsoup.clean(request.getParameter("messages"), Whitelist.none());

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("username", userName)
            .set("userEmail", userEmail)
            .set("message", message)
            .build();
    datastore.put(taskEntity);

    response.sendRedirect("/index.html#contact");
  }
}
