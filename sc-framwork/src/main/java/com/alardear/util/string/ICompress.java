package com.alardear.util.string;

import java.io.IOException;

public interface ICompress {
	
	
	byte[] compress(byte srcBytes[]) throws IOException;

    byte[] uncompress(byte[] bytes) throws IOException ;
}
