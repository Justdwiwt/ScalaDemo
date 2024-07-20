package leetCode._3000

object Solution_2967 {
  private val pal: List[Int] = {
    def generatePalindromes(base: Int): Seq[Int] = {
      val oddLengthPalindromes = (base until base * 10).flatMap(i => {
        val s = i.toString
        val palindrome = s + s.reverse.tail
        Seq(palindrome.toInt)
      })

      val evenLengthPalindromes = if (base <= 1000) (base until base * 10).flatMap(i => {
        val s = i.toString
        val palindrome = s + s.reverse
        Seq(palindrome.toInt)
      }) else Seq.empty[Int]

      oddLengthPalindromes ++ evenLengthPalindromes
    }

    val palindromes = {
      val bases = Iterator.iterate(1)(_ * 10).takeWhile(_ <= 10000).toSeq
      bases.flatMap(generatePalindromes)
    }

    (palindromes :+ 1000000001).distinct.sorted.toList
  }

  def minimumCost(nums: Array[Int]): Long = {
    val sortedNums = nums.sorted
    val n = sortedNums.length
    val medianIndex = (n - 1) / 2
    val target = sortedNums(medianIndex)
    val index = lowerBound(target)

    val cost1 = getCost(sortedNums, index)
    val cost2 = if (index > 0) getCost(sortedNums, index - 1) else Long.MaxValue
    cost1.min(cost2)
  }

  private def lowerBound(target: Int): Int = pal.indexWhere(_ >= target) match {
    case -1 => pal.length
    case idx => idx
  }

  private def getCost(nums: Array[Int], index: Int): Long = {
    val target = pal(index)
    nums.map(num => (num - target).abs.toLong).sum
  }
}
