package cn.edu.zzuli.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
@SuppressWarnings("all")
public class MyBackground extends  JPanel{

	Image im;
	int width ;
	int height;
	public MyBackground(Image im){
		this.im = im;
		width = Toolkit.getDefaultToolkit().getScreenSize().width; 
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		}
	public void paintComponent(Graphics g){
	
	super.paintComponents(g);
	g.drawImage(im, 0,0,this.getWidth(),this.getHeight(),this);
	
	}
}
