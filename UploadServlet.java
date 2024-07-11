import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UploadServlet")  // this servlet will handle requests to the /UploadServlet URL.
@MultipartConfig  //servlet will handle file uploads
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;   //serialized object can be deserialized correctly 1l where L denotes long class 1 denotes baese class

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //handles POST requests.
        response.setContentType("text/html;charset=UTF-8");  //sets return type to html form

        // Part class to handle file upload
        Part filePart = request.getPart("file");  //Retrieves the uploaded file part from the request.

        try (InputStream fileContent = filePart.getInputStream()) {  //Opens an input stream to read the file's content.
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));  //just like scanner to wrap the class

            
            PrintWriter out = response.getWriter();  // Generate HTML for table
            out.println("<html><head><title>Uploaded Excel File Contents</title></head><body>");  //content
            out.println("<h2>Uploaded Excel File Contents</h2>");
            out.println("<table border='1'>");

            String line;
            //boolean headerRow = true;  //A flag to indicate if the current row is the header row.

            while ((line = reader.readLine()) != null) {  //Reads the file line by line.
                out.println("<tr>");   //new row is started

               
                String[] cells = line.split(",");   // Split line by comma (CSV format) adjust based on excel format
                
                for (String cell : cells) {  //iterate cell wise
                  //  if (headerRow) {  //If it's the header row (headerRow is true), the content is wrapped in <th> tags. Otherwise, it's wrapped in <td> tags.
                    //    out.println("<th>" + cell + "</th>");   //to print in table
                  //  } else { 
                        out.println("<td>" + cell + "</td>");
                  //  }
                }

                out.println("</tr>");
              //  headerRow = false;  //now no header file is there so false
            }

            out.println("</table>");
            out.println("<br><br><a href='uploadForm.jsp'>Upload Another File</a>");
            out.println("</body></html>");

        } catch (Exception e) {
        
        }
    }
}
