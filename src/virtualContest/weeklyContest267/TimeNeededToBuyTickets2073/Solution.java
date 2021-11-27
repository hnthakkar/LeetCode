package virtualContest.weeklyContest267.TimeNeededToBuyTickets2073;

public class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;
        int noOfTicketsFork = tickets[k];

        int count = 0;
        for (int i = 0; i < noOfTicketsFork; i++) {
            for (int j = 0; j < len; j++) {
                if (tickets[j] > 0) {
                    tickets[j] -= 1;
                    count++;
                }

                if (i == noOfTicketsFork - 1 && j == k) {
                    break;
                }
            }
        }

        return count;
    }
}
