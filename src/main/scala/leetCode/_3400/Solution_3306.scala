package leetCode._3400

object Solution_3306 {
  def countOfSubstrings(word: String, k: Int): Long = {
    def f(word: String, k: Int): Long = {
      val vowels = Set('a', 'e', 'i', 'o', 'u')

      @scala.annotation.tailrec
      def loop(remaining: List[Char], cnt1: Map[Char, Int], cnt2: Int, left: Int, ans: Long): Long = remaining match {
        case Nil => ans
        case b :: tail =>
          val newCnt1 = if (vowels.contains(b)) cnt1.updated(b, cnt1.getOrElse(b, 0) + 1) else cnt1
          val newCnt2 = if (vowels.contains(b)) cnt2 else cnt2 + 1

          @scala.annotation.tailrec
          def adjust(cnt1: Map[Char, Int], cnt2: Int, left: Int): (Map[Char, Int], Int, Int) =
            if (cnt1.size == 5 && cnt2 >= k) {
              val out = word(left)
              val updatedCnt1 = if (vowels.contains(out)) {
                val updated = cnt1.updated(out, cnt1(out) - 1)
                if (updated(out) == 0) updated - out else updated
              } else cnt1
              adjust(updatedCnt1, if (vowels.contains(out)) cnt2 else cnt2 - 1, left + 1)
            } else (cnt1, cnt2, left)

          val (finalCnt1, finalCnt2, finalLeft) = adjust(newCnt1, newCnt2, left)
          loop(tail, finalCnt1, finalCnt2, finalLeft, ans + finalLeft)
      }

      loop(word.toList, Map.empty[Char, Int], 0, 0, 0)
    }

    f(word, k) - f(word, k + 1)
  }
}
