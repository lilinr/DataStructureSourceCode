package DataStructureTest;

import java.util.*;

public class MostGoldStrategy {
    public static int findMax(int[] arr) {
        int maxVal = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("How many rooms are there?");
            int numOfRooms = sc.nextInt();
            System.out.println("How many times do you want to try?");
            long numOfTrials = sc.nextLong();
            //�����������
            
            System.out.println(numOfRooms+" rooms in total. Tried "+numOfTrials+" times.");
            System.out.println("=============================================");
            System.out.println("Rooms seen\tWinning Probability");
            for (int numOfRoomsSeen=1; numOfRoomsSeen<numOfRooms; numOfRoomsSeen++) {
                boolean takeGold;
                int timesWon=0, trueMaxGold, maxGoldSeen, goldTaken=0;
                int[] goldSet = new int[numOfRooms];
                Random rm = new Random();
                for (int i=0; i<numOfTrials; i++) {
                    takeGold = false;
                    for (int j=0; j<goldSet.length; j++)
                        goldSet[j] = rm.nextInt(Integer.MAX_VALUE);//����������������������Ľ��
                    trueMaxGold = findMax(goldSet);    //�ҵ���ʵ������������
                    
                    int[] goldSeen = new int[numOfRoomsSeen];
                    for (int j=0; j<goldSeen.length; j++)
                        goldSeen[j] = goldSet[j];
                    maxGoldSeen = findMax(goldSeen);//�ҵ��۲�����������
                    
                    for (int j=numOfRoomsSeen; j<goldSet.length; j++) {
                        if (goldSet[j]>=maxGoldSeen) {//��֮��ķ����﷢�ֱ�ԭ���κη��䶼Ҫ��Ľ��
                            takeGold = true;
                            goldTaken = goldSet[j];//���߸÷���Ľ��
                            break;
                        }
                    }
                    if (takeGold && goldTaken==trueMaxGold)//������ߵĽ�Ҿ�����ʵ�������
                        timesWon++;//��ʤ����+1
                }
                System.out.println(numOfRoomsSeen+"\t\t"+timesWon/(double)numOfTrials);
            }
        } 
        catch (Exception e) {    e.printStackTrace();    }
        finally {    System.out.println("See results in console");    }
    }
}