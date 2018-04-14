package d0705;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

// �� client�� ���� ���۵� ���ڿ��� �����Ͽ� �ٸ� client���� ���ڿ��� �����ش�.
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
			String str = null; // br�� ���� ���ڿ��� ������ ���� ����
			
			while(true){ //���α׷��� ����� ������ �������κ��� �����͸� �ޱ����ؼ� �ݺ����� ���
				//Ŭ���̾�Ʈ�κ��� ���� ���ڿ��� str�� �����Ѵ�.
				str  = br.readLine(); 
				
				//Ŭ���̾�Ʈ�� ������ ������ ��� 
				if(str == null){
					// ������ ���Ϳ��� ����
					vec.remove(socket);
					break;
				}
				
				//����� ���ϵ��� ���ؼ� �ٸ� Ŭ���̾�Ʈ�鿡�� ���ڿ��� �����Ѵ�.
				sendMsg(str);
				
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		} finally{
			try{
				if(br != null) br.close();			//BufferedReader�� ���������� �ݴ´�.
				if(socket != null) socket.close();	//socket �� ���������� �ݴ´�.
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
	//���۹��� ���ڿ��� �ٸ� Ŭ���̾�Ʈ�鿡�� �������ش�.
	public void sendMsg(String str){
		try{
			for(Socket socket : vec){ // ������ ���ϵ��� ����ŭ �ݺ��Ѵ�.
				// �ݺ��� �����ϵ� �޼����� ���� Ŭ���̾�Ʈ�� �����ϰ� ������ ���ϵ鿡�� �޼����� �����Ѵ�.
				if(socket != this.socket){
					PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
					pw.println(str);
					pw.flush(); // �ٽ� �� �� �ְ� �ڽ��� clear
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
		// Ŭ���̾�Ʈ�� ����� ���ϵ��� �迭�� �����Ѵ�.
		Vector<Socket> vec = new Vector<Socket>();
		try{
			// Ŭ���̾�Ʈ�κ��� ������ �ޱ� ���ؼ� ServerSocket�� ��Ʈ��ȣ�� ������ �����Ѵ�.
			server = new ServerSocket(3000);
			while(true){
				System.out.println("���� ����� �Դϴ�.");
				socket = server.accept(); // ���ӵǴ� Ŭ���̾�Ʈ�� �޾Ƶ���.
				vec.add(socket); //Ŭ���̾�Ʈ�� ����� ������ ���Ϳ� �����Ѵ�.
				new EchoThread(socket,vec).start();
				
			}
		} catch ( IOException e){
			System.out.println(e.getMessage());
		}
	}
}
