package com.dashboard.servlet.toolservlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncServlet
 */
//for filter  would have to add asyncsuppoprted to same spot in filter class
@WebServlet(urlPatterns="/async", asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsyncServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AsyncContext asyncContext = request.startAsync();
		response.getWriter().append("I'm thread one. Thread two is slow so he is separated\n");
		//I happen in a separate thread
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				try {

					response.getWriter().append("I'm thread two. I'm gonna take forever so I'm separated \n");
					Thread.sleep(2000);
					response.getWriter().append("I'm done (thread two)\n");
					asyncContext.complete();
				}catch(InterruptedException e) {

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});
		response.getWriter().append("I'm much quicker and didn't want to wait for thread two to finish, so I'll go ahead and finish (thread one)\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}