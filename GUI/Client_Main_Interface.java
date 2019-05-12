package GUI_1;
import java.awt.*;
import javax.swing.*;
public class Client_Main_Interface extends JFrame{
	// 定义组件
	public static JPanel jp1, jp2;    
	// 定义组件名称
	public static JLabel jlb1, jlb2, jlb3, jlb4; // jp1:开奖日期；jp2:奖项名称；jp3：期数；jp4:上期中奖号码
	// 定义button
	public static JButton jb1, jb2, jb3, jb4; //jb1:买彩票；jb2:扫码；jb3：查看往期； jb4:退出
	// 定义文本框
	public static JTextField jtf1, jtf2, jtf3, jtf4; 
	//构造方法
	public Client_Main_Interface() {
		// 创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jlb1 = new JLabel("开奖日期：");
		jlb2 = new JLabel("奖项名称：");
		jlb3 = new JLabel("上期中奖号码：");
		jlb4 = new JLabel("期数");
		
		jb1 = new JButton("买彩票");
		jb2 = new JButton("扫码");
		jb3 = new JButton("查看往期");
		jb4 = new JButton("退出");
		
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		jtf4 = new JTextField(10);
		
		// 设置布局管理器
		setLayout(new GridLayout(3, 1));
		
		// 加入组件
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp1.add(jlb2);
		jp1.add(jtf2);
		
		jp1.add(jlb3);
		jp1.add(jtf3);
		
		jp1.add(jlb4);
		jp1.add(jtf4);
		
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		// 加入到JFrame
		add(jp1);
		add(jp2);
		// 设置框体
		setTitle("用户主界面：");
		setSize(300, 150);
		setLocation(1500, 1500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		Client_Main_Interface gui_Client_Main_Interface = new Client_Main_Interface();
	}
}
