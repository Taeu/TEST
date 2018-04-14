package d0705;
import java.net.*;
import java.util.*;

public class NetworkEx1 {
	public static void main(String[] args){
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try{
			ip = InetAddress.getByName("www.sogang.ac.kr");
			System.out.println("getHostName() \t: "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
			System.out.println("toString() \t: "+ ip);
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() \t: "+ Arrays.toString(ipAddr));
			String result = "";
			for(int i =0; i<ipAddr.length;i++){
				result += (ipAddr[i] <0) ? ipAddr[i] +256 : ipAddr[i];
				result += ".";
			}
			System.out.println("result \t: "+result);
			System.out.println();
			
		} catch(UnknownHostException e){
			e.printStackTrace();
		}
		try{ 
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() \t: "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
			System.out.println();
			
		} catch(UnknownHostException e){
			e.printStackTrace();
		}
		try{
			ipArr = InetAddress.getAllByName("www.sogang.ac.kr");
			for(int i =0 ; i<ipArr.length; i++){
				System.out.println("ipArr["+i+"] \t: "+ipArr[i]);
			}
		} catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
