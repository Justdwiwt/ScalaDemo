package leetCode._2800

object Solution_2782 {
  abstract class CategoryHandler(categories: Array[Int]) {
    def haveSameCategory(a: Int, b: Int): Boolean
  }

  def numberOfCategories(n: Int, categoryHandler: CategoryHandler): Int = {
    val st = (0 until n).foldLeft(collection.mutable.Set[Int]())((acc, i) => {
      val found = acc.exists(categoryHandler.haveSameCategory(i, _))
      if (!found) acc += i else acc
    })

    st.size
  }
}
