object Q729 {
  def main(args: Array[String]) = {
    val word = io.StdIn.readLine()
    val indexes = io.StdIn.readLine().split(' ').map(_.toInt).toSeq

    val i = indexes(0)
    val j = indexes(1)
    val answer = word.updated(i, word(j)).updated(j, word(i))
    println(answer)
  }
}