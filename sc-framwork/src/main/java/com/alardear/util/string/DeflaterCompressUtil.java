package com.alardear.util.string;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * LZ77算法与哈夫曼编码（Huffman Coding）
 * 
 * @see http://www.zlib.net/
 * @author http://zhengdi1992.github.io/
 *
 */
public class DeflaterCompressUtil implements ICompress {

	@Override
	public byte[] compress(byte[] srcBytes) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Deflater compressor = new Deflater(1);
		try {
			compressor.setInput(srcBytes);
			compressor.finish();
			final byte[] buf = new byte[2048];
			while (!compressor.finished()) {
				int count = compressor.deflate(buf);
				bos.write(buf, 0, count);
			}
		} finally {
			compressor.end();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] uncompress(byte[] bytes) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Inflater decompressor = new Inflater();
		try {
			decompressor.setInput(bytes);
			final byte[] buf = new byte[2048];
			while (!decompressor.finished()) {
				int count = decompressor.inflate(buf);
				bos.write(buf, 0, count);
			}
		} catch (DataFormatException e) {
			e.printStackTrace();
		} finally {
			decompressor.end();
		}
		return bos.toByteArray();
	}

}
