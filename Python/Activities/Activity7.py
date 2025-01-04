numbers = list(input("Enter a list of numbers, separated by space:").split(" "))
sum = 0
for number in numbers:
    sum += int(number)  # Convert each number to an integer
print(sum)
