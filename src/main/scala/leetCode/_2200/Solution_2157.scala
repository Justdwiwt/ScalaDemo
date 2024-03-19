package leetCode._2200

import scala.collection.{immutable, mutable}

object Solution_2157 {
  def groupStrings(words: Array[String]): Array[Int] = {
    val masks = words.indices.map(i => bitmask(words(i)))

    val maskToIdx = masks
      .zipWithIndex
      .flatMap { case (mask, i) => replaceMasks(mask).map((_, i)) }
      .toMap

    val uf = new UnionFind[Int]

    masks.indices.foreach(i => (0 until 26).foreach(bitIdx => {
      val connectedMasks =
        if ((masks(i) >> bitIdx & 1) == 0) Array(masks(i) + (1 << bitIdx))
        else Array(masks(i) - (1 << bitIdx), masks(i) - (1 << bitIdx) + (1 << 26))
      connectedMasks.foreach(maskToIdx.get(_).foreach(uf.union(i, _)))
    }))

    Array(words.indices.map(uf.find).toSet.size, words.indices.map(uf.rank).max)
  }

  private def bitmask(w: String): Int =
    w.foldLeft(0)((bits, c) => bits | 1 << c - 'a')

  private def replaceMasks(mask: Int): immutable.IndexedSeq[Int] = mask +: (0 until 26)
    .filter(bitIdx => (mask >> bitIdx & 1) == 1)
    .map(bitIdx => mask - (1 << bitIdx) + (1 << 26))


  private class UnionFind[T] {
    private val ranks: mutable.Map[T, Int] = mutable.Map.empty.withDefaultValue(1)
    private val parents: mutable.Map[T, T] = mutable.Map.empty.withDefault(n => n)

    def union(n1: T, n2: T): T = {
      val (p1, p2) = (find(n1), find(n2))
      if (p1 != p2) {
        val (lo, hi) = if (ranks(p1) >= ranks(p2)) (p2, p1) else (p1, p2)
        ranks.update(hi, ranks(lo) + ranks(hi))
        parents.update(lo, hi)
      }
      parents(p1)
    }

    def find(n: T): T = {
      if (parents(n) != n) parents.update(n, find(parents(n)))
      parents(n)
    }

    def nodes(): Set[T] =
      parents.keySet.toSet

    def rank(n: T): Int =
      ranks(n)
  }
}
