class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int i,
                        List<Integer> path,
                        List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || i == candidates.length) return;

        // take current element
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, path, result);
        path.remove(path.size() - 1);

        // skip current element
        helper(candidates, target, i + 1, path, result);
    }
}
