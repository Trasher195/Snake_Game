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
	public int[][] mas;
	public int napr;
	private int gX, gY;
	public int score;
	
	
	//
	// Конструктор
	//
	
	public Logic() {
		
		mas = new int[30][30];
		
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
		gX = gY = 15;
		
		// Создаем змейку по центру
		mas[15][15]= 1;
		
		//Создаем "Очко"
		make_score();
		
		
	}
	
	public void swipeHead(){
		
		mas[gY][gX]=0;
		
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
		
		if(mas[gY][gX]==-1){
			make_score();
			score += 10;
			
		}
		mas[gY][gX] = 1;
	}
	

}
