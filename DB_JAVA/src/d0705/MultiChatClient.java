package d0705;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;
// Ű����� �޽����� �Է¹޾Ƽ� ������ �����ϴ� ������
class WriteThread{
	Socket socket;
	ClientFrame cf;
	String str;
	String id;
	//������
	public WriteThread(ClientFrame cf){
		this.cf = cf;
		this.socket = cf.socket;
	}
	//�޼���, �޽����� ������ ����
	public void sendMsg(){
		//Ű����� ���� ������ �о���� ���� ��Ʈ����ü�� �����Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		try{
			//������ �޽����� �����ϱ� ���ؼ� ��Ʈ����ü�� �����Ѵ�.
			pw = new PrintWriter(socket.getOutputStream(),true);
			//id�� ip�ּҸ� �Բ� �����Ѵ�.
			if(cf.isFirst == true){
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();
				getId();
				System.out.println("ip:"+ip+"id:"+id);
				str = "["+id+"] ���� �α��� �ϼ̽��ϴ�. ("+ip+")";
			}else{
				str = "["+id+"]"+cf.txtF.getText();
			}
			// �Է��� �޽����� ������ ������.
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
	//Id ���
	public void getId(){
		id = Id.getId();
	}
}
// ������ ������ �޽����� �����ϴ� ������
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
				// �������� ���� �޽����� �д´�.
				String str = br.readLine();
				if(str == null){
					System.out.println("������ ������ϴ�");
					break;
				}
				//���۹��� �޽����� ȭ�鿡 ����Ѵ�.
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
			socket = new Socket("127.0.0.1",3000); // �ڱ� ��ȣ�� 127.0.0.1
			System.out.println("������ �����ƽ��ϴ�");
			cf=new ClientFrame(socket); //���Ͽ� ���� ���� �ѱ�鼭 ����
			new ReadThread(socket,cf).start(); // ��� ����ǰ� �ϱ� ���ؼ� thread�� ��������ش�.
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
}
