package GUI_1;
import java.awt.*;
import javax.swing.*;
public class buy extends JFrame{
	// 定义组件两个
	public static JPanel jp1, jp2,jp3, jp4;  // jp1: 请输入要购买的号码； jp2:是否要购买;jp3:button确认；jp4：button取消
	// 定义组件名称
	public static JLabel jlb1, jlb2; // jlb1: 请输入要购买的号码； jlb:是否要购买
	// 定义文本框
	public static JTextField jtf1, jtf2; // jtf1: 请输入要购买的号码； jtf2:是否要购买
	 
	// 定义button两个
	public static JButton jb1, jb2; // jb1: 确认 ； jb2 :取消
	
	// 构造方法
	public buy() {
		// 创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		// 创建组件名称
		jlb1 = new JLabel("请输入要购买的号码：");
		jlb2 = new JLabel("是否要购买(输入yes/no):");
		
		// 创建文本框
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		
		// 创建button
		jb1 = new JButton("确认");
		jb2 = new JButton("取消");
		
		// 设置布局管理器
		setLayout(new GridLayout(3, 1));
		// 加入组件
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		jp3.add(jb1);
		jp4.add(jb2);
		// 加入到JFrame
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		//设置窗体
		setTitle("数据报文显示界面");
		setSize(300,150);
		setLocation(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		buy gui_buy = new buy();
	}
}
	