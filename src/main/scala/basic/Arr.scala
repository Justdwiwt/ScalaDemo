package basic

import scala.collection.mutable.ArrayBuffer

object Arr {

  // 长度不变
  val nums = new Array[Int](10)
  val a = new Array[String](10)

  // 长度可变，数组缓冲
  val b = new ArrayBuffer[Int]
  b += 1
  b += (2, 3, 4, 5)
  //  b += nums(8, 13, 12)
  b.trimEnd(3)
  b.insert(2, 6)
  b.remove(3)

  // 数组遍历
  // until排除最后一个元素，0->a.length-1
  //noinspection RangeToIndices
  (0 until a.length).foreach(i => println(s"$i:${a(i)}"))

  nums.indices.foreach(i => println(s"$i:${nums(i)}"))

  // 数组与数组缓冲转换
  b.toArray
  a.toBuffer

}
