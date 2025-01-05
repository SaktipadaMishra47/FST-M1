numbers = list(input("Enter the numers sepated by space ").split(" "))
def summasion(n):
    sum = 0
    for i in n:
        sum = sum+int(i)
    print(sum)   
summasion(numbers)     
