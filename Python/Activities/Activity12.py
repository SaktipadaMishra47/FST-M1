# Calculate the sum of numbers
# using recursion
def sum(n):
  if n <= 1:
    return n
  else:
    return n + sum(n-1)
print(sum(10))

 