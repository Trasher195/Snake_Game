package SG;

//		-1 - "Очко"
//		 0 - "Ничего"
//		 1 - "Голова"
//		 2-... -"Туловище"
//

public class Logic {
	//
	// ОбЪявление всех переменных
	//
	public  boolean endg;
	public  boolean stop = false;
	public int Long;
	public int new_napr;
	public int[][] mas;
	public int napr;
	public static int Money= LoaderSave.LoadSave("Files/Saves/Money.save");
	
	private int gX, gY;
	public static int score;
	
	
	//
	// Конструктор
	//
	
	public Logic() {
		
		mas = new int[30][30];
		
	}
	
	private void rotate() {
		if(Math.abs((new_napr-napr))!=2) {
			napr = new_napr;
			if(napr==0) Panel.Head = Panel.Head_left;
			else if(napr==1) Panel.Head = Panel.Head_up;
			else if(napr==2) Panel.Head = Panel.Head_right;
			else if(napr==3) Panel.Head = Panel.Head_down;
		}
	}
	
	//
	// Создание очков
	//
	
	
	private void make_score() {
		
		while(true) {
			
			// Рандомные значения
			int x = (int)(Math.random()*30);
			int y = (int)(Math.random()*30);
			
			//Проверка значения клетки 
			
			if(mas[x][y] == 0) {
				// Присваивается значение "Очко"
				mas[x][y] = -1;
				//Заканчиваем цикл
				break;
			}
	
		}
	}
	
	
	
	//
	//		Старт игры
	// 
	
	public void Start() {
		
		//Отчищение игрогого поля 
		
		for(int i=0; i<30; i++){
			
			for(int j=0; j<30; j++) {
				mas[i][j] = 0;
			}
		}
		
		napr = 0;
		score = 0;
		gX = gY = 14;
		
		// Создаем змейку по центру
		mas[14][14]= 1;
		mas[14][15]= 2;
		mas[14][16]= 3;
		
		Long = 3;
		
		endg = false;
		stop = false;
		
		//Создаем "Очко"
		make_score();
		
		
	}
	
	public int swipeHead(){
		
		
		
		// Влево
		if(napr == 0){
			if((gX - 1)>= 0)
				gX--;
			else
				gX = 29;
		}
		
		// Вверх
		else if(napr == 1){
			if((gY - 1)>= 0)
				gY--;
			else
				gY = 29;
		}
		
		// Вправо
		else if(napr == 2){
			if((gX + 1)<= 29)
				gX++;
			else
				gX = 0;
		}
		
		// Вниз
		else if(napr == 3){
			if((gY + 1)<= 29)
				gY++;
			else
				gY = 0;
		}
		
		
		
		int rez = 0;
		
		if(mas[gY][gX]==-1) {
			rez=1;
			System.out.println("rez=1");
			Money = Money + 2;
			System.out.println("++  "+ Money);
		}
		
		else if(mas[gY][gX]==0) rez =2;
		
		else if(mas[gY][gX]>0) rez =3;
		
		
			
		mas[gY][gX] = -2;
		
		return rez;
		}
	
		public void perem() {
		
		int flag = swipeHead();
		
		if(flag==3) endg=true;
		
		for(int i = 0; i<30; i++) {
			for(int j = 0; j<30;j++) {
				
				if(mas[i][j]>0) mas[i][j]++;
				
				else if(mas[i][j]==-2) mas[i][j]=1;
				
				if(flag==2) {
					if(mas[i][j]==(Long+1)) mas[i][j]=0;
				}
				
			}
		}
		
		if(flag==1) {
			Long++;
			make_score();
			score += 10;
		}
		
		rotate();
	


		
		
	}
	

}

