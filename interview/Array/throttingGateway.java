/*
The gateway has the following limits:
The number of transactions in any given second cannot exceed 3.
The number of transactions in any given 10 second period cannot exceed 20. A ten-second period includes all requests arriving from any time max(1, T-9) to T (inclusive of both) for any valid time T.
The number of transactions in any given minute cannot exceed 60. Similar to above, 1 minute is from max(1, T-59) to T.
Any request that exceeds any of the above limits will be dropped by the gateway. Given the times at which different requests arrive sorted ascending, find how many requests will be dropped.
Note: Even if a request is dropped it is still considered for future calculations. Although, if a request is to be dropped due to multiple violations, it is still counted only once.
Example
n = 27
requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11 ]
Request 1 - Not Dropped.
Request 1 - Not Dropped.
Request 1 - Not Dropped.
Request 1 - Dropped. At most 3 requests are allowed in one second.
No request will be dropped till 6 as all comes at an allowed rate of 3 requests per second and the 10-second clause is also not violated.
Request 7 - Not Dropped. The total number of requests has reached 20 now.
Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
Request 7 - Dropped. At most 20 requests are allowed in ten seconds. Note that the 1-second limit is also violated here.
Request 11 - Not Dropped. The 10-second window has now become 2 to 11. Hence the total number of requests in this window is 20 now.
Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
Request 11 - Dropped. At most 20 requests are allowed in ten seconds. Also, at most 3 requests are allowed per second.
Hence, a total of 7 requests are dropped.
Function Description
Complete the droppedRequests function in the editor below.
droppedRequests has the following parameter(s):
int requestTime[n]: an ordered array of integers that represent the times of various requests
Returns
int: the total number of dropped requests
Constraints
1 ≤ n ≤ 106
1 ≤ requestTime[i] ≤ 109
Input Format For Custom Testing
Sample Case 0
Sample Input For Custom Testing
STDIN Function
----- --------
5 → requestTime[] size n = 5
1 → requestTime = [ 1, 1, 1, 1, 2 ]
1
1
1
2
Sample Output
1
Explanation
There are 4 requests that arrive at second 1. This exceeds the per second limit so one packet is dropped. No other limits are exceeded.```
*/

package interview.Array;

import java.util.*;

public class throttingGateway {

    public static void main(String[] args) {

    }

    public static int droppedRequests(int[] request, int n) {

        int max_per_second = 3;
        int max_per_tenSecond = 20;
        int max_per_60Secs = 60;
        int maximum_request = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : request) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maximum_request = Math.max(maximum_request, num);

        }
        int[] number = new int[maximum_request + 1];
        int drop_count = 0;

        for (int i = 1; i < number.length; i++) {
            int current_request_number = map.getOrDefault(i, 0);
            // fill in the number array;
            number[i] = number[i - 1] + current_request_number;

            if (current_request_number == 0) {
                continue;
            }
            int drop = 0;
            if (number[i] > max_per_second) {

            }
        }

        return 0;
    }

}
/*
 * public int droppedRequests(int[] requestTime) { if (requestTime == null ||
 * requestTime.length == 0) { return 0; } int drop = 0; Map<Integer, Integer>
 * map = new HashMap<>(); int lastReqTime = 0; for (int i : requestTime) {
 * map.put(i, map.getOrDefault(i, 0) + 1); lastReqTime = Math.max(lastReqTime,
 * i); } int[] nums = new int[lastReqTime + 1]; for (int i = 1; i < nums.length;
 * ++i) { int numReqThisSecond = map.getOrDefault(i, 0); nums[i] = nums[i - 1] +
 * numReqThisSecond; if (numReqThisSecond == 0) { continue; } int toDrop = 0; if
 * (numReqThisSecond > MAX_PER_SECOND) { toDrop = Math.max(toDrop,
 * numReqThisSecond - MAX_PER_SECOND); }
 * 
 * int timeTenSecondsAgo = Math.max(i - 10, 0); int numReqPastTenSecond =
 * nums[i] - nums[timeTenSecondsAgo]; if (numReqPastTenSecond > MAX_TEN_SECONDS)
 * { int numReqExceeded = Math.min(numReqThisSecond, numReqPastTenSecond -
 * MAX_TEN_SECONDS); toDrop = Math.max(toDrop, numReqExceeded); }
 * 
 * int timeOneMinuteAgo = Math.max(i - 60, 0); int numReqPastMinute = nums[i] -
 * nums[timeOneMinuteAgo]; if (numReqPastMinute > MAX_PER_MINUTE) { int
 * numReqExceeded = Math.min(numReqThisSecond, numReqPastMinute -
 * MAX_PER_MINUTE); toDrop = Math.max(toDrop, numReqExceeded); } drop += toDrop;
 * } return drop; } }
 */
