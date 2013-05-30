package it.daniel;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class LibroDellaSorte {
	private String path;
	private BufferedReader sb;
public String libroRandom() throws IOException{
FileReader rd = new FileReader(this.path);
sb = new BufferedReader(rd);
String libri[]=new String[500];
String s="";
int i=0;
//int n=(int) (Math.random()*100-32);
while((s=sb.readLine())!=null){
libri[i]=s;
i++;
}
Random r=new Random();
i=i-1;
int c=r.nextInt(i);
return libri[c];
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}


}
