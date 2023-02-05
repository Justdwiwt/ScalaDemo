package leetCode

object Solution_438 {
  def findAnagrams(s: String, p: String): List[Int] = {

    @scala.annotation.tailrec
    def f(idx: Int, acc: List[Int]): List[Int] =
      if (idx + p.length > s.length) acc
      else {
        val isAnagram = s.slice(idx, idx + p.length).sorted == p.sorted
        if (isAnagram) f(idx + 1, idx :: acc)
        else f(idx + 1, acc)
      }

    f(0, Nil)
  }
}
