class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        helper(nums, list, a, check);

        return list;
    }

    public void helper(int[] nums, List<List<Integer>> list,
                       List<Integer> a, boolean[] check) {

        if(a.size() == nums.length) {
            list.add(new ArrayList<>(a));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!check[i]) {
                a.add(nums[i]);
                check[i] = true;

                helper(nums, list, a, check);

                a.remove(a.size() - 1);
                check[i] = false;
            }
        }
    }
}
