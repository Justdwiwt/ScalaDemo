package spark

import java.io.PrintWriter
import java.net.ServerSocket

import scala.io.Source

object StreamingSimulation {

  /**
    * 随机获取整数
    *
    * @param length 范围
    * @return
    */
  def index(length: Int): Int = {
    import java.util.Random
    val rdm = new Random
    rdm.nextInt(length)
  }

  def main(args: Array[String]): Unit = {

    if (args.length != 3) {
      System.err.println("Usage: <filename><port><millisecond>")
      System.exit(1)
    }

    val fileName = args(0)
    val lines = Source.fromFile(fileName).getLines.toList
    val fileRow = lines.length

    val listener = new ServerSocket(args(1).toInt)
    while (true) {
      val socket = listener.accept()
      new Thread() {
        override def run(): Unit = {
          println("Got client connected from: " + socket.getInetAddress)
          val out = new PrintWriter(socket.getOutputStream, true)
          while (true) {
            Thread.sleep(args(2).toLong)
            val content = lines(index(fileRow))
            println(content)
            out.write(content + '\n')
            out.flush()
          }
          socket.close()
        }
      }.start()
    }
  }

}
