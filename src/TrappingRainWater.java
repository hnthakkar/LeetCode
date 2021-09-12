public class TrappingRainWater {
    public static void main(String[] args) {
        trap(new int[]{4,9,4,5,3,2});
    }

    public static int trap(int[] height) {
        int trappedWater = 0;
        int numberOfElevations = height.length - 1;
        int leftElevationPosition = nextLeftElevationPosition(height, 0, numberOfElevations);
        int rightElevationPosition = leftElevationPosition + 2;

        while(rightElevationPosition <= numberOfElevations) {
            int[] nextTrap = nextHighElevationIndex(height, leftElevationPosition);
            if (nextTrap[0] != -1) {
                // we have a next higher elevation
                trappedWater += rightIncreasingTrappedWater(height, leftElevationPosition, nextTrap[1]);
            } else {
                trappedWater += rightDecreasingTrapWater(height, leftElevationPosition, nextTrap[1]);
            }
            leftElevationPosition = nextLeftElevationPosition(height, nextTrap[1], numberOfElevations);
            rightElevationPosition = leftElevationPosition + 2;
        }

        System.out.println(trappedWater);
        return trappedWater;
    }

    private static int nextLeftElevationPosition(int[] elevations, int fromIndex, int numberOfElevations) {
        while (fromIndex < numberOfElevations && elevations[fromIndex] == 0) {
            fromIndex++;
        }

        while ((fromIndex + 1) < numberOfElevations && elevations[fromIndex + 1] > elevations[fromIndex]) {
            fromIndex++;
        }
        return fromIndex;
    }

    private static int[] nextHighElevationIndex(int[] elevations, int nextHighFromIndex) {
        int[] retArray = new int[2];
        boolean hasNextHigh = false;
        int elevationLastIndex = elevations.length - 1;
        int nextHighFromHeight = elevations[nextHighFromIndex];
        int currentIndex = nextHighFromIndex + 2;
        // If next high not available, than return next highest among the following
        int nextMaxIndex = currentIndex;

        while (currentIndex <= elevationLastIndex) {
            if (elevations[currentIndex] >= nextHighFromHeight) {
                retArray[0] = 1; // has a next higher elevation
                retArray[1] = currentIndex; // send the index
                hasNextHigh = true;
                break;
            }

            if (elevations[currentIndex] > elevations[nextMaxIndex]) {
                nextMaxIndex = currentIndex;
            }
            currentIndex++;
        }

        if (!hasNextHigh) {
            retArray[0] = -1;
            retArray[1] = nextMaxIndex;
        }

        return retArray;
    }

    private static int rightIncreasingTrappedWater(int[] elevations, int fromIndex, int toIndex) {
        int trapped = 0;
        int maxHeight = elevations[fromIndex];
        for (int i = fromIndex + 1; i < toIndex; i++) {
            if (maxHeight > elevations[i]) {
                trapped += maxHeight - elevations[i];
            }
        }
        return trapped;
    }

    private static int rightDecreasingTrapWater(int[] elevations, int fromIndex, int toIndex) {
        int trapped = 0;
        int maxHeight = elevations[toIndex];
        for (int i = fromIndex + 1; i < toIndex; i++) {
            if (elevations[i] < maxHeight) {
                trapped += maxHeight - elevations[i];
            }
        }
        return trapped;
    }
}


/*
 // Better coding

 import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

    public static int trappingRainWater(int[] elevations) {

        int n = elevations.length;
        int[] leftWalls = new int[n];
        int[] rightWalls = new int[n];

        int maxLeftWall = 0;
        for (int i = 0; i < n; i++) {
            leftWalls[i] = maxLeftWall;
            maxLeftWall = Math.max(elevations[i], maxLeftWall);
        }

        int maxRightWall = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightWalls[i] = maxRightWall;
            maxRightWall = Math.max(elevations[i], maxRightWall);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int elevation = elevations[i];
            int lowestWall = Math.min(leftWalls[i], rightWalls[i]);
            if (lowestWall > elevation) {
                totalWater += lowestWall - elevation;
            }
        }

        return totalWater;
    }
    //Driver code
    public static void main(String[] arg){
        String[] inputs = {"3 2 1 2 2 3 2","3 2 1 2 2 3"};
        for(int i = 0; i < inputs.length; i++) {
            int[] elevs = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println("Trapping rain water : "+Solution.trappingRainWater(elevs));
        }
    }

}


 */

/*

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

    public static int trappingRainWater(int[] elevations) {
        int len = elevations.length;
        int[] boundary;
        int startIndex = 0;
        int volume = 0;
        while (startIndex < (len - 1)) {
            boundary = getNextBoundary(0, elevations, len);
            volume += getTrappedWaterBetween(boundary[0], boundary[1], elevations);
            startIndex = boundary[1] + 1;
            if (startIndex + 2 > (len - 1)) {
                break;
            }
        }


        return volume;
    }

    private static int getTrappedWaterBetween(int startIndex, int endIndex, int[] elevations) {
        int minHeight = elevations[startIndex] <= elevations[endIndex] ? elevations[startIndex] : elevations[endIndex];
        int vol = 0;
        for (int i = startIndex + 1; i < endIndex; i++) {
            vol += minHeight - elevations[i];
        }

        return vol;
    }

    private static int[] getNextBoundary(int startIndex, int[] elevations, int len) {
        int leftIndex = startIndex;
        while (leftIndex < (len - 2) && elevations[leftIndex] < elevations[leftIndex + 1]) {
            leftIndex++;
        }


        int rightIndex = leftIndex + 2 < len ? leftIndex + 2 : len - 1;;

        int nextMaxIndex = rightIndex + 1;
        while (rightIndex < (len - 1) && elevations[rightIndex] < elevations[leftIndex]) {
            if (elevations[nextMaxIndex] < elevations[rightIndex]) {
                nextMaxIndex = rightIndex;
            }
            rightIndex++;
        }

        return new int[]{leftIndex, rightIndex};
    }

}


 */