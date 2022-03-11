package mypaintpackage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class PanelClass extends JPanel{
	
	// ������ ������
	Color [] masColor;
	
	// ����������, ������� �������� �� ������� ��������� ����
	int countColor = 0;
	
	// ���������� ��� �������� ��������� ����
	int mX = 0, mY = 0;
	
	// ����, �� ������������ ������
	Boolean flag = false;
	
	// ����������� ������ ������
	PanelClass () {
		// ���������� ���������� ������� ��� ���� � ������ ����
		addMouseListener(new myMouse1());
		addMouseMotionListener(new myMouse2());
		
		// �������� ������ �� ���� ������
		masColor = new Color[10];
		
		// �������� ������ �������
		masColor[0] = Color.BLACK;
		masColor[1] = Color.RED;
		masColor[2] = Color.GREEN;
		masColor[3] = Color.BLUE;
		masColor[4] = Color.YELLOW;
		masColor[5] = Color.ORANGE;
		// ����� ������� ���� ����
		masColor[6] = new Color(120,100,100);
		masColor[7] = Color.WHITE;
		masColor[8] = Color.CYAN;
		masColor[9] = Color.MAGENTA;
	}
	
	// ����� ��� ��������� �������
	public void paintComponent(Graphics g) {
		// ������ ���� ���������������
		for(int i = 0; i<10; i++) {
			// ������������� ����
			g.setColor(masColor[i]);
			// ������ ����������� �������������
			g.fillRect(100 * i, 0, 100, 100);
		}
		// ���� ���� ��������� - ������, �� ������
		// ��������� ������� ��������� ������
		// � ����� ��� ��������� ������ ����
		if(flag == true) {
			// ������������� ���� ��� ���������
			g.setColor(masColor[countColor]);
			// ������ ����������� �������
			g.fillRect(mX, mY, 3, 3);
		}
	}
	
	// ��������� ������� �� ����
	public class myMouse1 implements MouseListener {
		// ������� ������ ����
		public void mousePressed(MouseEvent e) {
			// �������� ���������� ����
			int tX = e.getX();
			int tY = e.getY();
			
			// �������� ���������� ������� �������
			int col = e.getClickCount();
			
			// ��������� ������ ������� �������
			int btn = e.getButton();
			
			// ���������,��� ������ ��������� � ������� ������ �����
			if ((tY>0) && (tY<100) && (tX>0) && (tX<1000)) {
				// ���������, ��� ������� ������ ���� ���
				if (col==1)
				{
					// ���������, ��� ������ ����� �������
					if(btn ==1) {
						// �� ���������� X ������� ���� �������� ����� �����
						// ��� ������� ������� ����� ����� �������������
						// ������ ��� countColor ����� ��� ������ int
						System.out.println("x = " + tX + " y = " + tY);
						countColor = tX / 100;
						System.out.println("����� ���������� �����" + countColor);
					}
				}
			}
		}

		// ���������� ������ ���� ����� �������
		public void mouseReleased(MouseEvent e) {
			// ������� ��������� ���� - �� ������
			flag = false;
		}
		
		// ������ ������� ���� (������ � ���������)
		public void mouseClicked(MouseEvent e) {}
		// ��������� ������� ���� �� ������ ����
		public void mouseEntered(MouseEvent e) {}
		// ����� ������� ���� �� ������� ������ ����
		public void mouseExited(MouseEvent e) {}
	}
	
	// ��������� ������� �� ����
	public class myMouse2 implements MouseMotionListener {
		// ����������� ���� � ������� ��������
		public void mouseDragged(MouseEvent e) {
			// ��������� ��������� ������� ����
			int tX = e.getX();
			int tY = e.getY();
			
			// ���� ������ ��������� � ��� ����� ������, ��� ����� ��������
			if (tY > 100) {
				// ���������� ���������� ���� � ����������
				mX = tX;
				mY = tY;
				
				// ������������� �������, ��� ������������ ������
				flag = true;
				
				// �������� �������������
				repaint();
			}
		}

		// ����������� ����
		public void mouseMoved(MouseEvent e) {
			// ��������� ��������� ������� ����
			int tX = e.getX();
			int tY = e.getY();
						
			// ���������,��� ������ ��������� � ������� ������ �����
			if ((tY>0) && (tY<100) && (tX>0) && (tX<1000)) {
				// ������������� ������ ������ (������ � ���� ������)
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else {
				// ������������� ������ �� ���������
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}	
}
