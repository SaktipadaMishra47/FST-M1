def fibonacci(n):
    a, b = 0, 1  # Initialize the first two Fibonacci numbers
    for i in range(1,int(n)) :
        print(a, end = " ")
        a, b = b, a + b  # Update a and b to the next two Fibonacci numbers
number = (input("Enter how many Fibonacci numbers to be generated : "))  # Convert input to integer
fibonacci(number)
