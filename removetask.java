

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class removetask
 */
@WebServlet("/removetask")
public class removetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removetask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		 PrintWriter out = response.getWriter();
		 
		  out.print("<html><body><p>" + "---------------Here is Removed Task-------------<br><br>Task Id : " + id + 
				  "<br>Task Removed. Have a great day!" + "</body></html>");
		  
		  try{
			  Statement s = (Statement)DatabaseInstance.getInstance().createStatement();
			  String deleteQuery = "delete from Todolist where id = " + id;
			  s.executeUpdate(deleteQuery);
			  System.out.println("Deleted successfully");
			  
		  }catch(Exception e){
			  System.out.println("Error while deleting " + e.getLocalizedMessage());
		  }
		  
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
