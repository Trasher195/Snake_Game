package SG;

//		-1 - "����"
//		 0 - "������"
//		 1 - "������"
//		 2-... -"��������"
//

public class Logic {
	//
	// ���������� ���� ����������
	//
	public int[][] mas;
	public int napr;
	private int gX, gY;
	public int score;
	
	
	//
	// �����������
	//
	
	public Logic() {
		
		mas = new int[30][30];
		
	}
	
	//
	// �������� �����
	//
	
	
	private void make_score() {
		
		while(true) {
			
			// ��������� ��������
			int x = (int)(Math.random()*30);
			int y = (int)(Math.random()*30);
			
			//�������� �������� ������ 
			
			if(mas[x][y] == 0) {
				// ������������� �������� "����"
				mas[x][y] = -1;
				//����������� ����
				break;
			}
	
		}
	}
	
	
	
	//
	//		����� ����
	// 
	
	public void Start() {
		
		//��������� �������� ���� 
		
		for(int i=0; i<30; i++){
			
			for(int j=0; j<30; j++) {
				mas[i][j] = 0;
			}
		}
		
		napr = 0;
		score = 0;
		gX = gY = 15;
		
		// ������� ������ �� ������
		mas[15][15]= 1;
		
		//������� "����"
		make_score();
		
		
	}
	
	public void swipeHead(){
		
		mas[gY][gX]=0;
		
		// �����
		if(napr == 0){
			if((gX - 1)>= 0)
				gX--;
			else
				gX = 29;
		}
		
		// �����
		else if(napr == 1){
			if((gY - 1)>= 0)
				gY--;
			else
				gY = 29;
		}
		
		// ������
		else if(napr == 2){
			if((gX + 1)<= 29)
				gX++;
			else
				gX = 0;
		}
		
		// ����
		else if(napr == 3){
			if((gY + 1)<= 29)
				gY++;
			else
				gY = 0;
		}
		
		if(mas[gY][gX]==-1){
			make_score();
			score += 10;
			
		}
		mas[gY][gX] = 1;
	}
	

}
