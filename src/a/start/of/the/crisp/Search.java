package a.start.of.the.crisp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Search goes by the doPost. to handle more text and make it safer
		
		doGet(request, response);
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter(); didnt use it!
		RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
		
		SearchingTheBase base = new SearchingTheBase();
		SplittingTheSearch split = new SplittingTheSearch();
		String[] words = split.destroyAndAssemble(request.getParameter("search"));
		
		System.out.println(words);		
		
		//sending the query to the search funktion. SearchingTheBase.java
		//that prints the result in Console atm
		String[] result = base.queryFromDb(words);
		
		//Sending Results to the resluts.jsp page so it can display it in a good enough way!
		request.setAttribute("information", result);
		dispatcher.forward(request, response);
		
		
		
//		for(String e : result) {
//			System.out.println(e);
//		}
//		
//		out.write("<ul>");
//		for(String e: result) {
//			out.write("<li>" + e + "</li>");
//		}
//		out.write("</ul>");
//		
	}

}
