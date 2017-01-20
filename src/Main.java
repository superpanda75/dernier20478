import java.util.Random;
import java.util.Scanner;

public class Main
	{

		public static void main(String[] args)
		{
			int a = 0;
			int x=4;
			int y=4;
			
			 int [][]grille = new int[4][4];
		        for(int i=0; i<4; i++){
		            for(int j=0; j<4; j++){
		                grille[i][j] = 0;

		            }
		        }
		        System.out.println("2048 java");
		        System.out.println("8 pour haut, 5 pour bas, 4 pour gauche et 6 pour droite");
		        

		        grille[1][2]=2;
		        grille[0][0]=2;
		        afficheGrille(grille);

		        Scanner in = new Scanner(System.in);
		        char touche = 'y';
		        int vide;
		        
		        
		        while(touche!='x'){
		        touche = in.next(".").charAt(0);
		        
		        switch(touche){
		            case '8':
		                Droite(grille);
		                ajouter(grille);
		                Gauche(grille);
		                afficheGrille(grille);
		                break;
		            case '5':
		                Gauche(grille);
		                ajouter(grille);
		                Droite(grille);
		                afficheGrille(grille);
		                break;
		            case '6':
		                ajouter(grille);
		                afficheGrille(grille);
		                break;
		            case '4':
		                Droite(grille);
		                Droite(grille);
		                ajouter(grille);
		                Gauche(grille);
		                Gauche(grille);
		                afficheGrille(grille);
		                break;
		        }

		        vide = vide(grille);

		        if(Victoire(grille) == true ){
		                    System.out.println("Victoire");
		                    touche = 'x';
		                }
		         
		        else if(vide==0){
		                    System.out.println("Vous avez perdu ! ");
		                    touche = 'x';
		                 }
		        }
		}
		
		 public static int vide(int [][]grille){
		        int vide = 0;
		        for(int i=0; i<4; i++){
		            for(int j=0; j<4; j++){
		                if(grille[i][j]==0){
		                    vide++;
		                }
		            }
		        }
		        return vide;
		    }
			

		public static boolean Victoire(int[][] mat){
			boolean victoire = false;
			for (int i = 0; i<4; i++){
				for (int j = 0; j<4; j++){
					if (mat[i][j] == 2048){
						victoire = true;
					}
					else {
						victoire = false;
					}
				
				}
			}
			return victoire;
		}
		
		static void isZero(int x){
		    if(x==0){
		    System.out.print(" ");
		    }
		    else{
		    System.out.print(x);
		    }
		    }
		
		static void afficheGrille(int [][]myTab){
		       System.out.println("_________________");
		       System.out.print("| ");
		       isZero(myTab[0][0]);
		       System.out.print(" | ");
		       isZero(myTab[0][1]);
		       System.out.print(" | ");
		       isZero(myTab[0][2]);
		       System.out.print(" | ");
		       isZero(myTab[0][3]);
		       System.out.println(" |");
		       System.out.println("_________________");
		       System.out.print("| ");
		       isZero(myTab[1][0]);
		       System.out.print(" | ");
		       isZero(myTab[1][1]);
		       System.out.print(" | ");
		       isZero(myTab[1][2]);
		       System.out.print(" | ");
		       isZero(myTab[1][3]);
		       System.out.println(" |");
		       System.out.println("_________________");
		       System.out.print("| ");
		       isZero(myTab[2][0]);
		       System.out.print(" | ");
		       isZero(myTab[2][1]);
		       System.out.print(" | ");
		       isZero(myTab[2][2]);
		       System.out.print(" | ");
		       isZero(myTab[2][3]);
		       System.out.println(" |");
		       System.out.println("_________________");
		       System.out.print("| ");
		       isZero(myTab[3][0]);
		       System.out.print(" | ");
		       isZero(myTab[3][1]);
		       System.out.print(" | ");
		       isZero(myTab[3][2]);
		       System.out.print(" | ");
		       isZero(myTab[3][3]);
		       System.out.println(" |");
		       System.out.println("_________________");
		    }
		
		//CONDITIONS
		public static void decalDroite(int [][]mat){
			for (int i = 0; i < 4; i++)
			{
				if (mat[i][3] == 0)
				{
					if (mat[i][2] == 0)
					{
						if (mat[i][1] == 0)
						{
							if (mat[i][0] != 0)
							{
								mat[i][3] = mat[i][0];
								mat[i][0] = 0;
							}
						}
						if (mat[i][1] != 0)
						{
							if (mat[i][0] == 0)
							{
								mat[i][3] = mat[i][1];
								mat[i][1] = 0;
							}
							if (mat[i][0] != 0)
							{
								mat[i][2] = mat[i][1];
								mat[i][1] = mat[i][0];
								mat[i][0] = 0;
							}
						}
					}
					if (mat[i][2] != 0)
					{
						if (mat[i][1] == 0)
						{
							if (mat[i][0] == 0)
							{
								mat[i][3] = mat[i][2];
								mat[i][2] = 0;
							}
							if (mat[i][0] != 0)
							{
								mat[i][3] = mat[i][2];
								mat[i][2] = mat[i][0];
								mat[i][0] = 0;
							}
						}
						if (mat[i][1] != 0)
						{
							if (mat[i][0] == 0)
							{
								mat[i][3] = mat[i][2];
								mat[i][2] = mat[i][1];
								mat[i][1] = 0;
							}
							if (mat[i][0] != 0)
							{
								mat[i][3] = mat[i][2];
								mat[i][2] = mat[i][1];
								mat[i][1] = mat[i][0];
								mat[i][0] = 0;
							}
						}
					}
				}
				if (mat[i][3] != 0)
				{
					if (mat[i][2] == 0)
					{
						if (mat[i][1] == 0)
						{
							if (mat[i][0] != 0)
							{
								mat[i][2] = mat[i][0];
								mat[i][0] = 0;
							}
						}
						if (mat[i][1] != 0)
						{
							if (mat[i][0] == 0)
							{
								mat[i][2] = mat[i][1];
								mat[i][1] = 0;
							}
							if (mat[i][0] != 0)
							{
								mat[i][2] = mat[i][1];
								mat[i][1] = mat[i][0];
								mat[i][0] = 0;
							}
						}
					}
					if (mat[i][2] != 0)
					{
						if (mat[i][1] == 0)
						{
							if (mat[i][0] == 0)
							{

							}
							if (mat[i][0] != 0)
							{
								mat[i][1] = mat[i][0];
								mat[i][0] = 0;
							}
						}
						if (mat[i][1] != 0)
						{
							if (mat[i][0] == 0)
							{

							}
							if (mat[i][0] != 0)
							{

							}
						}
					}
				}
			}
		}
		
		public static void Random(int [][]mat){
	        boolean check = true;
	        int[] rnd = new int[2];
	        rnd[0] = 2;
	        rnd[1] = 4;
	        Random randomGen = new Random();
	        int rint;
	        int rint2;
	        while(check){
	            rint = randomGen.nextInt(4);
	            if(mat[rint][0]==0){
	                mat[rint][0]=rnd[randomGen.nextInt(2)];
	                check = false;
	            }
	        }
	    }
		
		public static void ajouter(int [][]mat){
		    System.out.println("");
		    for(int i=3; i>-1; i--){
		    
		        if((mat[i][3]==mat[i][2])&&mat[i][3]!=0){
		            mat[i][3] = mat[i][3] + mat[i][2];
		            mat[i][2] = 0;
		        }
		        if((mat[i][2]==mat[i][1])&&mat[i][2]!=0){
		            mat[i][2] = mat[i][2] + mat[i][1];
		            mat[i][1] = 0;
		        }
		        if((mat[i][1]==mat[i][0])&&mat[i][1]!=0){
		            mat[i][1] = mat[i][1] + mat[i][0];
		            mat[i][0] = 0;
		        }
		        if((mat[i][0]==mat[i][2])&&(mat[i][2]!=0)&&(mat[i][1]==0)){
		            mat[i][2] = mat[i][2] + mat[i][0];
		            mat[i][0] = 0;
		        }
		        if((mat[i][1]==mat[i][3])&&(mat[i][3]!=0)&&(mat[i][2]==0)){
		            mat[i][3] = mat[i][2] + mat[i][1];
		            mat[i][1] = 0;
		        }
		        if((mat[i][0]==mat[i][3])&&(mat[i][3]!=0)&&(mat[i][1]==0)&&(mat[i][2]==0)){
		            mat[i][3] = mat[i][3] + mat[i][0];
		            mat[i][0] = 0;
		        }
		    }
		    decalDroite(mat);
		    Random(mat);
		    }
		
		 public static void Droite(int[][] mat) {
		        echangerTuile(mat);
		        for (int  j = 0; j < mat[0].length/2; j++) {
		            for (int i = 0; i < mat.length; i++) {
		                int x = mat[i][j];
		                mat[i][j] = mat[i][mat[0].length -1 -j]; 
		                mat[i][mat[0].length -1 -j] = x;
		            }
		        }
		    }
		 
		 public static void Gauche(int[][] mat) {
		        echangerTuile(mat);
		        for (int  i = 0; i < mat.length/2; i++) {
		            for (int j = 0; j < mat[0].length; j++) {
		                int x = mat[i][j];
		                mat[i][j] = mat[mat.length -1 -i][j]; 
		                mat[mat.length -1 -i][j] = x;
		            }
		        }
		    }
		
		 private static void echangerTuile(int[][] mat) {
		        for (int i = 0; i < mat.length; i++) {
		            for (int j = i; j < mat[0].length; j++) {
		                int x = mat[i][j];
		                mat[i][j] = mat[j][i];
		                mat[j][i] = x;
		            }
		        }
		    }
		 
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}