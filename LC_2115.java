import java.util.*;

class Solution {

    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supplies) {

        // ingredient -> recipes
        HashMap<String, List<String>> adj = new HashMap<>();

        // recipe -> remaining ingredients required
        HashMap<String, Integer> indegree = new HashMap<>();

        // ==========================
        // Step 1 : Build Graph
        // ==========================
        for (int i = 0; i < recipes.length; i++) {

            // Initial indegree = number of ingredients needed
            indegree.put(recipes[i], ingredients.get(i).size());

            // ingredient -> recipe
            for (String ingredient : ingredients.get(i)) {

                adj.putIfAbsent(ingredient, new ArrayList<>());
                adj.get(ingredient).add(recipes[i]);
            }
        }

        // ==========================
        // Step 2 : Put all supplies in queue
        // ==========================
        Queue<String> queue = new LinkedList<>();

        for (String supply : supplies) {
            queue.offer(supply);
        }

        // Final answer
        List<String> ans = new ArrayList<>();

        // ==========================
        // Step 3 : Kahn's Algorithm (BFS)
        // ==========================
        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Agar current se koi recipe dependent hi nahi hai
            if (!adj.containsKey(current))
                continue;

            // Current ingredient se jitni recipes banti hain
            for (String recipe : adj.get(current)) {

                // Ek ingredient mil gaya
                indegree.put(recipe, indegree.get(recipe) - 1);

                // Agar saare ingredients mil gaye
                if (indegree.get(recipe) == 0) {

                    ans.add(recipe);

                    // Recipe ab future ke liye supply ban gayi
                    queue.offer(recipe);
                }
            }
        }

        return ans;
    }
}
