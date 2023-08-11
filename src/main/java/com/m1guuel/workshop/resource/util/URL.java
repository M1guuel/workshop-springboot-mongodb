package com.m1guuel.workshop.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decoParam(String texte) {
		try {
			return URLDecoder.decode(texte,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
