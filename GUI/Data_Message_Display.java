package GUI_1;
import java.awt.*;
import javax.swing.*;
public class Data_Message_Display extends JFrame{
	// 定义组件
	public static JPanel jp1, jp2;    // jp1：密文 ； jp2:明文
	// 定义组件名称
	public static JLabel jlb1, jlb2; // jlb1:密文；jlb2：明文
	// 定义文本框
	public static JTextField jtf1, jtf2;  // jtf1:密文；jtf2:明文
	//构造方法
	public Data_Message_Display() {
		// 创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		// 创建组件名称
		jlb1 = new JLabel("密文：");
		jlb2 = new JLabel("明文：");
		// 创建文本框
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		
		// 设置布局管理器
		setLayout(new GridLayout(3, 1));
		
		// 加入组件
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		// 加入到JFrame
		add(jp1);
		add(jp2);
		
		// 设置窗体
		setTitle("数据报文显示界面");
		setSize(300,150);
		setLocation(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		Data_Message_Display gui_Data_Message_Display = new Data_Message_Display();
	}
}
