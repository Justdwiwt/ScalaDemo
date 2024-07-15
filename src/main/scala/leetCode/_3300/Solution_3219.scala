package leetCode._3300

import scala.collection.immutable.Stream.cons

object Solution_3219 {
  private sealed trait Cut {
    def cost: Int
  }

  private case class HorizontalCut(cost: Int) extends Cut

  private case class VerticalCut(cost: Int) extends Cut

  def minimumCost(m: Int, n: Int, horizontalCut: Array[Int], verticalCut: Array[Int]): Long = {
    val sortedH = horizontalCut.map(Solution_3219.HorizontalCut.apply).sorted(Ordering.by[Cut, Int](_.cost).reverse)
    val sortedV = verticalCut.map(Solution_3219.VerticalCut.apply).sorted(Ordering.by[Cut, Int](_.cost).reverse)

    def mergeCuts(hCuts: List[HorizontalCut], vCuts: List[VerticalCut]): Stream[Cut] = (hCuts, vCuts) match {
      case (Nil, v :: vs) => cons(v, mergeCuts(Nil, vs))
      case (h :: hs, Nil) => cons(h, mergeCuts(hs, Nil))
      case (h :: hs, v :: vs) =>
        if (h.cost >= v.cost) cons(h, mergeCuts(hs, v :: vs))
        else cons(v, mergeCuts(h :: hs, vs))
      case _ => Stream.empty
    }

    val allCuts = mergeCuts(sortedH.toList, sortedV.toList)

    @scala.annotation.tailrec
    def f(cuts: Stream[Cut], hPieces: Int, vPieces: Int, totalCost: Long): Long = cuts match {
      case Stream() => totalCost
      case HorizontalCut(cost) #:: rest => f(rest, hPieces + 1, vPieces, totalCost + cost * vPieces)
      case VerticalCut(cost) #:: rest => f(rest, hPieces, vPieces + 1, totalCost + cost * hPieces)
    }

    f(allCuts, 1, 1, 0L)
  }
}
