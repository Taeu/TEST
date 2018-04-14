package d0623;

public class t7 {
	public static void main(String[] args){
		int sum=0; //ÃÑÁ¡
		float average = 0f; // Æò±Õ
		int[] score = {100,88, 48, 75, 96};
		for(int i=0; i<score.length;i++){
			sum+=score[i];
		}
		average=((float)sum/score.length);
		System.out.println(average);
		
		int[] score1= {79,88,91,33,100,55,95};
		// ÀÌ Áß¿¡¼­ ÃÖ´ñ°ª°ú ÃÖ¼Ú°ªÀ» ±¸ÇÏ½Ê½Ã¿À.
		int max= score1[0]; int min =score[0];
		for(int i = 1; i< score1.length;i++){
			if(max<score1[i]) max =score1[i];
			if(min>score1[i]) min =score1[i];
		}
		
		
		System.out.println(max+", "+min);
		
	}
}
