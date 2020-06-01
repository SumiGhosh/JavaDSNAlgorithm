package greedy;

/*
*
* SAMPLE QUESTION
*
* Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.

Examples:

Input: Four Jobs with following
deadlines and profits
JobID  Deadline  Profit
  a      4        20
  b      1        10
  c      1        40
  d      1        30
Output: Following is maximum
profit sequence of jobs
        c, a


Input:  Five Jobs with following
deadlines and profits
JobID   Deadline  Profit
  a       2        100
  b       1        19
  c       2        27
  d       1        25
  e       3        15
Output: Following is maximum
profit sequence of jobs
        c, a, e*/

import java.util.Arrays;

public class JobScheduleDeadlineGreedyExample {

    String[] jobIds = {"a", "b", "c", "d"};
    int[] deadlines = {4, 1, 1, 1};
    int[] jobProfits = {20, 10, 40, 30};
    JobDetail[] availableJobs;

    public JobScheduleDeadlineGreedyExample(String[] jobIds, int[] deadlines, int[] jobProfits) {
        availableJobs = new JobDetail[jobIds.length];
        this.jobIds = jobIds;
        this.deadlines = deadlines;
        this.jobProfits = jobProfits;
        findProfitableJobs();
    }

    private void findProfitableJobs() {
        int maxSlot = 0;
        for (int index = 0; index < availableJobs.length; index++) {
            availableJobs[index] = new JobDetail(jobIds[index], deadlines[index], jobProfits[index]);
            if (maxSlot < deadlines[index]) {
                maxSlot = deadlines[index];
            }
        }

        Arrays.sort(availableJobs, (o1, o2) -> o2.profit.compareTo(o1.profit));

        boolean[] slotsAvailability = new boolean[maxSlot];
        String[] jobScheduled = new String[maxSlot];
        for (int index = 0; index < maxSlot; index++) {
            slotsAvailability[index] = false;
        }

        int maxProfit = 0;
        for (int index = 0; index < availableJobs.length; index++) {
            JobDetail jobDetail = availableJobs[index];
            if (!slotsAvailability[jobDetail.deadline - 1]) {
                slotsAvailability[jobDetail.deadline - 1] = true;
                maxProfit += jobDetail.profit;
                jobScheduled[jobDetail.deadline - 1] = jobDetail.jobId;
                continue;
            } else {
                for (int i = jobDetail.deadline; i > 0; i--) {
                    if (!slotsAvailability[i - 1]) {
                        slotsAvailability[i - 1] = true;
                        maxProfit += jobDetail.profit;
                        jobScheduled[i - 1] = jobDetail.jobId;
                        continue;
                    }
                }
            }
        }

        System.out.print("Maximum profit of " + maxProfit + " and job scheduled in order: " + Arrays.toString(jobScheduled));
    }

    class JobDetail {
        String jobId;
        Integer deadline;
        Integer profit;

        public JobDetail(String jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }

    }
}
