package leetCode._700

import scala.collection.mutable

object Solution_638 {
  def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {
    val m = mutable.Map.empty[Seq[Int], Int]

    def dfs(needs: Seq[Int]): Int = m.getOrElseUpdate(needs, {
      if (needs.forall(_ == 0)) 0
      else {
        special.collect {
          case offer if needs.indices.forall(i => offer(i) <= needs(i)) =>
            offer.last + dfs(needs.indices.map(i => needs(i) - offer(i)))
        } :+ needs.indices.foldLeft(0)((sum, i) => sum + needs(i) * price(i))
      }.min
    })

    dfs(needs)
  }
}
