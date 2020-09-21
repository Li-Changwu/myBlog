package com.licw.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
            HashMap<Integer,String> porker = new HashMap<>();
            porker.put(0,"大王");
            porker.put(1,"小王");
            int index = 2;
            ArrayList<Integer> porkerCard = new ArrayList<>();
            porkerCard.add(0);
            porkerCard.add(1);
            for (String number : Arrays.asList("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3")) {
                for (String color : Arrays.asList("♠", "♥", "♣", "♦")) {
                    porkerCard.add(index);
                    porker.put(index,color+number);
                    index++;
                }
            }
//        System.out.println(porkerCard);
//        System.out.println(porker);
        //洗牌发牌
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(porkerCard);
        }
        ArrayList<Integer> p1= new ArrayList<>();
            ArrayList<Integer> p2= new ArrayList<>();
            ArrayList<Integer> p3= new ArrayList<>();
            ArrayList<Integer> deck= new ArrayList<>();
            for (int i = 0; i < porkerCard.size(); i++) {
                Integer in = porkerCard.get(i);
                if (i>=51){
                    deck.add(in);
                }else if (i%3==0){
                    p1.add(in);
                }else if (i%3==1){
                    p2.add(in);
                }else if (i%3==2){
                    p3.add(in);
                }
            }
        sendCard("玩家1",p1,porker);
        sendCard("玩家2",p2,porker);
        sendCard("玩家3",p3,porker);
        sendCard("底牌",deck,porker);
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(deck);
    }
    public static void sendCard(String name,ArrayList<Integer> player,HashMap<Integer,String> card){
        Collections.sort(player);
        System.out.print(name+"的牌是:");
        for (Integer num : player) {
            System.out.print(card.get(num)+" ");
        }
        System.out.println();
    }


}
