package cn.edu.zzuli.test;

import java.io.IOException;

import sun.misc.BASE64Decoder;

public class T2 {

	public static void main(String[] args) {

		BASE64Decoder base64Decoder = new BASE64Decoder();

		try {
			byte[] bytes = base64Decoder
					.decodeBuffer("d2hhdCBpcyB0aGUgcmVtYWluZGVyIHdoZW4gdGhlIG51bWJlciBpcyBkaXZpZGVkIGJ5IDIwMTc/");
			System.out.println(new String(bytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
