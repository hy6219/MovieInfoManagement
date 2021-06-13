package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.MovieDao.MovieDao;
import com.js.MovieDto.MovieDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MovieUpdateServlet
 */
@WebServlet("/movieUpdate.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	MovieDao dao  = MovieDao.getInstance();
    public MovieUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int code 	  = Integer.valueOf(request.getParameter("code"));
		MovieDto target= dao.selectOne(code);
		
		request.setAttribute("targetToUpdate", target);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./movie/updateMovie.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			ServletContext context = getServletContext();
			String realPath =context.getRealPath("upload");
			
			int    sizeLimit= 10 * 1024*1024;
			String encType  = "UTF-8";
			
			
			MultipartRequest multi = new MultipartRequest(
					request,
					realPath,
					sizeLimit,
					encType,
					new DefaultFileRenamePolicy()
					);
			int    code  = Integer.valueOf(multi.getParameter("code"));
			String title = multi.getParameter("title");
			int    price = Integer.valueOf(multi.getParameter("price"));
			String director= multi.getParameter("director");
			String actor   = multi.getParameter("actor");
			String synopsis= multi.getParameter("synopsis");
			String poster  = multi.getFilesystemName("poster");
			MovieDto dto   = new MovieDto();
			
			if(poster==null) {
				poster = multi.getParameter("posterBefore");
			}
			
			dto.setCode(code);
			dto.setTitle(title);
			dto.setPrice(price);
			dto.setDirector(director);
			dto.setActor(actor);
			dto.setSynopsis(synopsis);
			dto.setPoster(poster);
			
			dao.updateInfo(dto);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("movieList.do");
	}

}
