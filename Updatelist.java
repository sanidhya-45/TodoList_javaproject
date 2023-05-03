

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatelist
 */
@WebServlet("/Updatelist")
public class Updatelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatelist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String taskname = request.getParameter("taskname");
        String time = request.getParameter("time");
        String priority = request.getParameter("priority");   
        
        
        try{
        	Statement s = (Statement)DatabaseInstance.getInstance().createStatement();
        	
        	int id = Integer.parseInt(request.getParameter("id"));
    		
    		String findEntry = String.format("Select * from Todolist where id = %s", id);
    		ResultSet fetchQueryResult = s.executeQuery(findEntry);
    		boolean isFound = false;
    		while(fetchQueryResult.next()){
	            isFound = true;
	         }
    		if(!isFound){
    			System.out.println("no list found with the given id");
    			return;
    		}
    		
    		System.out.println(fetchQueryResult);
    		
    		
    		String updateTheEntry = String.format("update Todolist set taskname = '%s', time = '%s', priority = '%s' where id = %s", taskname, time, priority, id);

			s.executeUpdate(updateTheEntry);
    		
        	
        
        	System.out.println("list updated sucessfully");
        	
        	
        	
			 
			
        	
        	
        }catch(Exception e){
        	System.out.println("Error while updating the list " + e.toString());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
