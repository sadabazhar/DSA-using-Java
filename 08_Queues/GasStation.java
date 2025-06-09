public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                // Can't start from previous stations
                start = i + 1;
                tank = 0;
            }
        }

        return (totalGas >= totalCost) ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 1, 2, 5, 4};
        int[] cost = {5, 1, 1, 2 ,3};

        int ans = canCompleteCircuit(gas, cost);
        if (ans != -1) {
            System.out.println("Possible starting station: "+ ans);
        }
    }
}
