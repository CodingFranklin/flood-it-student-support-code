// Imports for the parameters of flood

import java.lang.reflect.Array;
import java.util.*;


public class Flood {

    // Students implement this flood function.
    public static void flood(WaterColor color,
                             LinkedList<Coord> flooded_list,
                             Tile[][] tiles,
                             Integer board_size) {
        // Here for loop takes O(n)
        for (int i = 0; i < flooded_list.size(); ++i) {
            List<Coord> neighbors = new ArrayList<>();
            // Here the get function of linked list also takes O(n)**
            neighbors = flooded_list.get(i).neighbors(board_size);
            for (Coord neighbor : neighbors){
                //skip if it was already checked
                // Here the contains function of linked list also takes O(n)**
                if (flooded_list.contains(neighbor)){
                    continue;
                }
                else if (tiles[flooded_list.get(i).getY()][flooded_list.get(i).getX()].getColor()
                        .equals(tiles[neighbor.getY()][neighbor.getX()].getColor())){
                    flooded_list.add(neighbor);
                }
            }
        }
    }

    // An alternative implementation goes here.
    public static void flood1(WaterColor color,
                             LinkedList<Coord> flooded_list,
                             Tile[][] tiles,
                             Integer board_size) {
        // Here copy the list takes O(n)
        Queue<Coord> copy_flooded_list = new LinkedList<>(flooded_list);
        // Here copy the list takes O(n)
        Set<Coord> floodedSet = new HashSet<>(flooded_list);

        List<Coord> neighbors = new ArrayList<>();
        if (copy_flooded_list != null) {
            // Here while loop takes O(n)
            while (!copy_flooded_list.isEmpty()){
                Coord first = copy_flooded_list.poll();
                neighbors = first.neighbors(board_size);
                // Here for loop takes maximum O(4)
                for (Coord neighbor : neighbors){
                    //skip if it was already checked (use hashset to check)
                    // Here contains function of HashSet takes O(1)
                    if (floodedSet.contains(neighbor)){
                        continue;
                    }
                    else if (tiles[first.getY()][first.getX()].getColor()
                            .equals(tiles[neighbor.getY()][neighbor.getX()].getColor())){
                        copy_flooded_list.add(neighbor);
                        floodedSet.add(neighbor);
                        flooded_list.add(neighbor);
                    }
                }
            }

        }
    }

}
