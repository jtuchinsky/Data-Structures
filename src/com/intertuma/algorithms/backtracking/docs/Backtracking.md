##Boggle
Given an NxN grid of characters and a dictionary, find all words which can be made from 
the characters in the grid, which are present in the given dictionary.

### Description
A word can start and end at any character in the grid.  

The next character must be adjacent to the previous character in any of the directions: up, down, left, right and diagonal.

The character at each position in the grid can be used only once while making a word.

### Brute-Force Solution

Let's say we have a dictionary ```{"art", "tone", "cat", "cater", "not", "not", "ton"}``` and grid
looks like the following:  

![](Booble_grid.PNG)

We will try to find recursievly all words starting from each cell of the grid, similar to DFS.  
If word is in the dictionary, we add it to result.

```text
for each row in rows:  
    for each column in columns:
        word <- String of(grid[row][column])
        visited <- new boolean[rows][columns]
        findWords(grid, row, column, visited, result, word)

findWords(grid, row, column, visited, result, word):
    if word in dictionary:
        add word to result

    for each neighbour of the (row, column):
        if neighbour is valid: ## valid means within the grid and wasn't visited
            mark neighbour as visited
            append neighbour to word
            findWords(grid, neghbour_r, neighbour_c, visited, result, word)
            ## and now backtrack
            mark neighbour as un-visited
            remove neighbour from word
```

### Better Approach
We can limit the depth of search by the length of the longest word in a dictionary.

### Even better approach
Our definition of **"valid"** is too wide:  
```if neighbour is valid: ## valid means within the grid and wasn't visited```  
For example, if we start with *r* at (1,0), then next *r* at (1,1) is valid, however 
there is no word started with *rr* in a dictionary. 
The idea is to be able to calculate the valid prefix, where Trie could help us.

## Subset Sum
### Description
Given a set X of positive integers and target integer T, is there a subset of elements in X that add up to T?  

### Solution
There are two trivial cases:  
1. If the target value T is zero, then we can immediately return True, because the empty set is a subset 
     of every set X, and the elements of the empty set add up to zero.  
2. If T < 0, or if T <> 0 but the set X is empty, then we can immediately return False.  

For the general case, consider an arbitrary element x ∈ X.  
There is a subset of X that sums to T if and only if one of the following statements is true:  
1. There is a subset of X that includes x and whose sum is T.   
2. There is a subset of X that excludes x and whose sum is T.  
     
In the first case, there must be a subset of X \ {x} that sums to T − x;
In the second case, there must be a subset of X \ {x} that sums to T

```text
# does any subset of X[0..i] sum to T?
SubsetSum(X, T, i):
    if T==0
        return True
    if T<0 or i==0
        return False
    
    with <- SubsetSum(X, T - X[i], i-1)     
    wout <- SubsetSum(X, T, i-1)     

    return with OR wout
```
### Variations  
Constructs a subset of X that sums to T, if one exists, or returns the error value None 
if no such subset exists.  
This algorithm uses exact same recursive strategy as previous one.

```text
# return a subset of X[0..i] that sums to T or None otherwise
ConstructSubset(X, T, i):
    if T==0
        return Emty Set
    if T<0 or i==0
        return None
    
    Y <- ConstructSubset(X, T, i-1)
    if Y != None
        return Y     
    Y <- ConstructSubset(X, T - X[i], i-1)     
    if Y != None
        return Y + X[i]    
    return None
```  

## All Possible Braces
Print all balanced braces combinations for a given value 'n'.

### Description
Print all braces combinations for a given value nn so that they are balanced. Here are a few examples:

N= 1 {}
N=2  {{}} {}{}