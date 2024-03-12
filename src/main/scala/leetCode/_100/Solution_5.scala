package leetCode._100

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}

object Solution_5 {
  implicit val executionContext: ExecutionContextExecutor = ExecutionContext.global

  def longestPalindrome(s: String): String = {
    val accumulator: Future[(Int, Int)] = Future.successful((0, 0))

    val longestPalindromeFuture: Future[(Int, Int)] = s.indices./:(accumulator)((acc: Future[(Int, Int)], i: Int) ⇒ {

      @scala.annotation.tailrec
      def loopEven(j: Int, start: Int, maxLength: Int): (Int, Int) =
        if (i + j >= s.length || i - j < 0 || s(i + j) != s(i - j)) (start, maxLength)
        else if (maxLength < 2 * j + 1) loopEven(j + 1, i - j, 2 * j + 1)
        else loopEven(j + 1, start, maxLength)

      @scala.annotation.tailrec
      def loopOdd(j: Int, start: Int, maxLength: Int): (Int, Int) =
        if (i + j + 1 >= s.length || i - j < 0 || s(i + j + 1) != s(i - j)) (start, maxLength)
        else if (maxLength < 2 * j + 2) loopOdd(j + 1, i - j, 2 * j + 2)
        else loopOdd(j + 1, start, maxLength)

      val eve: Future[(Int, Int)] = acc.flatMap(t ⇒ Future(loopEven(0, t._1, t._2)))
      val odd: Future[(Int, Int)] = acc.flatMap(t ⇒ Future(loopOdd(0, t._1, t._2)))

      val mappedFuture: Future[(Int, Int)] = eve.zip(odd).map({
        case (t1: (Int, Int), t2: (Int, Int)) if t1._2 < t2._2 ⇒ t2
        case (t1: (Int, Int), _) ⇒ t1
      })
      mappedFuture
    })

    val (start: Int, len: Int) = Await.result(longestPalindromeFuture, 10.seconds)
    s.slice(start, start + len)
  }
}
