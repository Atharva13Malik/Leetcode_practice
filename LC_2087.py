class Solution:
    def minCost(self, startPos: List[int], homePos: List[int], rowCosts: List[int], colCosts: List[int]) -> int:
        total_cost = 0
        
        # 1. Decompose the problem into orthogonal 1D traversals
        start_r, start_c = startPos
        home_r, home_c = homePos
        
        # 2. Accumulate Row Costs
        # We move from start_r to home_r. 
        # If home_r > start_r, we move down; if home_r < start_r, we move up.
        step_r = 1 if home_r >= start_r else -1
        for r in range(start_r + step_r, home_r + step_r, step_r):
            total_cost += rowCosts[r]
            
        # 3. Accumulate Column Costs
        step_c = 1 if home_c >= start_c else -1
        for c in range(start_c + step_c, home_c + step_c, step_c):
            total_cost += colCosts[c]
            
        return total_cost        
