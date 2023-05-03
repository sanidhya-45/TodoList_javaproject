
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sanidhya
 */
@WebServlet("/sanidhya")
public class sanidhya extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sanidhya() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String id = request.getParameter("id");
	    String taskname =  request.getParameter("taskname");
	    String time = request.getParameter("time");
        String priority = request.getParameter("priority");
       
        PrintWriter out = response.getWriter();
        
        
        out.print("<html><body><p>" + "---------------Here is your today's list-------------<br><br>Task Id : " + id + "<br></p><p>Task name: " + taskname + "</p>");
        out.print("<p>Time  " + time + "</p><p>Priority : " + priority  );
        
        try{
        	Statement s = (Statement)DatabaseInstance.getInstance().createStatement();
        	
        	String insertIntoTable = String.format("insert into Todolist (id, taskname, time ,priority)"
        			+ " values ('%s','%s','%s','%s')", 
        			id, taskname, time, priority);
        	
        	int rs = s.executeUpdate(insertIntoTable);
        
        	System.out.println("Task added");
        	
        	
        	String getAllBookings = String.format("select * from Todolist");
			 
			 ResultSet fetchQueryResult = s.executeQuery(getAllBookings);
			 
			 System.out.println("Your List  ");
			 
			 while(fetchQueryResult.next()){
		            //Display values
		            System.out.print("ID: " + fetchQueryResult.getInt("id"));
		            System.out.print(", Task Name: " + fetchQueryResult.getString("taskname"));
		            System.out.print(", Time : " + fetchQueryResult.getString("time"));
		            System.out.print(", Priority : " + fetchQueryResult.getString("priority"));
		        
		         }
        	
        	
        }catch(Exception e){
        	System.out.println("Error while inserting into database " + e.toString());
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
