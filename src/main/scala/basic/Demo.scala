package basic

object Demo {

  def main(args: Array[String]): Unit = {

    println(fun1(5, 0))

    println(fun2(10))

    println(fun3(0, 0, 4))

    countdown(5)

    println(fun4(2, 2))

  }

  /**
    * 累加求和 n - 50
    *
    * @param num num
    * @param sum sum
    * @return
    */
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
    for (i <- 0 to n)
      print(i + " ")
  }

  /**
    * 计算x的n次方
    *
    * @param x num
    * @param n num * num (n)
    **/
  def fun4(x: Int, n: Int): Unit = {
    var res = 0.0
    if (x == 0) return 0
    if (n == 0) return x
    if (x > 0)
      for (i <- 0 to n; if i < n)
        res = x * x
    else res = 1 / x * n
  }

}
