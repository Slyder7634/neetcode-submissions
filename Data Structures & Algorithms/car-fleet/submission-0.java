class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;

        // Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
        // Here i can find time of each one using :
        // time = target - position[i] / speed[i] 

        // Time = [3,9,10,3]

        // 1. We merge the same times or count them only once.
        // 2. 9 and 10 are different value.
        // To catch up and form a fleet there are two conditions:
        // a. The distance of the greater one should be enough to catch up
        // b. smaller one (i.e. 9) must have greater speed than the other.
        // So the answer is 3.

        int[] roadSpeed = new int[target];
        for (int i = 0; i < position.length; i++) {
            roadSpeed[position[i]] = speed[i];
        }

        int fleets = 0;
        int leadPos = -1;
        int leadSpeed = -1;

        for (int pos = target - 1; pos >= 0; pos--) {
            int curSpeed = roadSpeed[pos];
            if (curSpeed == 0) continue; 
            if (leadPos == -1) {
                fleets = 1;
                leadPos = pos;
                leadSpeed = curSpeed;
                continue;
            }

            if (curSpeed > leadSpeed) {
                double catchUpTime = (double) (leadPos - pos) / (curSpeed - leadSpeed);
                double meetPos = leadPos + leadSpeed * catchUpTime;
                if (meetPos <= target) {
                    continue; 
                }
            }

            fleets++;
            leadPos = pos;
            leadSpeed = curSpeed;
        }

        return fleets;
    }
}
