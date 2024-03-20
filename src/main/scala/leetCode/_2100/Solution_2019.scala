package leetCode._2100

import scala.collection.mutable

object Solution_2019 {
  def scoreOfStudents(s: String, answers: Array[Int]): Int = {
    val correctAnswer = (1 to s.length by 2)
      .filter(i => i == s.length || s(i) == '+')
      .foldLeft(0, 0) { case ((sum, j), i) =>
        val localProduct = (j until i by 2).foldLeft(1) { case (product, k) => product * (s(k) - '0') }
        (sum + localProduct, i + 1)
      }
      ._1

    val m = mutable.Map.empty[(Int, Int), Set[Int]]

    def dfs(startIdx: Int, endIdx: Int): Set[Int] = {
      if (endIdx - startIdx == 1) return Set(s(startIdx) - '0')
      if (m.contains((startIdx, endIdx))) return m((startIdx, endIdx))

      val res = (startIdx + 1 until endIdx by 2)
        .flatMap(splitIdx => dfs(startIdx, splitIdx).flatMap(leftResult => dfs(splitIdx + 1, endIdx)
          .map { r => val ans = if (s(splitIdx) == '+') leftResult + r else leftResult * r; (r, ans) }
          .withFilter { case (_, ans) => ans <= 1000 }
          .map { case (_, ans) => ans }
        ))

      m.update((startIdx, endIdx), res.toSet)
      m((startIdx, endIdx))
    }

    val res = dfs(startIdx = 0, endIdx = s.length)

    answers.map(answer =>
        if (answer == correctAnswer) 5
        else if (res.contains(answer)) 2
        else 0)
      .sum
  }
}
