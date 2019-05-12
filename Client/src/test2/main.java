package test2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class main{
	public static void main(String[] args)
	{
		try {
			String a="123456789";
			String b=a.substring(3, 4);
			System.out.printf("密文：%s\n",b);
			//read();
			Date date = new Date(); 
	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
	        String c = sdf.format(date);
	        System.out.println(c);
			/*rsah s=new rsah();
			String word="hellow word!";
			String word1;
			String word2;
			String word3,word4;
			s.key();
			word1=s.jiami(0,s.e1, word);
			System.out.printf("密文：%s\n",word1);
			word2=s.jiemi(0,s.e2, word1);
			System.out.printf("明文：%s\n",word2);
			word3=s.jiami(1,s.e2, word);
			System.out.printf("加密的签名：%s\n",word3);
			word4=s.jiemi(1,s.e1, word3);
			System.out.printf("解密后的签名：%s\n",word4);
			
			/*KeyPair keyPair=s.generateKey();
			RSAPrivateKey privateKey=(RSAPrivateKey)keyPair.getPrivate();
			RSAPublicKey publickey=(RSAPublicKey)keyPair.getPublic();
			word1=s.jiami(publickey, word.getBytes());
			word2=s.jiemi(privateKey, word1);
			System.out.printf("密文：\n");
			System.out.println(s.toHexString(word1));
			System.out.printf("明文：\n");
			System.out.println(s.toHexString(word2));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void read()
    {
    	String name="\\home\\trp\\eclipse-workspace\\Client\\src\\test2\\key";
    	try(FileReader r=new FileReader(name);
    		BufferedReader b=new BufferedReader(r)
    	){
    		String line;
    		while((line=b.readLine())!=null)
    		{
    			System.out.println(line);
    		}
    	}catch(IOException e)
    	{e.printStackTrace();}
    }
    public static void write()
    {
    	
    }
}