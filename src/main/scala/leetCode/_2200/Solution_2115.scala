package leetCode._2200

object Solution_2115 {
  def findAllRecipes(recipes: Array[String], ingredients: List[List[String]], supplies: Array[String]): List[String] = {
    val st = supplies.toSet
    val m = recipes.zip(ingredients).toMap

    def f(recipe: String, reqs: Set[String]): Boolean = m
      .get(recipe)
      .exists(_.forall(x => !reqs.contains(x) && (st.contains(x) || f(x, reqs + x))))

    recipes.filter(f(_, Set.empty)).toList
  }
}
