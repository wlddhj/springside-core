package org.springside.modules.utils;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class EncodesTest {
	@Test
	public void encode() throws UnsupportedEncodingException {
		String input = "sandboxr00tm9";
		String result = Encodes.encode(input);
		System.out.println("encode>>>"+result);
		System.out.println("input>>>"+input);
		System.out.println("result>>>"+Encodes.decode(result));
		assertEquals(input, Encodes.decode(result));
	}
	public void hexEncode() throws UnsupportedEncodingException {
		String input = "sandboxr00tm9";
		String result = Encodes.encodeHex(input.getBytes("utf-8"));
		assertEquals(input, new String(Encodes.decodeHex(result)));
		System.out.println(input+">>>"+result);
		System.out.println("result>>>"+new String(Encodes.decodeHex(result)));
	}

	@Test
	public void base64Encode() {
		String input = "haha,i am a very long message";
		String result = Encodes.encodeBase64(input.getBytes());
		assertEquals(input, new String(Encodes.decodeBase64(result)));
	}

	@Test
	public void base64UrlSafeEncode() {
		String input = "haha,i am a very long message";
		String result = Encodes.encodeUrlSafeBase64(input.getBytes());
		assertEquals(input, new String(Encodes.decodeBase64(result)));
	}

	@Test
	public void urlEncode() {
		String input = "http://locahost/?q=中文&t=1";
		String result = Encodes.urlEncode(input);
		System.out.println(result);

		assertEquals(input, Encodes.urlDecode(result));
	}

	@Test
	public void xmlEncode() {
		String input = "1>2";
		String result = Encodes.escapeXml(input);
		assertEquals("1&gt;2", result);
		assertEquals(input, Encodes.unescapeXml(result));
	}

	@Test
	public void html() {
		String input = "1>2";
		String result = Encodes.escapeHtml(input);
		assertEquals("1&gt;2", result);
		assertEquals(input, Encodes.unescapeHtml(result));
	}
}
