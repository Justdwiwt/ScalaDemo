package leetCode

object Solution_1268 {
  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = {
    val sortedProducts = products.sorted.toList
    searchWord.zipWithIndex.foldLeft(List[List[String]]()) { (suggestions, charIndex) =>
      charIndex match {
        case (_, i) =>
          val prefix = searchWord.take(i + 1)
          suggestions :+ sortedProducts.filter(_.startsWith(prefix)).take(3)
      }
    }
  }
}
