package member.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberEmailServlet
 */
@WebServlet("/emailServlet.do")
public class MemberEmailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
   
           String user = "jazzhong5@gmail.com"; // gmail 계정
           String password = "1zjvldndb";   // 패스워드

           // SMTP 서버 정보를 설정한다.
           Properties prop = new Properties();
           prop.put("mail.smtp.starttls.enable", "true");
           prop.put("mail.smtp.host", "smtp.gmail.com"); 
           prop.put("mail.smtp.port", 465); 
           prop.put("mail.smtp.auth", "true"); 
           prop.put("mail.smtp.ssl.enable", "true"); 
           prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
           
           Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(user, password);
               }
           });

           int result =0;
           try {
               MimeMessage message = new MimeMessage(session);
               message.setFrom(new InternetAddress(user));
               System.out.println(request.getParameter("memberEmail"));

               //수신자메일주소
               message.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getParameter("memberEmail"))); 

               // Subject
               message.setSubject("FoodTruckGuide"); //메일 제목을 입력

               Random random = new Random();
               result = random.nextInt(10000)+1000;
               
               if(result>10000){
                   result = result - 1000;
               }

               // Text
               message.setText("인증번호 : "+result);    //메일 내용을 입력

               // send the message
               Transport.send(message); ////전송
               System.out.println("message sent successfully...");
           } catch (AddressException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           } catch (MessagingException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           
           System.out.println("인증번호 : "+result);
           response.getWriter().append(String.valueOf(result));
          
           
       }


   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}