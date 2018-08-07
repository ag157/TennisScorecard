import java.util.*;
public class tennis {
   private static int final_score[][]=new int[3][2];
   private static int points[]={0,15,30,40};
   private static String name_tag[]={"Sets   :   ","games  :   "};
   private static String doesBreak(String input,int criteria,int pos){
       int countA=0,countB=0;
       String result="";
       for(int i=0;i<input.length();i++){
           if(input.charAt(i)=='A')
               countA++;
           else
               countB++;
           if(countA > criteria && (countA-countB)>1) {
               result += "A";
               countA=0;
               countB=0;
           }
           else if(countB > criteria && (countB-countA)>1) {
               result += "B";
               countA=0;
               countB=0;
           }
       }
       final_score[pos][0]=countA;
       final_score[pos][1]=countB;
       return result;
   }
   public static void main(String args[]){
       String input = "ABABABAABABAABBBABBAAABBABBAABBABABABABAAA";
       String games = doesBreak(input,3,2);
       String sets  = doesBreak(games,5,1);
       System.out.println("Player :   A B");
       for(int i=0;i<2;i++){
           System.out.print(name_tag[i]);
           for(int j=0;j<2;j++){
                System.out.print(final_score[i][j]+" ");
           }
           System.out.println();
       }
       System.out.print("Points :   ");
       if(final_score[2][0]>4){
           if(final_score[2][0]>final_score[2][1])
               System.out.println("A D");
           else if(final_score[2][0]==final_score[2][1])
               System.out.println("D D");
           else
               System.out.println("D A");
       }
       else
           System.out.println(points[final_score[2][0]]+ " "+ points[final_score[2][1]]);

   }
}