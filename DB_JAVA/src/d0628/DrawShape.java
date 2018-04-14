package d0628;

import java.awt.Frame;
import java.awt.Graphics;


public class DrawShape extends Frame {
	DrawShape(String title){
		super(title);
		setSize(300,400); // win 창의 size width height
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawShape win= new DrawShape("도형그리기");
	//	win.paint(g);
	}
	public void paint(Graphics g){
		Point[] p = {new Point(100,100), new Point(140,50), new Point(200,100)};
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150,150),50);
		// 그리기 위한 명령
		// 원을 그린다
		g.drawOval(c.center.x, c.center.y, c.r, c.r);
		g.drawLine(t.p[0].x, t.p[0].y, t.p[1].x,t.p[1].y);
		g.drawLine(t.p[1].x, t.p[1].y, t.p[2].x,t.p[2].y);
		g.drawLine(t.p[2].x, t.p[2].y, t.p[0].x,t.p[0].y);
		
	}

}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	Point(){
		this(0,0);
	}

}
class Circle{
	Point center;
	int r;
	Circle(Point center, int r){
		this.center=center;
		this.r = r;
	}
	Circle(){
		this(new Point(0,0),100);
	}
}
class Triangle{
	Point[] p = new Point[3];
	Triangle(Point[] p){
		this.p = p;
	}
	Triangle(Point p1, Point p2, Point p3){
		p[0] =p1; p[1]=p2; p[2]=p3;
	}
}