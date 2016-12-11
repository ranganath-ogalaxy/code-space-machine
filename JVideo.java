package com.video.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jcodec.api.JCodecException;
import org.jcodec.api.awt.FrameGrab;
import org.jcodec.common.FileChannelWrapper;
import org.jcodec.common.NIOUtils;

public class JVideo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int frameNumber = 5;
		BufferedImage frame;
		try {
			frame = getFrame(new File("F:\\Tutorial\\'Aeron- Open-source high-performance messaging' by Martin Thompson.mp4"), frameNumber);
			ImageIO.write(frame, "png", new File("F:\\VideoImage\\frame2_150.png"));
			System.out.println("Image created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 static BufferedImage getFrame(File file, double sec) {
	        FileChannelWrapper ch = null;
	        try {
	            ch = NIOUtils.readableFileChannel(file);
	            return ((FrameGrab) new FrameGrab(ch).seekToSecondPrecise(sec)).getFrame();
	         
				} catch (IOException | JCodecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        finally {
	            NIOUtils.closeQuietly(ch);
	        }
			return null;
	    }

}
