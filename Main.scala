// package ...

object Main extends App {
    
  def interleave2[A](x: A, yss: LazyList[A]): LazyList[LazyList[A]] = {
    yss match {
      case _ if yss.isEmpty => LazyList.empty
      case _ => interleave1(x, yss.tail).map(yss.head +: _)
    }
  }

  def interleave1[A](x: A, yss: LazyList[A]): LazyList[LazyList[A]] = (x +: yss) +: interleave2(x, yss)
 
  def permutations[A](input: Seq[A]): LazyList[LazyList[A]] = {
    input match {
      case Nil => LazyList(LazyList())
      case head :: tail =>
        for {
          p <- permutations(tail)
          y <- interleave1(head, p)
        } yield y
    }
  }
  
  // 60! > all atoms in the universe 
  permutations(List.range(1, 60)).foreach(l => println(l.force))
  
  /*
    or read input from file:
    
    1) import on your build.sbt   "com.lihaoyi"  %% "os-lib"  % "0.7.3" for scala 2.13
    
    2) then define a function that loads the file: 
        
        val wd = os.pwd / "src" / "main" / "resources" / "[your_folder]"
        val input = os.list(wd).map { file => 
            ...
        }
     
  */
  
  
  
}
