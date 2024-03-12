package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_16_15 {
  def masterMind(solution: String, guess: String): Array[Int] = {
    val res = Array.fill(2)(0)
    val m1 = mutable.HashMap.empty[Char, Int]
    val m2 = mutable.HashMap.empty[Char, Int]
    (0 until 4).foreach(i => {
      val c1 = solution.charAt(i)
      val c2 = guess.charAt(i)
      if (c1 == c2) res(0) += 1
      m1 += c1 -> (m1.getOrElse(c1, 0) + 1)
      m2 += c2 -> (m2.getOrElse(c2, 0) + 1)
    })
    m1.keySet.foreach(c => if (m2.contains(c)) res(1) += (if (m1(c) <= m2(c)) m1(c) else m2(c)))
    res(1) -= res.head
    res
  }
}
