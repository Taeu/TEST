package d0705;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;
// 키보드로 메시지를 입력받아서 서버로 전송하는 스레드
class WriteThread{
	Socket socket;
	ClientFrame cf;
	String str;
	String id;
	//생성자
	public WriteThread(ClientFrame cf){
		this.cf = cf;
		this.socket = cf.socket;
	}
	//메서드, 메시지를 서버로 전송
	public void sendMsg(){
		//키보드로 부터 내용을 읽어오기 위해 스트림객체를 생성한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		try{
			//서버로 메시지를 전송하기 위해서 스트림객체를 생성한다.
			pw = new PrintWriter(socket.getOutputStream(),true);
			//id와 ip주소를 함께 전송한다.
			if(cf.isFirst == true){
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();
				getId();
				System.out.println("ip:"+ip+"id:"+id);
				str = "["+id+"] 님이 로그인 하셨습니다. ("+ip+")";
			}else{
				str = "["+id+"]"+cf.txtF.getText();
			}
			// 입력한 메시지를 서버로 보낸다.
			pw.println(str);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(br!=null) br.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
	//Id 얻기
	public void getId(){
		id = Id.getId();
	}
}
// 서버가 보내온 메시지를 수신하는 스레드
class ReadThread extends Thread{
	Socket socket;
	ClientFrame cf;
	
	public ReadThread(Socket socket, ClientFrame cf){
		this.cf = cf;
		this.socket = socket;
	}
	public void run(){
		BufferedReader br = null;
		try{
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				// 소켓으로 들어온 메시지를 읽는다.
				String str = br.readLine();
				if(str == null){
					System.out.println("접속이 끊겼습니다");
					break;
				}
				//전송받은 메시지를 화면에 출력한다.
				cf.txtA.append(str+"\n");
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(br != null) br.close();
				if(socket != null) socket.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
public class MultiChatClient {
	public static void main(String[] args){
		Socket socket = null;
		ClientFrame cf;
		try{
			socket = new Socket("127.0.0.1",3000); // 자기 번호는 127.0.0.1
			System.out.println("연결이 성공됐습니다");
			cf=new ClientFrame(socket); //소켓에 대한 정보 넘기면서 실행
			new ReadThread(socket,cf).start(); // 계속 실행되게 하기 위해서 thread를 실행시켜준다.
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
}
