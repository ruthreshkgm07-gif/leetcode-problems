class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        find(arr, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    void find(int[] arr, int target, int i,
              List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1])
                continue;

            if (arr[j] > target)
                break;

            list.add(arr[j]);
            find(arr, target - arr[j], j + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
