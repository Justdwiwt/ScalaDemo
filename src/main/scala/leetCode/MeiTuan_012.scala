package leetCode

import java.util.Scanner

object MeiTuan_012 {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val q = sc.nextInt()

    val bookShelf = Array.fill(n + 1)(-1)
    val isLock = Array.fill(m + 1)(false)
    val hasBooks = Array.fill(n + 1)(0)

    (0 until q).foreach(_ => {
      val op = sc.nextInt()
      var x, y = 0
      op match {
        case 1 =>
          x = sc.nextInt()
          y = sc.nextInt()
          if (!isLock(y) && hasBooks(x) != 1 && (bookShelf(x) == -1 || !isLock(bookShelf(x))))
            bookShelf(x) = y
        case 2 =>
          y = sc.nextInt()
          isLock(y) = true
        case 3 =>
          y = sc.nextInt()
          isLock(y) = false
        case 4 =>
          x = sc.nextInt()
          y = bookShelf(x)
          if (y != -1 && !isLock(y) && hasBooks(x) != 1) {
            println(y)
            hasBooks(x) = 1
            bookShelf(x) = -1
          } else println(-1)
        case 5 =>
          x = sc.nextInt()
          if (hasBooks(x) != 0) hasBooks(x) = 0
        case _ => -1
      }
    })
    sc.close()
  }
}
