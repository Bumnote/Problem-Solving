import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> orders = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            orders.put(players[i], i);
        }
        
        for (String player : callings) {
            int curr = orders.get(player);
            
            String competitor = players[curr - 1];
            players[curr - 1] = player;
            players[curr] = competitor;
            
            orders.put(competitor, curr);
            orders.put(player, curr - 1);
        }
        
        return players;
    }
}