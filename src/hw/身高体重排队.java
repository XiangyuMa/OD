package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 身高体重排队 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] high = sc.nextLine().split(" ");
        String[] weight = sc.nextLine().split(" ");
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            playerList.add(new Player(i+1,Integer.parseInt(high[i]),Integer.parseInt(weight[i])));
        }
        Collections.sort(playerList, (o1, o2) -> {
            if (o1.high != o2.high){
                return o1.high - o2.high;
            }
            if (o1.weight != o2.weight){
                return o1.weight - o2.weight;
            }
            if (o1.idx != o2.idx){
                return o1.idx - o2.idx;
            }
            return 0;
        });
        for (int i = 0; i < playerList.size(); i++) {
            System.out.print(playerList.get(i).idx+" ");
        }
    }
    static class Player{
        private int idx;
        private int high;
        private int weight;

        public Player(int idx, int high, int weight) {
            this.idx = idx;
            this.high = high;
            this.weight = weight;
        }
    }
}
