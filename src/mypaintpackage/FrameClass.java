package mypaintpackage;

import javax.swing.JFrame;

public class FrameClass extends JFrame{
	
	// ����������� ������ ������
	FrameClass() {
		
		// �������
		setBounds(100,100,1015,700);
				
		// ��������� �������� ������� ����
		setResizable(false);
				
		// �������� ����
		setTitle("��� �����, �� ������ �����!");
				
		// �������� ��������� ����� �������� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ��������� ������ � ����
		add(new PanelClass());
				
		// ���������
		setVisible(true);
	}
}
