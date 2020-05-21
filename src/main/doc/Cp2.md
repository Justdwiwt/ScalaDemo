# Chapter 2

> Exercise 1: Write a function to compute the nth fibonacci number

```scala
  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)

    loop(n, 0, 1)
  }
```

> Exercise 2: Implement a polymorphic function to check whether, an `Array[A]` is sorted

```scala
  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (gt(as(n), as(n + 1))) false
      else go(n + 1)

    go(0)
  }
```

> Exercise 3: Implement `curry`

```scala
  def curry[A, B, C](f: (A, B) => C): A => B => C =
    a => b => f(a, b)
```

> Exercise 4: Implement `uncurry`

```scala
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)
```

> Exercise 5: Implement `compose`

```scala
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))
```
