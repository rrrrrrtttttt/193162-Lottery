package GUI_1;
import java.awt.*;
import javax.swing.*;
public class Server_Main_Interface extends JFrame{
	// 创建组件
	public static JPanel jp1, jp2;
	// 创建组件名称
	public static JLabel jlb1, jlb2, jlb3, jlb4;
	// 创建button
	public static JButton jb1, jb2;
	// 创建文本框
	public static JTextField jtf1, jtf2, jtf3, jtf4;
	// 构建函数
	public Server_Main_Interface() {
		// 创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		//创建组件名称
		jlb1 = new JLabel("开奖日期");
		jlb2 = new JLabel("奖项名称");
		jlb3 = new JLabel("中奖号码");
		jlb4 = new JLabel("期数");
		// 创建button
		jb1 = new JButton("指定中奖号");
		jb2 = new JButton("查看往期");
		
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
		// 加入到JFrame
		add(jp1);
		add(jp2);
		// 设置框体
		setTitle("服务器主界面：");
		setSize(300, 150);
		setLocation(1500, 1500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		Server_Main_Interface gui_Server_Main_Interface = new Server_Main_Interface();
	}
	
}
