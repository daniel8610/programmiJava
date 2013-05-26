import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LibroDellaSorte {
public static String libroRandom() throws IOException{
FileReader rd = new FileReader("C:/Users/Daniel/Desktop/librimarcy.txt");
BufferedReader sb=new  BufferedReader(rd);
String libri[]=new String[99];
String s="";
int i=0;
int n=(int) (Math.random()*100);
while((s=sb.readLine())!=null){
	libri[i]=s;
	i++;
}

return libri[n];
}
public static void main(String args[]) throws IOException{
String l=LibroDellaSorte.libroRandom();	
System.out.println(l);
}

}
