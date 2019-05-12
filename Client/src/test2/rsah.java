package test2;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import java.io.*;

import java.util.*;

import java.math.*;

public class rsah {
	private static Random ran = null;
	public BigInteger n;//=new BigInteger("3233");
	private BigInteger p;
	private BigInteger q;
	public BigInteger e1;//=new BigInteger("17");
	public BigInteger e2;//=new BigInteger("2753");
	private BigInteger l;
	private BigInteger h=BigInteger.ONE;
	public static String md5(String string) {
        if (string.isEmpty()) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes("UTF-8"));
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
	public String jiami(int k,BigInteger key,String word)
	{
		int i;
		String word1 = "";
		String str = "";
	    
		if(k==0)
		{
			for (i = 0; i < word.length(); i++) 
			{
				int ch = (int) word.charAt(i);
				String s4 = Integer.toHexString(ch);
				str = str + s4;
			}
			BigInteger w=new BigInteger(str,16);
			w=w.modPow(e1, n);
			str=w.toString(16);
			word1=str;
		}
		else
		{
			String a=md5(word);
			word=word+a;
			//System.out.printf("%s\n", word);
			for (i = 0; i < word.length(); i++) 
			{
				int ch = (int) word.charAt(i);
				String s4 = Integer.toHexString(ch);
				str = str + s4;
			}
			BigInteger w=new BigInteger(str,16);
			w=w.modPow(e1, n);
			str=w.toString(16);
			word1=str;
		}
		return word1;
	}
	public String jiemi(int k,BigInteger key,String word)
	{
		int i;
		String word1 = "";
		String str = "";
		BigInteger w=new BigInteger(word,16);
		if(k==0)
		{
			w=w.modPow(e2, n);
			str=w.toString(16);
			word1=hexStringToString(str);
		}
		else
		{
			w=w.modPow(e2, n);
			str=w.toString(16);
			word1=hexStringToString(str);
			String c,d;
			c=word1.substring(word1.length()-32);
			System.out.printf("%s\n", c);
			d=word1.substring(0, word1.length()-32);
			System.out.printf("%s\n", md5(d));
			if(c.equals(md5(d)))
			{
				word1=d;
			}
			else
			{
				System.out.printf("信息错误！\n");
			}
		}
		return word1;
	}
	public static String hexStringToString(String s) {
	    if (s == null || s.equals("")) {
	        return null;
	    }
	    s = s.replace(" ", "");
	    byte[] baKeyword = new byte[s.length() / 2];
	    for (int i = 0; i < baKeyword.length; i++) {
	        try {
	            baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    try {
	        s = new String(baKeyword, "ascii");
	        new String();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    return s;
	}
	public void key()
	{
		int i;
		BigInteger bigInteger =get();//BigInteger.probablePrime(512, new Random());
		p=bigInteger.abs();
		for(i=0;i<10;i++)
		{
			BigInteger bigInteger2 =get();//BigInteger.probablePrime(512, new Random());
			q=bigInteger2.abs();
			if(p!=q)
			{
				break;
			}
		}
		n=p;
		n=n.multiply(q);
		p=p.subtract(h);
		q=q.subtract(h);
		l=p;
		l=l.multiply(q);
		e1=new BigInteger("65537");
		e2=ojld(e1,l,BigInteger.ONE,BigInteger.ZERO);
		if(e2.signum()==-1)
		{
			e2=e2.add(n);
		}
		//System.out.printf("%d\n",p);
		//System.out.printf("%d\n",q);
		System.out.printf("%d\n",n);
		System.out.printf("%d\n",e1);
		System.out.printf("%d\n",e2);
	}
	public BigInteger ojld(BigInteger a,BigInteger b,BigInteger c,BigInteger d)
	{
		BigInteger qr=a.divide(b);
		BigInteger r =a.remainder(b);
		BigInteger x=c.subtract(qr.multiply(d)); 
		if(r.intValue()==1)
		{
			return x;
		}
		else
		return ojld(b,r,d,x);
	}
	public BigInteger get()
	{
		BigInteger init = new BigInteger(510, ran);
		BigInteger a=new BigInteger("2");
		a=a.pow(511);
		a=a.add(init);
		BigInteger d=a;
		
		if(!d.testBit(0))
		{
			d=d.setBit(0);
		}
		int i;
		for(i=0;;i++)
		{
			if(isPrime(d)==true)
			{
				break;
			}
			d=d.add(BigInteger.valueOf(2));
		}
		return d;
	}
	static {
        ran = new SecureRandom();
    }
	public static boolean isPrime(BigInteger n, int tryTime) {
        for (int i = 0; i < tryTime; i++) {
            if (!passesMillerRabin(n)) {
                return false;
            }
        }
        return true;
    }
	public static boolean isPrime(BigInteger n) {
        int sizeInBits = n.bitLength();
        int tryTime = 0;
        if (sizeInBits < 100) {
            tryTime = 50;
        }
 
        if (sizeInBits < 256) {
            tryTime = 27;
        } else if (sizeInBits < 512) {
            tryTime = 15;
        } else if (sizeInBits < 768) {
            tryTime = 8;
        } else if (sizeInBits < 1024) {
            tryTime = 4;
        } else {
            tryTime = 2;
        }
        return isPrime(n, tryTime);
    }
	public static boolean passesMillerRabin(BigInteger n) {
        int base = 0;
        if (n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) < 0) 
        {
            base = ran.nextInt(n.intValue() - 1) + 1;
        } 
        else 
        {
            base = ran.nextInt(Integer.MAX_VALUE - 1) + 1;
        }
 
        BigInteger thisMinusOne = n.subtract(BigInteger.ONE);
        BigInteger m = thisMinusOne;
        while (!m.testBit(0)) {
            m = m.shiftRight(1);
            BigInteger z = expmod(base, m, n);
            if (z.equals(thisMinusOne)) {
                break;
            } else if (z.equals(BigInteger.ONE)) {
 
            } else {
                return false;
            }
        }
        return true;
    }
	public static boolean fermatTest(BigInteger n) {
        int base = 0;
        if (n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) < 0) {
            base = ran.nextInt(n.intValue() - 1) + 1;
        } else {
            base = ran.nextInt(Integer.MAX_VALUE - 1) + 1;
        }
        if (expmod(base, n, n).equals(BigInteger.valueOf(base))) {
            return true;
        } else {
            return false;
        }
    }
	public static BigInteger expmod(int base, BigInteger exp, BigInteger n) {
        if (exp.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
 
        if (!exp.testBit(0)) {//如果为偶数
            return expmod(base, exp.divide(BigInteger.valueOf(2)), n).pow(2).remainder(n);
        } else {
            return (expmod(base, exp.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)), n).pow(2).multiply(BigInteger.valueOf(base))).remainder(n);
        }
    }
	
}