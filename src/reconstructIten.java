//Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//        Note:
//
//        If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//        All airports are represented by three capital letters (IATA code).
//        You may assume all tickets form at least one valid itinerary.
//        Example 1:
//
//        Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//        Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
//        Example 2:
//
//        Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//        Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//        But it is larger in lexical order.

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class reconstructIten {

    public static void main(String args[]){

        reconstructIten p = new reconstructIten();
        List<String> one = new LinkedList<String>();
        List<String> two = new LinkedList<String>();
        List<String> three = new LinkedList<String>();
        List<String> four = new LinkedList<String>();
        List<String> five = new LinkedList<String>();
        one.add("JFK");
        one.add("SFO");
        two.add("JFK");
        two.add("ATL");
        three.add("SFO");
        three.add("ATL");
        four.add("ATL");
        four.add("JFK");
        five.add("ATL");
        five.add("SFO");

        List<List<String>> sample = new LinkedList<List<String>>();
        sample.add(one);
        sample.add(two);
        sample.add(three);
        sample.add(four);
        sample.add(five);

        System.out.println(p.findItinerary(sample));
    }

    public static Map<String, Queue<String>> graph = new HashMap<>();
    public static List<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket :tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(Comparator.naturalOrder()));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return ans;
    }

    private void dfs(String departure) {
        Queue<String> destinations = graph.get(departure);
        while (destinations != null && !destinations.isEmpty()){
            dfs(destinations.poll());
        }
        ans.add(0, departure);
    }
}
