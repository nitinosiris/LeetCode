import java.util.*;

public class Recipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));

        HashMap<String, Integer> recipeIndegree = new HashMap<>();
        HashMap<String, List<String>> ingredientToRecipes = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        for(int i = 0; i < recipes.length; i++)
        {
            var ingredientList = ingredients.get(i);
            int missingCount = 0;
            for(var ingredient : ingredientList)
            {
                if(!suppliesSet.contains(ingredient))
                    missingCount++;

                ingredientToRecipes.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
            }

            recipeIndegree.put(recipes[i], missingCount);

            if(missingCount  == 0)
            {
                // recipe can be created
                // directly, no dependency
                queue.add(recipes[i]);
            }
        }
        List<String> res = new LinkedList<>();
        while(!queue.isEmpty())
        {
            String craftable = queue.poll();
            res.add(craftable);

            if (ingredientToRecipes.containsKey(craftable)) {
                for(var dependentRecipe : ingredientToRecipes.get(craftable))
                {
                    recipeIndegree.put(dependentRecipe, recipeIndegree.get(dependentRecipe) - 1);
                    if(recipeIndegree.get(dependentRecipe) == 0)
                    {
                        queue.add(dependentRecipe);
                    }
                }
            }
        }
        return res;
    }
}
