# permutations

## Intro

Suppose you're given a file with a single string of comma separated numbers, your program must print to STDOUT all possible permutations with repetitions.

## Solution

The problem asks something quite difficult that is to compute all the permutations of a sequence of numbers.
This is a well known computation of **n!** elements that increases higher and higher by increases the size of the input.

The first thing that comes to my mind when approaching this kind of problems is to use a programming language that simplifies the usage of recursion and provides
**lazy evaluation** by default.
Haskell in facts has those characteristics
