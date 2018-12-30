package com.jetbrains;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a medium difficulty Hackerrank problem.
 * A description of the problem can be found at https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 * Written by William Davies
 */
public class OrganizingContainers {
    /**
     * Returns the total count of the given type of ball across all containers.
     *
     * @ param type         the type of ball
     * @ param container    the 2D array of containers and contained balls
     * @ return the count of the given type of ball
     */
    private static int getCount(int type, int[][] container) {

        int count = 0;
        for (int[] singleContainer : container) {
            count += singleContainer[type];
        }
        return count;
    }

    /**
     * Returns the size of the given container. The total count of balls it contains.
     *
     * @ param singleContainer  the container of which you want to calculate the size
     * @ return the size of the container
     */
    private static int getSize(int[] singleContainer){
        int size = 0;
        for (int type: singleContainer){
            size += type;
        }
        return size;
    }

    /**
     * Returns a ArrayList of Pairs. The key of the pair is the ball type. The value of the pair is the count of the ball type.
     *
     * @ param container  the 2D array of containers and contained balls
     * @ return the ArrayList of Pairs describing ball type and ball type count.
     */
    private static List<Pair<Integer, Integer>> getTypeData(int[][] container){
        List<Pair<Integer, Integer>> typeData = new ArrayList<>();
        for (int type = 0; type < container.length; type++){
            int count = getCount(type, container);
            typeData.add(new Pair<>(type, count));
        }
        return typeData;
    }

    /**
     * Returns a ArrayList of Pairs. The key of the pair is the container. The value of the pair is the size of the container.
     *
     * @ param container  the 2D array of containers and contained balls
     * @ return the ArrayList of Pairs describing container and container size.
     */
    private static List<Pair<int[], Integer>> getContainerData(int[][] container){
        List<Pair<int[], Integer>> containerData = new ArrayList<>();
        for (int[] singleContainer: container){
            int size = getSize(singleContainer);
            containerData.add(new Pair<>(singleContainer, size));
        }
        return containerData;
    }

    /**
     * Returns a string describing if it is possible to organise the given containers through swaps.
     *
     * @ param container  a 2D array of containers and contained balls, container[container][type].
     * @ return a string describing if it is possible to organise the given containers.
     */
    static String organizingContainers(int[][] container) {
        // get ArrayList of pairs describing ball types and containers
        List<Pair<int[], Integer>> containerData = getContainerData(container);
        List<Pair<Integer, Integer>> typeData = getTypeData(container);

        // check if each ball type can be sorted into its own container
        for (Pair<Integer, Integer> typePair: typeData){
            int type = typePair.getKey();
            int count = typePair.getValue();
            // initialise boolean possible as false
            boolean possible = false;
            // check each container to see if, through swaps, it could only contain the current ball type
            for (Pair<int[], Integer> containerPair: containerData){
                int size = containerPair.getValue();
                int[] singleContainer = containerPair.getKey();
                // if the count of balls of different type in the current container is equal to the count of balls of current type
                // in the other containers, it is possible for the current container to only contain the current ball type
                // for example, say, the current ball type is 0. there is one other ball of type 0 in a different container.
                // the current container contains a ball of type 0 and a ball of type 1. We can switch the ball of type 1
                // in the current container with the ball of type 0 that is in a different container.
                if (size - singleContainer[type] == count - singleContainer[type]){
                    possible = true;
                }
            }
            // if every container has been checked, and it is not possible for any of them to only contain the current
            // ball type, it is impossible to organise the given containers
            if (!possible){
                return "Impossible";
            }
        }
        // if "Impossible" has not been returned, it is possible to organise the containers
        return "Possible";
    }

    public static void main(String[] args){
//        int[][] container = {
//                {1, 3, 1},
//                {2, 1, 2},
//                {3, 3, 3}
//        };
        int[][] container = {
                {0, 2, 1},
                {1, 1, 1},
                {2, 0, 0}
        };




        String string = organizingContainers(container);
        System.out.println(string);
    }
}