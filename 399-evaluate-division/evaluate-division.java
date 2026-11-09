
import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());

            map.get(a).put(b, values[i]);
            map.get(b).put(a, 1.0 / values[i]);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            ans[i] = dfs(a, b, map, new HashSet<>());
        }

        return ans;
    }

    double dfs(String a, String b,
            Map<String, Map<String, Double>> map,
            Set<String> visited) {

        if (!map.containsKey(a) || !map.containsKey(b))
            return -1.0;

        if (a.equals(b))
            return 1.0;

        visited.add(a);

        for (String next : map.get(a).keySet()) {
            if (!visited.contains(next)) {
                double result = dfs(next, b, map, visited);

                if (result != -1.0)
                    return map.get(a).get(next) * result;
            }
        }

        return -1.0;
    }
}
