import java.util.*;
import java.math.*;

class Solution {
    
    class Song implements Comparable<Song> {
        int playCount;
        int uniqueId;   
    
    public Song(int playCount, int uniqueId) {
        this.playCount = playCount;
        this.uniqueId = uniqueId;
    }
    
    @Override
    public int compareTo(Song o) {
        if (this.playCount != o.playCount) {
            return Integer.compare(o.playCount, this.playCount);
        }
        
        return Integer.compare(this.uniqueId, o.uniqueId);
    }
}
    
    private final Map<String, Integer> totalCountMap = new HashMap<>();
    private final Map<String, ArrayList<Song>> songMap = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
 
        int size = genres.length;
        for (int i = 0; i < size; i++) {
            totalCountMap.put(genres[i], totalCountMap.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<Song> songs = songMap.getOrDefault(genres[i], new ArrayList<>());
            songs.add(new Song(plays[i], i));
            songMap.put(genres[i], songs);
        }
        
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(totalCountMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        List<Integer> uniqueIds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            ArrayList<Song> songs = songMap.get(entry.getKey());
            songs.sort(Comparator.naturalOrder());
            uniqueIds.add(songs.get(0).uniqueId);
            if (songs.size() >= 2) {
                uniqueIds.add(songs.get(1).uniqueId);
            }
        }
        
        int idx = 0;
        int[] answer = new int[uniqueIds.size()];
        for (Integer uniqueId : uniqueIds) {
            answer[idx++] = uniqueId;            
        }
    
        return answer;
    }
}
