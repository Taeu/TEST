package d0705;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

// 각 client로 부터 전송된 문자열을 수신하여 다른 client에게 문자열을 보내준다.
class EchoThread extends Thread{
	Socket socket;
	Vector<Socket> vec;
	
	public EchoThread(Socket socket, Vector<Socket> vec){
		this.socket = socket;
		this.vec = vec;
	}
	
	public void run(){
		BufferedReader br = null;
		try{
			br = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			String str = null; // br에 들어온 문자열의 내용을 위한 변수
			
			while(true){ //프로그램이 종료될 때까지 소켓으로부터 데이터를 받기위해서 반복문을 사용
				//클라이언트로부터 받은 문자열을 str에 저장한다.
				str  = br.readLine(); 
				
				//클라이언트가 접속을 끊었을 경우 
				if(str == null){
					// 소켓을 벡터에서 없앰
					vec.remove(socket);
					break;
				}
				
				//연결된 소켓들을 통해서 다른 클라이언트들에게 문자열을 전송한다.
				sendMsg(str);
				
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		} finally{
			try{
				if(br != null) br.close();			//BufferedReader가 열려있으면 닫는다.
				if(socket != null) socket.close();	//socket 이 열려있으면 닫는다.
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
	//전송받은 문자열을 다른 클라이언트들에게 전송해준다.
	public void sendMsg(String str){
		try{
			for(Socket socket : vec){ // 전송할 소켓들의 수만큼 반복한다.
				// 반복을 수행하되 메세지를 보낸 클라이언트를 제외하고 나머지 소켓들에게 메세지를 전송한다.
				if(socket != this.socket){
					PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
					pw.println(str);
					pw.flush(); // 다시 쓸 수 있게 자신을 clear
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
//server
public class ChattingProgram {
	public static void main(String[] args){
		ServerSocket server = null;
		Socket socket = null;
		// 클라이언트와 연결된 소켓들을 배열로 저장한다.
		Vector<Socket> vec = new Vector<Socket>();
		try{
			// 클라이언트로부터 접속을 받기 위해서 ServerSocket을 포트번호를 가지고 생성한다.
			server = new ServerSocket(3000);
			while(true){
				System.out.println("접속 대기중 입니다.");
				socket = server.accept(); // 접속되는 클라이언트를 받아들임.
				vec.add(socket); //클라이언트와 연결된 소켓을 벡터에 저장한다.
				new EchoThread(socket,vec).start();
				
			}
		} catch ( IOException e){
			System.out.println(e.getMessage());
		}
	}
}
