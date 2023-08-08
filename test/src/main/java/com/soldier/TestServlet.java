package com.soldier;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/servlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] aihaos = request.getParameterValues("aihao");
        Arrays.stream(aihaos).forEach(aihao -> {
            System.out.println(aihao);
        });
    }
}
