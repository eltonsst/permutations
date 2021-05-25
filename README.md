# Permutations

## Intro

Suppose you're given a file with a single string of comma separated numbers, your program must print to STDOUT all possible permutations with repetitions.

## Solution

The problem asks something quite difficult that is to compute all the permutations of a sequence of numbers.
This is a well known computation of **n!** elements that increases higher and higher by increasing the size of the input.

The first thing that comes to my mind when approaching this kind of problems is to use a programming language that simplifies the usage of recursion and provides
**lazy evaluation** by default.

**Haskell** (a programming language that I'm learning at the University of Padua) in facts has all those characteristics and already provides a function that does that.

So, I provided a little script written in Haskell that solves the problem.

Considering that and the scope of this exercise, I provided also a version of the algorithm in **Scala** that is inspired by the Haskell version.

The algorithm (that you can find inside Main.scala) uses lazy evaluation and this is not straightforward if you consider
that Scala is not a **pure functional language** like Haskell.
In facts, I decided to use **LazyList** to store all the permutations in order to delay the computation when needed.


The algorithm is composed by 3 functions and it's generic for any type of input (like Integers, Strings, Chars etc):

- **permutations**
  this function uses the for-comprehension to generate the recursion tree needed to generate the permutations. 
  
- **interleave1** and **interleave2** to insert the given element in all possible positions of the list.

At the end, the result is printed like requested.

Some considerations on the complexity:

- **space** is not a problem thanks to lazy evaluation, you don't have to load in memory all the permutations at once to print them.
In fact, if you substitute the LazyList with any other strict Scala collection like Seq, it's likely that the JVM will ask you for more heap memory.
Obviously, by waiting enough time you will reach some memory limit.
  
- **time** complexity I think that is not so improvable (at least significantly) because even if the program
generates all the permutation in linear time **O(n)** you have in any case **n!** permutations.
  
The time complexity of my permutations() function is **O(n • n!)**.



*PS.*
Loading the input from a file is a missing feature (only specified in comments) because I used the function *range* to generate the input.
(I executed it without memory leaks against input of size 60 which the factorial is greater than the number of atoms in the universe, so I'm quite confident 
that the algorithm can take any input with any size from file).


I founded the range function more comfortable to solve the problem, but you can check this repo: [algoritmi-avanzati](https://github.com/eltonsst/algoritmi-avanzati) 
where for the course of Advanced Algorithm I used a lot the *OS* library to read and map lines from dataset (.txt).
You can also find implementation of algorithms for **minimum spanning tree** and **traveling sales problem**.

