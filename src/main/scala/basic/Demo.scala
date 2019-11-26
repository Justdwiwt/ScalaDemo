package basic

object Demo {

  def main(args: Array[String]): Unit = {

    println(fun1(5, 0))

    println(fun2(10))

    println(fun3(0, 0, 4))

    countdown(5)

    println(fun4(2, 2))

    println(fun5(Array(4, 5, 6, 1, 2, 3)).toString)

  }

  /**
    * 累加求和 n - 50
    *
    * @param num num
    * @param sum sum
    * @return
    */
  @scala.annotation.tailrec
  def fun1(num: Int, sum: Int): Int = {
    if (num > 50) return sum
    if (num % 2 == 0) fun1(num + 1, sum + num)
    else fun1(num + 1, sum)
  }

  /**
    * 递归实现斐波那契数列
    *
    * @param n num
    * @return
    */
  def fun2(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) 1
    else fun2(n - 1) + fun2(n - 2)
  }

  /**
    * 给定一个scope范围，计算0~scope范围的整数之和
    * <p>当和>12或者达到scope边界时，结束递归
    *
    * @param n     num
    * @param sum   sum
    * @param scope max
    * @return
    */
  @scala.annotation.tailrec
  def fun3(n: Int, sum: Int, scope: Int): Int = {
    if (sum > 12) return sum
    if (n - 1 == scope) sum
    else fun3(n + 1, sum + n, scope)
  }

  /**
    * 打印从n到0的数字
    *
    * @param n num
    * @return
    */
  def countdown(n: Int): Unit = {
    (0 to n reverse).foreach(i => print(i + " "))
    println()
  }

  /**
    * 计算x的n次方
    *
    * @param x num
    * @param n num * num (n)
    **/
  def fun4(x: Int, n: Int): Double = {
    if (n == 0) 1
    else if (n > 0 && n % 2 == 0) fun4(x, n / 2) * fun4(x, n / 2)
    else if (n > 0 && n % 2 == 1) x * fun4(x, n - 1)
    else 1 / fun4(x, -n)
  }

  /**
    * 将整数数组中相邻的元素置换
    *
    * @param arr Array
    */
  def fun5(arr: Array[Int]): Unit = {
    (0 until(arr.length - 1, 2)).foreach(i => {
      val t = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = t
    })
  }

  private val var2 = Map("book" -> 10, "gun" -> 100, "iPad" -> 1000)
  var var3: Map[String, Double] = var2.map { case (k, v) => (k, v * 0.9) }

}
