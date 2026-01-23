package leetCode._3800

object Solution_3766 {
  private val MX = 5000

  private val palindromes: Array[Int] = {
    val pals = Iterator
      .iterate(1)(_ * 2)
      .flatMap(pow2 => {
        val odds =
          (pow2 until pow2 * 2).iterator.map(i => {
            val s = i.toBinaryString
            Integer.parseInt(s + s.reverse.tail, 2)
          })

        val evens =
          (pow2 until pow2 * 2).iterator.map(i => {
            val s = i.toBinaryString
            Integer.parseInt(s + s.reverse, 2)
          })

        odds ++ evens
      })
      .takeWhile(_ <= MX)
      .toVector

    (0 +: pals :+ 5049).sorted.toArray
  }

  def minOperations(nums: Array[Int]): Array[Int] = nums.map(x => {
    val j = java.util.Arrays.binarySearch(palindromes, x) match {
      case idx if idx >= 0 => idx
      case idx => -idx - 1
    }
    math.min(palindromes(j) - x, x - palindromes(j - 1))
  })
}
