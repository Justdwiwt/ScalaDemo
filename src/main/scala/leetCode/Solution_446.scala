package leetCode

object Solution_446 {
  def overflow(x: Int, y: Int): Boolean = {
    if (x > 0 && y < 0) BigInt(x) - BigInt(y) > Int.MaxValue
    else if (x < 0 && y > 0) BigInt(x) - BigInt(y) < Int.MinValue
    else false
  }

  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    def f(i: Int): Int = g(A.slice(0, i + 1).count(_ == A(i)), 0) + help(i)

    def help(i: Int): Int = {
      var ans = 0
      (i - 1 to 1 by -1).map({ k => val d = A(i) - A(k); (k, d) })
        .withFilter({ case (_, d) => d != 0 })
        .withFilter({ case (k, _) => !overflow(A(i), A(k)) })
        .foreach({ case (k, d) => ans += helpCore(i, k, d) })
      ans
    }

    def helpCore(i: Int, k: Int, d: Int): Int = {
      val l = A.slice(0, k).reverse.toList

      @scala.annotation.tailrec
      def fp(l: List[Int], mem: List[Int], freq: List[Int]): Int = (l, mem, freq) match {
        case (Nil, _, _) =>
          @scala.annotation.tailrec
          def fpp(l: List[Int], tmp: Int, acc: Int): Int = l match {
            case Nil => acc
            case h :: t => fpp(t, tmp * h, acc + tmp * h)
          }

          fpp(freq.reverse.tail.tail, 1, 0)
        case (h :: t, h1 :: _, _) if h1 - h == d => fp(t, h :: mem, 1 :: freq)
        case (h :: t, h1 :: _, h3 :: t3) if h1 == h && mem.length > 2 => fp(t, mem, (h3 + 1) :: t3)
        case (_ :: t, _, _) => fp(t, mem, freq)
      }

      fp(l, List(A(k), A(i)), List(1, 1))
    }

    if (A.length < 3) return 0
    val dp = Array.fill(A.length)(0)
    (2 until A.length).foreach(i => dp(i) = dp(i - 1) + f(i))
    dp(A.length - 1)
  }

  def g(n: Int, d: Int): Int = d match {
    case 0 => (1 << (n - 1)) - (n - 1) - 1
    case _ => n - 2
  }
}
